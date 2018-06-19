/*
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.amf.search.portlet.commands;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.search.dto.SearchData;
import com.liferay.training.amf.search.exception.InvalidZipCodeException;
import com.liferay.training.amf.search.exception.NoSearchQueryException;
import com.liferay.training.amf.search.portlet.constants.AmfSearchResultsPortletKeys;
import com.liferay.training.amf.search.portlet.constants.PermissionKeys;
import com.liferay.training.amf.search.service.SearchService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.LinkedList;
import java.util.List;

/**
 * @author William Strong
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AmfSearchResultsPortletKeys.PORTLET_NAME,
		"mvc.command.name=/"
	},
	service = MVCRenderCommand.class
)
public class SearchResultsRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest request, RenderResponse response) {

		// Initialize needed attributes.
		// Because _request and _response will be changed it needs to be
		// used instead of request and response.

		_request = request;
		_response = response;
		_themeDisplay = _getThemeDisplay();
		_groupId = _getGroupId();
		_permissionChecker = _getPermissionChecker();

		if (!_hasPermission()) {
			return "/NoPermission.jsp";
		}

		// Check for an event by reading the parameter and parsing it.
		// Return the default page if the parameter is empty.

		_readEventFlag();

		if (_eventFlagIsEmpty()) {
			return "/SearchInstructions.jsp";
		}

		_initializeNewSearchContainer();

		_setNewSearch();

		_getSearchContainerResults();

		_removeDefaultErrorMessage();

		_request.setAttribute("_searchContainer", _searchContainer);

		_request.setAttribute("zip", _zip);

		return "/SearchResults.jsp";
	}

	private boolean _eventFlagIsEmpty() {
		String eventFlag = ParamUtil.getString(_request, "eventFlag");

		return eventFlag.isEmpty();
	}

	private long _getGroupId() {
		if (null == _themeDisplay) {
			throw new IllegalArgumentException("request is null");
		}

		return _themeDisplay.getScopeGroupId();
	}

	private PermissionChecker _getPermissionChecker() {
		if (null == _themeDisplay) {
			throw new IllegalArgumentException("request is null");
		}

		return _themeDisplay.getPermissionChecker();
	}

	private void _getSearchContainerResults() {
		try {

			// TODO understand problem with Source Formatter and this function.

			_searchContainer.setResults(
				_searchService.findByZip(
					_groupId, _zip, _searchContainer.getStart(),
					_searchContainer.getEnd()));
			_searchContainer.setTotal((int) _searchService.getSize());
		}
		catch (NoSearchQueryException nsqe) {
			_log.error(nsqe);
			SessionErrors.add(_request, _NO_SEARCH);
			_searchContainer.setEmptyResultsMessage(_NO_SEARCH);
		}
		catch (InvalidZipCodeException.NotANumber e) {
			_log.error(e);
			SessionErrors.add(_request, _NOT_A_NUMBER);
			_searchContainer.setEmptyResultsMessage(_NOT_A_NUMBER);
		}
		catch (InvalidZipCodeException.Null e) {
			_log.error(e);
			SessionErrors.add(_request, _NULL);
			_searchContainer.setEmptyResultsMessage(_NULL);
		}
		catch (InvalidZipCodeException.TooFewDigits e) {
			_log.error(e);
			SessionErrors.add(_request, _TOO_FEW_DIGITS);
			_searchContainer.setEmptyResultsMessage(_TOO_FEW_DIGITS);
		}
		catch (InvalidZipCodeException.TooManyDigits e) {
			_log.error(e);
			SessionErrors.add(_request, _TOO_MANY_DIGITS);
			_searchContainer.setEmptyResultsMessage(_TOO_MANY_DIGITS);
		}
		catch (PrincipalException.MustHavePermission e) {
			_log.error(e);
			SessionErrors.add(_request, _NO_PERMISSION);
			_searchContainer.setEmptyResultsMessage(_NO_PERMISSION);
		}
		catch (PortalException pe) {
			_log.error(pe);
			SessionErrors.add(_request, _UNKNOWN_ERROR);
		}
	}

	private ThemeDisplay _getThemeDisplay() {
		if (null == _request) {
			throw new IllegalArgumentException("request is null");
		}

		return (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	private boolean _hasPermission() {
		return _permissionChecker.hasPermission(
			_groupId, AmfSearchResultsPortletKeys.PORTLET_NAME, 0,
			PermissionKeys.CAN_MAKE_SEARCH);
	}

	private void _initializeNewSearchContainer() {
		PortletURL iteratorURL = _response.createActionURL();

		_searchContainer = new SearchContainer<>(
			_request, iteratorURL, _headerNames, _EMPTY_RESULTS_MESSAGE);

		_searchContainer.setDeltaConfigurable(true);
		_searchContainer.setDelta(_DELTA);
	}

	private void _readEventFlag() {
		String eventFlagString = ParamUtil.getString(_request, "eventFlag");

		boolean eventFlag = Boolean.parseBoolean(eventFlagString);

		if (eventFlag) {
			_setEventFlag();
		}
	}

	private void _removeDefaultErrorMessage() {
		String portletId = PortalUtil.getPortletId(_request);

		SessionMessages.add(
			_request,
			portletId + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	private void _setEventFlag() {
		_eventFlag = true;
	}

	private void _setNewSearch() {
		if (_eventFlag) {
			_zip = ParamUtil.getString(_request, "zipSearch");
			_eventFlag = false;
		}
	}

	private static final int _DELTA = 5;

	private static final String _EMPTY_RESULTS_MESSAGE = "no-users";

	private static final String _NO_PERMISSION = "no-permission";

	private static final String _NO_SEARCH = "no-search";

	private static final String _NOT_A_NUMBER = "invalid-zip-not-a-number";

	private static final String _NULL = "invalid-zip-null";

	private static final String _TOO_FEW_DIGITS = "invalid-zip-too-few-digits";

	private static final String _TOO_MANY_DIGITS =
		"invalid-zip-too-many-digits";

	private static final String _UNKNOWN_ERROR = "unknown-error";

	private Boolean _eventFlag;
	private long _groupId;
	private final List<String> _headerNames = new LinkedList<String>() {
		{
			add("first-name");
			add("last-initial");
			add("screen-name");
			add("email-address");
		}
	};
	private Log _log = LogFactoryUtil.getLog(
		SearchResultsRenderCommand.class.getName());
	private PermissionChecker _permissionChecker;
	private RenderRequest _request;
	private RenderResponse _response;
	private SearchContainer<SearchData> _searchContainer;

	@Reference
	private SearchService _searchService;

	private ThemeDisplay _themeDisplay;
	private String _zip;

}
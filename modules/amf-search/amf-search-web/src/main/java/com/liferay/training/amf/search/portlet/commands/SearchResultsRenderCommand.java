package com.liferay.training.amf.search.portlet.commands;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.search.constants.PermissionKeys;
import com.liferay.training.amf.search.constants.AmfSearchResultsPortletKeys;
import com.liferay.training.amf.search.dto.SearchData;
import com.liferay.training.amf.search.exception.InvalidZipCodeException;
import com.liferay.training.amf.search.exception.NoSearchQueryException;
import com.liferay.training.amf.search.service.SearchService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.LinkedList;
import java.util.List;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AmfSearchResultsPortletKeys.PORTLET_NAME,
				"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
)
public class SearchResultsRenderCommand implements MVCRenderCommand {

	private final String _emptyResultsMessage = "no-users";

	private String _zip;
	private Boolean _eventFlag;
	private static final int _delta = 5;

	private SearchContainer<SearchData> searchContainer;

	private void _setEventFlag() {
		_eventFlag = true;
	}

	private enum _errors {
		NO_SEARCH("no-search"),
		NOT_A_NUMBER("invalid-zip-not-a-number"),
		TOO_MANY_DIGITS("invalid-zip-too-many-digits"),
		TOO_FEW_DIGITS("invalid-zip-too-few-digits"),
		NULL("invalid-zip-null"),
		NO_PERMISSION("no-permission");

		private String name;

		_errors(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}

	private final List<String> HEADER_NAMES = new LinkedList<String>() {{
		add("first-name");
		add("last-initial");
		add("screen-name");
		add("email-address");
	}};

	private PermissionChecker _permissionChecker;
	private ThemeDisplay _themeDisplay;
	private long _groupId;
	private boolean hasPermission() {
		return _permissionChecker.hasPermission(
				_groupId, AmfSearchResultsPortletKeys.PORTLET_NAME, 0, PermissionKeys.canMakeSearch);
	}
	private boolean eventFlagIsEmpty() {
		return ParamUtil.getString(_request, "eventFlag").isEmpty();
	}
	private void readEventFlag() {
		String eventFlagString = ParamUtil.getString(_request, "eventFlag");
		boolean eventFlag = Boolean.parseBoolean(eventFlagString);
		if (eventFlag) {
			_setEventFlag();
		}
	}

	private RenderRequest _request;

	private void initializeNewSearchContainer() {
		PortletURL iteratorURL = _response.createActionURL();
		searchContainer = new SearchContainer<>(
				_request, iteratorURL, HEADER_NAMES, _emptyResultsMessage);
		searchContainer.setDeltaConfigurable(true);
		searchContainer.setDelta(_delta);
	}

	private RenderResponse _response;

	private void setNewSearch() {
		if (_eventFlag) {
			_zip = ParamUtil.getString(_request, "zipSearch");
			_eventFlag = false;
		}
	}

	private void removeDefaultSessionMessage() {
		SessionMessages.add(
				_request, PortalUtil.getPortletId(_request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
	}

	@Override
	public String render(RenderRequest request, RenderResponse response) {

		// Initialize needed attributes.
		// Because _request and _response will be changed it needs to be used instead of request and response.

		_request = request;
		_response = response;
		_themeDisplay = _getThemeDisplay(_request);
		_groupId = _getGroupId(_themeDisplay);
		_permissionChecker = _getPermissionChecker(_themeDisplay);

		if (!hasPermission()) {
			return "/NoPermission.jsp";
		}

		// Check for an event by reading the parameter and parsing it.
		// Return the default page if the parameter is empty.

		readEventFlag();
		if (eventFlagIsEmpty()) {
			return "/SearchInstructions.jsp";
		}

		initializeNewSearchContainer();

		setNewSearch();

		getSearchContainerResults();

		_request.setAttribute("searchContainer", searchContainer);

		_request.setAttribute("zip", _zip);

//		request = _request;
//		response = _response;

		return "/SearchResults.jsp";
	}

	private void getSearchContainerResults() {
		try {
			searchContainer.setResults(
					_searchService.findByZip(_groupId, _zip, searchContainer.getStart(), searchContainer.getEnd()));
			searchContainer.setTotal((int) _searchService.getSize());
		}
		catch (NoSearchQueryException e) {
			SessionErrors.add(_request, _errors.NO_SEARCH.getName());
			searchContainer.setEmptyResultsMessage(_errors.NO_SEARCH.getName());
		}
		catch (InvalidZipCodeException.NotANumber e) {
			SessionErrors.add(_request, _errors.NOT_A_NUMBER.getName());
			searchContainer.setEmptyResultsMessage(_errors.NOT_A_NUMBER.getName());
		}
		catch (InvalidZipCodeException.Null e) {
			SessionErrors.add(_request, _errors.NULL.getName());
			searchContainer.setEmptyResultsMessage(_errors.NULL.getName());
		}
		catch (InvalidZipCodeException.TooFewDigits e) {
			SessionErrors.add(_request, _errors.TOO_FEW_DIGITS.getName());
			searchContainer.setEmptyResultsMessage(_errors.TOO_FEW_DIGITS.getName());
		}
		catch (InvalidZipCodeException.TooManyDigits e) {
			SessionErrors.add(_request, _errors.TOO_MANY_DIGITS.getName());
			searchContainer.setEmptyResultsMessage(_errors.TOO_MANY_DIGITS.getName());
		}
		catch (PrincipalException.MustHavePermission e) {
			SessionErrors.add(_request, _errors.NO_PERMISSION.getName());
			searchContainer.setEmptyResultsMessage(_errors.NO_PERMISSION.getName());
		}
		catch (PortalException e) {
			SessionErrors.add(_request, "");
		}
	}

	private static PermissionChecker _getPermissionChecker(ThemeDisplay themeDisplay) {
		if (null == themeDisplay) {
			throw new IllegalArgumentException("request is null");
		}
		return themeDisplay.getPermissionChecker();
	}

	private static long _getGroupId(ThemeDisplay themeDisplay) {
		if (null == themeDisplay) {
			throw new IllegalArgumentException("request is null");
		}
		return themeDisplay.getScopeGroupId();
	}

	private static ThemeDisplay _getThemeDisplay(PortletRequest request) {
		if (null == request) {
			throw new IllegalArgumentException("request is null");
		}

		return (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	@Reference
	private SearchService _searchService;
}
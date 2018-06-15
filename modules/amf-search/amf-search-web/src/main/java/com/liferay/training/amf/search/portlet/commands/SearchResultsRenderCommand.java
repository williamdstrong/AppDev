package com.liferay.training.amf.search.portlet.commands;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.search.constants.AmfSearchResultsPortletKeys;
import com.liferay.training.amf.search.dto.SearchData;
import com.liferay.training.amf.search.exception.InvalidZipCodeException;
import com.liferay.training.amf.search.exception.NoSearchQueryException;
import com.liferay.training.amf.search.service.SearchService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.LinkedList;
import java.util.List;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AmfSearchResultsPortletKeys.AmfSearchResults,
				"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
)
public class SearchResultsRenderCommand implements MVCRenderCommand {

	private final String _emptyResultsMessage = "no-users";
	private final int _delta = 5;

	private String _zip;
	private Boolean _eventFlag;

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

	@Override
	public String render(RenderRequest request, RenderResponse response) {

		String eventFlagString = ParamUtil.getString(request, "eventFlag");
		if (eventFlagString.isEmpty()) {
			return "/SearchInstructions.jsp";
		}

		if (Boolean.parseBoolean(eventFlagString)) {
			_setEventFlag();
		}

		PortletURL iteratorURL = response.createActionURL();



		SearchContainer<SearchData> searchContainer = new SearchContainer<>(
				request, iteratorURL, HEADER_NAMES, _emptyResultsMessage);
		searchContainer.setDeltaConfigurable(true);

		if (_eventFlag) {
			_zip = ParamUtil.getString(request, "zipSearch");
			_eventFlag = false;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();

		SessionMessages.add(
				request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);

		try {
			searchContainer.setResults(
					_searchService.findByZip(groupId, _zip, searchContainer.getStart(), searchContainer.getEnd()));
			searchContainer.setTotal((int) _searchService.getSize());
		}
		catch (NoSearchQueryException e) {
			SessionErrors.add(request, _errors.NO_SEARCH.getName());
			searchContainer.setEmptyResultsMessage(_errors.NO_SEARCH.getName());
		}
		catch (InvalidZipCodeException.NotANumber e) {
			SessionErrors.add(request, _errors.NOT_A_NUMBER.getName());
			searchContainer.setEmptyResultsMessage(_errors.NOT_A_NUMBER.getName());
		}
		catch (InvalidZipCodeException.Null e) {
			SessionErrors.add(request, _errors.NULL.getName());
			searchContainer.setEmptyResultsMessage(_errors.NULL.getName());
		}
		catch (InvalidZipCodeException.TooFewDigits e) {
			SessionErrors.add(request, _errors.TOO_FEW_DIGITS.getName());
			searchContainer.setEmptyResultsMessage(_errors.TOO_FEW_DIGITS.getName());
		}
		catch (InvalidZipCodeException.TooManyDigits e) {
			SessionErrors.add(request, _errors.TOO_MANY_DIGITS.getName());
			searchContainer.setEmptyResultsMessage(_errors.TOO_MANY_DIGITS.getName());
		}
		catch (PrincipalException.MustHavePermission e) {
			SessionErrors.add(request, _errors.NO_PERMISSION.getName());
			searchContainer.setEmptyResultsMessage(_errors.NO_PERMISSION.getName());
		}
		catch (PortalException e) {
			SessionErrors.add(request, "");
		}

		request.setAttribute("searchContainer", searchContainer);

		request.setAttribute("zip", _zip);



		return "/SearchResults.jsp";
	}

	@Reference
	private SearchService _searchService;
}
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

	private final String _emptyResultsMessage = "There are no users.";
	private final int _delta = 5;

	private String _zip;
	private Boolean _eventFlag;

	private void _setEventFlag() {
		_eventFlag = true;
	}

	@Override
	public String render(RenderRequest request, RenderResponse response) {

		if (Boolean.parseBoolean(ParamUtil.getString(request, "eventFlag", "false"))) {
			_setEventFlag();
		}

		PortletURL iteratorURL = response.createActionURL();

		List<String> headerNames = new LinkedList<>();
		headerNames.add("First Name");
		headerNames.add("Last Initial");
		headerNames.add("Screen Name");
		headerNames.add("Email Address");

		SearchContainer<SearchData> searchContainer = new SearchContainer<>(
				request, iteratorURL, headerNames, _emptyResultsMessage);
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
		} catch (NoSearchQueryException e) {
			SessionErrors.add(request, "noSearch");
			searchContainer.setEmptyResultsMessage("noSearch");
		} catch (InvalidZipCodeException e){
			SessionErrors.add(request, "invalidZip" );
			searchContainer.setEmptyResultsMessage("invalidZip");
		} catch (PrincipalException.MustHavePermission e) {
			SessionErrors.add(request, "noPermission");
			searchContainer.setEmptyResultsMessage("noPermission");
		} catch (PortalException e) {
			SessionErrors.add(request, "");
		}

		request.setAttribute("searchContainer", searchContainer);

		request.setAttribute("zip", _zip);



		return "/SearchResults.jsp";
	}

	@Reference
	private SearchService _searchService;
}
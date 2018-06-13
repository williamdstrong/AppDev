package com.liferay.training.amf.search.portlet.commands;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.search.constants.AmfSearchResultsPortletKeys;
import com.liferay.training.amf.search.exception.InvalidZipCodeException;
import com.liferay.training.amf.search.exception.NoSearchQueryException;
import com.liferay.training.amf.search.service.SearchService;
import com.liferay.training.amf.search.dto.SearchData;
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

	@Override
	public String render(RenderRequest request, RenderResponse response) {

		PortletURL iteratorURL = response.createActionURL();

		List<String> headerNames = new LinkedList<>();
		headerNames.add("First Name");
		headerNames.add("Last Initial");
		headerNames.add("Screen Name");
		headerNames.add("Email Address");

		SearchContainer<SearchData> searchContainer = new SearchContainer<>(
						request, iteratorURL, headerNames,  "There are no users...");
		searchContainer.setDelta(5);
		searchContainer.setDeltaConfigurable(true);

		String zip = ParamUtil.getString(request, "zip", "");


		try {
			searchContainer.setResults(_searchService.findByZip(zip, searchContainer.getStart(), searchContainer.getEnd()));
			searchContainer.setTotal((int) _searchService.getSize());
		} catch (NoSearchQueryException | InvalidZipCodeException e) {
			SessionErrors.add(request, "" );
		}

		request.setAttribute("searchContainer", searchContainer);

		request.setAttribute("zip", zip);

		return "/SearchResults.jsp";
	}

	@Reference
	private SearchService _searchService;
}
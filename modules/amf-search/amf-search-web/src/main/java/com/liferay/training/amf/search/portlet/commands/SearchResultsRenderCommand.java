package com.liferay.training.amf.search.portlet.commands;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.search.constants.AmfSearchResultsPortletKeys;
import com.liferay.training.amf.search.portlet.util.DataFormatter;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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

		String zip = ParamUtil.getString(request, "zip", "");
		DataFormatter dataFormatter = new DataFormatter();

		request.setAttribute("zip", zip);
		request.setAttribute("results", dataFormatter);

		return "/SearchResults.jsp";
	}

}
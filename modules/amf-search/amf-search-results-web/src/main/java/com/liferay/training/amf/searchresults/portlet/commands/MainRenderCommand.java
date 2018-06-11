package com.liferay.training.amf.searchresults.portlet.commands;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.search.service.SearchService;
import com.liferay.training.amf.searchresults.constants.AmfSearchResultsPortletKeys;
import com.liferay.training.amf.searchresults.portlet.util.DataFormatter;
import com.liferay.training.amf.searchresults.portlet.util.SearchData;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AmfSearchResultsPortletKeys.AmfSearchResults,
				"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
)
public class MainRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest request, RenderResponse response) {

		String zip = ParamUtil.getString(request, "zip", "");
		DataFormatter dataFormatter = new DataFormatter();

		request.setAttribute("zip", zip);
		request.setAttribute("results", dataFormatter);

		return "/view.jsp";
	}

	@Reference
	SearchService searchService;
}
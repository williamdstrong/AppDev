package com.liferay.training.amf.search.portlet.commands;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.training.amf.search.constants.AmfSearchPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + AmfSearchPortletKeys.AmfSearch,
				"mvc.command.name=/"
		},
		service = MVCRenderCommand.class
)
public class SearchInputRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest request, RenderResponse response) {

		return "/SearchInput.jsp";
	}
}

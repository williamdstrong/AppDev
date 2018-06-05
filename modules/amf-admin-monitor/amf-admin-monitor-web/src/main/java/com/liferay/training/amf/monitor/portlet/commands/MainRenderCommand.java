package com.liferay.training.amf.monitor.portlet.commands;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.training.amf.monitor.portlet.constants.AdminMonitorPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + AdminMonitorPortletKeys.AmfAdminMonitorWeb,
			"mvc.command.name=/"
	},
	service = MVCRenderCommand.class
)

public class MainRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest request, RenderResponse response) {

		return "/view.jsp";
	}
}

package com.liferay.training.amf.monitor.portlet.commands;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.monitor.portlet.constants.AdminMonitorPortletKeys;
import com.liferay.training.amf.monitor.portlet.util.AdminMonitorPortletUtil;
import com.liferay.training.amf.monitor.portlet.util.FormattedAdminMonitor;
import com.liferay.training.amf.monitor.service.AdminMonitorLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;

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

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);

		AdminMonitorPortletUtil adminMonitorPortletUtil = new AdminMonitorPortletUtil();
		ListUtil listUtil = new ListUtil();
		request.setAttribute("ListUtil", listUtil);
		request.setAttribute("Util", adminMonitorPortletUtil);

		return "/view.jsp";
	}



	@Reference(cardinality = ReferenceCardinality.MANDATORY)
	protected AdminMonitorLocalService _adminMonitorLocalService;
}

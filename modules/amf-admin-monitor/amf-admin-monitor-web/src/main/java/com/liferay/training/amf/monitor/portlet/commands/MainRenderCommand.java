package com.liferay.training.amf.monitor.portlet.commands;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.monitor.portlet.constants.AdminMonitorPortletKeys;
import com.liferay.training.amf.monitor.portlet.util.AdminMonitorPortletUtil;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + AdminMonitorPortletKeys.EVENT_MONITOR,
			"mvc.command.name=/"
	},
	service = MVCRenderCommand.class
)

public class MainRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest request, RenderResponse response) {

		PortletURL portletURL = response.createRenderURL();
		String tabs = ParamUtil.getString(request, "tabs", "all");

		portletURL.setParameter("tabs", tabs);

		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		AdminMonitorPortletUtil adminMonitorPortletUtil = new AdminMonitorPortletUtil();
		ListUtil listUtil = new ListUtil();
		request.setAttribute("userId", userId);
		request.setAttribute("groupId", groupId);
		request.setAttribute("listUtil", listUtil);
		request.setAttribute("util", adminMonitorPortletUtil);

		return "/view.jsp";
	}
}

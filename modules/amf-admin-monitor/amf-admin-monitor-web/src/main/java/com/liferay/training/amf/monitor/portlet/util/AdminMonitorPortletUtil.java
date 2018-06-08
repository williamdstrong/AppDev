package com.liferay.training.amf.monitor.portlet.util;

import com.liferay.portal.kernel.exception.NoSuchUserException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.training.amf.monitor.model.AdminMonitor;
import com.liferay.training.amf.monitor.service.AdminMonitorServiceUtil;

import java.util.LinkedList;
import java.util.List;

public class AdminMonitorPortletUtil {

	public static List<FormattedAdminMonitor> getResults(String eventType) throws PortalException {
		List<FormattedAdminMonitor> formattedAdminMonitors = new LinkedList<>();
		try {
			if (eventType.equalsIgnoreCase("create")) {
				formattedAdminMonitors =
						formattedAdminMonitorList(AdminMonitorServiceUtil.getCreationEvents());
			}
			else if (eventType.equalsIgnoreCase("login")) {
				formattedAdminMonitors =
						formattedAdminMonitorList(AdminMonitorServiceUtil.getLoginEvents());
			}
			else if (eventType.equalsIgnoreCase("all")) {
				formattedAdminMonitors =
						formattedAdminMonitorList(AdminMonitorServiceUtil.getAllEvents());
			}
		} catch (NoSuchUserException e) {
			_log.error("User does not exist");
			return formattedAdminMonitors;
		}
		return formattedAdminMonitors;
	}

	public static List<FormattedAdminMonitor> subList(List<FormattedAdminMonitor> adminMonitors, int start, int end) {
		if (adminMonitors.isEmpty()) {
			return adminMonitors;
		}
		else {
			return ListUtil.subList(adminMonitors, start, end);
		}
	}

	public static List<FormattedAdminMonitor> formattedAdminMonitorList(List<AdminMonitor> adminMonitors) throws PortalException {

		List<FormattedAdminMonitor> formattedAdminMonitors = new LinkedList<>();

		for (AdminMonitor adminMonitor : adminMonitors) {
			formattedAdminMonitors.add(new FormattedAdminMonitor(adminMonitor));
		}

		return formattedAdminMonitors;
	}

	private static Log _log = LogFactoryUtil.getLog(AdminMonitorPortletUtil.class.getName());
}

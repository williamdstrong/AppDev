package com.liferay.training.amf.monitor.portlet.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.training.amf.monitor.model.AdminMonitor;


public class FormattedAdminMonitor {

	public String getUsername() {
		return username;
	}

	public String getDateTime() {
		return dateTime;
	}

	public String getEventType() {
		return eventType;
	}

	public String getUserId() {
		return userId;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public FormattedAdminMonitor(AdminMonitor baseAdminMonitor) throws PortalException {
		this.baseAdminMonitor = baseAdminMonitor;
		extractData();
	}

	private void extractData() throws PortalException {

		dateTime = baseAdminMonitor.getDateTime().toString();
		ipAddress = baseAdminMonitor.getIpAddress();
		long userIdLong = baseAdminMonitor.getUserId();
		userId = Long.toString(userIdLong);

		username = getUsername(userIdLong);



		eventType = baseAdminMonitor.getEventType();
	}

	private String getUsername(long userId) throws PortalException {
		 User u =UserLocalServiceUtil.getUser(userId);
		 String screenName = u.getScreenName();
		 return screenName;
	}

	private AdminMonitor baseAdminMonitor;

	private String username;
	private String dateTime;
	private String eventType;
	private String userId;
	private String ipAddress;
}

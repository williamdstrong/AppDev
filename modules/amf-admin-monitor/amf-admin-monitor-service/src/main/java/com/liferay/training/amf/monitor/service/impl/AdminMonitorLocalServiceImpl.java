/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.amf.monitor.service.impl;

import com.liferay.portal.kernel.model.User;
import com.liferay.training.amf.monitor.model.AdminMonitor;
import com.liferay.training.amf.monitor.service.base.AdminMonitorLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the admin monitor local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.amf.monitor.service.AdminMonitorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdminMonitorLocalServiceBaseImpl
 * @see com.liferay.training.amf.monitor.service.AdminMonitorLocalServiceUtil
 */
public class AdminMonitorLocalServiceImpl
	extends AdminMonitorLocalServiceBaseImpl {

	public AdminMonitor addAdminMonitorCreationEvent(User user) {
		String eventType = "CREATE";
		return addAdminMonitor(user, eventType);
	}

	public AdminMonitor addAdminMonitorLoginEvent(User user) {
		String eventType = "LOGIN";
		return addAdminMonitor(user, eventType);
	}

	private AdminMonitor addAdminMonitor(User user, String eventType) {

		String ip;
		if (eventType.equalsIgnoreCase("create")) {
			ip = "0.0.0.0";
		}
		else {
			ip = user.getLastLoginIP();
		}

		long id = user.getUserId();

		Date date = _getNow();

		long adminMonitorId = counterLocalService.increment();
		AdminMonitor adminMonitor = adminMonitorLocalService.createAdminMonitor(adminMonitorId);

		adminMonitor.setDateTime(date);
		adminMonitor.setEventType(eventType);
		adminMonitor.setUserId(id);
		adminMonitor.setIpAddress(ip);
		adminMonitor.persist();

		return adminMonitor;
	}

	public List<AdminMonitor> getLoginEvents() {
		return findByEventType("LOGIN");
	}

	public List<AdminMonitor> getCreationEvents() {
		return findByEventType("CREATE");
	}

	private List<AdminMonitor> findByEventType(String s) {
		return adminMonitorPersistence.findByEventType(s);
	}

	private static Date _getNow() {
		return new Date();
	}

}
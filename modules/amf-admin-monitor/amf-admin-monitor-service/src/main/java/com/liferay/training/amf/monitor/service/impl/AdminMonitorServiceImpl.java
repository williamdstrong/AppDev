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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.training.amf.monitor.model.AdminMonitor;
import com.liferay.training.amf.monitor.service.base.AdminMonitorServiceBaseImpl;
import com.liferay.training.amf.monitor.service.permission.AdminMonitorPermissionChecker;

import java.util.List;

/**
 * The implementation of the admin monitor remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.amf.monitor.service.AdminMonitorService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdminMonitorServiceBaseImpl
 * @see com.liferay.training.amf.monitor.service.AdminMonitorServiceUtil
 */
public class AdminMonitorServiceImpl extends AdminMonitorServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.training.amf.monitor.service.AdminMonitorServiceUtil} to access the admin monitor remote service.
	 */

	public List<AdminMonitor> getAllEvents() throws PortalException {

		try {
			AdminMonitorPermissionChecker.check(getPermissionChecker(), "GET_ALL_DATA");

			return adminMonitorLocalService.getAllEvents();
		}
		catch (PrincipalException.MustHavePermission e) {
			AdminMonitorPermissionChecker.check(getPermissionChecker(), "GET_USER_DATA");

			ServiceContext serviceContext = new ServiceContext();
			long userId = serviceContext.getUserId();
			return adminMonitorLocalService.getAllUserEvents(userId);
		}
	}

	public List<AdminMonitor> getCreationEvents() throws PortalException {

		try {
			AdminMonitorPermissionChecker.check(getPermissionChecker(), "GET_ALL_DATA");

			return adminMonitorLocalService.getCreationEvents();
		}
		catch (PrincipalException.MustHavePermission e) {
			AdminMonitorPermissionChecker.check(getPermissionChecker(), "GET_USER_DATA");

			ServiceContext serviceContext = new ServiceContext();
			long userId = serviceContext.getUserId();
			return adminMonitorLocalService.getCreationUserEvents(userId);
		}
	}

	public List<AdminMonitor> getLoginEvents() throws PortalException {

		try {
			AdminMonitorPermissionChecker.check(getPermissionChecker(), "GET_ALL_DATA");

			return adminMonitorLocalService.getLoginEvents();
		}
		catch (PrincipalException.MustHavePermission e) {
			AdminMonitorPermissionChecker.check(getPermissionChecker(), "GET_USER_DATA");

			ServiceContext serviceContext = new ServiceContext();
			long userId = serviceContext.getUserId();
			return adminMonitorLocalService.getLoginUserEvents(userId);
		}
		return adminMonitorLocalService.getLoginEvents();
	}
}
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

package com.liferay.training.amf.monitor.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AdminMonitorService}.
 *
 * @author Brian Wing Shun Chan
 * @see AdminMonitorService
 * @generated
 */
@ProviderType
public class AdminMonitorServiceWrapper implements AdminMonitorService,
	ServiceWrapper<AdminMonitorService> {
	public AdminMonitorServiceWrapper(AdminMonitorService adminMonitorService) {
		_adminMonitorService = adminMonitorService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _adminMonitorService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.liferay.training.amf.monitor.model.AdminMonitor> getAllEvents() {
		return _adminMonitorService.getAllEvents();
	}

	@Override
	public java.util.List<com.liferay.training.amf.monitor.model.AdminMonitor> getCreationEvents() {
		return _adminMonitorService.getCreationEvents();
	}

	@Override
	public java.util.List<com.liferay.training.amf.monitor.model.AdminMonitor> getLoginEvents() {
		return _adminMonitorService.getLoginEvents();
	}

	@Override
	public AdminMonitorService getWrappedService() {
		return _adminMonitorService;
	}

	@Override
	public void setWrappedService(AdminMonitorService adminMonitorService) {
		_adminMonitorService = adminMonitorService;
	}

	private AdminMonitorService _adminMonitorService;
}
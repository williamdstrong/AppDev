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

package com.liferay.training.amf.monitor.listener;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.training.amf.monitor.service.AdminMonitorLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;



@Component(immediate = true, service = ModelListener.class)

/**
 * Provides listeners on the User Model for the Admin Monitor.
 * Provides the AdminMonitor service with User registrations, logins, and updates.
 *
 * @author William Strong
 *
 * @see com.liferay.training.amf.impl.AdminMonitorLocalServiceImpl
 */
public class UserModelListener extends BaseModelListener<User> {

	@Override
	public void onAfterCreate(User user) throws ModelListenerException {
		adminMonitorLocalService.addAdminMonitorCreationEvent(user);
		super.onAfterCreate(user);
	}

	@Reference()
	protected AdminMonitorLocalService adminMonitorLocalService;

}
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

package com.liferay.training.amf.monitor.lifecycle;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.training.amf.monitor.service.AdminMonitorLocalService;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author William Strong
 */
@Component(
	immediate = true, property = "key=login.events.post",
	service = LifecycleAction.class
)
public class LoginPreAction implements LifecycleAction {

	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent)
		throws ActionException {

		String userIdStr = lifecycleEvent.getRequest().getRemoteUser();

		long userId = Long.parseLong(userIdStr);

		User user;
		try {
			user = userLocalService.getUser(userId);
		}
		catch (PortalException pe) {
			throw new ActionException(pe.getLocalizedMessage());
		}

		adminMonitorLocalService.addAdminMonitorLoginEvent(user);
	}

	@Reference
	protected AdminMonitorLocalService adminMonitorLocalService;

	@Reference
	protected UserLocalService userLocalService;

	private static Log _log = LogFactoryUtil.getLog(
		LoginPreAction.class.getName());

}
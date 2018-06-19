/*
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

package com.liferay.training.amf.search.portlet.commands;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.training.amf.search.portlet.constants.AmfSearchPortletKeys;
import com.liferay.training.amf.search.portlet.constants.PermissionKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author William Strong
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + AmfSearchPortletKeys.PORTLET_NAME,
		"mvc.command.name=/"
	},
	service = MVCRenderCommand.class
)
public class SearchInputRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest request, RenderResponse response) {
		ThemeDisplay themeDisplay = _getThemeDisplay(request);

		PermissionChecker permissionChecker = _getPermissionChecker(
			themeDisplay);
		long groupId = _getGroupId(themeDisplay);

		boolean hasPermission = permissionChecker.hasPermission(
			groupId, AmfSearchPortletKeys.PORTLET_NAME, 0,
			PermissionKeys.CAN_MAKE_SEARCH);

		if (!hasPermission) {
			return "/NoPermission.jsp";
		}

		SessionMessages.clear(request);

		return "/SearchInput.jsp";
	}

	private static long _getGroupId(ThemeDisplay themeDisplay) {
		if (null == themeDisplay) {
			throw new IllegalArgumentException("request is null");
		}

		return themeDisplay.getScopeGroupId();
	}

	private static PermissionChecker _getPermissionChecker(
		ThemeDisplay themeDisplay) {

		if (null == themeDisplay) {
			throw new IllegalArgumentException("request is null");
		}

		return themeDisplay.getPermissionChecker();
	}

	private static ThemeDisplay _getThemeDisplay(PortletRequest request) {
		if (null == request) {
			throw new IllegalArgumentException("request is null");
		}

		return (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	}

}
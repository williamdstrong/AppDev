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

package com.liferay.training.amf.newsletter.portlet.commands;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.training.amf.newsletter.constants.NewsletterPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * @author William Strong
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + NewsletterPortletKeys.Newsletter,
		"mvc.command.name=/"
	},
	service = MVCRenderCommand.class
)
public class NewsletterRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest request, RenderResponse response) {

		return "/view.jsp";
	}


	Log _log = LogFactoryUtil.getLog(NewsletterRenderCommand.class);
}

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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.training.amf.newsletter.NewsletterIssue;
import com.liferay.training.amf.newsletter.constants.NewsletterPortletKeys;
import com.liferay.training.amf.newsletter.model.Issue;
import com.liferay.training.amf.newsletter.service.IssueLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.time.LocalDate;
import java.time.Month;
import java.util.LinkedList;
import java.util.List;


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

		List<NewsletterIssue> newsletterIssues = new LinkedList<>();

		List<Issue> issues = _issueLocalService.getIssues();


		List<NewsletterIssue> monthOfNewsletterIssues = new LinkedList<>();
		List<List<NewsletterIssue>> yearOfNewsletterIssues = new LinkedList<>();
		List<List<List<NewsletterIssue>>> allNewsletterIssues = new LinkedList<>();

		NewsletterIssue tmp;
		Month month;
		int year;
		LocalDate date;

		Month currentMonth = null;
		Integer currentYear = null;
		LocalDate currentLocalDate = null;
		for (Issue issue : issues) {
			try {
				tmp  = new NewsletterIssue(issue);
				date = tmp.getDate();
				year = date.getYear();
				month = date.getMonth();

				if (currentLocalDate == null) {
					currentLocalDate = date;
					currentMonth = month;
					currentYear = year;
				}
				else if (currentYear != year) {
					yearOfNewsletterIssues.add(monthOfNewsletterIssues);
					currentMonth = month;
					monthOfNewsletterIssues = new LinkedList<>();

					allNewsletterIssues.add(yearOfNewsletterIssues);
					currentYear = year;
					yearOfNewsletterIssues = new LinkedList<>();
				}
				else if (currentMonth != month) {
					yearOfNewsletterIssues.add(monthOfNewsletterIssues);
					currentMonth = month;
					monthOfNewsletterIssues = new LinkedList<>();
				}

				monthOfNewsletterIssues.add(tmp);
			}
			catch (PortalException e) {
				e.printStackTrace();
			}
			catch (DocumentException e) {
				e.printStackTrace();
			}
		}
		yearOfNewsletterIssues.add(monthOfNewsletterIssues);
		allNewsletterIssues.add(yearOfNewsletterIssues);
		// Get issues by year and populate NewsletterIssue object. A
		// forEach loop in the jsp will iterate through each of these
		// list and add headers.


		request.setAttribute("allNewsletterIssues", allNewsletterIssues);

		return "/view.jsp";
	}

	@Reference
	private IssueLocalService _issueLocalService;

	Log _log = LogFactoryUtil.getLog(NewsletterRenderCommand.class);
}

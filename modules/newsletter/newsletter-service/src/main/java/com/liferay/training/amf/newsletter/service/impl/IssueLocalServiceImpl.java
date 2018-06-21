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

package com.liferay.training.amf.newsletter.service.impl;

import com.liferay.journal.model.JournalFolder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.training.amf.newsletter.dto.NewsletterIssue;
import com.liferay.training.amf.newsletter.model.Issue;
import com.liferay.training.amf.newsletter.service.base.IssueLocalServiceBaseImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * The implementation of the issue local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.amf.newsletter.service.IssueLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author William Strong
 * @see IssueLocalServiceBaseImpl
 * @see com.liferay.training.amf.newsletter.service.IssueLocalServiceUtil
 */
public class IssueLocalServiceImpl extends IssueLocalServiceBaseImpl {

	public Issue addIssue(JournalFolder journalFolder) {
		long issueId = counterLocalService.increment();
		Issue issue = createIssue(issueId);

		// Issues will be ordered starting at 0 and descending in the db.
		// If a folder is removed then the numbers will be recalculated.

		issue.setIssueNumber(getLastIssueNumber());
		issue.setJournalFolderId(journalFolder.getFolderId());
		issuePersistence.update(issue);
		return issue;
	}

	@Override
	public Issue deleteIssue(Issue issue) {

		// Once an issue is removed from the database, the issue numbers need to
		// be recounted.

		return issuePersistence.remove(issue);
	}

	public Issue getIssue(long issueId) throws PortalException {
		return issuePersistence.findByPrimaryKey(issueId);
	}

	public Issue getIssueByFolderId(long folderId) throws PortalException {
		return issuePersistence.findByJournalFolderId(folderId);
	}
	public NewsletterIssue getNewsletterIssue(int issueNumber) throws
		PortalException {
		Issue issue = getIssue(issueNumber);
		return new NewsletterIssue(issue);
	}

	public List<NewsletterIssue> getNewsletterIssues() {
		List<NewsletterIssue> newsletterIssues = new LinkedList<>();
		for (Issue issue : getIssues())	{
			newsletterIssues.add(new NewsletterIssue(issue));
		}
		return newsletterIssues;
	}

	private int getLastIssueNumber() {
		return getIssuesCount();
	}

	private List<Issue> getIssues() {
		return issuePersistence.findAll();
	}

	private Issue getIssue(int issueNumber) throws PortalException {
		return issuePersistence.findByIssueNumber(issueNumber);
	}
}
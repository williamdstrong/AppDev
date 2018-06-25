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

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.training.amf.newsletter.dto.NewsletterIssue;
import com.liferay.training.amf.newsletter.model.Issue;
import com.liferay.training.amf.newsletter.service.base.IssueLocalServiceBaseImpl;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

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

		// TODO change the way this works. The user should manually choose the
		// issue number. This needs to have validation.

		issue.setIssueNumber(getLastIssueNumber());
		issue.setJournalFolderId(journalFolder.getFolderId());
		issuePersistence.update(issue);
		return issue;
	}


	/**
	 * Adds the metadata for the issue to the db.
	 *
	 * @param journalArticle a journal article with the issue structure intended
	 *                       for storing issue metadata.
	 * @throws PortalException
	 * @throws DocumentException
	 */
	public void addIssueMetaData(JournalArticle journalArticle)
		throws PortalException, DocumentException {

		long folderId = journalArticle.getFolderId();
		Issue issue = issueLocalService.getIssueByFolderId(folderId);

		int issueNumber = _getIssueNumberFromArticle(journalArticle);
		LocalDate date = _getIssueDateFromArticle(journalArticle);

		issue.setIssueNumber(issueNumber);
		issue.setIssueDate(date.toString());

		issueLocalService.updateIssue(issue);
	}

	@Override
	public Issue deleteIssue(Issue issue) {
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
		private int _getIssueNumberFromArticle(com.liferay.journal.model.JournalArticle journalArticle) throws DocumentException {

		Document document = SAXReaderUtil.read(
			journalArticle.getContentByLocale(Locale.ENGLISH.toString()));

		Node issueNumberNode = document.selectSingleNode(
			"/root/dynamic-element[@name='issueNumber']/dynamic-content");
		String issueNumber = issueNumberNode.getText();

		return Integer.parseInt(issueNumber);
	}

	private LocalDate _getIssueDateFromArticle(com.liferay.journal.model.JournalArticle journalArticle) throws DocumentException {

		Document document = SAXReaderUtil.read(
			journalArticle.getContentByLocale(Locale.ENGLISH.toString()));

		Node issueDateNode = document.selectSingleNode(
			"/root/dynamic-element[@name='issueDate']/dynamic-content");
		String issueDate = issueDateNode.getText();

		return LocalDate.parse(issueDate);
	}
}

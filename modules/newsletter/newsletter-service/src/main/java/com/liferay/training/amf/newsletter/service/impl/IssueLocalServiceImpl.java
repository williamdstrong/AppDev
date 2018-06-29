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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.training.amf.newsletter.NewsletterServiceKeys;
import com.liferay.training.amf.newsletter.model.Issue;
import com.liferay.training.amf.newsletter.service.base.IssueLocalServiceBaseImpl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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

	public List<Issue> getIssuesByYear() {
		DynamicQuery yearQuery = DynamicQueryFactoryUtil.forClass(Issue.class);
//		yearQuery.add(RestrictionsFactoryUtil.eq())
		return new LinkedList<>();
	}

	public List<Issue> getIssuesByMonth() {
		return new LinkedList<>();
	}

	public Issue addIssue(JournalFolder journalFolder) {
		long issueId = counterLocalService.increment();
		Issue issue = createIssue(issueId);

		// Issues will be ordered starting at 0 and descending in the db.

		issue.setJournalFolderId(journalFolder.getFolderId());
		issuePersistence.update(issue);
		return issue;
	}

	public List<JournalArticle> getIssueArticlesByFolderId(long folderId) {
		return _getIssueArticlesByF_D(folderId, NewsletterServiceKeys.ISSUE_DATA_STRUCTURE_KEY);
	}
	public List<JournalArticle> getIssueArticlesByIssue(Issue issue) {
		return _getIssueArticlesByF_D(issue.getJournalFolderId(), NewsletterServiceKeys.ISSUE_DATA_STRUCTURE_KEY);
	}

	private List<JournalArticle> _getIssueArticlesByF_D(
		long folderId, String ddmStructureKey) {

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(JournalArticle.class);

		dynamicQuery.add(
			PropertyFactoryUtil.forName("folderId").eq(folderId));

		dynamicQuery.add(PropertyFactoryUtil.forName(
			"DDMStructureKey").eq(ddmStructureKey));

		return dynamicQuery(dynamicQuery);
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
		LocalDate localDate = _getIssueDateFromArticle(journalArticle);
		Date date = _localDateToDate(localDate);

		issue.setIssueNumber(issueNumber);
		issue.setIssueDate(date);

		issueLocalService.updateIssue(issue);
	}

	private static Date _localDateToDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	}

	private static LocalDate _dateToLocalDate(Date date) {

		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
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


	public List<Issue> getIssues() {
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

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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.training.amf.newsletter.dto.JournalArticle;
import com.liferay.training.amf.newsletter.model.Issue;
import com.liferay.training.amf.newsletter.service.base.ArticleLocalServiceBaseImpl;

import java.time.LocalDate;
import java.util.Locale;

/**
 * The implementation of the article local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.training.amf.newsletter.service.ArticleLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * The service retrieves articles from the JournalArticle app and puts the
 * information from them in an JournalArticle object which contains
 * the article data.
 *
 * @author William Strong
 * @see ArticleLocalServiceBaseImpl
 * @see com.liferay.training.amf.newsletter.service.ArticleLocalServiceUtil
 */
public class ArticleLocalServiceImpl extends ArticleLocalServiceBaseImpl {

	public JournalArticle getArticle(long journalId)
		throws PortalException, DocumentException {
		com.liferay.journal.model.JournalArticle journalArticle1 =
			journalArticleLocalService.getLatestArticle(journalId);
		return _createNewsletterArticle(journalArticle1);
	}

	private JournalArticle _createNewsletterArticle(
		com.liferay.journal.model.JournalArticle journalArticle)
		throws DocumentException {

		Document document = SAXReaderUtil.read(
			journalArticle.getContentByLocale(Locale.ENGLISH.toString()));

		JournalArticle newsletterArticle =
			new JournalArticle();

		Node authorNode = document.selectSingleNode(
			"/root/dynamic-element[@name='author']/dynamic-content");
		String author = authorNode.getText();
		newsletterArticle.setAuthor(author);

		Node orderNode = document.selectSingleNode(
			"/root/dynamic-element[@name='order']/dynamic-content");
		String order = orderNode.getText();
		newsletterArticle.setOrder(Integer.parseInt(order));

		Node contentNode = document.selectSingleNode(
			"/root/dynamic-element[@name='content']/dynamic-content");
		String content = contentNode.getText();
		newsletterArticle.setContent(content);


		return newsletterArticle;
	}

	/**
	 * Adds the metadata for the issue to the db.
	 *
	 * @param journalArticle a journal article with the issue structure intended
	 *                       for storing issue metadata.
	 * @throws PortalException
	 * @throws DocumentException
	 */
	public void addIssueMetaData(com.liferay.journal.model.JournalArticle journalArticle) throws PortalException, DocumentException {
		long folderId = journalArticle.getFolderId();
		Issue issue = issueLocalService.getIssueByFolderId(folderId);

		int issueNumber = _getIssueNumberFromArticle(journalArticle);
		LocalDate date = _getIssueDateFromArticle(journalArticle);

		issue.setIssueNumber(issueNumber);
		issue.setIssueDate(date.toString());

		issueLocalService.updateIssue(issue);
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
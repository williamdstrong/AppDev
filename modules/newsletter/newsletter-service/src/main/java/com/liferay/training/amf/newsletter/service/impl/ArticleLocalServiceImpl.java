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
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.training.amf.newsletter.dto.NewsletterArticle;
import com.liferay.training.amf.newsletter.model.Issue;
import com.liferay.training.amf.newsletter.service.IssueLocalService;
import com.liferay.training.amf.newsletter.service.base.ArticleLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Reference;

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
 * information from them in an NewsletterArticle object which contains
 * the article data.
 *
 * @author William Strong
 * @see ArticleLocalServiceBaseImpl
 * @see com.liferay.training.amf.newsletter.service.ArticleLocalServiceUtil
 */
public class ArticleLocalServiceImpl extends ArticleLocalServiceBaseImpl {

	public NewsletterArticle getArticle(long journalId)
		throws PortalException, DocumentException {
		JournalArticle journalArticle1 =
			journalArticleLocalService.getLatestArticle(journalId);
		return _createNewsletterArticle(journalArticle1);
	}

	private NewsletterArticle _createNewsletterArticle(
		JournalArticle journalArticle)
		throws DocumentException {

		Document document = SAXReaderUtil.read(
			journalArticle.getContentByLocale(Locale.ENGLISH.toString()));

		NewsletterArticle newsletterArticle =
			new NewsletterArticle();

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

	public void addIssueMetaData(JournalArticle journalArticle) throws PortalException, DocumentException {
		long folderId = journalArticle.getFolderId();
		Issue issue = _issueLocalService.getIssueByFolderId(folderId);

		int issueNumber = _getIssueNumberFromArticle(journalArticle);
		LocalDate date = _getIssueDateFromArticle(journalArticle);

		issue.setIssueNumber(issueNumber);
		issue.setIssueDate(date.toString());
	}

	private int _getIssueNumberFromArticle(JournalArticle journalArticle) throws DocumentException {

		Document document = SAXReaderUtil.read(
			journalArticle.getContentByLocale(Locale.ENGLISH.toString()));

		Node issueNumberNode = document.selectSingleNode(
			"/root/dynamic-element[@name='issueNumber']/dynamic-content");
		String issueNumber = issueNumberNode.getText();

		return Integer.parseInt(issueNumber);
	}

	private LocalDate _getIssueDateFromArticle(JournalArticle journalArticle) throws DocumentException {

		Document document = SAXReaderUtil.read(
			journalArticle.getContentByLocale(Locale.ENGLISH.toString()));

		Node issueDateNode = document.selectSingleNode(
			"/root/dynamic-element[@name='issueDate']/dynamic-content");
		String issueDate = issueDateNode.getText();

		return LocalDate.parse(issueDate);
	}

	@Reference
	private IssueLocalService _issueLocalService;
}
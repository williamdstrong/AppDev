package com.liferay.training.amf.newsletter;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.util.Locale;

public class Article {


	public Article(long journalArticleId)
		throws PortalException, DocumentException {

		JournalArticle journalArticle =
			JournalArticleLocalServiceUtil.getArticle(journalArticleId);

		_initArticle(journalArticle);
	}

	public Article(JournalArticle journalArticle)
		throws PortalException, DocumentException {

		_initArticle(journalArticle);
	}
	private void _initArticle(JournalArticle journalArticle)
		throws DocumentException, PortalException {

		this.journalArticle = journalArticle;
		id = journalArticle.getId();
		title = _getTitleFromArticle();
		author = _getFieldFromArticle(authorKey);
		order = _getFieldFromArticle(orderKey);
		content = _getFieldFromArticle(contentKey);


	}

	private String _getTitleFromArticle() throws DocumentException {
		Document document = SAXReaderUtil.read(journalArticle.getTitle());

		Node node = document.selectSingleNode("/root/Title");
		return node.getText();
	}

	private String _getFieldFromArticle(String field) throws PortalException,
		DocumentException {

		Document document = SAXReaderUtil.read(
			journalArticle.getContentByLocale(Locale.ENGLISH.toString()));

		Node node = document.selectSingleNode(
			"/root/dynamic-element[@name='".concat(field).concat("']/dynamic-content"));
		return node.getText();
	}

	private JournalArticle journalArticle;

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getOrder() {
		return order;
	}

	public String getContent() {
		return content;
	}

	public long getId() {
		return id;
	}

	private long id;
	private String title;
	private String author;
	private String order;
	private String content;

	private String authorKey = "author";
	private String orderKey = "order";
	private String contentKey = "content";
}

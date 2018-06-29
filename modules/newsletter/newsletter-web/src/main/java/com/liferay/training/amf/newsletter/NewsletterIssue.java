package com.liferay.training.amf.newsletter;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.DocumentException;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import com.liferay.training.amf.newsletter.model.Issue;
import com.liferay.training.amf.newsletter.service.IssueLocalServiceUtil;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;


public class NewsletterIssue {


	public NewsletterIssue(Issue issue) throws PortalException, DocumentException {

		number = issue.getIssueNumber();
		date = dateToLocalDate(issue.getIssueDate());

		long folderId = issue.getJournalFolderId();
		JournalFolder journalFolder = JournalFolderLocalServiceUtil.getJournalFolder(folderId);
		description = journalFolder.getDescription();
		title = journalFolder.getName();

		articles = IssueLocalServiceUtil.getIssueArticlesByIssue(issue);

		authors = _getAuthorsFromArticle();
	}

	private List<String> _getAuthorsFromArticle() throws DocumentException {

		List<String> authorList = new LinkedList<>();
		for (JournalArticle article : articles) {
			Document document = SAXReaderUtil.read(
				article.getContentByLocale(Locale.ENGLISH.toString()));

			Node issueNumberNode = document.selectSingleNode(
				"/root/dynamic-element[@name='author']/dynamic-content");
			authorList.add(issueNumberNode.getText());
		}
		return authorList;
	}


	private static LocalDate dateToLocalDate(Date date) {
		Instant instant =date.toInstant();
		return instant.atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public List<JournalArticle> getArticles() {
		return articles;
	}

	public void setArticles(List<JournalArticle> articles) {
		this.articles = articles;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	private String title;
	private String description;
	private int number;
	private LocalDate date;
	private List<String> authors;
	private List<JournalArticle> articles;
}

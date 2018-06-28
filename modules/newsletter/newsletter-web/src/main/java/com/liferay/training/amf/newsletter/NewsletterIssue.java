package com.liferay.training.amf.newsletter;

import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.training.amf.newsletter.model.Author;
import com.liferay.training.amf.newsletter.model.Issue;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class NewsletterIssue {

	public NewsletterIssue(JournalFolder journalFolder) {

		long folderId = journalFolder.getFolderId();
		List<JournalArticle> allArticles =
			JournalArticleLocalServiceUtil.dynamicQuery(
				articleByFolderId(folderId));

		title = journalFolder.getName();
		description = journalFolder.getDescription();
	}

	private DynamicQuery articleByFolderId(long folderId) {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			com.liferay.journal.model.JournalArticle.class, PortalClassLoaderUtil.getClassLoader());

		return dynamicQuery.add(
			PropertyFactoryUtil.forName("folderId").eq(folderId));
	}

	public NewsletterIssue(Issue issue) {
		number = issue.getIssueNumber();
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

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
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
	private List<Author> authors;
	private List<JournalArticle> articles;
}

package com.liferay.training.amf.newsletter.dto;

import com.liferay.training.amf.newsletter.model.Author;
import com.liferay.training.amf.newsletter.model.Issue;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

public class NewsletterIssue {

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

	public List<NewsletterArticle> getArticles() {
		return articles;
	}

	public void setArticles(List<NewsletterArticle> articles) {
		this.articles = articles;
	}

	private String title;
	private String description;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	private int number;
	private LocalDate date;
	private List<Author> authors;
	private List<NewsletterArticle> articles;
}

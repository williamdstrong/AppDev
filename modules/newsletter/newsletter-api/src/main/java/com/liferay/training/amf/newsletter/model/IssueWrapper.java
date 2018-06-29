/**
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

package com.liferay.training.amf.newsletter.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Issue}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Issue
 * @generated
 */
@ProviderType
public class IssueWrapper implements Issue, ModelWrapper<Issue> {
	public IssueWrapper(Issue issue) {
		_issue = issue;
	}

	@Override
	public Class<?> getModelClass() {
		return Issue.class;
	}

	@Override
	public String getModelClassName() {
		return Issue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("issueId", getIssueId());
		attributes.put("issueNumber", getIssueNumber());
		attributes.put("journalFolderId", getJournalFolderId());
		attributes.put("issueDate", getIssueDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long issueId = (Long)attributes.get("issueId");

		if (issueId != null) {
			setIssueId(issueId);
		}

		Integer issueNumber = (Integer)attributes.get("issueNumber");

		if (issueNumber != null) {
			setIssueNumber(issueNumber);
		}

		Long journalFolderId = (Long)attributes.get("journalFolderId");

		if (journalFolderId != null) {
			setJournalFolderId(journalFolderId);
		}

		Date issueDate = (Date)attributes.get("issueDate");

		if (issueDate != null) {
			setIssueDate(issueDate);
		}
	}

	@Override
	public Object clone() {
		return new IssueWrapper((Issue)_issue.clone());
	}

	@Override
	public int compareTo(Issue issue) {
		return _issue.compareTo(issue);
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _issue.getExpandoBridge();
	}

	/**
	* Returns the issue date of this issue.
	*
	* @return the issue date of this issue
	*/
	@Override
	public Date getIssueDate() {
		return _issue.getIssueDate();
	}

	/**
	* Returns the issue ID of this issue.
	*
	* @return the issue ID of this issue
	*/
	@Override
	public long getIssueId() {
		return _issue.getIssueId();
	}

	/**
	* Returns the issue number of this issue.
	*
	* @return the issue number of this issue
	*/
	@Override
	public int getIssueNumber() {
		return _issue.getIssueNumber();
	}

	/**
	* Returns the journal folder ID of this issue.
	*
	* @return the journal folder ID of this issue
	*/
	@Override
	public long getJournalFolderId() {
		return _issue.getJournalFolderId();
	}

	/**
	* Returns the primary key of this issue.
	*
	* @return the primary key of this issue
	*/
	@Override
	public long getPrimaryKey() {
		return _issue.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _issue.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _issue.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _issue.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _issue.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _issue.isNew();
	}

	@Override
	public void persist() {
		_issue.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_issue.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_issue.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_issue.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_issue.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the issue date of this issue.
	*
	* @param issueDate the issue date of this issue
	*/
	@Override
	public void setIssueDate(Date issueDate) {
		_issue.setIssueDate(issueDate);
	}

	/**
	* Sets the issue ID of this issue.
	*
	* @param issueId the issue ID of this issue
	*/
	@Override
	public void setIssueId(long issueId) {
		_issue.setIssueId(issueId);
	}

	/**
	* Sets the issue number of this issue.
	*
	* @param issueNumber the issue number of this issue
	*/
	@Override
	public void setIssueNumber(int issueNumber) {
		_issue.setIssueNumber(issueNumber);
	}

	/**
	* Sets the journal folder ID of this issue.
	*
	* @param journalFolderId the journal folder ID of this issue
	*/
	@Override
	public void setJournalFolderId(long journalFolderId) {
		_issue.setJournalFolderId(journalFolderId);
	}

	@Override
	public void setNew(boolean n) {
		_issue.setNew(n);
	}

	/**
	* Sets the primary key of this issue.
	*
	* @param primaryKey the primary key of this issue
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_issue.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_issue.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Issue> toCacheModel() {
		return _issue.toCacheModel();
	}

	@Override
	public Issue toEscapedModel() {
		return new IssueWrapper(_issue.toEscapedModel());
	}

	@Override
	public String toString() {
		return _issue.toString();
	}

	@Override
	public Issue toUnescapedModel() {
		return new IssueWrapper(_issue.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _issue.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IssueWrapper)) {
			return false;
		}

		IssueWrapper issueWrapper = (IssueWrapper)obj;

		if (Objects.equals(_issue, issueWrapper._issue)) {
			return true;
		}

		return false;
	}

	@Override
	public Issue getWrappedModel() {
		return _issue;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _issue.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _issue.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_issue.resetOriginalValues();
	}

	private final Issue _issue;
}
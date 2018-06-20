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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Issue service. Represents a row in the &quot;AMF_Issue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.training.amf.newsletter.model.impl.IssueModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.training.amf.newsletter.model.impl.IssueImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Issue
 * @see com.liferay.training.amf.newsletter.model.impl.IssueImpl
 * @see com.liferay.training.amf.newsletter.model.impl.IssueModelImpl
 * @generated
 */
@ProviderType
public interface IssueModel extends BaseModel<Issue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a issue model instance should use the {@link Issue} interface instead.
	 */

	/**
	 * Returns the primary key of this issue.
	 *
	 * @return the primary key of this issue
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this issue.
	 *
	 * @param primaryKey the primary key of this issue
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the issue ID of this issue.
	 *
	 * @return the issue ID of this issue
	 */
	public long getIssueId();

	/**
	 * Sets the issue ID of this issue.
	 *
	 * @param issueId the issue ID of this issue
	 */
	public void setIssueId(long issueId);

	/**
	 * Returns the issue number of this issue.
	 *
	 * @return the issue number of this issue
	 */
	public int getIssueNumber();

	/**
	 * Sets the issue number of this issue.
	 *
	 * @param issueNumber the issue number of this issue
	 */
	public void setIssueNumber(int issueNumber);

	/**
	 * Returns the title of this issue.
	 *
	 * @return the title of this issue
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this issue.
	 *
	 * @param title the title of this issue
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this issue.
	 *
	 * @return the description of this issue
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this issue.
	 *
	 * @param description the description of this issue
	 */
	public void setDescription(String description);

	/**
	 * Returns the issue date of this issue.
	 *
	 * @return the issue date of this issue
	 */
	public Date getIssueDate();

	/**
	 * Sets the issue date of this issue.
	 *
	 * @param issueDate the issue date of this issue
	 */
	public void setIssueDate(Date issueDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(Issue issue);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Issue> toCacheModel();

	@Override
	public Issue toEscapedModel();

	@Override
	public Issue toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}
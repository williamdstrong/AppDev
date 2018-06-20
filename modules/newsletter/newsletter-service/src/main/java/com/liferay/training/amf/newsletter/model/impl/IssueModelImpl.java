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

package com.liferay.training.amf.newsletter.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.liferay.training.amf.newsletter.model.Issue;
import com.liferay.training.amf.newsletter.model.IssueModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Issue service. Represents a row in the &quot;AMF_Issue&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link IssueModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link IssueImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssueImpl
 * @see Issue
 * @see IssueModel
 * @generated
 */
@ProviderType
public class IssueModelImpl extends BaseModelImpl<Issue> implements IssueModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a issue model instance should use the {@link Issue} interface instead.
	 */
	public static final String TABLE_NAME = "AMF_Issue";
	public static final Object[][] TABLE_COLUMNS = {
			{ "issueId", Types.BIGINT },
			{ "issueNumber", Types.INTEGER },
			{ "title", Types.VARCHAR },
			{ "description", Types.VARCHAR },
			{ "issueDate", Types.TIMESTAMP }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("issueId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("issueNumber", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("issueDate", Types.TIMESTAMP);
	}

	public static final String TABLE_SQL_CREATE = "create table AMF_Issue (issueId LONG not null primary key,issueNumber INTEGER,title VARCHAR(75) null,description VARCHAR(75) null,issueDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table AMF_Issue";
	public static final String ORDER_BY_JPQL = " ORDER BY issue.issueId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY AMF_Issue.issueId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.training.amf.newsletter.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.training.amf.newsletter.model.Issue"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.training.amf.newsletter.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.training.amf.newsletter.model.Issue"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.training.amf.newsletter.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.training.amf.newsletter.model.Issue"),
			true);
	public static final long ISSUENUMBER_COLUMN_BITMASK = 1L;
	public static final long TITLE_COLUMN_BITMASK = 2L;
	public static final long ISSUEID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.training.amf.newsletter.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.training.amf.newsletter.model.Issue"));

	public IssueModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _issueId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setIssueId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _issueId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("issueDate", getIssueDate());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date issueDate = (Date)attributes.get("issueDate");

		if (issueDate != null) {
			setIssueDate(issueDate);
		}
	}

	@Override
	public long getIssueId() {
		return _issueId;
	}

	@Override
	public void setIssueId(long issueId) {
		_issueId = issueId;
	}

	@Override
	public int getIssueNumber() {
		return _issueNumber;
	}

	@Override
	public void setIssueNumber(int issueNumber) {
		_columnBitmask |= ISSUENUMBER_COLUMN_BITMASK;

		if (!_setOriginalIssueNumber) {
			_setOriginalIssueNumber = true;

			_originalIssueNumber = _issueNumber;
		}

		_issueNumber = issueNumber;
	}

	public int getOriginalIssueNumber() {
		return _originalIssueNumber;
	}

	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_columnBitmask |= TITLE_COLUMN_BITMASK;

		if (_originalTitle == null) {
			_originalTitle = _title;
		}

		_title = title;
	}

	public String getOriginalTitle() {
		return GetterUtil.getString(_originalTitle);
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
	}

	@Override
	public Date getIssueDate() {
		return _issueDate;
	}

	@Override
	public void setIssueDate(Date issueDate) {
		_issueDate = issueDate;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			Issue.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Issue toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Issue)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		IssueImpl issueImpl = new IssueImpl();

		issueImpl.setIssueId(getIssueId());
		issueImpl.setIssueNumber(getIssueNumber());
		issueImpl.setTitle(getTitle());
		issueImpl.setDescription(getDescription());
		issueImpl.setIssueDate(getIssueDate());

		issueImpl.resetOriginalValues();

		return issueImpl;
	}

	@Override
	public int compareTo(Issue issue) {
		long primaryKey = issue.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Issue)) {
			return false;
		}

		Issue issue = (Issue)obj;

		long primaryKey = issue.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		IssueModelImpl issueModelImpl = this;

		issueModelImpl._originalIssueNumber = issueModelImpl._issueNumber;

		issueModelImpl._setOriginalIssueNumber = false;

		issueModelImpl._originalTitle = issueModelImpl._title;

		issueModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Issue> toCacheModel() {
		IssueCacheModel issueCacheModel = new IssueCacheModel();

		issueCacheModel.issueId = getIssueId();

		issueCacheModel.issueNumber = getIssueNumber();

		issueCacheModel.title = getTitle();

		String title = issueCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			issueCacheModel.title = null;
		}

		issueCacheModel.description = getDescription();

		String description = issueCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			issueCacheModel.description = null;
		}

		Date issueDate = getIssueDate();

		if (issueDate != null) {
			issueCacheModel.issueDate = issueDate.getTime();
		}
		else {
			issueCacheModel.issueDate = Long.MIN_VALUE;
		}

		return issueCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{issueId=");
		sb.append(getIssueId());
		sb.append(", issueNumber=");
		sb.append(getIssueNumber());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", issueDate=");
		sb.append(getIssueDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.training.amf.newsletter.model.Issue");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>issueId</column-name><column-value><![CDATA[");
		sb.append(getIssueId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issueNumber</column-name><column-value><![CDATA[");
		sb.append(getIssueNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>issueDate</column-name><column-value><![CDATA[");
		sb.append(getIssueDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Issue.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Issue.class, ModelWrapper.class
		};
	private long _issueId;
	private int _issueNumber;
	private int _originalIssueNumber;
	private boolean _setOriginalIssueNumber;
	private String _title;
	private String _originalTitle;
	private String _description;
	private Date _issueDate;
	private long _columnBitmask;
	private Issue _escapedModel;
}
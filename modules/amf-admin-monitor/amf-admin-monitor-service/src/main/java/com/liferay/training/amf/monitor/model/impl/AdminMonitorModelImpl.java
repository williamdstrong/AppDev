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

package com.liferay.training.amf.monitor.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.training.amf.monitor.model.AdminMonitor;
import com.liferay.training.amf.monitor.model.AdminMonitorModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the AdminMonitor service. Represents a row in the &quot;AMF_AdminMonitor&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link AdminMonitorModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AdminMonitorImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdminMonitorImpl
 * @see AdminMonitor
 * @see AdminMonitorModel
 * @generated
 */
@ProviderType
public class AdminMonitorModelImpl extends BaseModelImpl<AdminMonitor>
	implements AdminMonitorModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a admin monitor model instance should use the {@link AdminMonitor} interface instead.
	 */
	public static final String TABLE_NAME = "AMF_AdminMonitor";
	public static final Object[][] TABLE_COLUMNS = {
			{ "monitorId", Types.BIGINT },
			{ "dateTime", Types.TIMESTAMP },
			{ "eventType", Types.VARCHAR },
			{ "userId", Types.BIGINT },
			{ "ipAddress", Types.VARCHAR }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("monitorId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("dateTime", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("eventType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ipAddress", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE = "create table AMF_AdminMonitor (monitorId LONG not null primary key,dateTime DATE null,eventType VARCHAR(75) null,userId LONG,ipAddress VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table AMF_AdminMonitor";
	public static final String ORDER_BY_JPQL = " ORDER BY adminMonitor.monitorId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY AMF_AdminMonitor.monitorId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.training.amf.monitor.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.training.amf.monitor.model.AdminMonitor"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.training.amf.monitor.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.training.amf.monitor.model.AdminMonitor"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.training.amf.monitor.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.training.amf.monitor.model.AdminMonitor"),
			true);
	public static final long EVENTTYPE_COLUMN_BITMASK = 1L;
	public static final long MONITORID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.training.amf.monitor.service.util.ServiceProps.get(
				"lock.expiration.time.com.liferay.training.amf.monitor.model.AdminMonitor"));

	public AdminMonitorModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _monitorId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMonitorId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _monitorId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AdminMonitor.class;
	}

	@Override
	public String getModelClassName() {
		return AdminMonitor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("monitorId", getMonitorId());
		attributes.put("dateTime", getDateTime());
		attributes.put("eventType", getEventType());
		attributes.put("userId", getUserId());
		attributes.put("ipAddress", getIpAddress());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long monitorId = (Long)attributes.get("monitorId");

		if (monitorId != null) {
			setMonitorId(monitorId);
		}

		Date dateTime = (Date)attributes.get("dateTime");

		if (dateTime != null) {
			setDateTime(dateTime);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}
	}

	@Override
	public long getMonitorId() {
		return _monitorId;
	}

	@Override
	public void setMonitorId(long monitorId) {
		_monitorId = monitorId;
	}

	@Override
	public Date getDateTime() {
		return _dateTime;
	}

	@Override
	public void setDateTime(Date dateTime) {
		_dateTime = dateTime;
	}

	@Override
	public String getEventType() {
		if (_eventType == null) {
			return StringPool.BLANK;
		}
		else {
			return _eventType;
		}
	}

	@Override
	public void setEventType(String eventType) {
		_columnBitmask |= EVENTTYPE_COLUMN_BITMASK;

		if (_originalEventType == null) {
			_originalEventType = _eventType;
		}

		_eventType = eventType;
	}

	public String getOriginalEventType() {
		return GetterUtil.getString(_originalEventType);
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return StringPool.BLANK;
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	@Override
	public String getIpAddress() {
		if (_ipAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _ipAddress;
		}
	}

	@Override
	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			AdminMonitor.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AdminMonitor toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AdminMonitor)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AdminMonitorImpl adminMonitorImpl = new AdminMonitorImpl();

		adminMonitorImpl.setMonitorId(getMonitorId());
		adminMonitorImpl.setDateTime(getDateTime());
		adminMonitorImpl.setEventType(getEventType());
		adminMonitorImpl.setUserId(getUserId());
		adminMonitorImpl.setIpAddress(getIpAddress());

		adminMonitorImpl.resetOriginalValues();

		return adminMonitorImpl;
	}

	@Override
	public int compareTo(AdminMonitor adminMonitor) {
		long primaryKey = adminMonitor.getPrimaryKey();

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

		if (!(obj instanceof AdminMonitor)) {
			return false;
		}

		AdminMonitor adminMonitor = (AdminMonitor)obj;

		long primaryKey = adminMonitor.getPrimaryKey();

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
		AdminMonitorModelImpl adminMonitorModelImpl = this;

		adminMonitorModelImpl._originalEventType = adminMonitorModelImpl._eventType;

		adminMonitorModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AdminMonitor> toCacheModel() {
		AdminMonitorCacheModel adminMonitorCacheModel = new AdminMonitorCacheModel();

		adminMonitorCacheModel.monitorId = getMonitorId();

		Date dateTime = getDateTime();

		if (dateTime != null) {
			adminMonitorCacheModel.dateTime = dateTime.getTime();
		}
		else {
			adminMonitorCacheModel.dateTime = Long.MIN_VALUE;
		}

		adminMonitorCacheModel.eventType = getEventType();

		String eventType = adminMonitorCacheModel.eventType;

		if ((eventType != null) && (eventType.length() == 0)) {
			adminMonitorCacheModel.eventType = null;
		}

		adminMonitorCacheModel.userId = getUserId();

		adminMonitorCacheModel.ipAddress = getIpAddress();

		String ipAddress = adminMonitorCacheModel.ipAddress;

		if ((ipAddress != null) && (ipAddress.length() == 0)) {
			adminMonitorCacheModel.ipAddress = null;
		}

		return adminMonitorCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{monitorId=");
		sb.append(getMonitorId());
		sb.append(", dateTime=");
		sb.append(getDateTime());
		sb.append(", eventType=");
		sb.append(getEventType());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", ipAddress=");
		sb.append(getIpAddress());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.liferay.training.amf.monitor.model.AdminMonitor");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>monitorId</column-name><column-value><![CDATA[");
		sb.append(getMonitorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateTime</column-name><column-value><![CDATA[");
		sb.append(getDateTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventType</column-name><column-value><![CDATA[");
		sb.append(getEventType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ipAddress</column-name><column-value><![CDATA[");
		sb.append(getIpAddress());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = AdminMonitor.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			AdminMonitor.class
		};
	private long _monitorId;
	private Date _dateTime;
	private String _eventType;
	private String _originalEventType;
	private long _userId;
	private String _ipAddress;
	private long _columnBitmask;
	private AdminMonitor _escapedModel;
}
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

package com.liferay.training.amf.monitor.model;

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
 * This class is a wrapper for {@link adminMonitor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see adminMonitor
 * @generated
 */
@ProviderType
public class adminMonitorWrapper implements adminMonitor,
	ModelWrapper<adminMonitor> {
	public adminMonitorWrapper(adminMonitor adminMonitor) {
		_adminMonitor = adminMonitor;
	}

	@Override
	public Class<?> getModelClass() {
		return adminMonitor.class;
	}

	@Override
	public String getModelClassName() {
		return adminMonitor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("monitorId", getMonitorId());
		attributes.put("dateTime", getDateTime());
		attributes.put("eventType", getEventType());
		attributes.put("userId", getUserId());
		attributes.put("ipAddress", getIpAddress());

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

		Long ipAddress = (Long)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _adminMonitor.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _adminMonitor.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _adminMonitor.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _adminMonitor.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<com.liferay.training.amf.monitor.model.adminMonitor> toCacheModel() {
		return _adminMonitor.toCacheModel();
	}

	@Override
	public com.liferay.training.amf.monitor.model.adminMonitor toEscapedModel() {
		return new adminMonitorWrapper(_adminMonitor.toEscapedModel());
	}

	@Override
	public com.liferay.training.amf.monitor.model.adminMonitor toUnescapedModel() {
		return new adminMonitorWrapper(_adminMonitor.toUnescapedModel());
	}

	@Override
	public int compareTo(
		com.liferay.training.amf.monitor.model.adminMonitor adminMonitor) {
		return _adminMonitor.compareTo(adminMonitor);
	}

	@Override
	public int hashCode() {
		return _adminMonitor.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _adminMonitor.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new adminMonitorWrapper((adminMonitor)_adminMonitor.clone());
	}

	/**
	* Returns the event type of this admin monitor.
	*
	* @return the event type of this admin monitor
	*/
	@Override
	public java.lang.String getEventType() {
		return _adminMonitor.getEventType();
	}

	/**
	* Returns the user uuid of this admin monitor.
	*
	* @return the user uuid of this admin monitor
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _adminMonitor.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _adminMonitor.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _adminMonitor.toXmlString();
	}

	/**
	* Returns the date time of this admin monitor.
	*
	* @return the date time of this admin monitor
	*/
	@Override
	public Date getDateTime() {
		return _adminMonitor.getDateTime();
	}

	/**
	* Returns the ip address of this admin monitor.
	*
	* @return the ip address of this admin monitor
	*/
	@Override
	public long getIpAddress() {
		return _adminMonitor.getIpAddress();
	}

	/**
	* Returns the monitor ID of this admin monitor.
	*
	* @return the monitor ID of this admin monitor
	*/
	@Override
	public long getMonitorId() {
		return _adminMonitor.getMonitorId();
	}

	/**
	* Returns the primary key of this admin monitor.
	*
	* @return the primary key of this admin monitor
	*/
	@Override
	public long getPrimaryKey() {
		return _adminMonitor.getPrimaryKey();
	}

	/**
	* Returns the user ID of this admin monitor.
	*
	* @return the user ID of this admin monitor
	*/
	@Override
	public long getUserId() {
		return _adminMonitor.getUserId();
	}

	@Override
	public void persist() {
		_adminMonitor.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_adminMonitor.setCachedModel(cachedModel);
	}

	/**
	* Sets the date time of this admin monitor.
	*
	* @param dateTime the date time of this admin monitor
	*/
	@Override
	public void setDateTime(Date dateTime) {
		_adminMonitor.setDateTime(dateTime);
	}

	/**
	* Sets the event type of this admin monitor.
	*
	* @param eventType the event type of this admin monitor
	*/
	@Override
	public void setEventType(java.lang.String eventType) {
		_adminMonitor.setEventType(eventType);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_adminMonitor.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_adminMonitor.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_adminMonitor.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ip address of this admin monitor.
	*
	* @param ipAddress the ip address of this admin monitor
	*/
	@Override
	public void setIpAddress(long ipAddress) {
		_adminMonitor.setIpAddress(ipAddress);
	}

	/**
	* Sets the monitor ID of this admin monitor.
	*
	* @param monitorId the monitor ID of this admin monitor
	*/
	@Override
	public void setMonitorId(long monitorId) {
		_adminMonitor.setMonitorId(monitorId);
	}

	@Override
	public void setNew(boolean n) {
		_adminMonitor.setNew(n);
	}

	/**
	* Sets the primary key of this admin monitor.
	*
	* @param primaryKey the primary key of this admin monitor
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_adminMonitor.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_adminMonitor.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this admin monitor.
	*
	* @param userId the user ID of this admin monitor
	*/
	@Override
	public void setUserId(long userId) {
		_adminMonitor.setUserId(userId);
	}

	/**
	* Sets the user uuid of this admin monitor.
	*
	* @param userUuid the user uuid of this admin monitor
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_adminMonitor.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof adminMonitorWrapper)) {
			return false;
		}

		adminMonitorWrapper adminMonitorWrapper = (adminMonitorWrapper)obj;

		if (Objects.equals(_adminMonitor, adminMonitorWrapper._adminMonitor)) {
			return true;
		}

		return false;
	}

	@Override
	public adminMonitor getWrappedModel() {
		return _adminMonitor;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _adminMonitor.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _adminMonitor.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_adminMonitor.resetOriginalValues();
	}

	private final adminMonitor _adminMonitor;
}
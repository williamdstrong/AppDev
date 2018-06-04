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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.liferay.training.amf.monitor.service.http.adminMonitorServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.training.amf.monitor.service.http.adminMonitorServiceSoap
 * @generated
 */
@ProviderType
public class adminMonitorSoap implements Serializable {
	public static adminMonitorSoap toSoapModel(adminMonitor model) {
		adminMonitorSoap soapModel = new adminMonitorSoap();

		soapModel.setMonitorId(model.getMonitorId());
		soapModel.setDateTime(model.getDateTime());
		soapModel.setEventType(model.getEventType());
		soapModel.setUserId(model.getUserId());
		soapModel.setIpAddress(model.getIpAddress());

		return soapModel;
	}

	public static adminMonitorSoap[] toSoapModels(adminMonitor[] models) {
		adminMonitorSoap[] soapModels = new adminMonitorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static adminMonitorSoap[][] toSoapModels(adminMonitor[][] models) {
		adminMonitorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new adminMonitorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new adminMonitorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static adminMonitorSoap[] toSoapModels(List<adminMonitor> models) {
		List<adminMonitorSoap> soapModels = new ArrayList<adminMonitorSoap>(models.size());

		for (adminMonitor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new adminMonitorSoap[soapModels.size()]);
	}

	public adminMonitorSoap() {
	}

	public long getPrimaryKey() {
		return _monitorId;
	}

	public void setPrimaryKey(long pk) {
		setMonitorId(pk);
	}

	public long getMonitorId() {
		return _monitorId;
	}

	public void setMonitorId(long monitorId) {
		_monitorId = monitorId;
	}

	public Date getDateTime() {
		return _dateTime;
	}

	public void setDateTime(Date dateTime) {
		_dateTime = dateTime;
	}

	public String getEventType() {
		return _eventType;
	}

	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getIpAddress() {
		return _ipAddress;
	}

	public void setIpAddress(long ipAddress) {
		_ipAddress = ipAddress;
	}

	private long _monitorId;
	private Date _dateTime;
	private String _eventType;
	private long _userId;
	private long _ipAddress;
}
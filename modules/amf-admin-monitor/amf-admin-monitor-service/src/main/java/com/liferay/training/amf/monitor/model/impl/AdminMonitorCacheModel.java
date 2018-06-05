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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.liferay.training.amf.monitor.model.AdminMonitor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AdminMonitor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see AdminMonitor
 * @generated
 */
@ProviderType
public class AdminMonitorCacheModel implements CacheModel<AdminMonitor>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AdminMonitorCacheModel)) {
			return false;
		}

		AdminMonitorCacheModel adminMonitorCacheModel = (AdminMonitorCacheModel)obj;

		if (monitorId == adminMonitorCacheModel.monitorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, monitorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{monitorId=");
		sb.append(monitorId);
		sb.append(", dateTime=");
		sb.append(dateTime);
		sb.append(", eventType=");
		sb.append(eventType);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AdminMonitor toEntityModel() {
		AdminMonitorImpl adminMonitorImpl = new AdminMonitorImpl();

		adminMonitorImpl.setMonitorId(monitorId);

		if (dateTime == Long.MIN_VALUE) {
			adminMonitorImpl.setDateTime(null);
		}
		else {
			adminMonitorImpl.setDateTime(new Date(dateTime));
		}

		if (eventType == null) {
			adminMonitorImpl.setEventType(StringPool.BLANK);
		}
		else {
			adminMonitorImpl.setEventType(eventType);
		}

		adminMonitorImpl.setUserId(userId);

		if (ipAddress == null) {
			adminMonitorImpl.setIpAddress(StringPool.BLANK);
		}
		else {
			adminMonitorImpl.setIpAddress(ipAddress);
		}

		adminMonitorImpl.resetOriginalValues();

		return adminMonitorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		monitorId = objectInput.readLong();
		dateTime = objectInput.readLong();
		eventType = objectInput.readUTF();

		userId = objectInput.readLong();
		ipAddress = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(monitorId);
		objectOutput.writeLong(dateTime);

		if (eventType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventType);
		}

		objectOutput.writeLong(userId);

		if (ipAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ipAddress);
		}
	}

	public long monitorId;
	public long dateTime;
	public String eventType;
	public long userId;
	public String ipAddress;
}
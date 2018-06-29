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

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import com.liferay.training.amf.newsletter.model.Issue;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Issue in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Issue
 * @generated
 */
@ProviderType
public class IssueCacheModel implements CacheModel<Issue>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof IssueCacheModel)) {
			return false;
		}

		IssueCacheModel issueCacheModel = (IssueCacheModel)obj;

		if (issueId == issueCacheModel.issueId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, issueId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{issueId=");
		sb.append(issueId);
		sb.append(", issueNumber=");
		sb.append(issueNumber);
		sb.append(", journalFolderId=");
		sb.append(journalFolderId);
		sb.append(", issueDate=");
		sb.append(issueDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Issue toEntityModel() {
		IssueImpl issueImpl = new IssueImpl();

		issueImpl.setIssueId(issueId);
		issueImpl.setIssueNumber(issueNumber);
		issueImpl.setJournalFolderId(journalFolderId);

		if (issueDate == Long.MIN_VALUE) {
			issueImpl.setIssueDate(null);
		}
		else {
			issueImpl.setIssueDate(new Date(issueDate));
		}

		issueImpl.resetOriginalValues();

		return issueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		issueId = objectInput.readLong();

		issueNumber = objectInput.readInt();

		journalFolderId = objectInput.readLong();
		issueDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(issueId);

		objectOutput.writeInt(issueNumber);

		objectOutput.writeLong(journalFolderId);
		objectOutput.writeLong(issueDate);
	}

	public long issueId;
	public int issueNumber;
	public long journalFolderId;
	public long issueDate;
}
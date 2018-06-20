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

import com.liferay.training.amf.newsletter.model.ArticleAuthor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ArticleAuthor in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see ArticleAuthor
 * @generated
 */
@ProviderType
public class ArticleAuthorCacheModel implements CacheModel<ArticleAuthor>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArticleAuthorCacheModel)) {
			return false;
		}

		ArticleAuthorCacheModel articleAuthorCacheModel = (ArticleAuthorCacheModel)obj;

		if (articleAuthorId == articleAuthorCacheModel.articleAuthorId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, articleAuthorId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{articleAuthorId=");
		sb.append(articleAuthorId);
		sb.append(", articlePk=");
		sb.append(articlePk);
		sb.append(", authorPk=");
		sb.append(authorPk);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ArticleAuthor toEntityModel() {
		ArticleAuthorImpl articleAuthorImpl = new ArticleAuthorImpl();

		articleAuthorImpl.setArticleAuthorId(articleAuthorId);
		articleAuthorImpl.setArticlePk(articlePk);
		articleAuthorImpl.setAuthorPk(authorPk);

		articleAuthorImpl.resetOriginalValues();

		return articleAuthorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		articleAuthorId = objectInput.readLong();

		articlePk = objectInput.readLong();

		authorPk = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(articleAuthorId);

		objectOutput.writeLong(articlePk);

		objectOutput.writeLong(authorPk);
	}

	public long articleAuthorId;
	public long articlePk;
	public long authorPk;
}
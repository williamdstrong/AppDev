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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class ArticleAuthorSoap implements Serializable {
	public static ArticleAuthorSoap toSoapModel(ArticleAuthor model) {
		ArticleAuthorSoap soapModel = new ArticleAuthorSoap();

		soapModel.setArticleAuthorId(model.getArticleAuthorId());
		soapModel.setArticlePk(model.getArticlePk());
		soapModel.setAuthorPk(model.getAuthorPk());

		return soapModel;
	}

	public static ArticleAuthorSoap[] toSoapModels(ArticleAuthor[] models) {
		ArticleAuthorSoap[] soapModels = new ArticleAuthorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ArticleAuthorSoap[][] toSoapModels(ArticleAuthor[][] models) {
		ArticleAuthorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ArticleAuthorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ArticleAuthorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ArticleAuthorSoap[] toSoapModels(List<ArticleAuthor> models) {
		List<ArticleAuthorSoap> soapModels = new ArrayList<ArticleAuthorSoap>(models.size());

		for (ArticleAuthor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ArticleAuthorSoap[soapModels.size()]);
	}

	public ArticleAuthorSoap() {
	}

	public long getPrimaryKey() {
		return _articleAuthorId;
	}

	public void setPrimaryKey(long pk) {
		setArticleAuthorId(pk);
	}

	public long getArticleAuthorId() {
		return _articleAuthorId;
	}

	public void setArticleAuthorId(long articleAuthorId) {
		_articleAuthorId = articleAuthorId;
	}

	public long getArticlePk() {
		return _articlePk;
	}

	public void setArticlePk(long articlePk) {
		_articlePk = articlePk;
	}

	public long getAuthorPk() {
		return _authorPk;
	}

	public void setAuthorPk(long authorPk) {
		_authorPk = authorPk;
	}

	private long _articleAuthorId;
	private long _articlePk;
	private long _authorPk;
}
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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link ArticleAuthor}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticleAuthor
 * @generated
 */
@ProviderType
public class ArticleAuthorWrapper implements ArticleAuthor,
	ModelWrapper<ArticleAuthor> {
	public ArticleAuthorWrapper(ArticleAuthor articleAuthor) {
		_articleAuthor = articleAuthor;
	}

	@Override
	public Class<?> getModelClass() {
		return ArticleAuthor.class;
	}

	@Override
	public String getModelClassName() {
		return ArticleAuthor.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("articleAuthorId", getArticleAuthorId());
		attributes.put("articlePk", getArticlePk());
		attributes.put("authorPk", getAuthorPk());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long articleAuthorId = (Long)attributes.get("articleAuthorId");

		if (articleAuthorId != null) {
			setArticleAuthorId(articleAuthorId);
		}

		Long articlePk = (Long)attributes.get("articlePk");

		if (articlePk != null) {
			setArticlePk(articlePk);
		}

		Long authorPk = (Long)attributes.get("authorPk");

		if (authorPk != null) {
			setAuthorPk(authorPk);
		}
	}

	@Override
	public Object clone() {
		return new ArticleAuthorWrapper((ArticleAuthor)_articleAuthor.clone());
	}

	@Override
	public int compareTo(ArticleAuthor articleAuthor) {
		return _articleAuthor.compareTo(articleAuthor);
	}

	/**
	* Returns the article author ID of this article author.
	*
	* @return the article author ID of this article author
	*/
	@Override
	public long getArticleAuthorId() {
		return _articleAuthor.getArticleAuthorId();
	}

	/**
	* Returns the article pk of this article author.
	*
	* @return the article pk of this article author
	*/
	@Override
	public long getArticlePk() {
		return _articleAuthor.getArticlePk();
	}

	/**
	* Returns the author pk of this article author.
	*
	* @return the author pk of this article author
	*/
	@Override
	public long getAuthorPk() {
		return _articleAuthor.getAuthorPk();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _articleAuthor.getExpandoBridge();
	}

	/**
	* Returns the primary key of this article author.
	*
	* @return the primary key of this article author
	*/
	@Override
	public long getPrimaryKey() {
		return _articleAuthor.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _articleAuthor.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _articleAuthor.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _articleAuthor.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _articleAuthor.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _articleAuthor.isNew();
	}

	/**
	* Sets the article author ID of this article author.
	*
	* @param articleAuthorId the article author ID of this article author
	*/
	@Override
	public void setArticleAuthorId(long articleAuthorId) {
		_articleAuthor.setArticleAuthorId(articleAuthorId);
	}

	/**
	* Sets the article pk of this article author.
	*
	* @param articlePk the article pk of this article author
	*/
	@Override
	public void setArticlePk(long articlePk) {
		_articleAuthor.setArticlePk(articlePk);
	}

	/**
	* Sets the author pk of this article author.
	*
	* @param authorPk the author pk of this article author
	*/
	@Override
	public void setAuthorPk(long authorPk) {
		_articleAuthor.setAuthorPk(authorPk);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_articleAuthor.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_articleAuthor.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_articleAuthor.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_articleAuthor.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public void setNew(boolean n) {
		_articleAuthor.setNew(n);
	}

	/**
	* Sets the primary key of this article author.
	*
	* @param primaryKey the primary key of this article author
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_articleAuthor.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_articleAuthor.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<ArticleAuthor> toCacheModel() {
		return _articleAuthor.toCacheModel();
	}

	@Override
	public ArticleAuthor toEscapedModel() {
		return new ArticleAuthorWrapper(_articleAuthor.toEscapedModel());
	}

	@Override
	public String toString() {
		return _articleAuthor.toString();
	}

	@Override
	public ArticleAuthor toUnescapedModel() {
		return new ArticleAuthorWrapper(_articleAuthor.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _articleAuthor.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ArticleAuthorWrapper)) {
			return false;
		}

		ArticleAuthorWrapper articleAuthorWrapper = (ArticleAuthorWrapper)obj;

		if (Objects.equals(_articleAuthor, articleAuthorWrapper._articleAuthor)) {
			return true;
		}

		return false;
	}

	@Override
	public ArticleAuthor getWrappedModel() {
		return _articleAuthor;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _articleAuthor.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _articleAuthor.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_articleAuthor.resetOriginalValues();
	}

	private final ArticleAuthor _articleAuthor;
}
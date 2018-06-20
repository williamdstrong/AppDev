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
 * This class is a wrapper for {@link Author}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Author
 * @generated
 */
@ProviderType
public class AuthorWrapper implements Author, ModelWrapper<Author> {
	public AuthorWrapper(Author author) {
		_author = author;
	}

	@Override
	public Class<?> getModelClass() {
		return Author.class;
	}

	@Override
	public String getModelClassName() {
		return Author.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("authorId", getAuthorId());
		attributes.put("name", getName());
		attributes.put("articleAuthorTable", getArticleAuthorTable());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long articleAuthorTable = (Long)attributes.get("articleAuthorTable");

		if (articleAuthorTable != null) {
			setArticleAuthorTable(articleAuthorTable);
		}
	}

	@Override
	public Object clone() {
		return new AuthorWrapper((Author)_author.clone());
	}

	@Override
	public int compareTo(Author author) {
		return _author.compareTo(author);
	}

	/**
	* Returns the article author table of this author.
	*
	* @return the article author table of this author
	*/
	@Override
	public long getArticleAuthorTable() {
		return _author.getArticleAuthorTable();
	}

	/**
	* Returns the author ID of this author.
	*
	* @return the author ID of this author
	*/
	@Override
	public long getAuthorId() {
		return _author.getAuthorId();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _author.getExpandoBridge();
	}

	/**
	* Returns the name of this author.
	*
	* @return the name of this author
	*/
	@Override
	public String getName() {
		return _author.getName();
	}

	/**
	* Returns the primary key of this author.
	*
	* @return the primary key of this author
	*/
	@Override
	public long getPrimaryKey() {
		return _author.getPrimaryKey();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _author.getPrimaryKeyObj();
	}

	@Override
	public int hashCode() {
		return _author.hashCode();
	}

	@Override
	public boolean isCachedModel() {
		return _author.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _author.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _author.isNew();
	}

	@Override
	public void persist() {
		_author.persist();
	}

	/**
	* Sets the article author table of this author.
	*
	* @param articleAuthorTable the article author table of this author
	*/
	@Override
	public void setArticleAuthorTable(long articleAuthorTable) {
		_author.setArticleAuthorTable(articleAuthorTable);
	}

	/**
	* Sets the author ID of this author.
	*
	* @param authorId the author ID of this author
	*/
	@Override
	public void setAuthorId(long authorId) {
		_author.setAuthorId(authorId);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_author.setCachedModel(cachedModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_author.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_author.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_author.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the name of this author.
	*
	* @param name the name of this author
	*/
	@Override
	public void setName(String name) {
		_author.setName(name);
	}

	@Override
	public void setNew(boolean n) {
		_author.setNew(n);
	}

	/**
	* Sets the primary key of this author.
	*
	* @param primaryKey the primary key of this author
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_author.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_author.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Author> toCacheModel() {
		return _author.toCacheModel();
	}

	@Override
	public Author toEscapedModel() {
		return new AuthorWrapper(_author.toEscapedModel());
	}

	@Override
	public String toString() {
		return _author.toString();
	}

	@Override
	public Author toUnescapedModel() {
		return new AuthorWrapper(_author.toUnescapedModel());
	}

	@Override
	public String toXmlString() {
		return _author.toXmlString();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AuthorWrapper)) {
			return false;
		}

		AuthorWrapper authorWrapper = (AuthorWrapper)obj;

		if (Objects.equals(_author, authorWrapper._author)) {
			return true;
		}

		return false;
	}

	@Override
	public Author getWrappedModel() {
		return _author;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _author.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _author.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_author.resetOriginalValues();
	}

	private final Author _author;
}
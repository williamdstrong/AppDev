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

package com.liferay.training.amf.newsletter.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.liferay.training.amf.newsletter.exception.NoSuchArticleAuthorException;
import com.liferay.training.amf.newsletter.model.ArticleAuthor;

/**
 * The persistence interface for the article author service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.training.amf.newsletter.service.persistence.impl.ArticleAuthorPersistenceImpl
 * @see ArticleAuthorUtil
 * @generated
 */
@ProviderType
public interface ArticleAuthorPersistence extends BasePersistence<ArticleAuthor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ArticleAuthorUtil} to access the article author persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the article author in the entity cache if it is enabled.
	*
	* @param articleAuthor the article author
	*/
	public void cacheResult(ArticleAuthor articleAuthor);

	/**
	* Caches the article authors in the entity cache if it is enabled.
	*
	* @param articleAuthors the article authors
	*/
	public void cacheResult(java.util.List<ArticleAuthor> articleAuthors);

	/**
	* Creates a new article author with the primary key. Does not add the article author to the database.
	*
	* @param articleAuthorId the primary key for the new article author
	* @return the new article author
	*/
	public ArticleAuthor create(long articleAuthorId);

	/**
	* Removes the article author with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param articleAuthorId the primary key of the article author
	* @return the article author that was removed
	* @throws NoSuchArticleAuthorException if a article author with the primary key could not be found
	*/
	public ArticleAuthor remove(long articleAuthorId)
		throws NoSuchArticleAuthorException;

	public ArticleAuthor updateImpl(ArticleAuthor articleAuthor);

	/**
	* Returns the article author with the primary key or throws a {@link NoSuchArticleAuthorException} if it could not be found.
	*
	* @param articleAuthorId the primary key of the article author
	* @return the article author
	* @throws NoSuchArticleAuthorException if a article author with the primary key could not be found
	*/
	public ArticleAuthor findByPrimaryKey(long articleAuthorId)
		throws NoSuchArticleAuthorException;

	/**
	* Returns the article author with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param articleAuthorId the primary key of the article author
	* @return the article author, or <code>null</code> if a article author with the primary key could not be found
	*/
	public ArticleAuthor fetchByPrimaryKey(long articleAuthorId);

	@Override
	public java.util.Map<java.io.Serializable, ArticleAuthor> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the article authors.
	*
	* @return the article authors
	*/
	public java.util.List<ArticleAuthor> findAll();

	/**
	* Returns a range of all the article authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArticleAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of article authors
	* @param end the upper bound of the range of article authors (not inclusive)
	* @return the range of article authors
	*/
	public java.util.List<ArticleAuthor> findAll(int start, int end);

	/**
	* Returns an ordered range of all the article authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArticleAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of article authors
	* @param end the upper bound of the range of article authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of article authors
	*/
	public java.util.List<ArticleAuthor> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleAuthor> orderByComparator);

	/**
	* Returns an ordered range of all the article authors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ArticleAuthorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of article authors
	* @param end the upper bound of the range of article authors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of article authors
	*/
	public java.util.List<ArticleAuthor> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ArticleAuthor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the article authors from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of article authors.
	*
	* @return the number of article authors
	*/
	public int countAll();
}
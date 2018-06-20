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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.training.amf.newsletter.model.ArticleAuthor;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the article author service. This utility wraps {@link com.liferay.training.amf.newsletter.service.persistence.impl.ArticleAuthorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticleAuthorPersistence
 * @see com.liferay.training.amf.newsletter.service.persistence.impl.ArticleAuthorPersistenceImpl
 * @generated
 */
@ProviderType
public class ArticleAuthorUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ArticleAuthor articleAuthor) {
		getPersistence().clearCache(articleAuthor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ArticleAuthor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ArticleAuthor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ArticleAuthor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ArticleAuthor> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ArticleAuthor update(ArticleAuthor articleAuthor) {
		return getPersistence().update(articleAuthor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ArticleAuthor update(ArticleAuthor articleAuthor,
		ServiceContext serviceContext) {
		return getPersistence().update(articleAuthor, serviceContext);
	}

	/**
	* Caches the article author in the entity cache if it is enabled.
	*
	* @param articleAuthor the article author
	*/
	public static void cacheResult(ArticleAuthor articleAuthor) {
		getPersistence().cacheResult(articleAuthor);
	}

	/**
	* Caches the article authors in the entity cache if it is enabled.
	*
	* @param articleAuthors the article authors
	*/
	public static void cacheResult(List<ArticleAuthor> articleAuthors) {
		getPersistence().cacheResult(articleAuthors);
	}

	/**
	* Creates a new article author with the primary key. Does not add the article author to the database.
	*
	* @param articleAuthorId the primary key for the new article author
	* @return the new article author
	*/
	public static ArticleAuthor create(long articleAuthorId) {
		return getPersistence().create(articleAuthorId);
	}

	/**
	* Removes the article author with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param articleAuthorId the primary key of the article author
	* @return the article author that was removed
	* @throws NoSuchArticleAuthorException if a article author with the primary key could not be found
	*/
	public static ArticleAuthor remove(long articleAuthorId)
		throws com.liferay.training.amf.newsletter.exception.NoSuchArticleAuthorException {
		return getPersistence().remove(articleAuthorId);
	}

	public static ArticleAuthor updateImpl(ArticleAuthor articleAuthor) {
		return getPersistence().updateImpl(articleAuthor);
	}

	/**
	* Returns the article author with the primary key or throws a {@link NoSuchArticleAuthorException} if it could not be found.
	*
	* @param articleAuthorId the primary key of the article author
	* @return the article author
	* @throws NoSuchArticleAuthorException if a article author with the primary key could not be found
	*/
	public static ArticleAuthor findByPrimaryKey(long articleAuthorId)
		throws com.liferay.training.amf.newsletter.exception.NoSuchArticleAuthorException {
		return getPersistence().findByPrimaryKey(articleAuthorId);
	}

	/**
	* Returns the article author with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param articleAuthorId the primary key of the article author
	* @return the article author, or <code>null</code> if a article author with the primary key could not be found
	*/
	public static ArticleAuthor fetchByPrimaryKey(long articleAuthorId) {
		return getPersistence().fetchByPrimaryKey(articleAuthorId);
	}

	public static java.util.Map<java.io.Serializable, ArticleAuthor> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the article authors.
	*
	* @return the article authors
	*/
	public static List<ArticleAuthor> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ArticleAuthor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ArticleAuthor> findAll(int start, int end,
		OrderByComparator<ArticleAuthor> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ArticleAuthor> findAll(int start, int end,
		OrderByComparator<ArticleAuthor> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the article authors from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of article authors.
	*
	* @return the number of article authors
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ArticleAuthorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ArticleAuthorPersistence, ArticleAuthorPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ArticleAuthorPersistence.class);

		ServiceTracker<ArticleAuthorPersistence, ArticleAuthorPersistence> serviceTracker =
			new ServiceTracker<ArticleAuthorPersistence, ArticleAuthorPersistence>(bundle.getBundleContext(),
				ArticleAuthorPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
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

import com.liferay.training.amf.newsletter.model.Issue;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the issue service. This utility wraps {@link com.liferay.training.amf.newsletter.service.persistence.impl.IssuePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssuePersistence
 * @see com.liferay.training.amf.newsletter.service.persistence.impl.IssuePersistenceImpl
 * @generated
 */
@ProviderType
public class IssueUtil {
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
	public static void clearCache(Issue issue) {
		getPersistence().clearCache(issue);
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
	public static List<Issue> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Issue> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Issue> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Issue> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Issue update(Issue issue) {
		return getPersistence().update(issue);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Issue update(Issue issue, ServiceContext serviceContext) {
		return getPersistence().update(issue, serviceContext);
	}

	/**
	* Returns the issue where issueNumber = &#63; or throws a {@link NoSuchIssueException} if it could not be found.
	*
	* @param issueNumber the issue number
	* @return the matching issue
	* @throws NoSuchIssueException if a matching issue could not be found
	*/
	public static Issue findByIssueNumber(int issueNumber)
		throws com.liferay.training.amf.newsletter.exception.NoSuchIssueException {
		return getPersistence().findByIssueNumber(issueNumber);
	}

	/**
	* Returns the issue where issueNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param issueNumber the issue number
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	*/
	public static Issue fetchByIssueNumber(int issueNumber) {
		return getPersistence().fetchByIssueNumber(issueNumber);
	}

	/**
	* Returns the issue where issueNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param issueNumber the issue number
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	*/
	public static Issue fetchByIssueNumber(int issueNumber,
		boolean retrieveFromCache) {
		return getPersistence()
				   .fetchByIssueNumber(issueNumber, retrieveFromCache);
	}

	/**
	* Removes the issue where issueNumber = &#63; from the database.
	*
	* @param issueNumber the issue number
	* @return the issue that was removed
	*/
	public static Issue removeByIssueNumber(int issueNumber)
		throws com.liferay.training.amf.newsletter.exception.NoSuchIssueException {
		return getPersistence().removeByIssueNumber(issueNumber);
	}

	/**
	* Returns the number of issues where issueNumber = &#63;.
	*
	* @param issueNumber the issue number
	* @return the number of matching issues
	*/
	public static int countByIssueNumber(int issueNumber) {
		return getPersistence().countByIssueNumber(issueNumber);
	}

	/**
	* Returns the issue where title = &#63; or throws a {@link NoSuchIssueException} if it could not be found.
	*
	* @param title the title
	* @return the matching issue
	* @throws NoSuchIssueException if a matching issue could not be found
	*/
	public static Issue findByTitle(String title)
		throws com.liferay.training.amf.newsletter.exception.NoSuchIssueException {
		return getPersistence().findByTitle(title);
	}

	/**
	* Returns the issue where title = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param title the title
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	*/
	public static Issue fetchByTitle(String title) {
		return getPersistence().fetchByTitle(title);
	}

	/**
	* Returns the issue where title = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param title the title
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	*/
	public static Issue fetchByTitle(String title, boolean retrieveFromCache) {
		return getPersistence().fetchByTitle(title, retrieveFromCache);
	}

	/**
	* Removes the issue where title = &#63; from the database.
	*
	* @param title the title
	* @return the issue that was removed
	*/
	public static Issue removeByTitle(String title)
		throws com.liferay.training.amf.newsletter.exception.NoSuchIssueException {
		return getPersistence().removeByTitle(title);
	}

	/**
	* Returns the number of issues where title = &#63;.
	*
	* @param title the title
	* @return the number of matching issues
	*/
	public static int countByTitle(String title) {
		return getPersistence().countByTitle(title);
	}

	/**
	* Caches the issue in the entity cache if it is enabled.
	*
	* @param issue the issue
	*/
	public static void cacheResult(Issue issue) {
		getPersistence().cacheResult(issue);
	}

	/**
	* Caches the issues in the entity cache if it is enabled.
	*
	* @param issues the issues
	*/
	public static void cacheResult(List<Issue> issues) {
		getPersistence().cacheResult(issues);
	}

	/**
	* Creates a new issue with the primary key. Does not add the issue to the database.
	*
	* @param issueId the primary key for the new issue
	* @return the new issue
	*/
	public static Issue create(long issueId) {
		return getPersistence().create(issueId);
	}

	/**
	* Removes the issue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param issueId the primary key of the issue
	* @return the issue that was removed
	* @throws NoSuchIssueException if a issue with the primary key could not be found
	*/
	public static Issue remove(long issueId)
		throws com.liferay.training.amf.newsletter.exception.NoSuchIssueException {
		return getPersistence().remove(issueId);
	}

	public static Issue updateImpl(Issue issue) {
		return getPersistence().updateImpl(issue);
	}

	/**
	* Returns the issue with the primary key or throws a {@link NoSuchIssueException} if it could not be found.
	*
	* @param issueId the primary key of the issue
	* @return the issue
	* @throws NoSuchIssueException if a issue with the primary key could not be found
	*/
	public static Issue findByPrimaryKey(long issueId)
		throws com.liferay.training.amf.newsletter.exception.NoSuchIssueException {
		return getPersistence().findByPrimaryKey(issueId);
	}

	/**
	* Returns the issue with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param issueId the primary key of the issue
	* @return the issue, or <code>null</code> if a issue with the primary key could not be found
	*/
	public static Issue fetchByPrimaryKey(long issueId) {
		return getPersistence().fetchByPrimaryKey(issueId);
	}

	public static java.util.Map<java.io.Serializable, Issue> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the issues.
	*
	* @return the issues
	*/
	public static List<Issue> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the issues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of issues
	* @param end the upper bound of the range of issues (not inclusive)
	* @return the range of issues
	*/
	public static List<Issue> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the issues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of issues
	* @param end the upper bound of the range of issues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of issues
	*/
	public static List<Issue> findAll(int start, int end,
		OrderByComparator<Issue> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the issues.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link IssueModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of issues
	* @param end the upper bound of the range of issues (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of issues
	*/
	public static List<Issue> findAll(int start, int end,
		OrderByComparator<Issue> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the issues from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of issues.
	*
	* @return the number of issues
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static IssuePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<IssuePersistence, IssuePersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(IssuePersistence.class);

		ServiceTracker<IssuePersistence, IssuePersistence> serviceTracker = new ServiceTracker<IssuePersistence, IssuePersistence>(bundle.getBundleContext(),
				IssuePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
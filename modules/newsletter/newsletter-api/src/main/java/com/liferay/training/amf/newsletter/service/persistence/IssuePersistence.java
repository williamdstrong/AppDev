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

import com.liferay.training.amf.newsletter.exception.NoSuchIssueException;
import com.liferay.training.amf.newsletter.model.Issue;

/**
 * The persistence interface for the issue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.training.amf.newsletter.service.persistence.impl.IssuePersistenceImpl
 * @see IssueUtil
 * @generated
 */
@ProviderType
public interface IssuePersistence extends BasePersistence<Issue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link IssueUtil} to access the issue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the issue where issueNumber = &#63; or throws a {@link NoSuchIssueException} if it could not be found.
	*
	* @param issueNumber the issue number
	* @return the matching issue
	* @throws NoSuchIssueException if a matching issue could not be found
	*/
	public Issue findByIssueNumber(int issueNumber) throws NoSuchIssueException;

	/**
	* Returns the issue where issueNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param issueNumber the issue number
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	*/
	public Issue fetchByIssueNumber(int issueNumber);

	/**
	* Returns the issue where issueNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param issueNumber the issue number
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	*/
	public Issue fetchByIssueNumber(int issueNumber, boolean retrieveFromCache);

	/**
	* Removes the issue where issueNumber = &#63; from the database.
	*
	* @param issueNumber the issue number
	* @return the issue that was removed
	*/
	public Issue removeByIssueNumber(int issueNumber)
		throws NoSuchIssueException;

	/**
	* Returns the number of issues where issueNumber = &#63;.
	*
	* @param issueNumber the issue number
	* @return the number of matching issues
	*/
	public int countByIssueNumber(int issueNumber);

	/**
	* Returns the issue where title = &#63; or throws a {@link NoSuchIssueException} if it could not be found.
	*
	* @param title the title
	* @return the matching issue
	* @throws NoSuchIssueException if a matching issue could not be found
	*/
	public Issue findByTitle(String title) throws NoSuchIssueException;

	/**
	* Returns the issue where title = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param title the title
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	*/
	public Issue fetchByTitle(String title);

	/**
	* Returns the issue where title = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param title the title
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching issue, or <code>null</code> if a matching issue could not be found
	*/
	public Issue fetchByTitle(String title, boolean retrieveFromCache);

	/**
	* Removes the issue where title = &#63; from the database.
	*
	* @param title the title
	* @return the issue that was removed
	*/
	public Issue removeByTitle(String title) throws NoSuchIssueException;

	/**
	* Returns the number of issues where title = &#63;.
	*
	* @param title the title
	* @return the number of matching issues
	*/
	public int countByTitle(String title);

	/**
	* Caches the issue in the entity cache if it is enabled.
	*
	* @param issue the issue
	*/
	public void cacheResult(Issue issue);

	/**
	* Caches the issues in the entity cache if it is enabled.
	*
	* @param issues the issues
	*/
	public void cacheResult(java.util.List<Issue> issues);

	/**
	* Creates a new issue with the primary key. Does not add the issue to the database.
	*
	* @param issueId the primary key for the new issue
	* @return the new issue
	*/
	public Issue create(long issueId);

	/**
	* Removes the issue with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param issueId the primary key of the issue
	* @return the issue that was removed
	* @throws NoSuchIssueException if a issue with the primary key could not be found
	*/
	public Issue remove(long issueId) throws NoSuchIssueException;

	public Issue updateImpl(Issue issue);

	/**
	* Returns the issue with the primary key or throws a {@link NoSuchIssueException} if it could not be found.
	*
	* @param issueId the primary key of the issue
	* @return the issue
	* @throws NoSuchIssueException if a issue with the primary key could not be found
	*/
	public Issue findByPrimaryKey(long issueId) throws NoSuchIssueException;

	/**
	* Returns the issue with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param issueId the primary key of the issue
	* @return the issue, or <code>null</code> if a issue with the primary key could not be found
	*/
	public Issue fetchByPrimaryKey(long issueId);

	@Override
	public java.util.Map<java.io.Serializable, Issue> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the issues.
	*
	* @return the issues
	*/
	public java.util.List<Issue> findAll();

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
	public java.util.List<Issue> findAll(int start, int end);

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
	public java.util.List<Issue> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Issue> orderByComparator);

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
	public java.util.List<Issue> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Issue> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the issues from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of issues.
	*
	* @return the number of issues
	*/
	public int countAll();
}
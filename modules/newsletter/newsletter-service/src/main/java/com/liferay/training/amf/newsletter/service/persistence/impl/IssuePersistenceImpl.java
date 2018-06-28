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

package com.liferay.training.amf.newsletter.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.training.amf.newsletter.exception.NoSuchIssueException;
import com.liferay.training.amf.newsletter.model.Issue;
import com.liferay.training.amf.newsletter.model.impl.IssueImpl;
import com.liferay.training.amf.newsletter.model.impl.IssueModelImpl;
import com.liferay.training.amf.newsletter.service.persistence.IssuePersistence;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the issue service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see IssuePersistence
 * @see com.liferay.training.amf.newsletter.service.persistence.IssueUtil
 * @generated
 */
@ProviderType
public class IssuePersistenceImpl extends BasePersistenceImpl<Issue>
	implements IssuePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link IssueUtil} to access the issue persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = IssueImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueModelImpl.FINDER_CACHE_ENABLED, IssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueModelImpl.FINDER_CACHE_ENABLED, IssueImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_JOURNALFOLDERID = new FinderPath(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueModelImpl.FINDER_CACHE_ENABLED, IssueImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByJournalFolderId",
			new String[] { Long.class.getName() },
			IssueModelImpl.JOURNALFOLDERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_JOURNALFOLDERID = new FinderPath(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByJournalFolderId", new String[] { Long.class.getName() });

	/**
	 * Returns the issue where journalFolderId = &#63; or throws a {@link NoSuchIssueException} if it could not be found.
	 *
	 * @param journalFolderId the journal folder ID
	 * @return the matching issue
	 * @throws NoSuchIssueException if a matching issue could not be found
	 */
	@Override
	public Issue findByJournalFolderId(long journalFolderId)
		throws NoSuchIssueException {
		Issue issue = fetchByJournalFolderId(journalFolderId);

		if (issue == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("journalFolderId=");
			msg.append(journalFolderId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchIssueException(msg.toString());
		}

		return issue;
	}

	/**
	 * Returns the issue where journalFolderId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param journalFolderId the journal folder ID
	 * @return the matching issue, or <code>null</code> if a matching issue could not be found
	 */
	@Override
	public Issue fetchByJournalFolderId(long journalFolderId) {
		return fetchByJournalFolderId(journalFolderId, true);
	}

	/**
	 * Returns the issue where journalFolderId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param journalFolderId the journal folder ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching issue, or <code>null</code> if a matching issue could not be found
	 */
	@Override
	public Issue fetchByJournalFolderId(long journalFolderId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { journalFolderId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_JOURNALFOLDERID,
					finderArgs, this);
		}

		if (result instanceof Issue) {
			Issue issue = (Issue)result;

			if ((journalFolderId != issue.getJournalFolderId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ISSUE_WHERE);

			query.append(_FINDER_COLUMN_JOURNALFOLDERID_JOURNALFOLDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(journalFolderId);

				List<Issue> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_JOURNALFOLDERID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"IssuePersistenceImpl.fetchByJournalFolderId(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Issue issue = list.get(0);

					result = issue;

					cacheResult(issue);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_JOURNALFOLDERID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Issue)result;
		}
	}

	/**
	 * Removes the issue where journalFolderId = &#63; from the database.
	 *
	 * @param journalFolderId the journal folder ID
	 * @return the issue that was removed
	 */
	@Override
	public Issue removeByJournalFolderId(long journalFolderId)
		throws NoSuchIssueException {
		Issue issue = findByJournalFolderId(journalFolderId);

		return remove(issue);
	}

	/**
	 * Returns the number of issues where journalFolderId = &#63;.
	 *
	 * @param journalFolderId the journal folder ID
	 * @return the number of matching issues
	 */
	@Override
	public int countByJournalFolderId(long journalFolderId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_JOURNALFOLDERID;

		Object[] finderArgs = new Object[] { journalFolderId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ISSUE_WHERE);

			query.append(_FINDER_COLUMN_JOURNALFOLDERID_JOURNALFOLDERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(journalFolderId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_JOURNALFOLDERID_JOURNALFOLDERID_2 =
		"issue.journalFolderId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_ISSUENUMBER = new FinderPath(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueModelImpl.FINDER_CACHE_ENABLED, IssueImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByIssueNumber",
			new String[] { Integer.class.getName() },
			IssueModelImpl.ISSUENUMBER_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_ISSUENUMBER = new FinderPath(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByIssueNumber",
			new String[] { Integer.class.getName() });

	/**
	 * Returns the issue where issueNumber = &#63; or throws a {@link NoSuchIssueException} if it could not be found.
	 *
	 * @param issueNumber the issue number
	 * @return the matching issue
	 * @throws NoSuchIssueException if a matching issue could not be found
	 */
	@Override
	public Issue findByIssueNumber(int issueNumber) throws NoSuchIssueException {
		Issue issue = fetchByIssueNumber(issueNumber);

		if (issue == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("issueNumber=");
			msg.append(issueNumber);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchIssueException(msg.toString());
		}

		return issue;
	}

	/**
	 * Returns the issue where issueNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param issueNumber the issue number
	 * @return the matching issue, or <code>null</code> if a matching issue could not be found
	 */
	@Override
	public Issue fetchByIssueNumber(int issueNumber) {
		return fetchByIssueNumber(issueNumber, true);
	}

	/**
	 * Returns the issue where issueNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param issueNumber the issue number
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching issue, or <code>null</code> if a matching issue could not be found
	 */
	@Override
	public Issue fetchByIssueNumber(int issueNumber, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { issueNumber };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_ISSUENUMBER,
					finderArgs, this);
		}

		if (result instanceof Issue) {
			Issue issue = (Issue)result;

			if ((issueNumber != issue.getIssueNumber())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_ISSUE_WHERE);

			query.append(_FINDER_COLUMN_ISSUENUMBER_ISSUENUMBER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(issueNumber);

				List<Issue> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_ISSUENUMBER,
						finderArgs, list);
				}
				else {
					Issue issue = list.get(0);

					result = issue;

					cacheResult(issue);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_ISSUENUMBER,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Issue)result;
		}
	}

	/**
	 * Removes the issue where issueNumber = &#63; from the database.
	 *
	 * @param issueNumber the issue number
	 * @return the issue that was removed
	 */
	@Override
	public Issue removeByIssueNumber(int issueNumber)
		throws NoSuchIssueException {
		Issue issue = findByIssueNumber(issueNumber);

		return remove(issue);
	}

	/**
	 * Returns the number of issues where issueNumber = &#63;.
	 *
	 * @param issueNumber the issue number
	 * @return the number of matching issues
	 */
	@Override
	public int countByIssueNumber(int issueNumber) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_ISSUENUMBER;

		Object[] finderArgs = new Object[] { issueNumber };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ISSUE_WHERE);

			query.append(_FINDER_COLUMN_ISSUENUMBER_ISSUENUMBER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(issueNumber);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ISSUENUMBER_ISSUENUMBER_2 = "issue.issueNumber = ?";

	public IssuePersistenceImpl() {
		setModelClass(Issue.class);
	}

	/**
	 * Caches the issue in the entity cache if it is enabled.
	 *
	 * @param issue the issue
	 */
	@Override
	public void cacheResult(Issue issue) {
		entityCache.putResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueImpl.class, issue.getPrimaryKey(), issue);

		finderCache.putResult(FINDER_PATH_FETCH_BY_JOURNALFOLDERID,
			new Object[] { issue.getJournalFolderId() }, issue);

		finderCache.putResult(FINDER_PATH_FETCH_BY_ISSUENUMBER,
			new Object[] { issue.getIssueNumber() }, issue);

		issue.resetOriginalValues();
	}

	/**
	 * Caches the issues in the entity cache if it is enabled.
	 *
	 * @param issues the issues
	 */
	@Override
	public void cacheResult(List<Issue> issues) {
		for (Issue issue : issues) {
			if (entityCache.getResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
						IssueImpl.class, issue.getPrimaryKey()) == null) {
				cacheResult(issue);
			}
			else {
				issue.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all issues.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(IssueImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the issue.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Issue issue) {
		entityCache.removeResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueImpl.class, issue.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((IssueModelImpl)issue, true);
	}

	@Override
	public void clearCache(List<Issue> issues) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Issue issue : issues) {
			entityCache.removeResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
				IssueImpl.class, issue.getPrimaryKey());

			clearUniqueFindersCache((IssueModelImpl)issue, true);
		}
	}

	protected void cacheUniqueFindersCache(IssueModelImpl issueModelImpl) {
		Object[] args = new Object[] { issueModelImpl.getJournalFolderId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_JOURNALFOLDERID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_JOURNALFOLDERID, args,
			issueModelImpl, false);

		args = new Object[] { issueModelImpl.getIssueNumber() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_ISSUENUMBER, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_ISSUENUMBER, args,
			issueModelImpl, false);
	}

	protected void clearUniqueFindersCache(IssueModelImpl issueModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { issueModelImpl.getJournalFolderId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_JOURNALFOLDERID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_JOURNALFOLDERID, args);
		}

		if ((issueModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_JOURNALFOLDERID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] {
					issueModelImpl.getOriginalJournalFolderId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_JOURNALFOLDERID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_JOURNALFOLDERID, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] { issueModelImpl.getIssueNumber() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ISSUENUMBER, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ISSUENUMBER, args);
		}

		if ((issueModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_ISSUENUMBER.getColumnBitmask()) != 0) {
			Object[] args = new Object[] { issueModelImpl.getOriginalIssueNumber() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_ISSUENUMBER, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_ISSUENUMBER, args);
		}
	}

	/**
	 * Creates a new issue with the primary key. Does not add the issue to the database.
	 *
	 * @param issueId the primary key for the new issue
	 * @return the new issue
	 */
	@Override
	public Issue create(long issueId) {
		Issue issue = new IssueImpl();

		issue.setNew(true);
		issue.setPrimaryKey(issueId);

		return issue;
	}

	/**
	 * Removes the issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param issueId the primary key of the issue
	 * @return the issue that was removed
	 * @throws NoSuchIssueException if a issue with the primary key could not be found
	 */
	@Override
	public Issue remove(long issueId) throws NoSuchIssueException {
		return remove((Serializable)issueId);
	}

	/**
	 * Removes the issue with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the issue
	 * @return the issue that was removed
	 * @throws NoSuchIssueException if a issue with the primary key could not be found
	 */
	@Override
	public Issue remove(Serializable primaryKey) throws NoSuchIssueException {
		Session session = null;

		try {
			session = openSession();

			Issue issue = (Issue)session.get(IssueImpl.class, primaryKey);

			if (issue == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchIssueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(issue);
		}
		catch (NoSuchIssueException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Issue removeImpl(Issue issue) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(issue)) {
				issue = (Issue)session.get(IssueImpl.class,
						issue.getPrimaryKeyObj());
			}

			if (issue != null) {
				session.delete(issue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (issue != null) {
			clearCache(issue);
		}

		return issue;
	}

	@Override
	public Issue updateImpl(Issue issue) {
		boolean isNew = issue.isNew();

		if (!(issue instanceof IssueModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(issue.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(issue);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in issue proxy " +
					invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Issue implementation " +
				issue.getClass());
		}

		IssueModelImpl issueModelImpl = (IssueModelImpl)issue;

		Session session = null;

		try {
			session = openSession();

			if (issue.isNew()) {
				session.save(issue);

				issue.setNew(false);
			}
			else {
				issue = (Issue)session.merge(issue);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!IssueModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
			IssueImpl.class, issue.getPrimaryKey(), issue, false);

		clearUniqueFindersCache(issueModelImpl, false);
		cacheUniqueFindersCache(issueModelImpl);

		issue.resetOriginalValues();

		return issue;
	}

	/**
	 * Returns the issue with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the issue
	 * @return the issue
	 * @throws NoSuchIssueException if a issue with the primary key could not be found
	 */
	@Override
	public Issue findByPrimaryKey(Serializable primaryKey)
		throws NoSuchIssueException {
		Issue issue = fetchByPrimaryKey(primaryKey);

		if (issue == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchIssueException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return issue;
	}

	/**
	 * Returns the issue with the primary key or throws a {@link NoSuchIssueException} if it could not be found.
	 *
	 * @param issueId the primary key of the issue
	 * @return the issue
	 * @throws NoSuchIssueException if a issue with the primary key could not be found
	 */
	@Override
	public Issue findByPrimaryKey(long issueId) throws NoSuchIssueException {
		return findByPrimaryKey((Serializable)issueId);
	}

	/**
	 * Returns the issue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the issue
	 * @return the issue, or <code>null</code> if a issue with the primary key could not be found
	 */
	@Override
	public Issue fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
				IssueImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Issue issue = (Issue)serializable;

		if (issue == null) {
			Session session = null;

			try {
				session = openSession();

				issue = (Issue)session.get(IssueImpl.class, primaryKey);

				if (issue != null) {
					cacheResult(issue);
				}
				else {
					entityCache.putResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
						IssueImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
					IssueImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return issue;
	}

	/**
	 * Returns the issue with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param issueId the primary key of the issue
	 * @return the issue, or <code>null</code> if a issue with the primary key could not be found
	 */
	@Override
	public Issue fetchByPrimaryKey(long issueId) {
		return fetchByPrimaryKey((Serializable)issueId);
	}

	@Override
	public Map<Serializable, Issue> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Issue> map = new HashMap<Serializable, Issue>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Issue issue = fetchByPrimaryKey(primaryKey);

			if (issue != null) {
				map.put(primaryKey, issue);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
					IssueImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Issue)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ISSUE_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(",");
		}

		query.setIndex(query.index() - 1);

		query.append(")");

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Issue issue : (List<Issue>)q.list()) {
				map.put(issue.getPrimaryKeyObj(), issue);

				cacheResult(issue);

				uncachedPrimaryKeys.remove(issue.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(IssueModelImpl.ENTITY_CACHE_ENABLED,
					IssueImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the issues.
	 *
	 * @return the issues
	 */
	@Override
	public List<Issue> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Issue> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Issue> findAll(int start, int end,
		OrderByComparator<Issue> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Issue> findAll(int start, int end,
		OrderByComparator<Issue> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Issue> list = null;

		if (retrieveFromCache) {
			list = (List<Issue>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ISSUE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ISSUE;

				if (pagination) {
					sql = sql.concat(IssueModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Issue>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Issue>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the issues from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Issue issue : findAll()) {
			remove(issue);
		}
	}

	/**
	 * Returns the number of issues.
	 *
	 * @return the number of issues
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ISSUE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return IssueModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the issue persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(IssueImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ISSUE = "SELECT issue FROM Issue issue";
	private static final String _SQL_SELECT_ISSUE_WHERE_PKS_IN = "SELECT issue FROM Issue issue WHERE issueId IN (";
	private static final String _SQL_SELECT_ISSUE_WHERE = "SELECT issue FROM Issue issue WHERE ";
	private static final String _SQL_COUNT_ISSUE = "SELECT COUNT(issue) FROM Issue issue";
	private static final String _SQL_COUNT_ISSUE_WHERE = "SELECT COUNT(issue) FROM Issue issue WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "issue.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Issue exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Issue exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(IssuePersistenceImpl.class);
}
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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.training.amf.newsletter.exception.NoSuchArticleAuthorException;
import com.liferay.training.amf.newsletter.model.ArticleAuthor;
import com.liferay.training.amf.newsletter.model.impl.ArticleAuthorImpl;
import com.liferay.training.amf.newsletter.model.impl.ArticleAuthorModelImpl;
import com.liferay.training.amf.newsletter.service.persistence.ArticleAuthorPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the article author service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ArticleAuthorPersistence
 * @see com.liferay.training.amf.newsletter.service.persistence.ArticleAuthorUtil
 * @generated
 */
@ProviderType
public class ArticleAuthorPersistenceImpl extends BasePersistenceImpl<ArticleAuthor>
	implements ArticleAuthorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ArticleAuthorUtil} to access the article author persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ArticleAuthorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ArticleAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ArticleAuthorModelImpl.FINDER_CACHE_ENABLED,
			ArticleAuthorImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ArticleAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ArticleAuthorModelImpl.FINDER_CACHE_ENABLED,
			ArticleAuthorImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ArticleAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ArticleAuthorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public ArticleAuthorPersistenceImpl() {
		setModelClass(ArticleAuthor.class);
	}

	/**
	 * Caches the article author in the entity cache if it is enabled.
	 *
	 * @param articleAuthor the article author
	 */
	@Override
	public void cacheResult(ArticleAuthor articleAuthor) {
		entityCache.putResult(ArticleAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ArticleAuthorImpl.class, articleAuthor.getPrimaryKey(),
			articleAuthor);

		articleAuthor.resetOriginalValues();
	}

	/**
	 * Caches the article authors in the entity cache if it is enabled.
	 *
	 * @param articleAuthors the article authors
	 */
	@Override
	public void cacheResult(List<ArticleAuthor> articleAuthors) {
		for (ArticleAuthor articleAuthor : articleAuthors) {
			if (entityCache.getResult(
						ArticleAuthorModelImpl.ENTITY_CACHE_ENABLED,
						ArticleAuthorImpl.class, articleAuthor.getPrimaryKey()) == null) {
				cacheResult(articleAuthor);
			}
			else {
				articleAuthor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all article authors.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ArticleAuthorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the article author.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ArticleAuthor articleAuthor) {
		entityCache.removeResult(ArticleAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ArticleAuthorImpl.class, articleAuthor.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ArticleAuthor> articleAuthors) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ArticleAuthor articleAuthor : articleAuthors) {
			entityCache.removeResult(ArticleAuthorModelImpl.ENTITY_CACHE_ENABLED,
				ArticleAuthorImpl.class, articleAuthor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new article author with the primary key. Does not add the article author to the database.
	 *
	 * @param articleAuthorId the primary key for the new article author
	 * @return the new article author
	 */
	@Override
	public ArticleAuthor create(long articleAuthorId) {
		ArticleAuthor articleAuthor = new ArticleAuthorImpl();

		articleAuthor.setNew(true);
		articleAuthor.setPrimaryKey(articleAuthorId);

		return articleAuthor;
	}

	/**
	 * Removes the article author with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param articleAuthorId the primary key of the article author
	 * @return the article author that was removed
	 * @throws NoSuchArticleAuthorException if a article author with the primary key could not be found
	 */
	@Override
	public ArticleAuthor remove(long articleAuthorId)
		throws NoSuchArticleAuthorException {
		return remove((Serializable)articleAuthorId);
	}

	/**
	 * Removes the article author with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the article author
	 * @return the article author that was removed
	 * @throws NoSuchArticleAuthorException if a article author with the primary key could not be found
	 */
	@Override
	public ArticleAuthor remove(Serializable primaryKey)
		throws NoSuchArticleAuthorException {
		Session session = null;

		try {
			session = openSession();

			ArticleAuthor articleAuthor = (ArticleAuthor)session.get(ArticleAuthorImpl.class,
					primaryKey);

			if (articleAuthor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchArticleAuthorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(articleAuthor);
		}
		catch (NoSuchArticleAuthorException nsee) {
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
	protected ArticleAuthor removeImpl(ArticleAuthor articleAuthor) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(articleAuthor)) {
				articleAuthor = (ArticleAuthor)session.get(ArticleAuthorImpl.class,
						articleAuthor.getPrimaryKeyObj());
			}

			if (articleAuthor != null) {
				session.delete(articleAuthor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (articleAuthor != null) {
			clearCache(articleAuthor);
		}

		return articleAuthor;
	}

	@Override
	public ArticleAuthor updateImpl(ArticleAuthor articleAuthor) {
		boolean isNew = articleAuthor.isNew();

		Session session = null;

		try {
			session = openSession();

			if (articleAuthor.isNew()) {
				session.save(articleAuthor);

				articleAuthor.setNew(false);
			}
			else {
				articleAuthor = (ArticleAuthor)session.merge(articleAuthor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(ArticleAuthorModelImpl.ENTITY_CACHE_ENABLED,
			ArticleAuthorImpl.class, articleAuthor.getPrimaryKey(),
			articleAuthor, false);

		articleAuthor.resetOriginalValues();

		return articleAuthor;
	}

	/**
	 * Returns the article author with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the article author
	 * @return the article author
	 * @throws NoSuchArticleAuthorException if a article author with the primary key could not be found
	 */
	@Override
	public ArticleAuthor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchArticleAuthorException {
		ArticleAuthor articleAuthor = fetchByPrimaryKey(primaryKey);

		if (articleAuthor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchArticleAuthorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return articleAuthor;
	}

	/**
	 * Returns the article author with the primary key or throws a {@link NoSuchArticleAuthorException} if it could not be found.
	 *
	 * @param articleAuthorId the primary key of the article author
	 * @return the article author
	 * @throws NoSuchArticleAuthorException if a article author with the primary key could not be found
	 */
	@Override
	public ArticleAuthor findByPrimaryKey(long articleAuthorId)
		throws NoSuchArticleAuthorException {
		return findByPrimaryKey((Serializable)articleAuthorId);
	}

	/**
	 * Returns the article author with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the article author
	 * @return the article author, or <code>null</code> if a article author with the primary key could not be found
	 */
	@Override
	public ArticleAuthor fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(ArticleAuthorModelImpl.ENTITY_CACHE_ENABLED,
				ArticleAuthorImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		ArticleAuthor articleAuthor = (ArticleAuthor)serializable;

		if (articleAuthor == null) {
			Session session = null;

			try {
				session = openSession();

				articleAuthor = (ArticleAuthor)session.get(ArticleAuthorImpl.class,
						primaryKey);

				if (articleAuthor != null) {
					cacheResult(articleAuthor);
				}
				else {
					entityCache.putResult(ArticleAuthorModelImpl.ENTITY_CACHE_ENABLED,
						ArticleAuthorImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(ArticleAuthorModelImpl.ENTITY_CACHE_ENABLED,
					ArticleAuthorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return articleAuthor;
	}

	/**
	 * Returns the article author with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param articleAuthorId the primary key of the article author
	 * @return the article author, or <code>null</code> if a article author with the primary key could not be found
	 */
	@Override
	public ArticleAuthor fetchByPrimaryKey(long articleAuthorId) {
		return fetchByPrimaryKey((Serializable)articleAuthorId);
	}

	@Override
	public Map<Serializable, ArticleAuthor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, ArticleAuthor> map = new HashMap<Serializable, ArticleAuthor>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			ArticleAuthor articleAuthor = fetchByPrimaryKey(primaryKey);

			if (articleAuthor != null) {
				map.put(primaryKey, articleAuthor);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(ArticleAuthorModelImpl.ENTITY_CACHE_ENABLED,
					ArticleAuthorImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (ArticleAuthor)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ARTICLEAUTHOR_WHERE_PKS_IN);

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

			for (ArticleAuthor articleAuthor : (List<ArticleAuthor>)q.list()) {
				map.put(articleAuthor.getPrimaryKeyObj(), articleAuthor);

				cacheResult(articleAuthor);

				uncachedPrimaryKeys.remove(articleAuthor.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(ArticleAuthorModelImpl.ENTITY_CACHE_ENABLED,
					ArticleAuthorImpl.class, primaryKey, nullModel);
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
	 * Returns all the article authors.
	 *
	 * @return the article authors
	 */
	@Override
	public List<ArticleAuthor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<ArticleAuthor> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<ArticleAuthor> findAll(int start, int end,
		OrderByComparator<ArticleAuthor> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<ArticleAuthor> findAll(int start, int end,
		OrderByComparator<ArticleAuthor> orderByComparator,
		boolean retrieveFromCache) {
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

		List<ArticleAuthor> list = null;

		if (retrieveFromCache) {
			list = (List<ArticleAuthor>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ARTICLEAUTHOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ARTICLEAUTHOR;

				if (pagination) {
					sql = sql.concat(ArticleAuthorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ArticleAuthor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<ArticleAuthor>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the article authors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ArticleAuthor articleAuthor : findAll()) {
			remove(articleAuthor);
		}
	}

	/**
	 * Returns the number of article authors.
	 *
	 * @return the number of article authors
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ARTICLEAUTHOR);

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
		return ArticleAuthorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the article author persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(ArticleAuthorImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ARTICLEAUTHOR = "SELECT articleAuthor FROM ArticleAuthor articleAuthor";
	private static final String _SQL_SELECT_ARTICLEAUTHOR_WHERE_PKS_IN = "SELECT articleAuthor FROM ArticleAuthor articleAuthor WHERE articleAuthorId IN (";
	private static final String _SQL_COUNT_ARTICLEAUTHOR = "SELECT COUNT(articleAuthor) FROM ArticleAuthor articleAuthor";
	private static final String _ORDER_BY_ENTITY_ALIAS = "articleAuthor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ArticleAuthor exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(ArticleAuthorPersistenceImpl.class);
}
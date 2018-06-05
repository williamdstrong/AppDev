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

package com.liferay.training.amf.monitor.service.persistence.impl;

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
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.liferay.training.amf.monitor.exception.NoSuchAdminMonitorException;
import com.liferay.training.amf.monitor.model.AdminMonitor;
import com.liferay.training.amf.monitor.model.impl.AdminMonitorImpl;
import com.liferay.training.amf.monitor.model.impl.AdminMonitorModelImpl;
import com.liferay.training.amf.monitor.service.persistence.AdminMonitorPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the admin monitor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdminMonitorPersistence
 * @see com.liferay.training.amf.monitor.service.persistence.AdminMonitorUtil
 * @generated
 */
@ProviderType
public class AdminMonitorPersistenceImpl extends BasePersistenceImpl<AdminMonitor>
	implements AdminMonitorPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link AdminMonitorUtil} to access the admin monitor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = AdminMonitorImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
			AdminMonitorModelImpl.FINDER_CACHE_ENABLED, AdminMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
			AdminMonitorModelImpl.FINDER_CACHE_ENABLED, AdminMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
			AdminMonitorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public AdminMonitorPersistenceImpl() {
		setModelClass(AdminMonitor.class);
	}

	/**
	 * Caches the admin monitor in the entity cache if it is enabled.
	 *
	 * @param adminMonitor the admin monitor
	 */
	@Override
	public void cacheResult(AdminMonitor adminMonitor) {
		entityCache.putResult(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
			AdminMonitorImpl.class, adminMonitor.getPrimaryKey(), adminMonitor);

		adminMonitor.resetOriginalValues();
	}

	/**
	 * Caches the admin monitors in the entity cache if it is enabled.
	 *
	 * @param adminMonitors the admin monitors
	 */
	@Override
	public void cacheResult(List<AdminMonitor> adminMonitors) {
		for (AdminMonitor adminMonitor : adminMonitors) {
			if (entityCache.getResult(
						AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
						AdminMonitorImpl.class, adminMonitor.getPrimaryKey()) == null) {
				cacheResult(adminMonitor);
			}
			else {
				adminMonitor.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all admin monitors.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(AdminMonitorImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the admin monitor.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(AdminMonitor adminMonitor) {
		entityCache.removeResult(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
			AdminMonitorImpl.class, adminMonitor.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<AdminMonitor> adminMonitors) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (AdminMonitor adminMonitor : adminMonitors) {
			entityCache.removeResult(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
				AdminMonitorImpl.class, adminMonitor.getPrimaryKey());
		}
	}

	/**
	 * Creates a new admin monitor with the primary key. Does not add the admin monitor to the database.
	 *
	 * @param monitorId the primary key for the new admin monitor
	 * @return the new admin monitor
	 */
	@Override
	public AdminMonitor create(long monitorId) {
		AdminMonitor adminMonitor = new AdminMonitorImpl();

		adminMonitor.setNew(true);
		adminMonitor.setPrimaryKey(monitorId);

		return adminMonitor;
	}

	/**
	 * Removes the admin monitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param monitorId the primary key of the admin monitor
	 * @return the admin monitor that was removed
	 * @throws NoSuchAdminMonitorException if a admin monitor with the primary key could not be found
	 */
	@Override
	public AdminMonitor remove(long monitorId)
		throws NoSuchAdminMonitorException {
		return remove((Serializable)monitorId);
	}

	/**
	 * Removes the admin monitor with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the admin monitor
	 * @return the admin monitor that was removed
	 * @throws NoSuchAdminMonitorException if a admin monitor with the primary key could not be found
	 */
	@Override
	public AdminMonitor remove(Serializable primaryKey)
		throws NoSuchAdminMonitorException {
		Session session = null;

		try {
			session = openSession();

			AdminMonitor adminMonitor = (AdminMonitor)session.get(AdminMonitorImpl.class,
					primaryKey);

			if (adminMonitor == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchAdminMonitorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(adminMonitor);
		}
		catch (NoSuchAdminMonitorException nsee) {
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
	protected AdminMonitor removeImpl(AdminMonitor adminMonitor) {
		adminMonitor = toUnwrappedModel(adminMonitor);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(adminMonitor)) {
				adminMonitor = (AdminMonitor)session.get(AdminMonitorImpl.class,
						adminMonitor.getPrimaryKeyObj());
			}

			if (adminMonitor != null) {
				session.delete(adminMonitor);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (adminMonitor != null) {
			clearCache(adminMonitor);
		}

		return adminMonitor;
	}

	@Override
	public AdminMonitor updateImpl(AdminMonitor adminMonitor) {
		adminMonitor = toUnwrappedModel(adminMonitor);

		boolean isNew = adminMonitor.isNew();

		Session session = null;

		try {
			session = openSession();

			if (adminMonitor.isNew()) {
				session.save(adminMonitor);

				adminMonitor.setNew(false);
			}
			else {
				adminMonitor = (AdminMonitor)session.merge(adminMonitor);
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

		entityCache.putResult(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
			AdminMonitorImpl.class, adminMonitor.getPrimaryKey(), adminMonitor,
			false);

		adminMonitor.resetOriginalValues();

		return adminMonitor;
	}

	protected AdminMonitor toUnwrappedModel(AdminMonitor adminMonitor) {
		if (adminMonitor instanceof AdminMonitorImpl) {
			return adminMonitor;
		}

		AdminMonitorImpl adminMonitorImpl = new AdminMonitorImpl();

		adminMonitorImpl.setNew(adminMonitor.isNew());
		adminMonitorImpl.setPrimaryKey(adminMonitor.getPrimaryKey());

		adminMonitorImpl.setMonitorId(adminMonitor.getMonitorId());
		adminMonitorImpl.setDateTime(adminMonitor.getDateTime());
		adminMonitorImpl.setEventType(adminMonitor.getEventType());
		adminMonitorImpl.setUserId(adminMonitor.getUserId());
		adminMonitorImpl.setIpAddress(adminMonitor.getIpAddress());

		return adminMonitorImpl;
	}

	/**
	 * Returns the admin monitor with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the admin monitor
	 * @return the admin monitor
	 * @throws NoSuchAdminMonitorException if a admin monitor with the primary key could not be found
	 */
	@Override
	public AdminMonitor findByPrimaryKey(Serializable primaryKey)
		throws NoSuchAdminMonitorException {
		AdminMonitor adminMonitor = fetchByPrimaryKey(primaryKey);

		if (adminMonitor == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchAdminMonitorException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return adminMonitor;
	}

	/**
	 * Returns the admin monitor with the primary key or throws a {@link NoSuchAdminMonitorException} if it could not be found.
	 *
	 * @param monitorId the primary key of the admin monitor
	 * @return the admin monitor
	 * @throws NoSuchAdminMonitorException if a admin monitor with the primary key could not be found
	 */
	@Override
	public AdminMonitor findByPrimaryKey(long monitorId)
		throws NoSuchAdminMonitorException {
		return findByPrimaryKey((Serializable)monitorId);
	}

	/**
	 * Returns the admin monitor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the admin monitor
	 * @return the admin monitor, or <code>null</code> if a admin monitor with the primary key could not be found
	 */
	@Override
	public AdminMonitor fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
				AdminMonitorImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		AdminMonitor adminMonitor = (AdminMonitor)serializable;

		if (adminMonitor == null) {
			Session session = null;

			try {
				session = openSession();

				adminMonitor = (AdminMonitor)session.get(AdminMonitorImpl.class,
						primaryKey);

				if (adminMonitor != null) {
					cacheResult(adminMonitor);
				}
				else {
					entityCache.putResult(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
						AdminMonitorImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
					AdminMonitorImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return adminMonitor;
	}

	/**
	 * Returns the admin monitor with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param monitorId the primary key of the admin monitor
	 * @return the admin monitor, or <code>null</code> if a admin monitor with the primary key could not be found
	 */
	@Override
	public AdminMonitor fetchByPrimaryKey(long monitorId) {
		return fetchByPrimaryKey((Serializable)monitorId);
	}

	@Override
	public Map<Serializable, AdminMonitor> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, AdminMonitor> map = new HashMap<Serializable, AdminMonitor>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			AdminMonitor adminMonitor = fetchByPrimaryKey(primaryKey);

			if (adminMonitor != null) {
				map.put(primaryKey, adminMonitor);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
					AdminMonitorImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (AdminMonitor)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_ADMINMONITOR_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (AdminMonitor adminMonitor : (List<AdminMonitor>)q.list()) {
				map.put(adminMonitor.getPrimaryKeyObj(), adminMonitor);

				cacheResult(adminMonitor);

				uncachedPrimaryKeys.remove(adminMonitor.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
					AdminMonitorImpl.class, primaryKey, nullModel);
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
	 * Returns all the admin monitors.
	 *
	 * @return the admin monitors
	 */
	@Override
	public List<AdminMonitor> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the admin monitors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of admin monitors
	 * @param end the upper bound of the range of admin monitors (not inclusive)
	 * @return the range of admin monitors
	 */
	@Override
	public List<AdminMonitor> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the admin monitors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of admin monitors
	 * @param end the upper bound of the range of admin monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of admin monitors
	 */
	@Override
	public List<AdminMonitor> findAll(int start, int end,
		OrderByComparator<AdminMonitor> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the admin monitors.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of admin monitors
	 * @param end the upper bound of the range of admin monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of admin monitors
	 */
	@Override
	public List<AdminMonitor> findAll(int start, int end,
		OrderByComparator<AdminMonitor> orderByComparator,
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

		List<AdminMonitor> list = null;

		if (retrieveFromCache) {
			list = (List<AdminMonitor>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_ADMINMONITOR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ADMINMONITOR;

				if (pagination) {
					sql = sql.concat(AdminMonitorModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<AdminMonitor>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<AdminMonitor>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the admin monitors from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (AdminMonitor adminMonitor : findAll()) {
			remove(adminMonitor);
		}
	}

	/**
	 * Returns the number of admin monitors.
	 *
	 * @return the number of admin monitors
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_ADMINMONITOR);

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
		return AdminMonitorModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the admin monitor persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(AdminMonitorImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_ADMINMONITOR = "SELECT adminMonitor FROM AdminMonitor adminMonitor";
	private static final String _SQL_SELECT_ADMINMONITOR_WHERE_PKS_IN = "SELECT adminMonitor FROM AdminMonitor adminMonitor WHERE monitorId IN (";
	private static final String _SQL_COUNT_ADMINMONITOR = "SELECT COUNT(adminMonitor) FROM AdminMonitor adminMonitor";
	private static final String _ORDER_BY_ENTITY_ALIAS = "adminMonitor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdminMonitor exists with the primary key ";
	private static final Log _log = LogFactoryUtil.getLog(AdminMonitorPersistenceImpl.class);
}
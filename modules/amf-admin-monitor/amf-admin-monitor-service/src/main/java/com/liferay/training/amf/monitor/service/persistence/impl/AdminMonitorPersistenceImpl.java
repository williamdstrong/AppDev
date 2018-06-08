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
import com.liferay.portal.kernel.dao.orm.QueryPos;
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
import java.util.Objects;
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
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPE =
		new FinderPath(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
			AdminMonitorModelImpl.FINDER_CACHE_ENABLED, AdminMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEventType",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE =
		new FinderPath(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
			AdminMonitorModelImpl.FINDER_CACHE_ENABLED, AdminMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEventType",
			new String[] { String.class.getName() },
			AdminMonitorModelImpl.EVENTTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTTYPE = new FinderPath(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
			AdminMonitorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEventType",
			new String[] { String.class.getName() });

	/**
	 * Returns all the admin monitors where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the matching admin monitors
	 */
	@Override
	public List<AdminMonitor> findByEventType(String eventType) {
		return findByEventType(eventType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the admin monitors where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of admin monitors
	 * @param end the upper bound of the range of admin monitors (not inclusive)
	 * @return the range of matching admin monitors
	 */
	@Override
	public List<AdminMonitor> findByEventType(String eventType, int start,
		int end) {
		return findByEventType(eventType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the admin monitors where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of admin monitors
	 * @param end the upper bound of the range of admin monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching admin monitors
	 */
	@Override
	public List<AdminMonitor> findByEventType(String eventType, int start,
		int end, OrderByComparator<AdminMonitor> orderByComparator) {
		return findByEventType(eventType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the admin monitors where eventType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param start the lower bound of the range of admin monitors
	 * @param end the upper bound of the range of admin monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching admin monitors
	 */
	@Override
	public List<AdminMonitor> findByEventType(String eventType, int start,
		int end, OrderByComparator<AdminMonitor> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE;
			finderArgs = new Object[] { eventType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTTYPE;
			finderArgs = new Object[] { eventType, start, end, orderByComparator };
		}

		List<AdminMonitor> list = null;

		if (retrieveFromCache) {
			list = (List<AdminMonitor>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AdminMonitor adminMonitor : list) {
					if (!Objects.equals(eventType, adminMonitor.getEventType())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_ADMINMONITOR_WHERE);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdminMonitorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEventType) {
					qPos.add(eventType);
				}

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
	 * Returns the first admin monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching admin monitor
	 * @throws NoSuchAdminMonitorException if a matching admin monitor could not be found
	 */
	@Override
	public AdminMonitor findByEventType_First(String eventType,
		OrderByComparator<AdminMonitor> orderByComparator)
		throws NoSuchAdminMonitorException {
		AdminMonitor adminMonitor = fetchByEventType_First(eventType,
				orderByComparator);

		if (adminMonitor != null) {
			return adminMonitor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdminMonitorException(msg.toString());
	}

	/**
	 * Returns the first admin monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching admin monitor, or <code>null</code> if a matching admin monitor could not be found
	 */
	@Override
	public AdminMonitor fetchByEventType_First(String eventType,
		OrderByComparator<AdminMonitor> orderByComparator) {
		List<AdminMonitor> list = findByEventType(eventType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last admin monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching admin monitor
	 * @throws NoSuchAdminMonitorException if a matching admin monitor could not be found
	 */
	@Override
	public AdminMonitor findByEventType_Last(String eventType,
		OrderByComparator<AdminMonitor> orderByComparator)
		throws NoSuchAdminMonitorException {
		AdminMonitor adminMonitor = fetchByEventType_Last(eventType,
				orderByComparator);

		if (adminMonitor != null) {
			return adminMonitor;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdminMonitorException(msg.toString());
	}

	/**
	 * Returns the last admin monitor in the ordered set where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching admin monitor, or <code>null</code> if a matching admin monitor could not be found
	 */
	@Override
	public AdminMonitor fetchByEventType_Last(String eventType,
		OrderByComparator<AdminMonitor> orderByComparator) {
		int count = countByEventType(eventType);

		if (count == 0) {
			return null;
		}

		List<AdminMonitor> list = findByEventType(eventType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the admin monitors before and after the current admin monitor in the ordered set where eventType = &#63;.
	 *
	 * @param monitorId the primary key of the current admin monitor
	 * @param eventType the event type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next admin monitor
	 * @throws NoSuchAdminMonitorException if a admin monitor with the primary key could not be found
	 */
	@Override
	public AdminMonitor[] findByEventType_PrevAndNext(long monitorId,
		String eventType, OrderByComparator<AdminMonitor> orderByComparator)
		throws NoSuchAdminMonitorException {
		AdminMonitor adminMonitor = findByPrimaryKey(monitorId);

		Session session = null;

		try {
			session = openSession();

			AdminMonitor[] array = new AdminMonitorImpl[3];

			array[0] = getByEventType_PrevAndNext(session, adminMonitor,
					eventType, orderByComparator, true);

			array[1] = adminMonitor;

			array[2] = getByEventType_PrevAndNext(session, adminMonitor,
					eventType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdminMonitor getByEventType_PrevAndNext(Session session,
		AdminMonitor adminMonitor, String eventType,
		OrderByComparator<AdminMonitor> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ADMINMONITOR_WHERE);

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1);
		}
		else if (eventType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AdminMonitorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEventType) {
			qPos.add(eventType);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adminMonitor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdminMonitor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the admin monitors where eventType = &#63; from the database.
	 *
	 * @param eventType the event type
	 */
	@Override
	public void removeByEventType(String eventType) {
		for (AdminMonitor adminMonitor : findByEventType(eventType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(adminMonitor);
		}
	}

	/**
	 * Returns the number of admin monitors where eventType = &#63;.
	 *
	 * @param eventType the event type
	 * @return the number of matching admin monitors
	 */
	@Override
	public int countByEventType(String eventType) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTTYPE;

		Object[] finderArgs = new Object[] { eventType };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ADMINMONITOR_WHERE);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEventType) {
					qPos.add(eventType);
				}

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

	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_1 = "adminMonitor.eventType IS NULL";
	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_2 = "adminMonitor.eventType = ?";
	private static final String _FINDER_COLUMN_EVENTTYPE_EVENTTYPE_3 = "(adminMonitor.eventType IS NULL OR adminMonitor.eventType = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_E_U = new FinderPath(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
			AdminMonitorModelImpl.FINDER_CACHE_ENABLED, AdminMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByE_U",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_E_U = new FinderPath(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
			AdminMonitorModelImpl.FINDER_CACHE_ENABLED, AdminMonitorImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByE_U",
			new String[] { String.class.getName(), Long.class.getName() },
			AdminMonitorModelImpl.EVENTTYPE_COLUMN_BITMASK |
			AdminMonitorModelImpl.USERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_E_U = new FinderPath(AdminMonitorModelImpl.ENTITY_CACHE_ENABLED,
			AdminMonitorModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByE_U",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the admin monitors where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @return the matching admin monitors
	 */
	@Override
	public List<AdminMonitor> findByE_U(String eventType, long userId) {
		return findByE_U(eventType, userId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the admin monitors where eventType = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param start the lower bound of the range of admin monitors
	 * @param end the upper bound of the range of admin monitors (not inclusive)
	 * @return the range of matching admin monitors
	 */
	@Override
	public List<AdminMonitor> findByE_U(String eventType, long userId,
		int start, int end) {
		return findByE_U(eventType, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the admin monitors where eventType = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param start the lower bound of the range of admin monitors
	 * @param end the upper bound of the range of admin monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching admin monitors
	 */
	@Override
	public List<AdminMonitor> findByE_U(String eventType, long userId,
		int start, int end, OrderByComparator<AdminMonitor> orderByComparator) {
		return findByE_U(eventType, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the admin monitors where eventType = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param start the lower bound of the range of admin monitors
	 * @param end the upper bound of the range of admin monitors (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching admin monitors
	 */
	@Override
	public List<AdminMonitor> findByE_U(String eventType, long userId,
		int start, int end, OrderByComparator<AdminMonitor> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_E_U;
			finderArgs = new Object[] { eventType, userId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_E_U;
			finderArgs = new Object[] {
					eventType, userId,
					
					start, end, orderByComparator
				};
		}

		List<AdminMonitor> list = null;

		if (retrieveFromCache) {
			list = (List<AdminMonitor>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (AdminMonitor adminMonitor : list) {
					if (!Objects.equals(eventType, adminMonitor.getEventType()) ||
							(userId != adminMonitor.getUserId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_ADMINMONITOR_WHERE);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_E_U_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_E_U_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_E_U_EVENTTYPE_2);
			}

			query.append(_FINDER_COLUMN_E_U_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(AdminMonitorModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEventType) {
					qPos.add(eventType);
				}

				qPos.add(userId);

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
	 * Returns the first admin monitor in the ordered set where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching admin monitor
	 * @throws NoSuchAdminMonitorException if a matching admin monitor could not be found
	 */
	@Override
	public AdminMonitor findByE_U_First(String eventType, long userId,
		OrderByComparator<AdminMonitor> orderByComparator)
		throws NoSuchAdminMonitorException {
		AdminMonitor adminMonitor = fetchByE_U_First(eventType, userId,
				orderByComparator);

		if (adminMonitor != null) {
			return adminMonitor;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdminMonitorException(msg.toString());
	}

	/**
	 * Returns the first admin monitor in the ordered set where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching admin monitor, or <code>null</code> if a matching admin monitor could not be found
	 */
	@Override
	public AdminMonitor fetchByE_U_First(String eventType, long userId,
		OrderByComparator<AdminMonitor> orderByComparator) {
		List<AdminMonitor> list = findByE_U(eventType, userId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last admin monitor in the ordered set where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching admin monitor
	 * @throws NoSuchAdminMonitorException if a matching admin monitor could not be found
	 */
	@Override
	public AdminMonitor findByE_U_Last(String eventType, long userId,
		OrderByComparator<AdminMonitor> orderByComparator)
		throws NoSuchAdminMonitorException {
		AdminMonitor adminMonitor = fetchByE_U_Last(eventType, userId,
				orderByComparator);

		if (adminMonitor != null) {
			return adminMonitor;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventType=");
		msg.append(eventType);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchAdminMonitorException(msg.toString());
	}

	/**
	 * Returns the last admin monitor in the ordered set where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching admin monitor, or <code>null</code> if a matching admin monitor could not be found
	 */
	@Override
	public AdminMonitor fetchByE_U_Last(String eventType, long userId,
		OrderByComparator<AdminMonitor> orderByComparator) {
		int count = countByE_U(eventType, userId);

		if (count == 0) {
			return null;
		}

		List<AdminMonitor> list = findByE_U(eventType, userId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the admin monitors before and after the current admin monitor in the ordered set where eventType = &#63; and userId = &#63;.
	 *
	 * @param monitorId the primary key of the current admin monitor
	 * @param eventType the event type
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next admin monitor
	 * @throws NoSuchAdminMonitorException if a admin monitor with the primary key could not be found
	 */
	@Override
	public AdminMonitor[] findByE_U_PrevAndNext(long monitorId,
		String eventType, long userId,
		OrderByComparator<AdminMonitor> orderByComparator)
		throws NoSuchAdminMonitorException {
		AdminMonitor adminMonitor = findByPrimaryKey(monitorId);

		Session session = null;

		try {
			session = openSession();

			AdminMonitor[] array = new AdminMonitorImpl[3];

			array[0] = getByE_U_PrevAndNext(session, adminMonitor, eventType,
					userId, orderByComparator, true);

			array[1] = adminMonitor;

			array[2] = getByE_U_PrevAndNext(session, adminMonitor, eventType,
					userId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected AdminMonitor getByE_U_PrevAndNext(Session session,
		AdminMonitor adminMonitor, String eventType, long userId,
		OrderByComparator<AdminMonitor> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_ADMINMONITOR_WHERE);

		boolean bindEventType = false;

		if (eventType == null) {
			query.append(_FINDER_COLUMN_E_U_EVENTTYPE_1);
		}
		else if (eventType.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_E_U_EVENTTYPE_3);
		}
		else {
			bindEventType = true;

			query.append(_FINDER_COLUMN_E_U_EVENTTYPE_2);
		}

		query.append(_FINDER_COLUMN_E_U_USERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(AdminMonitorModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindEventType) {
			qPos.add(eventType);
		}

		qPos.add(userId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(adminMonitor);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<AdminMonitor> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the admin monitors where eventType = &#63; and userId = &#63; from the database.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 */
	@Override
	public void removeByE_U(String eventType, long userId) {
		for (AdminMonitor adminMonitor : findByE_U(eventType, userId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(adminMonitor);
		}
	}

	/**
	 * Returns the number of admin monitors where eventType = &#63; and userId = &#63;.
	 *
	 * @param eventType the event type
	 * @param userId the user ID
	 * @return the number of matching admin monitors
	 */
	@Override
	public int countByE_U(String eventType, long userId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_E_U;

		Object[] finderArgs = new Object[] { eventType, userId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_ADMINMONITOR_WHERE);

			boolean bindEventType = false;

			if (eventType == null) {
				query.append(_FINDER_COLUMN_E_U_EVENTTYPE_1);
			}
			else if (eventType.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_E_U_EVENTTYPE_3);
			}
			else {
				bindEventType = true;

				query.append(_FINDER_COLUMN_E_U_EVENTTYPE_2);
			}

			query.append(_FINDER_COLUMN_E_U_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindEventType) {
					qPos.add(eventType);
				}

				qPos.add(userId);

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

	private static final String _FINDER_COLUMN_E_U_EVENTTYPE_1 = "adminMonitor.eventType IS NULL AND ";
	private static final String _FINDER_COLUMN_E_U_EVENTTYPE_2 = "adminMonitor.eventType = ? AND ";
	private static final String _FINDER_COLUMN_E_U_EVENTTYPE_3 = "(adminMonitor.eventType IS NULL OR adminMonitor.eventType = '') AND ";
	private static final String _FINDER_COLUMN_E_U_USERID_2 = "adminMonitor.userId = ?";

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

		AdminMonitorModelImpl adminMonitorModelImpl = (AdminMonitorModelImpl)adminMonitor;

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

		if (!AdminMonitorModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { adminMonitorModelImpl.getEventType() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
				args);

			args = new Object[] {
					adminMonitorModelImpl.getEventType(),
					adminMonitorModelImpl.getUserId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_E_U, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_E_U,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((adminMonitorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adminMonitorModelImpl.getOriginalEventType()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
					args);

				args = new Object[] { adminMonitorModelImpl.getEventType() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTTYPE, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTTYPE,
					args);
			}

			if ((adminMonitorModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_E_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						adminMonitorModelImpl.getOriginalEventType(),
						adminMonitorModelImpl.getOriginalUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_E_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_E_U,
					args);

				args = new Object[] {
						adminMonitorModelImpl.getEventType(),
						adminMonitorModelImpl.getUserId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_E_U, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_E_U,
					args);
			}
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
	private static final String _SQL_SELECT_ADMINMONITOR_WHERE = "SELECT adminMonitor FROM AdminMonitor adminMonitor WHERE ";
	private static final String _SQL_COUNT_ADMINMONITOR = "SELECT COUNT(adminMonitor) FROM AdminMonitor adminMonitor";
	private static final String _SQL_COUNT_ADMINMONITOR_WHERE = "SELECT COUNT(adminMonitor) FROM AdminMonitor adminMonitor WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "adminMonitor.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No AdminMonitor exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No AdminMonitor exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(AdminMonitorPersistenceImpl.class);
}
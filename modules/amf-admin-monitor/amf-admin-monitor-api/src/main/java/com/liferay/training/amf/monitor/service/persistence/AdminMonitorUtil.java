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

package com.liferay.training.amf.monitor.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.liferay.training.amf.monitor.model.AdminMonitor;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the admin monitor service. This utility wraps {@link com.liferay.training.amf.monitor.service.persistence.impl.AdminMonitorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AdminMonitorPersistence
 * @see com.liferay.training.amf.monitor.service.persistence.impl.AdminMonitorPersistenceImpl
 * @generated
 */
@ProviderType
public class AdminMonitorUtil {
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
	public static void clearCache(AdminMonitor adminMonitor) {
		getPersistence().clearCache(adminMonitor);
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
	public static List<AdminMonitor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AdminMonitor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AdminMonitor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AdminMonitor> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AdminMonitor update(AdminMonitor adminMonitor) {
		return getPersistence().update(adminMonitor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AdminMonitor update(AdminMonitor adminMonitor,
		ServiceContext serviceContext) {
		return getPersistence().update(adminMonitor, serviceContext);
	}

	/**
	* Returns all the admin monitors where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the matching admin monitors
	*/
	public static List<AdminMonitor> findByEventType(java.lang.String eventType) {
		return getPersistence().findByEventType(eventType);
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
	public static List<AdminMonitor> findByEventType(
		java.lang.String eventType, int start, int end) {
		return getPersistence().findByEventType(eventType, start, end);
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
	public static List<AdminMonitor> findByEventType(
		java.lang.String eventType, int start, int end,
		OrderByComparator<AdminMonitor> orderByComparator) {
		return getPersistence()
				   .findByEventType(eventType, start, end, orderByComparator);
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
	public static List<AdminMonitor> findByEventType(
		java.lang.String eventType, int start, int end,
		OrderByComparator<AdminMonitor> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByEventType(eventType, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first admin monitor in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin monitor
	* @throws NoSuchAdminMonitorException if a matching admin monitor could not be found
	*/
	public static AdminMonitor findByEventType_First(
		java.lang.String eventType,
		OrderByComparator<AdminMonitor> orderByComparator)
		throws com.liferay.training.amf.monitor.exception.NoSuchAdminMonitorException {
		return getPersistence()
				   .findByEventType_First(eventType, orderByComparator);
	}

	/**
	* Returns the first admin monitor in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin monitor, or <code>null</code> if a matching admin monitor could not be found
	*/
	public static AdminMonitor fetchByEventType_First(
		java.lang.String eventType,
		OrderByComparator<AdminMonitor> orderByComparator) {
		return getPersistence()
				   .fetchByEventType_First(eventType, orderByComparator);
	}

	/**
	* Returns the last admin monitor in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin monitor
	* @throws NoSuchAdminMonitorException if a matching admin monitor could not be found
	*/
	public static AdminMonitor findByEventType_Last(
		java.lang.String eventType,
		OrderByComparator<AdminMonitor> orderByComparator)
		throws com.liferay.training.amf.monitor.exception.NoSuchAdminMonitorException {
		return getPersistence()
				   .findByEventType_Last(eventType, orderByComparator);
	}

	/**
	* Returns the last admin monitor in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin monitor, or <code>null</code> if a matching admin monitor could not be found
	*/
	public static AdminMonitor fetchByEventType_Last(
		java.lang.String eventType,
		OrderByComparator<AdminMonitor> orderByComparator) {
		return getPersistence()
				   .fetchByEventType_Last(eventType, orderByComparator);
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
	public static AdminMonitor[] findByEventType_PrevAndNext(long monitorId,
		java.lang.String eventType,
		OrderByComparator<AdminMonitor> orderByComparator)
		throws com.liferay.training.amf.monitor.exception.NoSuchAdminMonitorException {
		return getPersistence()
				   .findByEventType_PrevAndNext(monitorId, eventType,
			orderByComparator);
	}

	/**
	* Removes all the admin monitors where eventType = &#63; from the database.
	*
	* @param eventType the event type
	*/
	public static void removeByEventType(java.lang.String eventType) {
		getPersistence().removeByEventType(eventType);
	}

	/**
	* Returns the number of admin monitors where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the number of matching admin monitors
	*/
	public static int countByEventType(java.lang.String eventType) {
		return getPersistence().countByEventType(eventType);
	}

	/**
	* Returns all the admin monitors where eventType = &#63; and userId = &#63;.
	*
	* @param eventType the event type
	* @param userId the user ID
	* @return the matching admin monitors
	*/
	public static List<AdminMonitor> findByE_U(java.lang.String eventType,
		long userId) {
		return getPersistence().findByE_U(eventType, userId);
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
	public static List<AdminMonitor> findByE_U(java.lang.String eventType,
		long userId, int start, int end) {
		return getPersistence().findByE_U(eventType, userId, start, end);
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
	public static List<AdminMonitor> findByE_U(java.lang.String eventType,
		long userId, int start, int end,
		OrderByComparator<AdminMonitor> orderByComparator) {
		return getPersistence()
				   .findByE_U(eventType, userId, start, end, orderByComparator);
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
	public static List<AdminMonitor> findByE_U(java.lang.String eventType,
		long userId, int start, int end,
		OrderByComparator<AdminMonitor> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByE_U(eventType, userId, start, end, orderByComparator,
			retrieveFromCache);
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
	public static AdminMonitor findByE_U_First(java.lang.String eventType,
		long userId, OrderByComparator<AdminMonitor> orderByComparator)
		throws com.liferay.training.amf.monitor.exception.NoSuchAdminMonitorException {
		return getPersistence()
				   .findByE_U_First(eventType, userId, orderByComparator);
	}

	/**
	* Returns the first admin monitor in the ordered set where eventType = &#63; and userId = &#63;.
	*
	* @param eventType the event type
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin monitor, or <code>null</code> if a matching admin monitor could not be found
	*/
	public static AdminMonitor fetchByE_U_First(java.lang.String eventType,
		long userId, OrderByComparator<AdminMonitor> orderByComparator) {
		return getPersistence()
				   .fetchByE_U_First(eventType, userId, orderByComparator);
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
	public static AdminMonitor findByE_U_Last(java.lang.String eventType,
		long userId, OrderByComparator<AdminMonitor> orderByComparator)
		throws com.liferay.training.amf.monitor.exception.NoSuchAdminMonitorException {
		return getPersistence()
				   .findByE_U_Last(eventType, userId, orderByComparator);
	}

	/**
	* Returns the last admin monitor in the ordered set where eventType = &#63; and userId = &#63;.
	*
	* @param eventType the event type
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin monitor, or <code>null</code> if a matching admin monitor could not be found
	*/
	public static AdminMonitor fetchByE_U_Last(java.lang.String eventType,
		long userId, OrderByComparator<AdminMonitor> orderByComparator) {
		return getPersistence()
				   .fetchByE_U_Last(eventType, userId, orderByComparator);
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
	public static AdminMonitor[] findByE_U_PrevAndNext(long monitorId,
		java.lang.String eventType, long userId,
		OrderByComparator<AdminMonitor> orderByComparator)
		throws com.liferay.training.amf.monitor.exception.NoSuchAdminMonitorException {
		return getPersistence()
				   .findByE_U_PrevAndNext(monitorId, eventType, userId,
			orderByComparator);
	}

	/**
	* Removes all the admin monitors where eventType = &#63; and userId = &#63; from the database.
	*
	* @param eventType the event type
	* @param userId the user ID
	*/
	public static void removeByE_U(java.lang.String eventType, long userId) {
		getPersistence().removeByE_U(eventType, userId);
	}

	/**
	* Returns the number of admin monitors where eventType = &#63; and userId = &#63;.
	*
	* @param eventType the event type
	* @param userId the user ID
	* @return the number of matching admin monitors
	*/
	public static int countByE_U(java.lang.String eventType, long userId) {
		return getPersistence().countByE_U(eventType, userId);
	}

	/**
	* Returns all the admin monitors where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching admin monitors
	*/
	public static List<AdminMonitor> findByUser(long userId) {
		return getPersistence().findByUser(userId);
	}

	/**
	* Returns a range of all the admin monitors where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of admin monitors
	* @param end the upper bound of the range of admin monitors (not inclusive)
	* @return the range of matching admin monitors
	*/
	public static List<AdminMonitor> findByUser(long userId, int start, int end) {
		return getPersistence().findByUser(userId, start, end);
	}

	/**
	* Returns an ordered range of all the admin monitors where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of admin monitors
	* @param end the upper bound of the range of admin monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching admin monitors
	*/
	public static List<AdminMonitor> findByUser(long userId, int start,
		int end, OrderByComparator<AdminMonitor> orderByComparator) {
		return getPersistence().findByUser(userId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the admin monitors where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of admin monitors
	* @param end the upper bound of the range of admin monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching admin monitors
	*/
	public static List<AdminMonitor> findByUser(long userId, int start,
		int end, OrderByComparator<AdminMonitor> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUser(userId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first admin monitor in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin monitor
	* @throws NoSuchAdminMonitorException if a matching admin monitor could not be found
	*/
	public static AdminMonitor findByUser_First(long userId,
		OrderByComparator<AdminMonitor> orderByComparator)
		throws com.liferay.training.amf.monitor.exception.NoSuchAdminMonitorException {
		return getPersistence().findByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the first admin monitor in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin monitor, or <code>null</code> if a matching admin monitor could not be found
	*/
	public static AdminMonitor fetchByUser_First(long userId,
		OrderByComparator<AdminMonitor> orderByComparator) {
		return getPersistence().fetchByUser_First(userId, orderByComparator);
	}

	/**
	* Returns the last admin monitor in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin monitor
	* @throws NoSuchAdminMonitorException if a matching admin monitor could not be found
	*/
	public static AdminMonitor findByUser_Last(long userId,
		OrderByComparator<AdminMonitor> orderByComparator)
		throws com.liferay.training.amf.monitor.exception.NoSuchAdminMonitorException {
		return getPersistence().findByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the last admin monitor in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin monitor, or <code>null</code> if a matching admin monitor could not be found
	*/
	public static AdminMonitor fetchByUser_Last(long userId,
		OrderByComparator<AdminMonitor> orderByComparator) {
		return getPersistence().fetchByUser_Last(userId, orderByComparator);
	}

	/**
	* Returns the admin monitors before and after the current admin monitor in the ordered set where userId = &#63;.
	*
	* @param monitorId the primary key of the current admin monitor
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next admin monitor
	* @throws NoSuchAdminMonitorException if a admin monitor with the primary key could not be found
	*/
	public static AdminMonitor[] findByUser_PrevAndNext(long monitorId,
		long userId, OrderByComparator<AdminMonitor> orderByComparator)
		throws com.liferay.training.amf.monitor.exception.NoSuchAdminMonitorException {
		return getPersistence()
				   .findByUser_PrevAndNext(monitorId, userId, orderByComparator);
	}

	/**
	* Removes all the admin monitors where userId = &#63; from the database.
	*
	* @param userId the user ID
	*/
	public static void removeByUser(long userId) {
		getPersistence().removeByUser(userId);
	}

	/**
	* Returns the number of admin monitors where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching admin monitors
	*/
	public static int countByUser(long userId) {
		return getPersistence().countByUser(userId);
	}

	/**
	* Caches the admin monitor in the entity cache if it is enabled.
	*
	* @param adminMonitor the admin monitor
	*/
	public static void cacheResult(AdminMonitor adminMonitor) {
		getPersistence().cacheResult(adminMonitor);
	}

	/**
	* Caches the admin monitors in the entity cache if it is enabled.
	*
	* @param adminMonitors the admin monitors
	*/
	public static void cacheResult(List<AdminMonitor> adminMonitors) {
		getPersistence().cacheResult(adminMonitors);
	}

	/**
	* Creates a new admin monitor with the primary key. Does not add the admin monitor to the database.
	*
	* @param monitorId the primary key for the new admin monitor
	* @return the new admin monitor
	*/
	public static AdminMonitor create(long monitorId) {
		return getPersistence().create(monitorId);
	}

	/**
	* Removes the admin monitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor that was removed
	* @throws NoSuchAdminMonitorException if a admin monitor with the primary key could not be found
	*/
	public static AdminMonitor remove(long monitorId)
		throws com.liferay.training.amf.monitor.exception.NoSuchAdminMonitorException {
		return getPersistence().remove(monitorId);
	}

	public static AdminMonitor updateImpl(AdminMonitor adminMonitor) {
		return getPersistence().updateImpl(adminMonitor);
	}

	/**
	* Returns the admin monitor with the primary key or throws a {@link NoSuchAdminMonitorException} if it could not be found.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor
	* @throws NoSuchAdminMonitorException if a admin monitor with the primary key could not be found
	*/
	public static AdminMonitor findByPrimaryKey(long monitorId)
		throws com.liferay.training.amf.monitor.exception.NoSuchAdminMonitorException {
		return getPersistence().findByPrimaryKey(monitorId);
	}

	/**
	* Returns the admin monitor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor, or <code>null</code> if a admin monitor with the primary key could not be found
	*/
	public static AdminMonitor fetchByPrimaryKey(long monitorId) {
		return getPersistence().fetchByPrimaryKey(monitorId);
	}

	public static java.util.Map<java.io.Serializable, AdminMonitor> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the admin monitors.
	*
	* @return the admin monitors
	*/
	public static List<AdminMonitor> findAll() {
		return getPersistence().findAll();
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
	public static List<AdminMonitor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<AdminMonitor> findAll(int start, int end,
		OrderByComparator<AdminMonitor> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
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
	public static List<AdminMonitor> findAll(int start, int end,
		OrderByComparator<AdminMonitor> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the admin monitors from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of admin monitors.
	*
	* @return the number of admin monitors
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AdminMonitorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AdminMonitorPersistence, AdminMonitorPersistence> _serviceTracker =
		ServiceTrackerFactory.open(AdminMonitorPersistence.class);
}
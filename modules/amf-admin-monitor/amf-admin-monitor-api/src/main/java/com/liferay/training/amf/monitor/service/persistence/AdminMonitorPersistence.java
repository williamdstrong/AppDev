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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.liferay.training.amf.monitor.exception.NoSuchAdminMonitorException;
import com.liferay.training.amf.monitor.model.AdminMonitor;

/**
 * The persistence interface for the admin monitor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.training.amf.monitor.service.persistence.impl.AdminMonitorPersistenceImpl
 * @see AdminMonitorUtil
 * @generated
 */
@ProviderType
public interface AdminMonitorPersistence extends BasePersistence<AdminMonitor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AdminMonitorUtil} to access the admin monitor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the admin monitors where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the matching admin monitors
	*/
	public java.util.List<AdminMonitor> findByEventType(
		java.lang.String eventType);

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
	public java.util.List<AdminMonitor> findByEventType(
		java.lang.String eventType, int start, int end);

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
	public java.util.List<AdminMonitor> findByEventType(
		java.lang.String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdminMonitor> orderByComparator);

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
	public java.util.List<AdminMonitor> findByEventType(
		java.lang.String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdminMonitor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first admin monitor in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin monitor
	* @throws NoSuchAdminMonitorException if a matching admin monitor could not be found
	*/
	public AdminMonitor findByEventType_First(java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AdminMonitor> orderByComparator)
		throws NoSuchAdminMonitorException;

	/**
	* Returns the first admin monitor in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching admin monitor, or <code>null</code> if a matching admin monitor could not be found
	*/
	public AdminMonitor fetchByEventType_First(java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AdminMonitor> orderByComparator);

	/**
	* Returns the last admin monitor in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin monitor
	* @throws NoSuchAdminMonitorException if a matching admin monitor could not be found
	*/
	public AdminMonitor findByEventType_Last(java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AdminMonitor> orderByComparator)
		throws NoSuchAdminMonitorException;

	/**
	* Returns the last admin monitor in the ordered set where eventType = &#63;.
	*
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching admin monitor, or <code>null</code> if a matching admin monitor could not be found
	*/
	public AdminMonitor fetchByEventType_Last(java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AdminMonitor> orderByComparator);

	/**
	* Returns the admin monitors before and after the current admin monitor in the ordered set where eventType = &#63;.
	*
	* @param monitorId the primary key of the current admin monitor
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next admin monitor
	* @throws NoSuchAdminMonitorException if a admin monitor with the primary key could not be found
	*/
	public AdminMonitor[] findByEventType_PrevAndNext(long monitorId,
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AdminMonitor> orderByComparator)
		throws NoSuchAdminMonitorException;

	/**
	* Returns all the admin monitors that the user has permission to view where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the matching admin monitors that the user has permission to view
	*/
	public java.util.List<AdminMonitor> filterFindByEventType(
		java.lang.String eventType);

	/**
	* Returns a range of all the admin monitors that the user has permission to view where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of admin monitors
	* @param end the upper bound of the range of admin monitors (not inclusive)
	* @return the range of matching admin monitors that the user has permission to view
	*/
	public java.util.List<AdminMonitor> filterFindByEventType(
		java.lang.String eventType, int start, int end);

	/**
	* Returns an ordered range of all the admin monitors that the user has permissions to view where eventType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventType the event type
	* @param start the lower bound of the range of admin monitors
	* @param end the upper bound of the range of admin monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching admin monitors that the user has permission to view
	*/
	public java.util.List<AdminMonitor> filterFindByEventType(
		java.lang.String eventType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdminMonitor> orderByComparator);

	/**
	* Returns the admin monitors before and after the current admin monitor in the ordered set of admin monitors that the user has permission to view where eventType = &#63;.
	*
	* @param monitorId the primary key of the current admin monitor
	* @param eventType the event type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next admin monitor
	* @throws NoSuchAdminMonitorException if a admin monitor with the primary key could not be found
	*/
	public AdminMonitor[] filterFindByEventType_PrevAndNext(long monitorId,
		java.lang.String eventType,
		com.liferay.portal.kernel.util.OrderByComparator<AdminMonitor> orderByComparator)
		throws NoSuchAdminMonitorException;

	/**
	* Removes all the admin monitors where eventType = &#63; from the database.
	*
	* @param eventType the event type
	*/
	public void removeByEventType(java.lang.String eventType);

	/**
	* Returns the number of admin monitors where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the number of matching admin monitors
	*/
	public int countByEventType(java.lang.String eventType);

	/**
	* Returns the number of admin monitors that the user has permission to view where eventType = &#63;.
	*
	* @param eventType the event type
	* @return the number of matching admin monitors that the user has permission to view
	*/
	public int filterCountByEventType(java.lang.String eventType);

	/**
	* Caches the admin monitor in the entity cache if it is enabled.
	*
	* @param adminMonitor the admin monitor
	*/
	public void cacheResult(AdminMonitor adminMonitor);

	/**
	* Caches the admin monitors in the entity cache if it is enabled.
	*
	* @param adminMonitors the admin monitors
	*/
	public void cacheResult(java.util.List<AdminMonitor> adminMonitors);

	/**
	* Creates a new admin monitor with the primary key. Does not add the admin monitor to the database.
	*
	* @param monitorId the primary key for the new admin monitor
	* @return the new admin monitor
	*/
	public AdminMonitor create(long monitorId);

	/**
	* Removes the admin monitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor that was removed
	* @throws NoSuchAdminMonitorException if a admin monitor with the primary key could not be found
	*/
	public AdminMonitor remove(long monitorId)
		throws NoSuchAdminMonitorException;

	public AdminMonitor updateImpl(AdminMonitor adminMonitor);

	/**
	* Returns the admin monitor with the primary key or throws a {@link NoSuchAdminMonitorException} if it could not be found.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor
	* @throws NoSuchAdminMonitorException if a admin monitor with the primary key could not be found
	*/
	public AdminMonitor findByPrimaryKey(long monitorId)
		throws NoSuchAdminMonitorException;

	/**
	* Returns the admin monitor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor, or <code>null</code> if a admin monitor with the primary key could not be found
	*/
	public AdminMonitor fetchByPrimaryKey(long monitorId);

	@Override
	public java.util.Map<java.io.Serializable, AdminMonitor> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the admin monitors.
	*
	* @return the admin monitors
	*/
	public java.util.List<AdminMonitor> findAll();

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
	public java.util.List<AdminMonitor> findAll(int start, int end);

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
	public java.util.List<AdminMonitor> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdminMonitor> orderByComparator);

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
	public java.util.List<AdminMonitor> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AdminMonitor> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the admin monitors from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of admin monitors.
	*
	* @return the number of admin monitors
	*/
	public int countAll();
}
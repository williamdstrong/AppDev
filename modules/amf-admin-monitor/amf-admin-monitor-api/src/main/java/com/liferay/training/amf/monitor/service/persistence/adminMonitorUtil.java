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

import com.liferay.training.amf.monitor.model.adminMonitor;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the admin monitor service. This utility wraps {@link com.liferay.training.amf.monitor.service.persistence.impl.adminMonitorPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see adminMonitorPersistence
 * @see com.liferay.training.amf.monitor.service.persistence.impl.adminMonitorPersistenceImpl
 * @generated
 */
@ProviderType
public class adminMonitorUtil {
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
	public static void clearCache(adminMonitor adminMonitor) {
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
	public static List<adminMonitor> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<adminMonitor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<adminMonitor> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<adminMonitor> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static adminMonitor update(adminMonitor adminMonitor) {
		return getPersistence().update(adminMonitor);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static adminMonitor update(adminMonitor adminMonitor,
		ServiceContext serviceContext) {
		return getPersistence().update(adminMonitor, serviceContext);
	}

	/**
	* Caches the admin monitor in the entity cache if it is enabled.
	*
	* @param adminMonitor the admin monitor
	*/
	public static void cacheResult(adminMonitor adminMonitor) {
		getPersistence().cacheResult(adminMonitor);
	}

	/**
	* Caches the admin monitors in the entity cache if it is enabled.
	*
	* @param adminMonitors the admin monitors
	*/
	public static void cacheResult(List<adminMonitor> adminMonitors) {
		getPersistence().cacheResult(adminMonitors);
	}

	/**
	* Creates a new admin monitor with the primary key. Does not add the admin monitor to the database.
	*
	* @param monitorId the primary key for the new admin monitor
	* @return the new admin monitor
	*/
	public static adminMonitor create(long monitorId) {
		return getPersistence().create(monitorId);
	}

	/**
	* Removes the admin monitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor that was removed
	* @throws NoSuchadminMonitorException if a admin monitor with the primary key could not be found
	*/
	public static adminMonitor remove(long monitorId)
		throws com.liferay.training.amf.monitor.exception.NoSuchadminMonitorException {
		return getPersistence().remove(monitorId);
	}

	public static adminMonitor updateImpl(adminMonitor adminMonitor) {
		return getPersistence().updateImpl(adminMonitor);
	}

	/**
	* Returns the admin monitor with the primary key or throws a {@link NoSuchadminMonitorException} if it could not be found.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor
	* @throws NoSuchadminMonitorException if a admin monitor with the primary key could not be found
	*/
	public static adminMonitor findByPrimaryKey(long monitorId)
		throws com.liferay.training.amf.monitor.exception.NoSuchadminMonitorException {
		return getPersistence().findByPrimaryKey(monitorId);
	}

	/**
	* Returns the admin monitor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor, or <code>null</code> if a admin monitor with the primary key could not be found
	*/
	public static adminMonitor fetchByPrimaryKey(long monitorId) {
		return getPersistence().fetchByPrimaryKey(monitorId);
	}

	public static java.util.Map<java.io.Serializable, adminMonitor> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the admin monitors.
	*
	* @return the admin monitors
	*/
	public static List<adminMonitor> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the admin monitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link adminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of admin monitors
	* @param end the upper bound of the range of admin monitors (not inclusive)
	* @return the range of admin monitors
	*/
	public static List<adminMonitor> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the admin monitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link adminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of admin monitors
	* @param end the upper bound of the range of admin monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of admin monitors
	*/
	public static List<adminMonitor> findAll(int start, int end,
		OrderByComparator<adminMonitor> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the admin monitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link adminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of admin monitors
	* @param end the upper bound of the range of admin monitors (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of admin monitors
	*/
	public static List<adminMonitor> findAll(int start, int end,
		OrderByComparator<adminMonitor> orderByComparator,
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

	public static adminMonitorPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<adminMonitorPersistence, adminMonitorPersistence> _serviceTracker =
		ServiceTrackerFactory.open(adminMonitorPersistence.class);
}
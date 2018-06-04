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

import com.liferay.training.amf.monitor.exception.NoSuchadminMonitorException;
import com.liferay.training.amf.monitor.model.adminMonitor;

/**
 * The persistence interface for the admin monitor service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.training.amf.monitor.service.persistence.impl.adminMonitorPersistenceImpl
 * @see adminMonitorUtil
 * @generated
 */
@ProviderType
public interface adminMonitorPersistence extends BasePersistence<adminMonitor> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link adminMonitorUtil} to access the admin monitor persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the admin monitor in the entity cache if it is enabled.
	*
	* @param adminMonitor the admin monitor
	*/
	public void cacheResult(adminMonitor adminMonitor);

	/**
	* Caches the admin monitors in the entity cache if it is enabled.
	*
	* @param adminMonitors the admin monitors
	*/
	public void cacheResult(java.util.List<adminMonitor> adminMonitors);

	/**
	* Creates a new admin monitor with the primary key. Does not add the admin monitor to the database.
	*
	* @param monitorId the primary key for the new admin monitor
	* @return the new admin monitor
	*/
	public adminMonitor create(long monitorId);

	/**
	* Removes the admin monitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor that was removed
	* @throws NoSuchadminMonitorException if a admin monitor with the primary key could not be found
	*/
	public adminMonitor remove(long monitorId)
		throws NoSuchadminMonitorException;

	public adminMonitor updateImpl(adminMonitor adminMonitor);

	/**
	* Returns the admin monitor with the primary key or throws a {@link NoSuchadminMonitorException} if it could not be found.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor
	* @throws NoSuchadminMonitorException if a admin monitor with the primary key could not be found
	*/
	public adminMonitor findByPrimaryKey(long monitorId)
		throws NoSuchadminMonitorException;

	/**
	* Returns the admin monitor with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor, or <code>null</code> if a admin monitor with the primary key could not be found
	*/
	public adminMonitor fetchByPrimaryKey(long monitorId);

	@Override
	public java.util.Map<java.io.Serializable, adminMonitor> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the admin monitors.
	*
	* @return the admin monitors
	*/
	public java.util.List<adminMonitor> findAll();

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
	public java.util.List<adminMonitor> findAll(int start, int end);

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
	public java.util.List<adminMonitor> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<adminMonitor> orderByComparator);

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
	public java.util.List<adminMonitor> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<adminMonitor> orderByComparator,
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
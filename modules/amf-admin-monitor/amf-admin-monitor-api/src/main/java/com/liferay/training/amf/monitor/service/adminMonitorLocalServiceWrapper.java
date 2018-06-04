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

package com.liferay.training.amf.monitor.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link adminMonitorLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see adminMonitorLocalService
 * @generated
 */
@ProviderType
public class adminMonitorLocalServiceWrapper implements adminMonitorLocalService,
	ServiceWrapper<adminMonitorLocalService> {
	public adminMonitorLocalServiceWrapper(
		adminMonitorLocalService adminMonitorLocalService) {
		_adminMonitorLocalService = adminMonitorLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _adminMonitorLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _adminMonitorLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _adminMonitorLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _adminMonitorLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _adminMonitorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the admin monitor to the database. Also notifies the appropriate model listeners.
	*
	* @param adminMonitor the admin monitor
	* @return the admin monitor that was added
	*/
	@Override
	public com.liferay.training.amf.monitor.model.adminMonitor addadminMonitor(
		com.liferay.training.amf.monitor.model.adminMonitor adminMonitor) {
		return _adminMonitorLocalService.addadminMonitor(adminMonitor);
	}

	/**
	* Creates a new admin monitor with the primary key. Does not add the admin monitor to the database.
	*
	* @param monitorId the primary key for the new admin monitor
	* @return the new admin monitor
	*/
	@Override
	public com.liferay.training.amf.monitor.model.adminMonitor createadminMonitor(
		long monitorId) {
		return _adminMonitorLocalService.createadminMonitor(monitorId);
	}

	/**
	* Deletes the admin monitor from the database. Also notifies the appropriate model listeners.
	*
	* @param adminMonitor the admin monitor
	* @return the admin monitor that was removed
	*/
	@Override
	public com.liferay.training.amf.monitor.model.adminMonitor deleteadminMonitor(
		com.liferay.training.amf.monitor.model.adminMonitor adminMonitor) {
		return _adminMonitorLocalService.deleteadminMonitor(adminMonitor);
	}

	/**
	* Deletes the admin monitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor that was removed
	* @throws PortalException if a admin monitor with the primary key could not be found
	*/
	@Override
	public com.liferay.training.amf.monitor.model.adminMonitor deleteadminMonitor(
		long monitorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _adminMonitorLocalService.deleteadminMonitor(monitorId);
	}

	@Override
	public com.liferay.training.amf.monitor.model.adminMonitor fetchadminMonitor(
		long monitorId) {
		return _adminMonitorLocalService.fetchadminMonitor(monitorId);
	}

	/**
	* Returns the admin monitor with the primary key.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor
	* @throws PortalException if a admin monitor with the primary key could not be found
	*/
	@Override
	public com.liferay.training.amf.monitor.model.adminMonitor getadminMonitor(
		long monitorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _adminMonitorLocalService.getadminMonitor(monitorId);
	}

	/**
	* Updates the admin monitor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param adminMonitor the admin monitor
	* @return the admin monitor that was updated
	*/
	@Override
	public com.liferay.training.amf.monitor.model.adminMonitor updateadminMonitor(
		com.liferay.training.amf.monitor.model.adminMonitor adminMonitor) {
		return _adminMonitorLocalService.updateadminMonitor(adminMonitor);
	}

	/**
	* Returns the number of admin monitors.
	*
	* @return the number of admin monitors
	*/
	@Override
	public int getadminMonitorsCount() {
		return _adminMonitorLocalService.getadminMonitorsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _adminMonitorLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _adminMonitorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.monitor.model.impl.adminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _adminMonitorLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.monitor.model.impl.adminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _adminMonitorLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the admin monitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.monitor.model.impl.adminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of admin monitors
	* @param end the upper bound of the range of admin monitors (not inclusive)
	* @return the range of admin monitors
	*/
	@Override
	public java.util.List<com.liferay.training.amf.monitor.model.adminMonitor> getadminMonitors(
		int start, int end) {
		return _adminMonitorLocalService.getadminMonitors(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _adminMonitorLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _adminMonitorLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public adminMonitorLocalService getWrappedService() {
		return _adminMonitorLocalService;
	}

	@Override
	public void setWrappedService(
		adminMonitorLocalService adminMonitorLocalService) {
		_adminMonitorLocalService = adminMonitorLocalService;
	}

	private adminMonitorLocalService _adminMonitorLocalService;
}
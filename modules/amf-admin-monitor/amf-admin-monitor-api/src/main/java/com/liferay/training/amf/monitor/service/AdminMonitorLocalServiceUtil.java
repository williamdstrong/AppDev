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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AdminMonitor. This utility wraps
 * {@link com.liferay.training.amf.monitor.service.impl.AdminMonitorLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AdminMonitorLocalService
 * @see com.liferay.training.amf.monitor.service.base.AdminMonitorLocalServiceBaseImpl
 * @see com.liferay.training.amf.monitor.service.impl.AdminMonitorLocalServiceImpl
 * @generated
 */
@ProviderType
public class AdminMonitorLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.amf.monitor.service.impl.AdminMonitorLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the admin monitor to the database. Also notifies the appropriate model listeners.
	*
	* @param adminMonitor the admin monitor
	* @return the admin monitor that was added
	*/
	public static com.liferay.training.amf.monitor.model.AdminMonitor addAdminMonitor(
		com.liferay.training.amf.monitor.model.AdminMonitor adminMonitor) {
		return getService().addAdminMonitor(adminMonitor);
	}

	public static com.liferay.training.amf.monitor.model.AdminMonitor addAdminMonitorCreationEvent(
		com.liferay.portal.kernel.model.User user) {
		return getService().addAdminMonitorCreationEvent(user);
	}

	public static com.liferay.training.amf.monitor.model.AdminMonitor addAdminMonitorLoginEvent(
		com.liferay.portal.kernel.model.User user) {
		return getService().addAdminMonitorLoginEvent(user);
	}

	/**
	* Creates a new admin monitor with the primary key. Does not add the admin monitor to the database.
	*
	* @param monitorId the primary key for the new admin monitor
	* @return the new admin monitor
	*/
	public static com.liferay.training.amf.monitor.model.AdminMonitor createAdminMonitor(
		long monitorId) {
		return getService().createAdminMonitor(monitorId);
	}

	/**
	* Deletes the admin monitor from the database. Also notifies the appropriate model listeners.
	*
	* @param adminMonitor the admin monitor
	* @return the admin monitor that was removed
	*/
	public static com.liferay.training.amf.monitor.model.AdminMonitor deleteAdminMonitor(
		com.liferay.training.amf.monitor.model.AdminMonitor adminMonitor) {
		return getService().deleteAdminMonitor(adminMonitor);
	}

	/**
	* Deletes the admin monitor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor that was removed
	* @throws PortalException if a admin monitor with the primary key could not be found
	*/
	public static com.liferay.training.amf.monitor.model.AdminMonitor deleteAdminMonitor(
		long monitorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteAdminMonitor(monitorId);
	}

	public static com.liferay.training.amf.monitor.model.AdminMonitor fetchAdminMonitor(
		long monitorId) {
		return getService().fetchAdminMonitor(monitorId);
	}

	/**
	* Returns the admin monitor with the primary key.
	*
	* @param monitorId the primary key of the admin monitor
	* @return the admin monitor
	* @throws PortalException if a admin monitor with the primary key could not be found
	*/
	public static com.liferay.training.amf.monitor.model.AdminMonitor getAdminMonitor(
		long monitorId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAdminMonitor(monitorId);
	}

	/**
	* Updates the admin monitor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param adminMonitor the admin monitor
	* @return the admin monitor that was updated
	*/
	public static com.liferay.training.amf.monitor.model.AdminMonitor updateAdminMonitor(
		com.liferay.training.amf.monitor.model.AdminMonitor adminMonitor) {
		return getService().updateAdminMonitor(adminMonitor);
	}

	/**
	* Returns the number of admin monitors.
	*
	* @return the number of admin monitors
	*/
	public static int getAdminMonitorsCount() {
		return getService().getAdminMonitorsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.monitor.model.impl.AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.monitor.model.impl.AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns a range of all the admin monitors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.training.amf.monitor.model.impl.AdminMonitorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of admin monitors
	* @param end the upper bound of the range of admin monitors (not inclusive)
	* @return the range of admin monitors
	*/
	public static java.util.List<com.liferay.training.amf.monitor.model.AdminMonitor> getAdminMonitors(
		int start, int end) {
		return getService().getAdminMonitors(start, end);
	}

	public static java.util.List<com.liferay.training.amf.monitor.model.AdminMonitor> getCreationEvents() {
		return getService().getCreationEvents();
	}

	public static java.util.List<com.liferay.training.amf.monitor.model.AdminMonitor> getLoginEvents() {
		return getService().getLoginEvents();
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static AdminMonitorLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AdminMonitorLocalService, AdminMonitorLocalService> _serviceTracker =
		ServiceTrackerFactory.open(AdminMonitorLocalService.class);
}
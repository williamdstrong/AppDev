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

package com.liferay.training.amf.search.service;

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Search. This utility wraps
 * {@link com.liferay.training.amf.search.service.impl.SearchLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see SearchLocalService
 * @see com.liferay.training.amf.search.service.base.SearchLocalServiceBaseImpl
 * @see com.liferay.training.amf.search.service.impl.SearchLocalServiceImpl
 * @generated
 */
@ProviderType
public class SearchLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.amf.search.service.impl.SearchLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* NOTE FOR DEVELOPERS:
	* <p>
	* Never reference this class directly. Always use {@link SearchLocalServiceUtil} to access the search local service.
	*/
	public static java.util.List<com.liferay.training.amf.search.dto.SearchData> findByZip(
		String zip, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().findByZip(zip, start, end);
	}

	public static long get_size()
		throws com.liferay.training.amf.search.exception.NoSearchQueryException {
		return getService().get_size();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static SearchLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SearchLocalService, SearchLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SearchLocalService.class);

		ServiceTracker<SearchLocalService, SearchLocalService> serviceTracker = new ServiceTracker<SearchLocalService, SearchLocalService>(bundle.getBundleContext(),
				SearchLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
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
 * Provides the remote service utility for Search. This utility wraps
 * {@link com.liferay.training.amf.search.service.impl.SearchServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see SearchService
 * @see com.liferay.training.amf.search.service.base.SearchServiceBaseImpl
 * @see com.liferay.training.amf.search.service.impl.SearchServiceImpl
 * @generated
 */
@ProviderType
public class SearchServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.amf.search.service.impl.SearchServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this class directly. Always use {@link SearchServiceUtil} to access the search remote service.
	*
	* @param groupId
	* @param zip
	* @param start
	* @param end
	* @return
	* @throws InvalidZipCodeException thrown when the zip code provided is invalid (i.e. not 5 digits).
	* @throws PrincipalException thrown when the user does not have permission to access the user data requested.
	* @throws PortalException
	*/
	public static java.util.List<com.liferay.training.amf.search.dto.SearchData> findByZip(
		long groupId, String zip, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().findByZip(groupId, zip, start, end);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static long getSize()
		throws com.liferay.training.amf.search.exception.NoSearchQueryException {
		return getService().getSize();
	}

	public static SearchService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SearchService, SearchService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(SearchService.class);

		ServiceTracker<SearchService, SearchService> serviceTracker = new ServiceTracker<SearchService, SearchService>(bundle.getBundleContext(),
				SearchService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}
}
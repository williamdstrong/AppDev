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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SearchLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SearchLocalService
 * @generated
 */
@ProviderType
public class SearchLocalServiceWrapper implements SearchLocalService,
	ServiceWrapper<SearchLocalService> {
	public SearchLocalServiceWrapper(SearchLocalService searchLocalService) {
		_searchLocalService = searchLocalService;
	}

	/**
	* NOTE FOR DEVELOPERS:
	* <p>
	* Never reference this class directly. Always use {@link SearchLocalServiceUtil} to access the search local service.
	*/
	@Override
	public java.util.List<com.liferay.training.amf.search.dto.SearchData> findByZip(
		String zip, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _searchLocalService.findByZip(zip, start, end);
	}

	@Override
	public long get_size()
		throws com.liferay.training.amf.search.exception.NoSearchQueryException {
		return _searchLocalService.get_size();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public String getOSGiServiceIdentifier() {
		return _searchLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public SearchLocalService getWrappedService() {
		return _searchLocalService;
	}

	@Override
	public void setWrappedService(SearchLocalService searchLocalService) {
		_searchLocalService = searchLocalService;
	}

	private SearchLocalService _searchLocalService;
}
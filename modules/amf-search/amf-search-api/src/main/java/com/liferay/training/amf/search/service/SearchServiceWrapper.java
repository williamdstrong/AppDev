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
 * Provides a wrapper for {@link SearchService}.
 *
 * @author Brian Wing Shun Chan
 * @see SearchService
 * @generated
 */
@ProviderType
public class SearchServiceWrapper implements SearchService,
	ServiceWrapper<SearchService> {
	public SearchServiceWrapper(SearchService searchService) {
		_searchService = searchService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _searchService.getOSGiServiceIdentifier();
	}

	/**
	* @param groupId
	* @param zip
	* @param start
	* @param end
	* @return
	* @throws InvalidZipCodeException thrown when the zip code provided is invalid (i.e. not 5 digits).
	* @throws PrincipalException thrown when the user does not have permission to access the user data requested.
	* @throws PortalException
	*/
	@Override
	public java.util.List<com.liferay.training.amf.search.dto.SearchData> findByZip(
		long groupId, java.lang.String zip, int start, int end)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _searchService.findByZip(groupId, zip, start, end);
	}

	@Override
	public long getSize()
		throws com.liferay.training.amf.search.exception.NoSearchQueryException {
		return _searchService.getSize();
	}

	@Override
	public SearchService getWrappedService() {
		return _searchService;
	}

	@Override
	public void setWrappedService(SearchService searchService) {
		_searchService = searchService;
	}

	private SearchService _searchService;
}
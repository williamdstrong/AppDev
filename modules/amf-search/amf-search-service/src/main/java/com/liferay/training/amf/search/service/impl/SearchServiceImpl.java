/*
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

package com.liferay.training.amf.search.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.training.amf.search.dto.SearchData;
import com.liferay.training.amf.search.exception.NoSearchQueryException;
import com.liferay.training.amf.search.service.base.SearchServiceBaseImpl;
import com.liferay.training.amf.search.service.permission.SearchServicePermissionChecker;

import java.util.List;

/**
 * The implementation of the search remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.amf.search.service.SearchService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author William Strong
 * @see SearchServiceBaseImpl
 * @see com.liferay.training.amf.search.service.SearchServiceUtil
 */
public class SearchServiceImpl extends SearchServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.training.amf.search.service.SearchServiceUtil} to access the search remote service.
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
	public List<SearchData> findByZip(
		long groupId, String zip, int start, int end)
		throws PortalException {

		SearchServicePermissionChecker.check(
			getPermissionChecker(), groupId, "USE_THIS_SERVICE");

		return searchLocalService.findByZip(zip, start, end);
	}

	public long getSize() throws NoSearchQueryException {
		return searchLocalService.get_size();
	}

}
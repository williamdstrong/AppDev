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

package com.liferay.training.amf.search.service.impl;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.User;
import com.liferay.training.amf.search.service.SearchService;
import com.liferay.training.amf.search.service.SearchServiceUtil;
import com.liferay.training.amf.search.service.base.SearchServiceBaseImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * The implementation of the search remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link SearchService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SearchServiceBaseImpl
 * @see SearchServiceUtil
 */
public class SearchServiceImpl extends SearchServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.training.a,fsearch.service.SearchServiceUtil} to access the search remote service.
	 */

	public List<User> findUsersByZip(String zip, int start, int end) throws PortalException {
		// TODO validation
		// TODO permissions

		// Use dynamic query that finds all entries with a particular zip code.
		List<Long> userIds = getUserIdsByZip(zip, start, end);
		List<User> users = null;
		for (Long l : userIds) {
			users.add(userLocalService.getUser(l));
		}
		return users;
	}

	private List<Long> getUserIdsByZip(String zip, int start, int end) {

		Session session = null;
		try {
			session = addressPersistence.openSession();

			DynamicQuery zipQuery =
					DynamicQueryFactoryUtil.forClass(Address.class)
							.add(RestrictionsFactoryUtil.eq("zip", zip))
							.setProjection(ProjectionFactoryUtil.property("userId"));

			return addressPersistence.findWithDynamicQuery(zipQuery, start, end);
		}
		// TODO find out what errors may be thrown.
		// Ideas: cannot open session, no data found
		catch (ORMException e) {
			_log.error("Cannot get address data.");
			return new LinkedList<>();
		}
		finally {
			addressPersistence.closeSession(session);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SearchService.class.getName());
}
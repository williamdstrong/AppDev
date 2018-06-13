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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.amf.search.exception.InvalidZipCodeException;
import com.liferay.training.amf.search.service.SearchService;
import com.liferay.training.amf.search.service.base.SearchServiceBaseImpl;
import com.liferay.training.amf.search.dto.SearchData;

import java.util.LinkedList;
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
 * @author Brian Wing Shun Chan
 * @see SearchServiceBaseImpl
 * @see com.liferay.training.amf.search.service.SearchServiceUtil
 */
public class SearchServiceImpl extends SearchServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.liferay.training.amf.search.service.SearchServiceUtil} to access the search remote service.
	 */

	public List<SearchData> findByZip(String zip, int start, int end) throws InvalidZipCodeException {
		validateZip(zip);
		return getFormattedData(zip, start, end);
	}

	public long getSize() throws NoSearchQuery {
		if (size == null) {
			throw new NoSearchQuery();
		}
		else {
			return size;
		}
	}

	private void validateZip(String zip) throws InvalidZipCodeException {
		if( Validator.isNotNull(zip) &&
		Validator.isNumber(zip) ) {
			throw new InvalidZipCodeException(zip + "is an invalid zip code.");
		}
	}



	private List<SearchData> getFormattedData(String zip, int start, int end) {
		if (zip.isEmpty()) {
			return new LinkedList<>();
		}
		List<User> users;
		List<SearchData> searchData = new LinkedList<>();

		// Get total size and set.
		size = (int)_getSize(zip);

		try {
			users = getUsers(zip, start, end);
		} catch (PortalException e) {
			return searchData;
		}

		SearchData a;
		for (User u : users) {
			SearchData s = new SearchData(getFirstName(u), getLastInitial(u), getScreenName(u), getEmailAddress(u));
			searchData.add(s);
//			searchData.add(new SearchData(getFirstName(u), getLastInitial(u), getScreenName(u), getEmailAddress(u)));
		}
		return searchData;
	}

	private String getFirstName(User u) {
		return u.getFirstName();
	}

	private String getLastInitial(User u) {
		String lastName = u.getLastName();
		return String.valueOf(lastName.charAt(0));
	}

	private String getScreenName(User u) {
		return u.getScreenName();
	}

	private String getEmailAddress(User u) {
		return u.getEmailAddress();
	}

	private long _getSize(String zip) {
		return findUsersByZipCount(zip);
	}

	private List<User> getUsers(String zip, int start, int end) throws PortalException {
		return findUsersByZip(zip, start, end);
	}

	private long findUsersByZipCount(String zip) {
		DynamicQuery zipQuery =
				DynamicQueryFactoryUtil.forClass(Address.class)
						.add(RestrictionsFactoryUtil.eq("zip", zip));
		return addressPersistence.countWithDynamicQuery(zipQuery);
	}

	private List<User> findUsersByZip(String zip, int start, int end) throws PortalException {
		// TODO validation
		// TODO permissions

		// Use dynamic query that finds all entries with a particular zip code.
		List<Long> userIds = getUserIdsByZip(zip, start, end);
		List<User> users = new LinkedList<>();
		for (Long l : userIds) {
			User u = userLocalService.getUser(l);
			users.add(u);
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

	private Integer size;

	private static Log _log = LogFactoryUtil.getLog(SearchService.class.getName());
}
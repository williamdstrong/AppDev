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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ORMException;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.training.amf.search.dto.SearchData;
import com.liferay.training.amf.search.exception.InvalidZipCodeException;
import com.liferay.training.amf.search.exception.NoSearchQueryException;
import com.liferay.training.amf.search.service.SearchService;
import com.liferay.training.amf.search.service.base.SearchLocalServiceBaseImpl;

import java.util.LinkedList;
import java.util.List;

/**
 * The implementation of the search local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.amf.search.service.SearchLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author William Strong
 * @see SearchLocalServiceBaseImpl
 * @see com.liferay.training.amf.search.service.SearchLocalServiceUtil
 */
public class SearchLocalServiceImpl extends SearchLocalServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 * <p>
	 * Never reference this class directly. Always use {@link com.liferay.training.amf.search.service.SearchLocalServiceUtil} to access the search local service.
	 */
	public List<SearchData> findByZip(String zip, int start, int end)
		throws PortalException {

		_validateZip(zip);

		return _getFormattedData(zip, start, end);
	}

	public long get_size() throws NoSearchQueryException {
		if (_size == null) {
			throw new NoSearchQueryException();
		}
		else {
			return _size;
		}
	}

	private List<User> _findUsersByZip(String zip, int start, int end)
		throws PortalException {

		// Use dynamic query that finds all entries with a particular zip code.

		List<Long> userIds = _getUserIdsByZip(zip, start, end);
		List<User> users = new LinkedList<>();

		for (Long l : userIds) {
			User u = userLocalService.getUser(l);

			users.add(u);
		}

		return users;
	}

	private long _findUsersByZipCount(String zip) {
		DynamicQuery zipQuery = DynamicQueryFactoryUtil.forClass(Address.class);

		zipQuery.add(RestrictionsFactoryUtil.eq("zip", zip));

		return addressLocalService.dynamicQueryCount(zipQuery);
	}

	private String _getEmailAddress(User u) {
		return u.getEmailAddress();
	}

	private String _getFirstName(User u) {
		return u.getFirstName();
	}

	private List<SearchData> _getFormattedData(String zip, int start, int end) {
		if (zip.isEmpty()) {
			return new LinkedList<>();
		}

		List<User> users;
		List<SearchData> searchData = new LinkedList<>();

		// Get total _size and set.

		_size = (int) _getSize(zip);

		try {
			users = _getUsers(zip, start, end);
		}
		catch (PortalException pe) {
			_log.error(pe);

			return searchData;
		}

		for (User u : users) {
			SearchData s = new SearchData(
				_getFirstName(u), _getLastInitial(u), _getScreenName(u),
				_getEmailAddress(u));

			searchData.add(s);
		}

		return searchData;
	}

	private String _getLastInitial(User u) {
		String lastName = u.getLastName();

		return String.valueOf(lastName.charAt(0));
	}

	private String _getScreenName(User u) {
		return u.getScreenName();
	}

	private long _getSize(String zip) {
		return _findUsersByZipCount(zip);
	}

	private List<Long> _getUserIdsByZip(String zip, int start, int end) {
		try {
			DynamicQuery zipQuery = DynamicQueryFactoryUtil.forClass(
				Address.class);

			zipQuery.add(RestrictionsFactoryUtil.eq("zip", zip));
			zipQuery.setProjection(ProjectionFactoryUtil.property("userId"));

			return addressLocalService.dynamicQuery(zipQuery, start, end);
		}
		catch (ORMException orme) {
			_log.error(orme);

			return new LinkedList<>();
		}
	}

	private List<User> _getUsers(String zip, int start, int end)
		throws PortalException {

		return _findUsersByZip(zip, start, end);
	}

	private boolean _isFewerThanFiveDigits(String zip) {
		return zip.length() < 5;

	}

	private boolean _isGreaterThanFiveDigits(String zip) {
		return zip.length() > 5;

	}

	private void _validateZip(String zip) throws InvalidZipCodeException {
		if (Validator.isNull(zip)) {
			throw new InvalidZipCodeException.Null();
		}

		if (!Validator.isNumber(zip)) {
			throw new InvalidZipCodeException.NotANumber();
		}

		if (_isFewerThanFiveDigits(zip)) {
			throw new InvalidZipCodeException.TooFewDigits();
		}

		if (_isGreaterThanFiveDigits(zip)) {
			throw new InvalidZipCodeException.TooManyDigits();
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		SearchService.class.getName());

	private Integer _size;

}
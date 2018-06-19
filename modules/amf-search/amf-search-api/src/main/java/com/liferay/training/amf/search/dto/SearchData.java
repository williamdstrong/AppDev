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

package com.liferay.training.amf.search.dto;

/**
 * @author William Strong
 */
public class SearchData {

	public String getEmailAddress() {
		return _emailAddress;
	}

	public String getFirstName() {
		return _firstName;
	}

	public String getLastInitial() {
		return _lastInitial;
	}

	public String getScreenName() {
		return _screenName;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public void setLastInitial(String lastInitial) {
		_lastInitial = lastInitial;
	}

	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	private String _emailAddress;
	private String _firstName;
	private String _lastInitial;
	private String _screenName;

	public SearchData(
		String firstName, String lastInitial, String screenName,
		String emailAddress) {

		_firstName = firstName;
		_lastInitial = lastInitial;
		_screenName = screenName;
		_emailAddress = emailAddress;
	}

}
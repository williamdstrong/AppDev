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

package com.liferay.training.amf.registration.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link RegistrationLocalService}.
 *
 * @author William Strong
 * @see RegistrationLocalService
 * @generated
 */
@ProviderType
public class RegistrationLocalServiceWrapper implements RegistrationLocalService,
	ServiceWrapper<RegistrationLocalService> {
	public RegistrationLocalServiceWrapper(
		RegistrationLocalService registrationLocalService) {
		_registrationLocalService = registrationLocalService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _registrationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public void addRegistration(java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAddress,
		java.lang.String username, boolean male, int birthMonth, int birthDay,
		int birthYear, java.lang.String password,
		java.lang.String confirmPassword, java.lang.String homePhone,
		java.lang.String mobilePhone, java.lang.String address,
		java.lang.String address2, java.lang.String city,
		java.lang.String state, java.lang.String zip,
		java.lang.String securityQuestion,
		java.lang.String securityQuestionAnswer)
		throws com.liferay.portal.kernel.exception.PortalException {
		_registrationLocalService.addRegistration(firstName, lastName,
			emailAddress, username, male, birthMonth, birthDay, birthYear,
			password, confirmPassword, homePhone, mobilePhone, address,
			address2, city, state, zip, securityQuestion, securityQuestionAnswer);
	}

	@Override
	public RegistrationLocalService getWrappedService() {
		return _registrationLocalService;
	}

	@Override
	public void setWrappedService(
		RegistrationLocalService registrationLocalService) {
		_registrationLocalService = registrationLocalService;
	}

	private RegistrationLocalService _registrationLocalService;
}
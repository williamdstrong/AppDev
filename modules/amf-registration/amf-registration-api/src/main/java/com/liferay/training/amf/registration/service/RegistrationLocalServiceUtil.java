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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Registration. This utility wraps
 * {@link com.liferay.training.amf.registration.service.impl.RegistrationLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author William Strong
 * @see RegistrationLocalService
 * @see com.liferay.training.amf.registration.service.base.RegistrationLocalServiceBaseImpl
 * @see com.liferay.training.amf.registration.service.impl.RegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
public class RegistrationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.training.amf.registration.service.impl.RegistrationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static boolean usernameIsUnique(java.lang.String username) {
		return getService().usernameIsUnique(username);
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static void addRegistration(java.lang.String firstName,
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
		getService()
			.addRegistration(firstName, lastName, emailAddress, username, male,
			birthMonth, birthDay, birthYear, password, confirmPassword,
			homePhone, mobilePhone, address, address2, city, state, zip,
			securityQuestion, securityQuestionAnswer);
	}

	public static RegistrationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<RegistrationLocalService, RegistrationLocalService> _serviceTracker =
		ServiceTrackerFactory.open(RegistrationLocalService.class);
}
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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.*;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Transactional;

/**
 * Provides the local service interface for Registration. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author William Strong
 * @see RegistrationLocalServiceUtil
 * @see com.liferay.training.amf.registration.service.base.RegistrationLocalServiceBaseImpl
 * @see com.liferay.training.amf.registration.service.impl.RegistrationLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface RegistrationLocalService extends BaseLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link RegistrationLocalServiceUtil} to access the registration local service. Add custom service methods to {@link com.liferay.training.amf.registration.service.impl.RegistrationLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	public void addRegistration(java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAddress,
		java.lang.String username, boolean male, int birthMonth, int birthDay,
		int birthYear, java.lang.String password,
		java.lang.String confirmPassword, java.lang.String homePhone,
		java.lang.String mobilePhone, java.lang.String address,
		java.lang.String address2, java.lang.String city,
		java.lang.String state, java.lang.String zip,
		java.lang.String securityQuestion,
		java.lang.String securityQuestionAnswer) throws PortalException;
}
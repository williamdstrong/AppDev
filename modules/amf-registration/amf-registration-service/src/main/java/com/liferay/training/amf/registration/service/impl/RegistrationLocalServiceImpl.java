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

package com.liferay.training.amf.registration.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.*;
import com.liferay.portal.kernel.service.*;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;
import com.liferay.training.amf.registration.service.base.RegistrationLocalServiceBaseImpl;

import java.util.List;
import java.util.Locale;

/**
 * The implementation of the registration local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.training.amf.registration.service.RegistrationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author William Strong
 * @see RegistrationLocalServiceBaseImpl
 * @see com.liferay.training.amf.registration.service.RegistrationLocalServiceUtil
 */
public class RegistrationLocalServiceImpl
	extends RegistrationLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use {@link com.liferay.training.amf.registration.service.RegistrationLocalServiceUtil} to access the registration local service.
     */
    private Address address;
    private User user;
    private Contact contact;


    public void addRegistration(
            String firstName,
            String lastName,
            String emailAddress,
            String username,
            boolean male,
            int birthMonth,
            int birthDay,
            int birthYear,
            String password,
            String confirmPassword,
            String homePhone,
            String mobilePhone,
            String address,
            String address2,
            String city,
            String state,
            String zip,
            String securityQuestion,
            String securityQuestionAnswer) throws PortalException {

        // Make user.
        createUser(
                firstName,
                lastName,
                emailAddress,
                username,
                male,
                birthMonth,
                birthDay,
                birthYear,
                password,
                confirmPassword,
                securityQuestion,
                securityQuestionAnswer);

        createAddress(
                address,
                address2,
                city,
                state,
                zip);

        createPhone(homePhone);
        createPhone(mobilePhone);

    }

    private void createUser(
            String firstName,
            String lastName,
            String emailAddress,
            String username,
            boolean male,
            int birthMonth,
            int birthDay,
            int birthYear,
            String password,
            String confirmPassword,
            String securityQuestion,
            String securityQuestionAnswer)
            throws PortalException {

        Locale locale = Locale.US;

        long creatorUserId = 0;
        long companyId = 0;
        boolean autoPassword = false;
        boolean autoScreenName = false;
        long facebookId = 0;
        String openId = StringPool.BLANK;
        String middleName = StringPool.BLANK;
        long prefixId = 0;
        long suffixId = 0;
        String jobTitle = StringPool.BLANK;

        Group guestGroup = groupLocalService.getGroup(
                companyId, GroupConstants.GUEST);

        long[] groupIds = {guestGroup.getGroupId()};

        long[] organizationIds = null;

        Role userRole = roleLocalService.getRole(
                companyId, RoleConstants.USER);

        long[] roleIds = {userRole.getRoleId()};

        long[] userGroupIds = null;
        boolean sendEmail = false;
        ServiceContext serviceContext = new ServiceContext();

        User user = userLocalService.addUser(
                creatorUserId,
                companyId,
                autoPassword,
                password,
                confirmPassword,
                autoScreenName,
                username,
                emailAddress,
                facebookId,
                openId,
                locale,
                firstName,
                middleName,
                lastName,
                prefixId,
                suffixId,
                male,
                birthMonth,
                birthDay,
                birthYear,
                jobTitle,
                groupIds,
                organizationIds,
                roleIds,
                userGroupIds,
                sendEmail,
                serviceContext);

        user.setReminderQueryQuestion(securityQuestion);
        user.setReminderQueryAnswer(securityQuestionAnswer);

        this.user = user;

    }

    private void createAddress(
            String street1,
            String street2,
            String city,
            String state,
            String zip) {

        long addressId = counterLocalService.increment(Address.class.getName());
        Address address = addressLocalService.createAddress(addressId);

        address.setUserId(this.user.getUserId());

        address.setStreet1(street1);
        address.setStreet2(street2);
        address.setCity(city);
        address.setZip(zip);
        address.setCountryId(19);

        // RegionService only provides a way to get all regions in a specific country code. The user is restricted
        // to the US so use the US country code and compare the state name to the names of the regions until a match
        // is found.
        // This will also be a form of validation, if the state name is not found in the region then we know that the
        // state name is invalid.
        List<Region> regions = regionService.getRegions(19);
        for (Region region : regions) {
            if (region.getName() == state) {
                address.setRegionId(region.getRegionId());
                break;
            }
        }

        address.persist();

        this.address = address;
    }

    private void createPhone(String phoneNumber) {

        long phoneId = counterLocalService.increment(Phone.class.getName());
        Phone phone = phoneLocalService.createPhone(phoneId);

        phone.setUserId(this.user.getUserId());
        phone.setNumber(phoneNumber);
    }

    @ServiceReference(type = PhoneService.class)
    protected PhoneService phoneService;

    @ServiceReference(type = RegionService.class)
    protected RegionService regionService;
}
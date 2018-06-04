package com.liferay.training.amf.registration.web.portlet.command;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.training.amf.registration.service.RegistrationLocalService;
import com.liferay.training.amf.registration.web.constants.AmfRegistrationWebPortletKeys;
import com.liferay.training.amf.registration.web.portlet.AmfRegistrationWebUtil;
import org.apache.commons.lang3.StringUtils;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

@Component(immediate = true, property = {
        "javax.portlet.name=" + AmfRegistrationWebPortletKeys.AmfRegistrationWeb,
        "mvc.command.name=/signup/send"},
        service = MVCActionCommand.class)

public class AddRegistrationMVCActionCommand extends BaseMVCActionCommand {

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    protected RegistrationLocalService _registrationLocalService;

    @Reference(cardinality = ReferenceCardinality.MANDATORY)
    protected UserLocalService _userLocalService;

    private static boolean lessThanEqual(String s, Integer i) {
        return s.length() <= i;
    }

    private static boolean greaterThanEqual(String s, Integer i) {
        return s.length() >= i;
    }

    private static boolean isAlpha(String s) {
        return StringUtils.isAlpha(s);
    }

    private static boolean isAlphanumeric(String s) {
        return StringUtils.isAlphanumeric(s);
    }

    private static boolean containsUppercase(String s) {
        boolean flag = false;
        for (Character c : s.toCharArray()) {
            flag = StringUtils.isAllUpperCase(c.toString());
        }
        return flag;
    }

    private static boolean containsNumber(String s) {
        for (Character c : s.toCharArray()) {
            if (isNumeric(c.toString())) {
                return true;
            }
        }
        return false;
    }

    static private boolean equals(String s1, String s2) {
        return StringUtils.equals(s1, s2);
    }

    static private boolean lengthIs(String s, Integer i) {
        return s.length() == i;
    }

    static private String removeNonNumbers(String s) {
        StringBuilder string = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (isNumeric(c.toString())) {
                string.append(c.toString());
            }
        }
        return string.toString();
    }

    private static boolean isNameValid(String s) {
        return isAlphanumeric(s) && (lessThanEqual(s, 50));
    }

    private static boolean isEmailValid(String s) {
        return (isAlphanumeric(s.replace("@", "").replace(".", "")) || isAlpha(s)) && lessThanEqual(s, 50);
    }

    private static boolean isUsernameValid(String s) {
        return isAlphanumeric(s) && lessThanEqual(s, 16) && greaterThanEqual(s, 4);
    }

    private boolean isUsernameUnique(String s) {
        return _registrationLocalService.usernameIsUnique(s);
    }

    static public boolean isBirthdayValid(Integer day, Integer month, Integer year) {

        // This needs to be changed to check for the actual day, not just a dummy value.

        return day <= 1 && month <= 6 && year <= 2005;
    }

    private static boolean isPasswordValid(String s) {
        return greaterThanEqual(s, 6) && containsNumber(s) && containsUppercase(s);
    }

    private static boolean doPasswordsMatch(String p1, String p2) {
        return equals(p1, p2);
    }

    //
    private static boolean isPhoneValid(String p) {
        return lengthIs(removeNonNumbers(p), 10) || p.isEmpty();
    }

    private static boolean isAddressValid(String s) {
        return isAlphanumeric(s) && lessThanEqual(s, 225);
    }

    private static boolean isCityValid(String s) {
        return isAlphanumeric(s) && lessThanEqual(s, 225);
    }

    private static boolean isStateValid(String s) {
        return isStateInLiferay(s);
    }

    private static boolean isStateInLiferay(String s) {
        return true;
    }

    private static boolean isTermsOfUseValid(String s) {
        return s.contains("y");
    }

    private static boolean isNumeric(String s) {
        return StringUtils.isNumeric(s);
    }

    private static boolean isZipValid(String s) {
        return lengthIs(s, 5) && isNumeric(s);
    }

    private static boolean isSecurityAnswerValid(String s) {
        return isAlphanumeric(s) && lessThanEqual(s, 225);
    }

    private void replaceError(String key, String value) {
        errors.replace(key, value);
    }

    private void validateAndSetErrors() {

        errors = AmfRegistrationWebUtil.setInitialErrors();

        if (!isNameValid(firstName)) {
            replaceError("firstName", "Error! Your input must be alphanumeric and under 50 characters.");
            errorFlag = true;
        }
        if (!isNameValid(lastName)) {
            replaceError("lastName", "Error! Your input must be alphanumeric and under 50 characters.");
            errorFlag = true;
        }
        if (!isEmailValid(emailAddress)) {
            replaceError("emailAddress", "Error! Your input must be alphanumeric and under 225 characters.");
            errorFlag = true;
        }
        if (!isUsernameValid(username)) {
            replaceError("username", "Error! Your input must be alphanumeric and over 4 and under 16 characters.");
            errorFlag = true;
        }
        if (!isUsernameUnique(username)) {
            replaceError("usernameUnique", "Error! Your input must be unique.");
            errorFlag = true;
        }


        if (!isPasswordValid(password)) {
            replaceError(
                    "password", "Error! Your input must contain at least one uppercase, " +
                            "one number, and one special character.");
            errorFlag = true;
        }
        if (!doPasswordsMatch(password, confirmPassword)) {
            replaceError("passwordMatch", "Error! Passwords must match.");
            errorFlag = true;
        }

        if (!isBirthdayValid(birthDay, birthMonth, birthYear)) {
            replaceError("overThirteen", "You are too young. Please come back later.");
            errorFlag = true;
        }


        if (!isPhoneValid(homePhone)) {
            replaceError("homePhone", "Error! Your input must be 9 numbers.");
            errorFlag = true;
        }
        if (!isPhoneValid(mobilePhone)) {
            replaceError("mobilePhone", "Error! Your input must be 9 numbers.");
            errorFlag = true;
        }
        if (!isAddressValid(address)) {
            replaceError("address1", "Error! Your input must be alphanumeric and under 225 characters.");
            errorFlag = true;
        }
        if (!((!isAddressValid(address2)) || address2.contentEquals(""))) {
            replaceError("address2", "Error! Your input must be alphanumeric and under 225 characters.");
            errorFlag = true;
        }
        if (!isCityValid(city)) {
            replaceError("city", "Error! Your input must be alphanumeric and under 225 characters.");
            errorFlag = true;
        }
        if (!isStateValid(state)) {
            replaceError("state", "Error! Your input must be a state in the US.");
            errorFlag = true;
        }
        if (!isZipValid(zip)) {
            replaceError("zip", "Error! Your input must be a 5 digit number.");
            errorFlag = true;
        }

        if (!isSecurityAnswerValid(securityQuestionAnswer)) {
            replaceError("securityQuestionAnswer", "Error! Your input must be alphanumeric and under 225 characters.");
            errorFlag = true;
        }

        if (!isTermsOfUseValid(termsOfUse)) {
            replaceError("termsOfUse", "Error! You must accept the terms of service to register.");
            errorFlag = true;
        }

    }

//    String errorStart = "Error! Your input must: ";
//    String errorAlphaNumeric = "be alphanumeric ";
//    String errorMaxCharacters = "be under"

    boolean errorFlag = false;
    Map<String, String> errors;

    String firstName;
    String lastName;
    String emailAddress;
    String username;

    String gender;

    Integer birthMonth;
    Integer birthDay;
    Integer birthYear;

    String password;
    String confirmPassword;

    String homePhone;
    String mobilePhone;

    String address;
    String address2;
    String city;
    String state;
    String zip;

    String securityQuestion;
    String securityQuestionAnswer;

    String termsOfUse;

    @Override
    protected void doProcessAction(ActionRequest request, ActionResponse response) throws IOException {

        // Extract data from actionRequest and call _registrationLocalService with data. Then call sendRedirect()

        firstName = ParamUtil.getString(request, "firstName");
        lastName = ParamUtil.getString(request, "lastName");
        emailAddress = ParamUtil.getString(request, "emailAddress");
        username = ParamUtil.getString(request, "username");

        gender = ParamUtil.getString(request, "gender");

        birthMonth = ParamUtil.getInteger(request, "month");
        birthDay = ParamUtil.getInteger(request, "day");
        birthYear = ParamUtil.getInteger(request, "year");

        password = ParamUtil.getString(request, "password");
        confirmPassword = ParamUtil.getString(request, "confirmPassword");

        homePhone = ParamUtil.getString(request, "homePhone");
        mobilePhone = ParamUtil.getString(request, "mobilePhone");

        address = ParamUtil.getString(request, "address1");
        address2 = ParamUtil.getString(request, "address2");
        city = ParamUtil.getString(request, "city");
        state = ParamUtil.getString(request, "state");
        zip = ParamUtil.getString(request, "zip");

        securityQuestion = ParamUtil.getString(request, "securityQuestion");
        securityQuestionAnswer = ParamUtil.getString(request, "securityQuestionAnswer");

        termsOfUse = ParamUtil.getString(request, "termsOfUse");


        validateAndSetErrors();


        boolean male = !gender.contains("f");

        try {
            _registrationLocalService.addRegistration(
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
                    homePhone,
                    mobilePhone,
                    address,
                    address2,
                    city,
                    state,
                    zip,
                    securityQuestion,
                    securityQuestionAnswer);
        } catch (PortalException e) {
            System.out.print("Uh oh");
        } finally {

            Iterator it = errors.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                request.setAttribute(pair.getKey().toString(), pair.getValue().toString());
                it.remove();
            }

            sendRedirect(request, response);
        }
    }

}

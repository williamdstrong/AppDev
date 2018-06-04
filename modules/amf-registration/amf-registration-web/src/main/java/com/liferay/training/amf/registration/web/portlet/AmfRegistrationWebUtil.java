package com.liferay.training.amf.registration.web.portlet;

import java.util.HashMap;
import java.util.Map;

public class AmfRegistrationWebUtil {

    public static Map<String, String> setInitialErrors() {
        Map<String, String> errors = new HashMap<>();

        errors.put("firstName", "");
        errors.put("lastName", "");
        errors.put("emailAddress", "");
        errors.put("username", "");
        errors.put("usernameUnique", "");
        errors.put("password", "");
        errors.put("passwordMatch", "");
        errors.put("homePhone", "");
        errors.put("mobilePhone", "");
        errors.put("address1", "");
        errors.put("address2", "");
        errors.put("city", "");
        errors.put("state", "");
        errors.put("zip", "");
        errors.put("securityQuestionAnswer", "");
        errors.put("termsOfUse", "");
        errors.put("overThirteen", "");

        return errors;
    }
}


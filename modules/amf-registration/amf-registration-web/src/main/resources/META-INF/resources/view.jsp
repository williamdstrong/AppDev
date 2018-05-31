<%@ taglib prefix="liferay-ui" uri="http://liferay.com/tld/aui" %>
<%@ taglib prefix="aui" uri="http://liferay.com/tld/aui" %>
<%@ include file="/init.jsp" %>

    <liferay-ui:form name="form" action="${registrationActionURL}"
              onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() +
              "savePage();" %>' >
        <liferay-ui:field-wrapper>
            <liferay-ui:input name="firstName" label="First Name" type="text" />
            <liferay-ui:input name="lastName" label="Last Name" type="text" />
            <liferay-ui:input name="emailAddress" label="Email Address" type="mail" />
            <liferay-ui:input name="username" label="Username" type="text" />
            <liferay-ui:input name="password" label="Password" type="password" />
            <liferay-ui:input name="confirmPassword" label="Confirm Password" type="password" />
        </liferay-ui:field-wrapper>
        <liferay-ui:fieldset column="false" label="Gender">
            <liferay-ui:input name="gender" label="Female" type="radio" />
            <liferay-ui:input name="gender" label="Male" type="radio" />
        </liferay-ui:fieldset>
        <liferay-ui:fieldset label="Date of Birth">
            <liferay-ui:input name="month" label="Month" type="number" max="12" />
            <liferay-ui:input name="day" label="Day" type="number" max="31"/>
            <liferay-ui:input name="year" label="Year" type="number" />
        </liferay-ui:fieldset>
        <liferay-ui:input name="homePhone" label="Home Phone" type="text" />
        <liferay-ui:input name="mobilePhone" label="Mobile Phone" type="text" />
        <liferay-ui:input name="address1" label="Address Line 1" type="text" />
        <liferay-ui:input name="address2" label="Address Line 2" type="text" />
        <liferay-ui:input name="city" label="City" type="text" />
        <liferay-ui:input name="state" label="State" type="text" />
        <liferay-ui:input name="zip" label="Zip" type="text" />
        <liferay-ui:input name="securityQuestion" label="Security Question" type="text" />
        <liferay-ui:input name="securityAnswer" label="Security Answer" type="text" />
        <liferay-ui:fieldset label="Accept Terms of Use?">
            <liferay-ui:input name="termsOfUse" label="Yes" type="radio" />
            <liferay-ui:input name="termsOfUse" label="No" type="radio" />
        </liferay-ui:fieldset>
        <liferay-ui:button type="submit" value="submit" />
    </liferay-ui:form>


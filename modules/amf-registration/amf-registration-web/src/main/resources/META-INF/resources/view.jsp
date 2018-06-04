<%@ taglib prefix="portal" uri="http://java.sun.com/portlet" %>
<%@ include file="/init.jsp" %>

<portlet:actionURL name="/signup/send" var="addRegistrationURL" />
<portal:renderURL var="termsOfUseURL">
    <portlet:param name="mvcRenderCommandName" value="/terms" />
</portal:renderURL>

<c:if test="${userIsLoggedIn}">
    <p>You are logged in. No need to register.</p>
</c:if>
<c:if test="${!userIsLoggedIn}">
    <aui:form name="form" action="${addRegistrationURL}" method="post">
        <aui:fieldset-group markupView="lexicon">
            <aui:fieldset>
                <aui:input name="firstName" label="First Name" type="text" />
                <c:out value="${firstName}" />
                <aui:input name="lastName" label="Last Name" type="text" />
                <c:out value="${lastName}" />
                <aui:input name="emailAddress" label="Email Address" type="mail" />
                <c:out value="${emailAddress}" />
                <aui:input name="username" label="Username" type="text" />
                <c:out value="${username}" />
                <c:out value="${usernameUnique}" />
                <aui:input name="password" label="Password" type="password" />
                <c:out value="${password}" />
                <aui:input name="confirmPassword" label="Confirm Password" type="password" />
                <c:out value="${passwordMatch}" />
            </aui:fieldset>
            <aui:fieldset column="false" label="Gender">
                <aui:input name="gender" label="Female" type="radio" value="female" />
                <aui:input name="gender" label="Male" type="radio" value="male"/>
            </aui:fieldset>
            <aui:fieldset label="Date of Birth">
                <c:out value="${overThirteen}" />
                <aui:input name="month" label="Month" type="number" max="12" />
                <aui:input name="day" label="Day" type="number" max="31"/>
                <aui:input name="year" label="Year" type="number" />
            </aui:fieldset>
            <aui:input name="homePhone" label="Home Phone" type="text" />
            <c:out value="${homePhone}" />
            <aui:input name="mobilePhone" label="Mobile Phone" type="text" />
            <c:out value="${mobilePhone}" />
            <aui:input name="address1" label="Address Line 1" type="text" />
            <c:out value="${address1}" />
            <aui:input name="address2" label="Address Line 2" type="text" />
            <c:out value="${address2}" />
            <aui:input name="city" label="City" type="text" />
            <c:out value="${city}" />
            <aui:input name="state" label="State" type="text" />
            <c:out value="${state}" />
            <aui:input name="zip" label="Zip" type="text" />
            <c:out value="${zip}" />
            <aui:select name="securityQuestion" label="Security Question" type="text" >
                <aui:option label="What is your mothers maiden name?" />
                <aui:option label="What is the make of your first car?" />
            </aui:select>
            <aui:input name="securityAnswer" label="Security Answer" type="text" />
            <c:out value="${securityQuestionAnswer}" />
            <aui:fieldset label="I have read, understand, and agree with the Terms of Use governing my
access to and use of the Acme Movie Fanatics web site.">
                <c:out value="${termsOfUse}" />
                <a href="${termsOfUseURL}">Terms of Use</a>
                <aui:input name="termsOfUse" label="Yes" type="radio" value="yes" />
                <aui:input name="termsOfUse" label="No" type="radio" value="no" />
            </aui:fieldset>
            <aui:button type="submit" value="submit" />
        </aui:fieldset-group>
    </aui:form>
</c:if>

<%--
  ~ Copyright (c) 2000-present Liferay, Inc. All rights reserved.
  ~
  ~ This library is free software; you can redistribute it and/or modify it under
  ~ the terms of the GNU Lesser General Public License as published by the Free
  ~ Software Foundation; either version 2.1 of the License, or (at your option)
  ~ any later version.
  ~
  ~ This library is distributed in the hope that it will be useful, but WITHOUT
  ~ ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
  ~ FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
  ~ details.
  --%>

<%@ include file="/init.jsp" %>

<portlet:actionURL name="/submit" var="submitURL" />

<aui:form action="${submitURL}" method="post" name="form">
    <aui:input label="Zip Code" name="zip" type="text">
        <aui:validator name="number"/>
        <aui:validator name="maxLength">5</aui:validator>
        <aui:validator name="minLength">5</aui:validator>
    </aui:input>

    <aui:button label="submit" type="submit" value="submit"/>
</aui:form>
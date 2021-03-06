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

<liferay-ui:error key="noSearch" message="no-search"/>
<liferay-ui:error key="invalidZipNotANumber" message="invalid-zip-not-a-number"/>
<liferay-ui:error key="invalidZipNull" message="invalid-zip-null"/>
<liferay-ui:error key="invalidZipTooFewDigits" message="invalid-zip-too-few-digits"/>
<liferay-ui:error key="invalidZipNotANumber" message="invalid-zip-too-many-digits"/>
<liferay-ui:error key="noPermission" message="no-permission"/>

<p>Search Results for ${zip}.</p>

<liferay-ui:search-container searchContainer="${searchContainer}">

    <liferay-ui:search-container-row className="searchData">
        <liferay-ui:search-container-column-text name="first-name" property="firstName"/>
        <liferay-ui:search-container-column-text name="last-initial" property="lastInitial"/>
        <liferay-ui:search-container-column-text name="screen-name" property="screenName"/>
        <liferay-ui:search-container-column-text name="email-address" property="emailAddress"/>
    </liferay-ui:search-container-row>

    <liferay-ui:search-iterator markupView="lexicon"/>
</liferay-ui:search-container>
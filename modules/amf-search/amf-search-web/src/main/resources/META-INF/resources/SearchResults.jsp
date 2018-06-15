<%@ include file="/init.jsp" %>

<liferay-ui:error key="no-search" message="no-search" />
<liferay-ui:error key="invalid-zip-not-a-number" message="invalid-zip-not-a-number" />
<liferay-ui:error key="invalid-zip-null" message="invalid-zip-null" />
<liferay-ui:error key="invalid-zip-too-few-digits" message="invalid-zip-too-few-digits" />
<liferay-ui:error key="invalid-zip-not-a-number" message="invalid-zip-too-many-digits" />
<liferay-ui:error key="no-permission" message="no-permission"/>

<p>Search Results for ${zip}.</p>

<liferay-ui:search-container searchContainer="${searchContainer}">

    <liferay-ui:search-container-row className="searchData">
        <liferay-ui:search-container-column-text property="firstName" name="first-name" />
        <liferay-ui:search-container-column-text property="lastInitial" name="last-initial" />
        <liferay-ui:search-container-column-text property="screenName" name="screen-name" />
        <liferay-ui:search-container-column-text property="emailAddress" name="email-address" />
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator markupView="lexicon" />

</liferay-ui:search-container>

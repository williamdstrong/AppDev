<%@ include file="/init.jsp" %>

<p>Search Results for ${zip}.</p>

<liferay-ui:search-container searchContainer="${searchContainer}">

    <liferay-ui:search-container-row className="searchData">
        <liferay-ui:search-container-column-text property="firstName" name="First Name"/>
        <liferay-ui:search-container-column-text property="lastInitial" name="Last Initial" />
        <liferay-ui:search-container-column-text property="screenName" name="Screen Name" />
        <liferay-ui:search-container-column-text property="emailAddress" name="Email Address"/>
    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator markupView="lexicon" />

</liferay-ui:search-container>

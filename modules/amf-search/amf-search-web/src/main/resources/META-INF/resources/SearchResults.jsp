<%@ include file="/init.jsp" %>

<p>Search Results for ${zip}.</p>


<liferay-ui:search-container
        total="${results.getSize()}"
        var="searchContainer"
        delta="5"
        deltaConfigurable="true"
        emptyResultsMessage="There appear to be no users...">

    <p>${results.getSize()}</p>
    <liferay-ui:search-container-results
            results="${results.getFormattedData(zip, searchContainer.start, searchContainer.end)}" />

    <liferay-ui:search-container-row className="searchData">
        <liferay-ui:search-container-column-text property="firstName" name="First Name"/>
        <liferay-ui:search-container-column-text property="lastInitial" name="Last Initial" />
        <liferay-ui:search-container-column-text property="screenName" name="Screen Name" />
        <liferay-ui:search-container-column-text property="emailAddress" name="Email Address"/>

    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>

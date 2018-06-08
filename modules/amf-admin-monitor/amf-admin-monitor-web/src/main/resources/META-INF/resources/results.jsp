

<p>${eventType}</p>

<c:set var="results" value="${Util.getResults(eventType, groupId)}" />

<liferay-ui:search-container
        total="${results.size()}"
        var="searchContainer"
        delta="20"
        deltaConfigurable="true"
        emptyResultsMessage="There appear to be no users...">

    <liferay-ui:search-container-results
            results="${Util.subList(results, searchContainer.start, searchContainer.end)}" />

    <liferay-ui:search-container-row className="eventMonitor">
        <liferay-ui:search-container-column-text property="dateTime" />
        <liferay-ui:search-container-column-text property="username" />
        <liferay-ui:search-container-column-text property="userId" />
        <liferay-ui:search-container-column-text property="ipAddress" />
        <liferay-ui:search-container-column-text property="eventType" />

    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator markupView="lexicon" />
</liferay-ui:search-container>

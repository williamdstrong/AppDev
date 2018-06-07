

<liferay-ui:search-container total="${size}" var="searchContainer" delta="20" deltaConfigurable="true"
                             emptyResultsMessage="There appear to be no users...">

    <liferay-ui:search-container-results
            results="${results(eventType, searchContainer.start, searchContainer.end)}" />

    <liferay-ui:search-container-row className="eventMonitor">
        <liferay-ui:search-container-column-text property="date" />
        <liferay-ui:search-container-column-text property="username" />
        <liferay-ui:search-container-column-text property="userId" />
        <liferay-ui:search-container-column-text property="ip" />
        <liferay-ui:search-container-column-text property="eventType" />

    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator />
</liferay-ui:search-container>

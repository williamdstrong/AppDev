<%@ include file="/init.jsp" %>

<p>${zip}</p>

<c:set var="results" value="${util.getResults(eventType, groupId, userId)}" />

<liferay-ui:search-container
        total="${results.size()}"
        var="searchContainer"
        delta="5"
        deltaConfigurable="true"
        emptyResultsMessage="There appear to be no users...">

    <liferay-ui:search-container-results
            results="${util.subList(results, searchContainer.start, searchContainer.end)}" />

    <liferay-ui:search-container-row className="eventMonitor">
        <liferay-ui:search-container-column-text property="dateTime" name="Date and Time"/>
        <liferay-ui:search-container-column-text property="username" name="User" />
        <liferay-ui:search-container-column-text property="userId" name="User ID"/>
        <liferay-ui:search-container-column-text property="ipAddress" name="IP Address"/>
        <liferay-ui:search-container-column-text property="eventType" name="Event Type"/>

    </liferay-ui:search-container-row>
    <liferay-ui:search-iterator markupview="lexicon" />
</liferay-ui:search-container>

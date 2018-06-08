<%@ include file="/init.jsp" %>

<liferay-ui:tabs names='All,Registration,Login' param="tabs3" refresh="false" type="tabs nav-tabs-default">

    <liferay-ui:section>
        <c:set var="eventType" value="all" />
        <%@ include file="results.jsp"%>
    </liferay-ui:section>
    <liferay-ui:section>
        <c:set var="eventType" value="create" />
        <%@ include file="results.jsp"%>
    </liferay-ui:section>
    <liferay-ui:section>
        <c:set var="eventType" value="login" />
        <%@ include file="results.jsp"%>
    </liferay-ui:section>

</liferay-ui:tabs>


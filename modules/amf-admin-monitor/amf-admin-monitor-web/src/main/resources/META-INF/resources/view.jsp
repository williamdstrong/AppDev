<%@ include file="/init.jsp" %>

<liferay-portlet:renderURL var="portletURL">
    <liferay-portlet:param name="tabs" value="${tabs}"/>
</liferay-portlet:renderURL>

<liferay-ui:tabs
        names="all,registration,login" param="tabs" refresh="true" type="tabs nav-tabs-default" url="${portletURL}">

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


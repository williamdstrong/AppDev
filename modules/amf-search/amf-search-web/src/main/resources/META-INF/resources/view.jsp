<%@ include file="/init.jsp" %>

<portlet:actionURL name="/submit" var="submitURL" />

<liferay-ui:form name="form" action="${submitURL}" method="post">
    <liferay-ui:input name="zip" type="text" label="Zip Code" />
    <liferay-ui:button type="submit" value="submit" />
</liferay-ui:form>

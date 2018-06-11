<%@ include file="/init.jsp" %>

<portlet:actionURL name="/submit" var="submitURL" />

<aui:form name="form" action="${submitURL}" method="post">
    <aui:input name="zip" type="text" label="Zip Code" />
    <aui:button type="submit" value="submit" />
</aui:form>

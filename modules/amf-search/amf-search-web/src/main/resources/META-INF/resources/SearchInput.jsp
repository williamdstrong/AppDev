<%@ include file="/init.jsp" %>

<portlet:actionURL name="/submit" var="submitURL" />

<aui:form name="form" action="${submitURL}" method="post">
    <aui:input name="zip" type="text" label="Zip Code" >
        <aui:validator name="number" />
        <aui:validator name="maxLength" >5</aui:validator>
        <aui:validator name="minLength" >5</aui:validator>
    </aui:input>
    <aui:button type="submit" value="submit" />
</aui:form>

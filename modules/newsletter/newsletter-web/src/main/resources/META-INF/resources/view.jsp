<%@ include file="/init.jsp" %>

<%--
  ~ Copyright (c) 2000-present Liferay, Inc. All rights reserved.
  ~
  ~ This library is free software; you can redistribute it and/or modify it under
  ~ the terms of the GNU Lesser General Public License as published by the Free
  ~ Software Foundation; either version 2.1 of the License, or (at your option)
  ~ any later version.
  ~
  ~ This library is distributed in the hope that it will be useful, but WITHOUT
  ~ ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
  ~ FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
  ~ details.
--%>



<c:forEach items="${allNewsletterIssues}" var="yearOfIssues">
    <liferay-ui:message key="${yearOfIssues.getFirst().getFirst().getDate().getYear()}" /><br/>
    <c:forEach items="${yearOfIssues}" var="monthOfIssues">
        <liferay-ui:message key="${monthOfIssues.getFirst().getDate().getMonth().toString().toLowerCase()}" /><br/>
        <c:forEach items="${monthOfIssues}" var="issue">
            <b>${issue.title}</b><br/>
            <p>${issue.description}</p><br/>
            <c:forEach items="${issue.articles}" var="article">
                <c:set var="articleId" value="${article.id}" />
                <portlet:renderURL var="articleURL" copyCurrentRenderParameters="true">
                    <portlet:param name="mvcRenderCommandName" value="article" />
                </portlet:renderURL>
                <a href="${articleURL}">
                    <liferay-ui:message key="${article.title}" />
                <a/>
            </c:forEach>
        </c:forEach>
    </c:forEach>
</c:forEach>
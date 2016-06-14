<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Removed successfully</title>
</head>
<body>
<jsp:include flush="false" page="start.jsp"/>


<div class="span-12 last">
    <form:form method="post"
               action="${pageContext.request.contextPath}/deleteEmployee"
               commandName="deleteEmployee">
        <fieldset>
            <legend>Removed successfully</legend>

            <h3>Removed successfully</h3>
        </fieldset>
    </form:form>
</div>
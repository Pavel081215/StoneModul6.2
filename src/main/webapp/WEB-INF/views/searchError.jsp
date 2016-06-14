<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search Error</title>
</head>
<body>
<jsp:include flush="false" page="start.jsp"/>

<h3>Search Employee</h3>
<div class="span-12 last">
    <form:form method="post"
               action="${pageContext.request.contextPath}/searchError"
               commandName="Error">
        <fieldset>
            <legend>Error Employee</legend>
            <legend>Search Error</legend>
            <p> Employee is absent </p>
        </fieldset>
    </form:form>
</div>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search Employer</title>
</head>
<body>
<jsp:include flush="false" page="start.jsp"/>

<h3>Search Employee</h3>
<div class="span-12 last">
    <form:form method="post"
               action="${pageContext.request.contextPath}/searchEmployee"
               commandName="Employee">
        <fieldset>
            <legend>Search Employee</legend>
            <p>Enter name of the employee who look:    <input type="logout" name="name"></p>
            <p>
                <input type="submit" />
            </p>
        </fieldset>
    </form:form>
</div>




</body>
</html>

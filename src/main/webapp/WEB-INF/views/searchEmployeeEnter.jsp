<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search Employee</title>
</head>
<body>
<jsp:include flush="false" page="start.jsp"/>

<h3>Search Employee</h3>

<form:form method="post"
           action="${pageContext.request.contextPath}/searchEmployee"
           commandName="Employee">
    <fieldset>
        <legend>Search Employee</legend>
        <td>  ID  <c:out  value="${Employee.id}"/></td> <br>
        <th>&nbsp;</th>
        <td> Name  <c:out value="${Employee.name}"/></td> <br>
        <th>&nbsp;</th>
        <td> Surname <c:out value="${Employee.surname}"/></td> <br>
        <th>&nbsp;</th>
        <td> BirthDay <c:out value="${Employee.birthDay}"/></td> <br>
        <th>&nbsp;</th>
        <td> Phone <c:out value="${Employee.phone}"/></td> <br>
        <th>&nbsp;</th>
        <td> Position  <c:out value="${Employee.position}"/></td> <br>
        <th>&nbsp;</th>
        <td> Salary  <c:out value="${Employee.salary}"/></td> <br>
    </fieldset>
</form:form>

</body>
</html>

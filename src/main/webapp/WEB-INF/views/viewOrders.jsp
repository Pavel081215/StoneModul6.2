<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>List Employee</title>
</head>
<body>
<jsp:include flush="false" page="start.jsp"/>

<h3>View Orders</h3>

<form:form method="post"
           action="${pageContext.request.contextPath}/viewOrders"
           commandName="Orders">
</form:form>


<c:if test="${!empty listOrders }">
<fieldset>
    <table class="data">

        <legend>Search Employee</legend>
        <c:forEach items="${listOrders}" var="Order">
            <tr>
                <td> ID ${Order.id}</td>
                <th>&nbsp;</th>
                <td> Name - ${Order.dish_1}</td>
                <th>&#10;</th>
                <th>&nbsp;</th>
                <td> Surname - ${Order.dish_2}</td>
                <th>&nbsp;</th>
                <td> BirthDay - ${Order.dish_3}</td>
                <th>&nbsp;</th>
                <td> Phone - ${Order.table_number}</td>
                <th>&nbsp;</th>
                <td> Position - ${Order.waiter}</td>
                <th>&nbsp;</th>
                <td> Salary - ${Order.time}</td>
                <th>&#10;</th>
            </tr>
        </c:forEach>

    </table>
    <fieldset>
        </c:if>

</body>
</html>
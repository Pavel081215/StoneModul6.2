<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf8">
    <title><spring:message code="label.title" /></title>
</head>
<body>



<h2><spring:message code="label.title" /></h2>

<form:form method="post" action="add" commandName="contact">

    <table>
        <tr>
            <td><form:label path="surname">
                <spring:message code="label.surname" />
            </form:label></td>
            <td><form:input path="surname" /></td>
        </tr>

        <tr>
            <td><form:label path="name">
                <spring:message code="label.name" />
            </form:label></td>
            <td><form:input path="name" /></td>
        </tr>

        <tr>
            <td><form:label path="birthDay">
                <spring:message code="label.birthDay" />
            </form:label></td>
            <td><form:input path="birthDay" /></td>
        </tr>

        <tr>
            <td><form:label path="phone">
                <spring:message code="label.phone" />
            </form:label></td>
            <td><form:input path="phone" /></td>
        </tr>


        <tr>
            <td><form:label path="position">
                <spring:message code="label.position" />
            </form:label></td>
            <td><form:input path="position" /></td>
        </tr>


        <tr>
            <td><form:label path="salary">
                <spring:message code="label.salary" />
            </form:label></td>
            <td><form:input path="salary" /></td>
        </tr>






        <tr>
            <td colspan="2"><input type="submit"
                                   value="<spring:message code="label.addemployee"/>" /></td>
        </tr>
    </table>
</form:form>

<h3><spring:message code="label.employee" /></h3>
<c:if test="${!empty contactList}">
    <table class="data">
        <tr>
            <th><spring:message code="label.firstname" /></th>
            <th><spring:message code="label.email" /></th>
            <th><spring:message code="label.telephone" /></th>
            <th>&nbsp;</th>
        </tr>
        <c:forEach items="${contactList}" var="contact">
            <tr>
                <td>${contact.lastname}, ${contact.firstname}</td>
                <td>${contact.email}</td>
                <td>${contact.telephone}</td>
                <td><a href="delete/${contact.id}"><spring:message code="label.delete" /></a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
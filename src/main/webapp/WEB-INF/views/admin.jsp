<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>
    Hello 333333 world!
</h1>
<a href="<c:url value="/admin"  />">

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
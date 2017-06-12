<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="<c:url value="/css/table-style.css"/>" rel="stylesheet">
</head>
<body>
<table>
    <c:forEach items="${usersModel}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.age}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
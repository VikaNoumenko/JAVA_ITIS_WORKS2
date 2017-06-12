<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
</head>
<body>
<table>
    <c:forEach items="${requestScope.autos}" var="auto">
        <tr>
            <td><c:out value="${auto.id}"/></td>
            <td><c:out value="${auto.model}"/></td>
            <td><c:out value="${auto.color}"/></td>
            <td><c:out value="${auto.carMileage}"/></td>
            <td><c:out value="${auto.isUsed}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

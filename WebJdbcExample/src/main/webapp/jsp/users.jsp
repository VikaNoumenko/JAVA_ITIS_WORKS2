<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ru.itis.models.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <% ArrayList<User> userList = (ArrayList<User>) request.getAttribute("users"); %>
    <% for (User user : userList) { %>
    <tr>
        <td><%=user.getId()%>
        </td>
        <td><%=user.getName()%>
        </td>
        <td><%=user.getAge()%>
        </td>
    </tr>
    <%}%>
</table>
<hr>
<table>
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <td><c:out value="${user.id}"/></td>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.age}"/></td>
        </tr>
    </c:forEach>
</table>
<form action="users" method="post">
    <input type="text" name="name"/>
    <br>
    <input type="text" name="login"/>
    <br>
    <input type="password" name="password"/>
    <br>
    <input type="text" name="age"/>
    <br>
    <input type="submit"/>
</form>
</body>
</html>

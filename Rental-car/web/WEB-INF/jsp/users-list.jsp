<%--
  Created by IntelliJ IDEA.
  User: acer pc
  Date: 07.04.2019
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>

        <c:forEach var="user" items="${requestScope.users}">
            <a href="${pageContext.request.contextPath}/show-user-details?id=${user.id}">${user.username}</a><br>
        </c:forEach>

</div>
</body>
</html>

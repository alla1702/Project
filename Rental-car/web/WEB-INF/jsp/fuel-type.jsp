<%--
  Created by IntelliJ IDEA.
  User: acer pc
  Date: 02.04.2019
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
<body>
  <div>
    <c:forEach items="${requestScope.fuelTypes}" var="fuelType">
        <p>${fuelType.name}</p>
    </c:forEach>
  </div>
</body>
</html>
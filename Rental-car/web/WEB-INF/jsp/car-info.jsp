<%--
  Created by IntelliJ IDEA.
  User: acer pc
  Date: 04.04.2019
  Time: 15:32
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
    Модель автомобиля: <span>${requestScope.car.modelCarName}</span><br>
    Тип топлива: <span>${requestScope.car.fuelTypeName}</span><br>
    Стоимость проката автомобиля за сутки, в бел. руб.: <span>${requestScope.car.rentalPrice}</span><br>
    Год выпуска автомобиля: <span>${requestScope.car.year}</span><br>
    Описание: <span>${requestScope.car.description}</span><br>
</div>
</body>
</html>

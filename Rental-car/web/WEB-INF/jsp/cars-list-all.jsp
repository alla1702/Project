<%--
  Created by IntelliJ IDEA.
  User: acer pc
  Date: 06.04.2019
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<div class="form-check"><br>
<c:forEach items="${requestScope.cars}" var="car">
    <p style="text-indent:10px"><input class="form-check-input" type="radio" name="car" id="exampleRadios1" value="${pageContext.request.contextPath}${car.id}" checked>
    <label class="form-check-label" for="exampleRadios1">
        <i><b>${car.modelCarName}</b></i>  ${car.description}.  Вид топлива: ${car.fuelTypeName}. Год выпуска автомобиля: ${car.year}<br>
            Стоимость проката за сутки в бел. руб: ${car.rentalPrice}<br><br>
      </label></p>
</c:forEach>
</div>
<p style="text-indent:20px"><input class="btn btn-success" type="submit" value="Заказ"></p>
</body>
</html>

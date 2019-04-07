<%--
  Created by IntelliJ IDEA.
  User: acer pc
  Date: 04.04.2019
  Time: 13:26
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
<form action="${pageContext.request.contextPath}/save-car" method="post">
    <div class="form-group"><br><p style="text-indent:10px">Модель автомобиля:</p>
        <p style="text-indent:10px"><select class="form-control" name="modelCar" id="modelCar">
            <c:forEach var="modelCar" items="${requestScope.modelCars}">
                <option value="${modelCar.id}">${modelCar.name}</option>
            </c:forEach>
        </select></p>
    </div>
    <br>
    <div class="form-group"><p style="text-indent:10px">Вид топлива:</p>
        <p style="text-indent:10px"><select class="form-control" name="fuelType" id="fuelType">
            <c:forEach var="fuelType" items="${requestScope.fuelTypes}">
                <option value="${fuelType.id}">${fuelType.name}</option>
            </c:forEach>
        </select></p>
    </div><br>
    <div class="form-group">
        <label for="rentalPrice"><p style="text-indent:10px">Стоимость проката автомобиля за сутки, в бел. руб.</p>
            <input class="form-control" id="rentalPrice" type="number" name="rentalPrice"/>
        </label><br>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="year" id="inlineRadio1" value="YEAR2000">
        <label class="form-check-label" for="inlineRadio1">2000</label>
    </div>
    <div class="form-check form-check-inline">
        <input class="form-check-input" type="radio" name="year" id="inlineRadio2" value="YEAR2001">
        <label class="form-check-label" for="inlineRadio2">2001</label>
    </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio3" value="YEAR2003">
            <label class="form-check-label" for="inlineRadio3">2003</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio4" value="YEAR2004">
            <label class="form-check-label" for="inlineRadio4">2004</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio5" value="YEAR2005">
            <label class="form-check-label" for="inlineRadio5">2005</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio6" value="YEAR2006">
            <label class="form-check-label" for="inlineRadio6">2006</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio7" value="YEAR2007">
            <label class="form-check-label" for="inlineRadio7">2007</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio8" value="YEAR2008">
            <label class="form-check-label" for="inlineRadio8">2008</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio9" value="YEAR2009">
            <label class="form-check-label" for="inlineRadio9">2009</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio10" value="YEAR2010">
            <label class="form-check-label" for="inlineRadio10">2010</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio11" value="YEAR2011">
            <label class="form-check-label" for="inlineRadio11">2011</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio12" value="YEAR2012">
            <label class="form-check-label" for="inlineRadio12">2012</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio13" value="YEAR2013">
            <label class="form-check-label" for="inlineRadio13">2013</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio14" value="YEAR2014">
            <label class="form-check-label" for="inlineRadio14">2014</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio15" value="YEAR2015">
            <label class="form-check-label" for="inlineRadio15">2015</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio16" value="YEAR2016">
            <label class="form-check-label" for="inlineRadio16">2016</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio17" value="YEAR2017">
            <label class="form-check-label" for="inlineRadio17">2017</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio18" value="YEAR2018">
            <label class="form-check-label" for="inlineRadio18">2018</label>
        </div>
        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="year" id="inlineRadio19" value="YEAR2019">
            <label class="form-check-label" for="inlineRadio19">2019</label>
        </div><br><br><br>
    <div class="form-group">
        <label for="description"><p style="text-indent:10px">Описание</p>
            <input size="100px" class="form-control" id="description" type="text" name="description"/>
        </label><br>
    </div>
        <p style="text-indent:10px"><input class="btn btn-success" type="submit" value="Сохранить"></p>
</form>
</body>
</html>

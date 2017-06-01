<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<div class="jumbotron">
  <h1>Car Rental.com</h1>
  <p>Добро пожаловать на сайт аренды автомобилей. Приятной поездки!</p>
  <form action="do?command=home" method="GET">
  <p><a name="findcars" class="btn btn-primary btn-lg" href="do?command=cars" role="button">Выбрать машину</a></p>
  </form>
</div>
<%@ include file="include/end-html.jsp" %>



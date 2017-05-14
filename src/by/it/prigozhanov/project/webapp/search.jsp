<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<h2>${message}</h2>
<div class="row">
<c:forEach items="${cars}" var="car">

  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <div class="caption">
        <h2>${car.mark} ${car.model}</h2>
        <h4>${car.price}$ за день</h4>
        <p>${car.hp} HP</p>
        <p><a href="#" class="btn btn-success" role="button">Rent car</a></p>
        <p>Месторасположение: ${car.location} <span class="glyphicon glyphicon-globe" aria-hidden="true"></span></p>
        <p>Объем багажника: ${car.luggageCapacity}  <span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span></p>
        <p>Колличество мест для пассажиров: ${car.seats}  <span class="glyphicon glyphicon-user" aria-hidden="true"></span></p>
        <p>Средний расход: ${car.fuelConsumption} литров/100км  <span class="glyphicon glyphicon-filter" aria-hidden="true"></span></p>
      </div>
    </div>
  </div>

</c:forEach>
</div>



<%@ include file="include/end-html.jsp" %>



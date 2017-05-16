<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<div class="row">
<div class=col-md-5>
<legend>Арендуемый автомобиль</legend>
 <h2>${car.mark} ${car.model}</h2>
        <h4>${car.price}$ за день</h4>
        <p>${car.hp} HP</p>
        <p>Месторасположение: ${car.location}  <span class="glyphicon glyphicon-globe" aria-hidden="true"></span></p>
        <p>Объем багажника: ${car.luggageCapacity} <span class="glyphicon glyphicon-briefcase" aria-hidden="true"></span></p>
        <p>Колличество мест для пассажиров: ${car.seats}  <span class="glyphicon glyphicon-user" aria-hidden="true"></span></p>
        <p>Средний расход: ${car.fuelConsumption} литров/100км  <span class="glyphicon glyphicon-filter" aria-hidden="true"></span></p>
 </div>
 <div class=col-md-7>
<form class="form-horizontal" action="do?command=rentcar" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Форма для заполнения</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="">Телефон для связи</label>
  <div class="col-md-4">
  <input id="telephone" name="telephone" type="text" placeholder="example +375293333333" class="form-control input-md" required="" pattern="\+[0-9]{12}">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Паспортные данные</label>
  <div class="col-md-4">
  <input id="passportdata" value="${user.passportData}" name="passportdata" type="text" placeholder="example: MP2931234" class="form-control input-md" required="" pattern="[A-Z]{2,}[0-9]{7,}">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Срок аренды</label>
  <div class="col-md-4">
  <input id="duration" name="duration" type="text" placeholder="max 30 days" class="form-control input-md" required="" pattern="[0-9]{1,2}">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="">Номер карты</label>
  <div class="col-md-4">
  <input id="cardnumber" name="cardnumber" type="text" placeholder="XXXX-XXXX-XXXX-XXXX" class="form-control input-md" required="" pattern="(([A-Za-z0-9]{4})-){3}[A-Za-z0-9]{4}">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="" name="" class="btn btn-success">Арендовать</button>
  </div>
</div>

</fieldset>
</form>
</div>
<div class="row">

<%@ include file="include/end-html.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=CreateAd" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Создание объявления</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="description">Описание</label>
  <div class="col-md-4">
  <input id="description" name="description" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="address">Адрес</label>
  <div class="col-md-4">
  <input id="address" name="address" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="area">Площадь</label>
  <div class="col-md-4">
  <input id="area" name="area" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="floor">Этаж</label>
  <div class="col-md-4">
  <input id="floor" name="floor" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="floors">Этажей</label>
  <div class="col-md-4">
  <input id="floors" name="floors" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="rooms">Комнат</label>
  <div class="col-md-4">
  <input id="rooms" name="rooms" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Стоимость</label>
  <div class="col-md-4">
  <input id="price" name="price" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="price"></label>
  <div class="col-md-4">
    <button id="" name="" class="btn btn-primary">Добавить</button>
  </div>
</div>

</fieldset>
</form>

<p>INDEX: ${message}</p>

<%@ include file="include/end-html.jsp" %>
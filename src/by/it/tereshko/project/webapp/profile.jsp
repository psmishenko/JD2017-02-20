<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="page-header">
  <h1>Данные профиля</h1>
  <div class="row">
    <div class="col-md-1">Ваш логин: ${user.login}</div>
    <div class="col-md-1">Ваш Email: ${user.email}</div>
  </div>
</div>

<h1>Ваши объявления</h1>

<div class="row">
  <div class="col-md-1">Цена</div>
  <div class="col-md-3">Адрес</div>
  <div class="col-md-4">Описание</div>
  <div class="col-md-1">Число комнат</div>
  <div class="col-md-1">Площадь</div>
  <div class="col-md-1">Этаж</div>
  <div class="col-md-1">Этажность</div>
</div>

<c:forEach items="${ads}" var="ad">
  <br><div class="row">
  <div class="col-md-1">${ad.price} </div>
  <div class="col-md-3">${ad.address}</div>
  <div class="col-md-4">${ad.description}</div>
  <div class="col-md-1">${ad.roomCount}</div>
  <div class="col-md-1">${ad.area}</div>
  <div class="col-md-1">${ad.floor}</div>
  <div class="col-md-1">${ad.floors}</div>
</div>
</c:forEach>
<br><br>
<t:paginator count="${adCount}" step="5" urlprefix="?command=Profile&start="/>
<br>

<form class="form-horizontal" action="do?command=profile" method="POST">
<fieldset>
<!-- Form Name -->
<legend>Выход</legend>
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-danger">Logout</button>
  </div>
</div>
</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
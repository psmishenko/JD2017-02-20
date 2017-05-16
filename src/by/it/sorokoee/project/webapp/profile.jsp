<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="page-header">
  <h1>Данные профиля</h1>
  <div class="row">
    <div class="col-md-1">Ваш логин: ${user.login}</div>
    <div class="col-md-1">Ваш Email: ${user.email}</div>
  </div>
</div>

<h1>Ваши товары</h1>
<div class="row">
  <div class="col-md-2">Модель авто</div>
      <div class="col-md-1">Год выпуска</div>
      <div class="col-md-2">Запчасть</div>
      <div class="col-md-2">Тип двигателя</div>
      <div class="col-md-1">Объем двигателя</div>
</div>
<c:forEach items="${goods}" var="good">
    <div class="row">
        <div class="col-md-2">${good.modelCar} </div>
        <div class="col-md-1">${good.yearOfIssue} </div>
        <div class="col-md-2">${good.spare} </div>
        <div class="col-md-2">${good.typeEngine} </div>
        <div class="col-md-1">${good.capacityEngine} </div>
</div>
</c:forEach>
<br><br>



<form class="form-horizontal"  action="do?command=profile" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Выход</legend>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-danger">Выйти</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
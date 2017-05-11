<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="do?command=addUser" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Добавление нового пользователя</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Имя пользователя</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="Имя пользователя" class="form-control input-md">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="login">Логин</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="Логин" class="form-control input-md">
  <span class="help-block">Английские буквы и цифры. Не менее 5 символов</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Пароль</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="Пароль" class="form-control input-md">
  <span class="help-block">Английские буквы и цифры. Не менее 8 символов</span>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="checkboxes">Роли</label>
  <div class="col-md-4">
  <c:forEach items="${roles}" var="role">
  <div class="checkbox">
    <label>
      <input type="checkbox" name="checkboxes-${role.id}" value="${role.id}">${role.name}</label>
	</div>
  </c:forEach>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Сохранить</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>



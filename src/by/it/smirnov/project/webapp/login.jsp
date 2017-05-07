<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=login" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Вход в систему</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Логин</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="Логин" class="form-control input-md">
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Пароль</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="Пароль" class="form-control input-md">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Вход</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
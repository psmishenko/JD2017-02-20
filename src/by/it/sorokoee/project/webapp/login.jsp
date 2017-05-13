<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal" action="do?command=login" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Вход</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Логин</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">минимум 5 символов</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Пароль</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="">
    <span class="help-block">минимум 8 символов</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submitbutton"></label>
  <div class="col-md-4">
    <button id="submitbutton" name="submitbutton" class="btn btn-primary">Войти</button>
  </div>
</div>

</fieldset>
</form>

<p>Cmd Login: ${message}</p>

<%@ include file="include/end-html.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="inc_header.jsp" %>

<form class="form-horizontal" action="do?command=SignUp" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Вход в систему</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Имя пользователя</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="" class="form-control input-md" required="">
  <span class="help-block">Ваш login (минимум 5 символов)</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Пароль</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="">
    <span class="help-block">Минимум 5 символов</span>
  </div>
</div>

<!-- Email input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email</label>
  <div class="col-md-4">
    <input id="email" name="email" type="text" placeholder="" class="form-control input-md" required="">
    <span class="help-block">Адрес электронной почты</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submitbutton"></label>
  <div class="col-md-4">
    <button id="submitbutton" name="submitbutton" class="btn btn-primary">Сохранить</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="inc_footer.jsp" %>




<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=signup" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Registration</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Имя</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="input login here" class="form-control input-md" required="" pattern="[a-zA-Z0-9]{4,}">
  <span class="help-block">max 16 characters</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">E-mail</label>
  <div class="col-md-4">
  <input id="email" name="email" type="text" placeholder="example@mail.com" class="form-control input-md" required="" pattern="[a-zA-Z0-9.-_]+@[a-zA-Z0-9]+.[a-zA-Z]{2,4}">
  <span class="help-block">example@email.com</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passport_data">Паспортные данные</label>
  <div class="col-md-4">
  <input id="passport_data" name="passport_data" type="text" placeholder="enter your passport data here" class="form-control input-md" required="" pattern="[A-Z]{2,}[0-9]{7,}">
  <span class="help-block">example: MP7777777</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Пароль</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="" pattern="[a-zA-Z0-9]{8,}">
    <span class="help-block">min 8 characters</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="signup"></label>
  <div class="col-md-4">
    <button id="signup" name="signup" class="btn btn-success">Зарегистрироваться</button>
  </div>
</div>

</fieldset>
</form>


<p>${message}</p>


<%@ include file="include/end-html.jsp" %>



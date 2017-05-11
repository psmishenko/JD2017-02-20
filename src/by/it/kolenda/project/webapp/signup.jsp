<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ include file="include/begin-html.jsp" %>

<p>Cmd SIGN-UP: ${message}</p>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Sign Up</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="id">Id пользователя</label>
  <div class="col-md-4">
  <input id="id" name="id" type="text" placeholder="Enter Id" class="form-control input-md" required="">
  <span class="help-block">hidden field</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="Enter login" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email</label>
  <div class="col-md-4">
  <input id="email" name="email" type="text" placeholder="Enter Email" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="role">User role</label>
  <div class="col-md-4">
  <input id="role" name="role" type="text" placeholder="User" class="form-control input-md" required="">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passwordinput">Password</label>
  <div class="col-md-4">
    <input id="passwordinput" name="passwordinput" type="password" placeholder="Enter password" class="form-control input-md" required="">
    <span class="help-block">Введите пароль не менее 8-и символов</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="signupbutton"></label>
  <div class="col-md-4">
    <button id="signupbutton" name="signupbutton" class="btn btn-primary">Register</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>



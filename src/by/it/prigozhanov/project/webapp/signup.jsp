<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=signup" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Registration</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="input login here" class="form-control input-md" required="">
  <span class="help-block">Your login (16 characters)</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">E-mail</label>
  <div class="col-md-4">
  <input id="email" name="email" type="text" placeholder="example@mail.com" class="form-control input-md" required="">
  <span class="help-block">your email</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="passport_data">Passport data</label>
  <div class="col-md-4">
  <input id="passport_data" name="passport_data" type="text" placeholder="enter your passport data here" class="form-control input-md" required="">
  <span class="help-block">your email</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="">
    <span class="help-block">8 characters</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="signup"></label>
  <div class="col-md-4">
    <button id="signup" name="signup" class="btn btn-success">Signup</button>
  </div>
</div>

</fieldset>
</form>


<p>Cmd SIGN-UP: ${message}</p>


<%@ include file="include/end-html.jsp" %>



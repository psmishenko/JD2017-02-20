<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal" action="do?command=signup" method="POST">
<fieldset>

<!-- Form Name -->
<legend align="center">Sign Up! It's free and anyone can join!</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-6">
  <input id="login" name="login" type="text" placeholder="Password" class="form-control input-md" required="">
  <span class="help-block">Enter your login (min 5 symbols)</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email</label>
  <div class="col-md-6">
  <input id="email" name="email" type="text" placeholder="Email" class="form-control input-md" required="">
  <span class="help-block">Enter your email</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-6">
    <input id="password" name="password" type="password" placeholder="Password" class="form-control input-md" required="">
    <span class="help-block">Enter your password (min 5 symbols)</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submit"></label>
  <div class="col-md-4">
    <button id="submit" name="submit" class="btn btn-success">Signup</button>
  </div>
</div>

</fieldset>
</form>
<%@ include file="include/end-html.jsp" %>



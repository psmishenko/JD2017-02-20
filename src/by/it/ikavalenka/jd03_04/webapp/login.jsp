<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Login">Login</label>
  <div class="col-md-4">
  <input id="Login" name="Login" type="text" placeholder="Enter Your Login" class="form-control input-md" required="">
  <span class="help-block">Required field</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Password">Password</label>
  <div class="col-md-4">
    <input id="Password" name="Password" type="password" placeholder="Enter Your Password" class="form-control input-md" required="">
    <span class="help-block">Required field</span>
  </div>
</div>

<!-- Button (Double) -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Login">Login/SignUp</label>
  <div class="col-md-8">
    <button id="Login" name="Login" class="btn btn-success">Log in</button>
    <button id="Sign up" name="Sign up" class="btn btn-danger">Sign up</button>
  </div>
</div>

</fieldset>
</form>

<p>Cmd Login: ${message}</p>

<%@ include file="include/end-html.jsp" %>

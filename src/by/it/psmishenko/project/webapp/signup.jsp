<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal" action="do?command=signup" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-6">
  <input id="login" name="login" type="text" placeholder="Password" class="form-control input-md" required="">
  <span class="help-block">min 5 symb</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">Email</label>
  <div class="col-md-6">
  <input id="email" name="email" type="text" placeholder="Email" class="form-control input-md" required="">
  <span class="help-block">your email</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-6">
    <input id="password" name="password" type="password" placeholder="Password" class="form-control input-md" required="">
    <span class="help-block">min 5 symb</span>
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
<p>Cmd SIGN-UP: ${message}</p>

<%@ include file="include/end-html.jsp" %>



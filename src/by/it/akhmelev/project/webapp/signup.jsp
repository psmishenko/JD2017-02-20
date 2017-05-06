<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="input login here" class="form-control input-md" required="">
  <span class="help-block">Your login (min 5 symbols)</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="" class="form-control input-md" required="">
    <span class="help-block">min 8 symbols</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="email">E-mail</label>
  <div class="col-md-4">
  <input id="email" name="email" type="text" placeholder="your email" class="form-control input-md" required="">
  <span class="help-block">Your email</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submitbutton"></label>
  <div class="col-md-4">
    <button id="submitbutton" name="submitbutton" class="btn btn-primary">Signup</button>
  </div>
</div>

</fieldset>
</form>



<p>Cmd SIGN-UP: ${message}</p>

<%@ include file="include/end-html.jsp" %>



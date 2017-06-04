<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>SignUp</legend>

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

<!-- Multiple Radios -->
<div class="form-group">
  <label class="col-md-4 control-label" for="SelectRole">Select role</label>
  <div class="col-md-4">
  <div class="radio">
    <label for="SelectRole-0">
      <input type="radio" name="SelectRole" id="SelectRole-0" value="1" checked="checked">
      Administrator
    </label>
	</div>
  <div class="radio">
    <label for="SelectRole-1">
      <input type="radio" name="SelectRole" id="SelectRole-1" value="2">
      Client
    </label>
	</div>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Submit">Submit</label>
  <div class="col-md-4">
    <button id="Submit" name="Submit" class="btn btn-success">Save</button>
  </div>
</div>

</fieldset>
</form>

<p>Cmd SIGN-UP: ${message}</p>

<%@ include file="include/end-html.jsp" %>



<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="LoginForm">Login</label>
  <div class="col-md-4">
  <input id="LoginForm" name="LoginForm" type="text" placeholder="Your Login" class="form-control input-md" required="">
  <span class="help-block">Enter Your Login</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Password">Password*</label>
  <div class="col-md-4">
  <input id="Password" name="Password" type="text" placeholder="Enter Your Password" class="form-control input-md" required="">
  <span class="help-block">Help?</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="Email">Email</label>
  <div class="col-md-4">
  <input id="Email" name="Email" type="text" placeholder="Enter Your email" class="form-control input-md">
  <span class="help-block">Forgot?</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton">Single Button</label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Button</button>
  </div>
</div>

</fieldset>
</form>

<p>Cmd Login: ${message}</p>

<%@ include file="include/end-html.jsp" %>

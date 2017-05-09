<%@ include file="include/begin-html.jsp" %>


<form class="form-horizontal" action="do?command=signup" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Signup</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Name</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="Only name" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Login</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" class="form-control input-md">

  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Password</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" class="form-control input-md">
    <span class="help-block">min 5 symbols</span>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="specialization">Specialization</label>
  <div class="col-md-4">
  <input id="specialization" name="specialization" type="text" placeholder="Numeral" class="form-control input-md">
  <span class="help-block">1 - Pilot</span>
  <span class="help-block">2 - Navigator</span>
  <span class="help-block">3 - Radio-operator</span>
  <span class="help-block">4 - Stewardess</span>
  <span class="help-block">5 - Dispatcher</span>
  <span class="help-block">6 - Administrator</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submitbutton"></label>
  <div class="col-md-4">
    <button id="submitbutton" name="submitbutton" class="btn btn-primary">Submit</button>
  </div>
</div>

</fieldset>
</form>

<p>Cmd SIGN-UP: ${message}</p>

<%@ include file="include/end-html.jsp" %>



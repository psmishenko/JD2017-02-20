<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=staff" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Profile</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Change login</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submitbutton"></label>
  <div class="col-md-4">
    <button id="submitbutton" name="submitbutton" class="btn btn-success">Change</button>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Change password</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submitbutton"></label>
  <div class="col-md-4">
    <button id="submitbutton" name="submitbutton" class="btn btn-success">Change</button>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logoutbutton"></label>
  <div class="col-md-4">
    <button id="logoutbutton" name="logoutbutton" class="btn btn-danger">Logout</button>
  </div>
</div>

</fieldset>
</form>

<p>Main: ${message}</p>

<%@ include file="include/end-html.jsp" %>
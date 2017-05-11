<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=createflight" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Administrator form</legend>

<h4>Create flight</h4>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="brigade">Brigade ID</label>
  <div class="col-md-4">
  <input id="brigade" name="brigade" type="text" placeholder="Numeral" class="form-control input-md">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="destination">Destination</label>
  <div class="col-md-4">
  <input id="destination" name="destination" type="text" class="form-control input-md">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="createflightbutton"></label>
  <div class="col-md-4">
    <button id="createflightebutton" name="createflightbutton" class="btn btn-success">Create</button>
  </div>
</div>

<h4>Remove flight</h4>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="removeflight">Remove flight</label>
  <div class="col-md-4">
  <input id="removeflight" name="removeflight" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="removeflightbutton"></label>
  <div class="col-md-4">
    <button id="removeflightbutton" name="removeflightbutton" class="btn btn-danger">Remove</button>
  </div>
</div>

<h4>Profile config</h4>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="newlogin">Change login</label>
  <div class="col-md-4">
  <input id="newlogin" name="newlogin" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="changeloginbutton"></label>
  <div class="col-md-4">
    <button id="changeloginbutton" name="changeloginbutton" class="btn btn-success">Change</button>
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
  <label class="col-md-4 control-label" for="changepasswordbutton"></label>
  <div class="col-md-4">
    <button id="changepasswordbutton" name="changepasswordbutton" class="btn btn-success">Change</button>
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
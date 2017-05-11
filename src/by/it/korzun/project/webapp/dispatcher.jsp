<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=createbrigade" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Dispatcher form</legend>

<h4>Create brigade</h4>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="firstpilot">First pilot ID</label>
  <div class="col-md-4">
  <input id="firstpilot" name="firstpilot" type="text" placeholder="Numeral" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="secondpilot">Second pilot ID</label>
  <div class="col-md-4">
  <input id="secondpilot" name="secondpilot" type="text" placeholder="Numeral" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="navigator">Navigator ID</label>
  <div class="col-md-4">
  <input id="navigator" name="navigator" type="text" placeholder="Numeral" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="radio_operator">Radio-operator</label>
  <div class="col-md-4">
  <input id="radio_operator" name="radio_operator" type="text" placeholder="Numeral" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="stewardess">Stewardess</label>
  <div class="col-md-4">
  <input id="stewardess" name="stewardess" type="text" placeholder="Numeral" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="createbrigade"></label>
  <div class="col-md-4">
    <button id="createbrigade" name="createbrigade" class="btn btn-success">Create</button>
  </div>
</div>

<h4>Remove brigade</h4>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="removebrigade">Remove brigade</label>
  <div class="col-md-4">
  <input id="removebrigade" name="removebrigade" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="removebrigadebutton"></label>
  <div class="col-md-4">
    <button id="removebrigadebutton" name="removebrigadebutton" class="btn btn-danger">Remove</button>
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
  <label class="col-md-4 control-label" for="newpassword">Change password</label>
  <div class="col-md-4">
    <input id="newpassword" name="newpassword" type="password" placeholder="" class="form-control input-md">

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
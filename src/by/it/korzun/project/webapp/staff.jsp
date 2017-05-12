<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=staff" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Profile</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Change login</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="submitnewloginbutton"></label>
  <div class="col-md-4">
    <button id="submitnewloginbutton" name="submitnewloginbutton" class="btn btn-success">Change</button>
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
  <label class="col-md-4 control-label" for="submitnewpasswordbutton"></label>
  <div class="col-md-4">
    <button id="submitnewpasswordbutton" name="submitnewpasswordbutton" class="btn btn-success">Change</button>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-danger">Logout</button>
  </div>
</div>

</fieldset>
</form>

<p>Main: ${message}</p>

<%@ include file="include/end-html.jsp" %>
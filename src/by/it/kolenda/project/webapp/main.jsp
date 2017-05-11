<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ include file="include/begin-html.jsp" %>

<p>Main: ${message}</p>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Main</legend>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="goToSignUp"></label>
  <div class="col-md-4">
    <button id="goToSignUp" name="goToSignUp" class="btn btn-primary">Sign Up</button>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="goToLogin"></label>
  <div class="col-md-4">
    <button id="goToLogin" name="goToLogin" class="btn btn-primary"> Login </button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>
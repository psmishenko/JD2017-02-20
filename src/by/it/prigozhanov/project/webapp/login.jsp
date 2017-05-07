<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Form Name</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="">Login</label>
  <div class="col-md-4">
  <input id="" name="" type="text" placeholder="" class="form-control input-md">
  <span class="help-block">16 characters</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="">Password</label>
  <div class="col-md-4">
    <input id="" name="" type="password" placeholder="" class="form-control input-md">
    <span class="help-block">8 characters</span>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="" name="" class="btn btn-success">Login</button>
  </div>
</div>

</fieldset>
</form>



<p>Cmd Login: ${message}</p>

<%@ include file="include/end-html.jsp" %>
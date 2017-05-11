<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Rent car</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="">Telephone</label>
  <div class="col-md-4">
  <input id="" name="" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Passport data</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Duration</label>
  <div class="col-md-4">
  <input id="textinput" name="textinput" type="text" placeholder="<30 days" class="form-control input-md" required="">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="">Card number</label>
  <div class="col-md-4">
  <input id="" name="" type="text" placeholder="" class="form-control input-md" required="">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="" name="" class="btn btn-success">Rent car</button>
  </div>
</div>

</fieldset>
</form>


<p>cmd RENT-CAR: ${message}</p>

<%@ include file="include/end-html.jsp" %>
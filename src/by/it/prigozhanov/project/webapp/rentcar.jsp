<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=rentcar" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Rent car</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="">Telephone</label>
  <div class="col-md-4">
  <input id="telephone" name="telephone" type="text" placeholder="example +375293333333" class="form-control input-md" required="" pattern="\+[0-9]{12}">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Passport data</label>
  <div class="col-md-4">
  <input id="passportdata" value="${user.passportData}" name="passportdata" type="text" placeholder="example: MP2931234" class="form-control input-md" required="" pattern="[A-Z]{2,}[0-9]{7,}">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="textinput">Duration</label>
  <div class="col-md-4">
  <input id="duration" name="duration" type="text" placeholder="max 30 days" class="form-control input-md" required="" pattern="[0-9]{1,2}">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="">Card number</label>
  <div class="col-md-4">
  <input id="cardnumber" name="cardnumber" type="text" placeholder="XXXX-XXXX-XXXX-XXXX" class="form-control input-md" required="" pattern="(([A-Za-z0-9]{4})-){3}[A-Za-z0-9]{4}">

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
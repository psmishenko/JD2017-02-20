<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal" action="do?command=login" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Orders</legend>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Your Coffee</label>
  <div class="col-md-5">
    <select id="selectbasic" name="selectbasic" class="form-control">
      <option value="1">Latte 2.5$</option>
      <option value="2">Americano 2.0$</option>
      <option value="3">Cappuccino 3.0$</option>
      <option value="4">Espresso 2.5$</option>
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-success">Order</button>
  </div>
</div>

</fieldset>
</form>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<form class="form-horizontal" action="do?command=login" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Orders</legend>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Выберите свой кофе</label>
  <div class="col-md-5">
    <select id="selectbasic" name="selectbasic" class="form-control">
      <option value="1">Latte 2.5$</option>
      <option value="2">Americano 2.0$</option>
      <option value="3">Cappuccino 3.0$</option>
      <option value="4">Espresso 2.5$</option>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Объем</label>
  <div class="col-md-4">
    <select name="selectbasic" class="form-control" id="selectbasic">
      <option value="1">150 мл</option>
      <option value="2">250 мл</option>
      <option value="3">350 мл</option>
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button name="singlebutton" class="btn btn-success" id="singlebutton">Заказать</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>

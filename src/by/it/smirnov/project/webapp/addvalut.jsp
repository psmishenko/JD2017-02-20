<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="do?command=addValut" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Добавление новой валюты</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Сокращенное наименование</label>
  <div class="col-md-4">
  <input id="namesokr" name="namesokr" type="text" placeholder="Сокращенное наименование" class="form-control input-md">
  <span class="help-block">3 английский больших буквы</span>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="login">Полное наименование</label>
  <div class="col-md-4">
  <input id="namefull" name="namefull" type="text" placeholder="Полное наименование" class="form-control input-md">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Сохранить</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>



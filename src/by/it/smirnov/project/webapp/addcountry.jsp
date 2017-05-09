<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="do?command=addCountry" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Добавление новой страны</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Наименование</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="Наименование" class="form-control input-md">
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



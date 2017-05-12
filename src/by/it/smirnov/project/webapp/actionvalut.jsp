<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="do?command=actionValut" method="POST">
<fieldset>

<input type="hidden" name="id" value="<c:if test="${valut == null}" >0</c:if><c:if test="${valut != null}" >${valut.id}</c:if>" />

<!-- Form Name -->
<legend>
<c:if test="${valut == null}" >Добавление новой валюты</c:if>
<c:if test="${valut != null}" >Редактирование валюты</c:if>
</legend>


<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="namesokr">Сокращенное наименование</label>
  <div class="col-md-4">
  <input id="namesokr" name="namesokr" type="text" placeholder="Сокращенное наименование" required=""
    value="<c:if test="${valut != null}" >${valut.namesokr}</c:if>"
    class="form-control input-md">
  <span class="help-block">3 английский больших буквы</span>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="namefull">Полное наименование</label>
  <div class="col-md-4">
  <input id="namefull" name="namefull" type="text" placeholder="Полное наименование" required=""
    value="<c:if test="${valut != null}" >${valut.namefull}</c:if>"
    class="form-control input-md">
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
<c:remove var="valut" scope="session" />

<%@ include file="include/end-html.jsp" %>



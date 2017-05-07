<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="do?command=addKursValut" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Добавление нового курса</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Дата</label>
  <div class="col-md-4">
  <input id="datekurs" name="datekurs" type="date" placeholder="дата" class="form-control input-md">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">Сумма</label>
  <div class="col-md-4">
  <input id="za" name="za" type="number" step="0.01" value="0.00" placeholder="Сумма" class="form-control input-md">
      <select id="zavalut" name="zavalut" class="form-control">
        <c:forEach items="${valuts}" var="valut">
            <option value="${valut.id}">${valut.namesokr}</option>
        </c:forEach>
      </select>

  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label">Сумма</label>
  <div class="col-md-4">
  <input id="dat" name="dat" type="number" step="0.01" value="0.00" placeholder="Сумма" class="form-control input-md">
      <select id="datvalut" name="datvalut" class="form-control">
        <c:forEach items="${valuts}" var="valut">
            <option value="${valut.id}">${valut.namesokr}</option>
        </c:forEach>
      </select>

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



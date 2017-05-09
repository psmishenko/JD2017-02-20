<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="do?command=addBank" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Добавление нового банка</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Наименование банка</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="Наименование банка" class="form-control input-md">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="login">БИК</label>
  <div class="col-md-4">
  <input id="bic" name="bic" type="text" placeholder="БИК" class="form-control input-md">
  <span class="help-block">123456789</span>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Страна</label>
  <div class="col-md-4">
    <select id="idcountry" name="idcountry" class="form-control">
      <c:forEach items="${countrys}" var="country">
          <option value="${country.id}">${country.name}</option>
      </c:forEach>
    </select>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Группа</label>
  <div class="col-md-4">
    <select id="idgroupbank" name="idgroupbank" class="form-control">
      <c:forEach items="${groupbanks}" var="groupbank">
          <option value="${groupbank.id}">${groupbank.name}</option>
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



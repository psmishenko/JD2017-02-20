<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="do?command=actionBank" method="POST">
<fieldset>

<input type="hidden" name="id" value="<c:if test="${bank == null}" >0</c:if><c:if test="${bank != null}" >${bank.id}</c:if>" />

<!-- Form Name -->
<legend>
<c:if test="${bank == null}" >Добавление нового банка</c:if>
<c:if test="${bank != null}" >Редактирование банка</c:if>
</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Наименование банка</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="Наименование банка" required=""
    value="<c:if test="${bank != null}" >${bank.name}</c:if>"
    class="form-control input-md">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="bic">БИК</label>
  <div class="col-md-4">
  <input id="bic" name="bic" type="text" placeholder="БИК" required=""
    value="<c:if test="${bank != null}" >${bank.bic}</c:if>"
    class="form-control input-md">
  <span class="help-block">123456789</span>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="idcountry">Страна</label>
  <div class="col-md-4">
    <select id="idcountry" name="idcountry" class="form-control">
      <c:forEach items="${countrys}" var="country">
          <option <c:if test="${bank != null && country.id==bank.country.id}" >selected</c:if> value="${country.id}">${country.name}</option>
      </c:forEach>
    </select>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="idgroupbank">Группа</label>
  <div class="col-md-4">
    <select id="idgroupbank" name="idgroupbank" class="form-control">
      <c:forEach items="${groupbanks}" var="groupbank">
          <option <c:if test="${bank != null && groupbank.id==bank.groupBank.id}" >selected</c:if> value="${groupbank.id}">${groupbank.name}</option>
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
<c:remove var="bank" scope="session" />

<%@ include file="include/end-html.jsp" %>



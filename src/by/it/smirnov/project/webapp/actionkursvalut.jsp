<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form class="form-horizontal" action="do?command=actionKursValut" method="POST">
<fieldset>

<input type="hidden" name="id" value="<c:if test="${kursvalut == null}" >0</c:if><c:if test="${kursvalut != null}" >${kursvalut.id}</c:if>" />

<!-- Form Name -->
<legend>
<c:if test="${kursvalut == null}" >Добавление нового курса</c:if>
<c:if test="${kursvalut != null}" >Редактирование курса</c:if>
</legend>


<c:set var="now" value="<%=new java.util.Date()%>" />

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="datekurs">Дата</label>
  <div class="col-md-4">
  <input id="datekurs" name="datekurs" type="date" placeholder="дата" class="form-control input-md" required=""
    value="<c:if test="${kursvalut != null}" >${kursvalut.datekurs}</c:if><c:if test="${kursvalut == null}" ><fmt:formatDate pattern="yyyy-MM-dd" value="${now}"/></c:if>"
  >
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="za">Сумма</label>
  <div class="col-md-4">
    <span class="input-group-btn">
  <input id="za" name="za" type="number" step="0.01" required=""
    value="<c:if test="${kursvalut == null}" >0</c:if><c:if test="${kursvalut != null}" >${kursvalut.za}</c:if>"
    placeholder="Сумма" class="form-control input-md">
    </span>
    <span class="input-group-btn">
      <select id="zavalut" name="zavalut" class="form-control">
        <c:forEach items="${valuts}" var="valut">
            <option <c:if test="${kursvalut != null && valut.id==kursvalut.zavalut.id}" >selected</c:if> value="${valut.id}">${valut.namesokr}</option>
        </c:forEach>
      </select>
    </span>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="dat">Сумма</label>
  <div class="col-md-4">
    <span class="input-group-btn">
  <input id="dat" name="dat" type="number" step="0.01" required=""
    value="<c:if test="${kursvalut == null}" >0</c:if><c:if test="${kursvalut != null}" >${kursvalut.dat}</c:if>"
    placeholder="Сумма" class="form-control input-md">
    </span>
    <span class="input-group-btn">
      <select id="datvalut" name="datvalut" class="form-control">
        <c:forEach items="${valuts}" var="valut">
            <option <c:if test="${kursvalut != null && valut.id==kursvalut.datvalut.id}" >selected</c:if> value="${valut.id}">${valut.namesokr}</option>
        </c:forEach>
      </select>
    </span>
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
<c:remove var="kursvalut" scope="session" />

<%@ include file="include/end-html.jsp" %>



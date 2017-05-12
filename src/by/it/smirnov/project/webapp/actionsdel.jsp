<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form class="form-horizontal" action="do?command=ActionSdel" method="POST">
<fieldset>

<input type="hidden" name="id" value="<c:if test="${sdel == null}" >0</c:if><c:if test="${sdel != null}" >${sdel.id}</c:if>" />

<!-- Form Name -->
<legend>
<c:if test="${sdel == null}" >Добавление новой сделки</c:if>
<c:if test="${sdel != null}" >Редактирование сделки</c:if>
</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="idbank">Банк</label>
  <div class="col-md-4">
    <select id="idbank" name="idbank" class="form-control" value="<c:if test="${sdel == null}" >0</c:if><c:if test="${sdel != null}" >${sdel.bank.id}</c:if>">
      <c:forEach items="${banks}" var="bank">
          <option <c:if test="${sdel != null && bank.id==sdel.bank.id}" >selected</c:if> value="${bank.id}">${bank.name}</option>
      </c:forEach>
    </select>
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="summa">Сумма</label>
  <div class="col-md-4">
  <input id="summa" name="summa" type="number" step="0.01" required="" value="<c:if test="${sdel == null}" >0</c:if><c:if test="${sdel != null}" >${sdel.summa}</c:if>" placeholder="Сумма" class="form-control input-md">
      <select id="idvalut" name="idvalut" class="form-control">
        <c:forEach items="${valuts}" var="valut">
            <option <c:if test="${sdel != null && valut.id==sdel.valut.id}" >selected</c:if> value="${valut.id}">${valut.namesokr}</option>
        </c:forEach>
      </select>

  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="idopertype">Операция</label>
  <div class="col-md-4">
    <select id="idopertype" name="idopertype" class="form-control" >
      <c:forEach items="${opertypes}" var="opertype">
          <option <c:if test="${sdel != null && opertype.id==sdel.operType.id}" >selected</c:if> value="${opertype.id}">${opertype.name}</option>
      </c:forEach>
    </select>
  </div>
</div>

<c:set var="now" value="<%=new java.util.Date()%>" />

<div class="form-group">
  <label class="col-md-4 control-label" for="fromdate">С даты</label>
  <div class="col-md-4">
  <input id="fromdate" name="fromdate" type="date" placeholder="дата" required="" class="form-control input-md" value="<c:if test="${sdel == null}" ><fmt:formatDate pattern="yyyy-MM-dd" value="${now}" /></c:if><c:if test="${sdel != null}" >${sdel.fromdate}</c:if>">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="todate">По дату</label>
  <div class="col-md-4">
  <input id="todate" name="todate" type="date" placeholder="дата" required="" class="form-control input-md" value="<c:if test="${sdel == null}" ><fmt:formatDate pattern="yyyy-MM-dd" value="${now}" /></c:if><c:if test="${sdel != null}" >${sdel.todate}</c:if>">
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

<c:remove var="sdel" scope="session" />

<%@ include file="include/end-html.jsp" %>



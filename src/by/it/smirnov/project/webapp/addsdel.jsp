<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form class="form-horizontal" action="do?command=addSdel" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Добавление новой сделки</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Банк</label>
  <div class="col-md-4">
    <select id="idbank" name="idbank" class="form-control">
      <c:forEach items="${banks}" var="bank">
          <option value="${bank.id}">${bank.name}</option>
      </c:forEach>
    </select>
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="login">Сумма</label>
  <div class="col-md-4">
  <input id="summa" name="summa" type="number" step="0.01" value="0.00" placeholder="Сумма" class="form-control input-md">
      <select id="idvalut" name="idvalut" class="form-control">
        <c:forEach items="${valuts}" var="valut">
            <option value="${valut.id}">${valut.namesokr}</option>
        </c:forEach>
      </select>

  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Операция</label>
  <div class="col-md-4">
    <select id="idopertype" name="idopertype" class="form-control">
      <c:forEach items="${opertypes}" var="opertype">
          <option value="${opertype.id}">${opertype.name}</option>
      </c:forEach>
    </select>
  </div>
</div>

<c:set var="now" value="<%=new java.util.Date()%>" />

<div class="form-group">
  <label class="col-md-4 control-label" for="login">С даты</label>
  <div class="col-md-4">
  <input id="fromdate" name="fromdate" type="date" placeholder="дата" class="form-control input-md" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${now}" />">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="login">По дату</label>
  <div class="col-md-4">
  <input id="todate" name="todate" type="date" placeholder="дата" class="form-control input-md" value="<fmt:formatDate pattern="yyyy-MM-dd" value="${now}" />">
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



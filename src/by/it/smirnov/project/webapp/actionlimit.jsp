<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form class="form-horizontal" action="do?command=actionLimit" method="POST">
<fieldset>

<input type="hidden" name="id" value="<c:if test="${limit == null}" >0</c:if><c:if test="${limit != null}" >${limit.id}</c:if>" />

<!-- Form Name -->
<legend>
<c:if test="${limit == null}" >Добавление нового лимита</c:if>
<c:if test="${limit != null}" >Редактирование лимита</c:if>
</legend>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-4 control-label" for="idgroupbank">Группа банков</label>
  <div class="col-md-4">
    <select id="idgroupbank" name="idgroupbank" class="form-control">
      <c:forEach items="${groupbanks}" var="groupbank">
          <option <c:if test="${limit != null && groupbank.id==limit.groupbank.id}" >selected</c:if> value="${groupbank.id}">${groupbank.name}</option>
      </c:forEach>
    </select>
  </div>
</div>


<div class="form-group">
  <label class="col-md-4 control-label" for="idopertype">Операция</label>
  <div class="col-md-4">
    <select id="idopertype" name="idopertype" class="form-control">
      <c:forEach items="${opertypes}" var="opertype">
          <option <c:if test="${limit != null && opertype.id==limit.opertype.id}" >selected</c:if> value="${opertype.id}">${opertype.name}</option>
      </c:forEach>
    </select>
  </div>
</div>
<c:set var="now" value="<%=new java.util.Date()%>" />

<div class="form-group">
  <label class="col-md-4 control-label" for="fromdate">С даты</label>
  <div class="col-md-4">
  <input id="fromdate" name="fromdate" type="date" placeholder="дата" required=""
    value="<c:if test="${limit != null}" >${limit.fromdate}</c:if><c:if test="${limit == null}" ><fmt:formatDate pattern="yyyy-MM-dd" value="${now}"/></c:if>"
    class="form-control input-md">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="summa">Сумма</label>
  <div class="col-md-4">
    <span class="input-group-btn">
  <input id="summa" name="summa" type="number" step="0.01" required=""
      value="<c:if test="${limit != null}" >${limit.summa}</c:if><c:if test="${limit == null}" >0.00</c:if>"
      placeholder="Сумма" class="form-control input-md">
    </span>
    <span class="input-group-btn">
      <select id="idvalut" name="idvalut" class="form-control">
        <c:forEach items="${valuts}" var="valut">
            <option <c:if test="${limit != null && valut.id==limit.valut.id}" >selected</c:if> value="${valut.id}">${valut.namesokr}</option>
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
<c:remove var="limit" scope="session" />

<%@ include file="include/end-html.jsp" %>



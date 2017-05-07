<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="do?command=addLimit" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Добавление нового лимита</legend>

<!-- Text input-->

<div class="form-group">
  <label class="col-md-4 control-label" for="selectbasic">Группа банков</label>
  <div class="col-md-4">
    <select id="idgroupbank" name="idgroupbank" class="form-control">
      <c:forEach items="${groupbanks}" var="groupbank">
          <option value="${groupbank.id}">${groupbank.name}</option>
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

<div class="form-group">
  <label class="col-md-4 control-label" for="login">С даты</label>
  <div class="col-md-4">
  <input id="fromdate" name="fromdate" type="date" placeholder="дата" class="form-control input-md">
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



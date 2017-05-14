<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<c:if test="${userauthorized}">

<p>Список моих задач:</p>

<style>

  .STasksTable th
  {
    text-align: center;
  }

  .STasksTable td.C
  {
    text-align: center;
  }

  .STasksTable td.R
  {
    text-align: right;
  }

</style>

<table class="table table-bordered STasksTable">
    <tr>
        <th>Наименование</th>
        <th style="width: 10em">Срок исполнения</th>
        <th style="width: 6em">Стоимость</th>
        <th style="width: 7em">Состояние</th>
    </tr>
    <c:forEach items="${tasks}" var="task">
    <tr>
        <td>${task.name}</td>
        <td class="C">${task.formattedEndDate}</td>
        <td class="R" style="padding-right: 1em">${task.formattedPrice}</td>
        <td>${task.statusName}</td>
    </tr>
    </c:forEach>
</table>

<form class="form-horizontal" action="do?command=Profile" method="POST">
<fieldset>

<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-primary">Выйти</button>
  </div>
</div>

</fieldset>
</form>

</c:if>

<c:if test="${!userauthorized}">

<p>Авторизуйтесь!</p>

</c:if>

<%@ include file="include/end-html.jsp" %>
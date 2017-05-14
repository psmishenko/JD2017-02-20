<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<p>Список заданий:</p>

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
        <th style="width: 7em">Исполнитель</th>
    </tr>
    <c:forEach items="${tasks}" var="task">
    <tr>
        <td>${task.name}</td>
        <td class="C">${task.formattedEndDate}</td>
        <td class="R" style="padding-right: 1em">${task.formattedPrice}</td>
        <td>${task.statusName}</td>
        <td>${task.execUserName}</td>
    </tr>
    </c:forEach>
</table>

<%@ include file="include/end-html.jsp" %>
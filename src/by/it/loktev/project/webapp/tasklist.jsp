<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<p>Список задач:</p>

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
        <c:if test="${userauthorized}">
          <th style="width: 1em"></th>
        </c:if>
        <c:if test="${userroleid==1}">
          <th style="width: 1em"></th>
          <th style="width: 1em"></th>
        </c:if>
    </tr>
    <c:forEach items="${tasks}" var="task">
    <tr>
        <td>${task.name}</td>
        <td class="C">${task.formattedEndDate}</td>
        <td class="R" style="padding-right: 1em">${task.formattedPrice}</td>
        <td>${task.statusName}</td>
        <td>${task.execUserName}</td>
        <c:if test="${userauthorized}">
        <td>
          <c:if test="${task.statusId==1}">
          <form action="do?command=TaskGet" method="post">
            <input type=hidden name="taskid" value="${task.id}">
            <input type=submit class="btn btn-info" value="взять в работу">
          </form>
          </c:if>
          <c:if test="${task.statusId==2 && task.execUserId==userid}">
          <form action="do?command=TaskReady" method="post">
            <input type=hidden name="taskid" value="${task.id}">
            <input type=submit class="btn btn-info" value="исполнено">
          </form>
          </c:if>
        </td>
        </c:if>
        <c:if test="${userroleid==1}">
        <td>
          <form action="do?command=TaskEdit" method="post">
            <input type=hidden name="taskid" value="${task.id}">
            <input type=submit class="btn btn-primary" value="редактировать">
          </form>
        </td>
        <td>
          <form action="do?command=TaskDelete" method="post">
            <input type=hidden name="taskid" value="${task.id}">
            <input type=submit class="btn btn-danger" value="удалить">
          </form>
        </td>
        </c:if>
    </tr>
    </c:forEach>
    <c:if test="${userroleid==1}">
    <tr>
        <td colspan=8>
            <a href=do?command=TaskCreate class="btn btn-info">Добавить задачу</a>
        </td>
    </tr>
    </c:if>
</table>

<%@ include file="include/end-html.jsp" %>
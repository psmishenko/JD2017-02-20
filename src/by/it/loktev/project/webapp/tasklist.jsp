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
            <input type=button class="btn btn-info" value="взять в работу" onclick="javascript:TaskGet(${task.id},'${task.name}')">
          </c:if>
          <c:if test="${task.statusId==2 && task.execUserId==userid}">
            <input type=button class="btn btn-success" value="исполнить" onclick="javascript:TaskReady(${task.id},'${task.name}')">
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
           <input type=button class="btn btn-danger" value="удалить" onclick="javascript:TaskDelete(${task.id},'${task.name}')">
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

<form name=FTaskDelete action="do?command=TaskDelete" method="post">
  <input type=hidden name="taskid">
</form>

<form name=FTaskGet action="do?command=TaskGet" method="post">
  <input type=hidden name="taskid">
</form>

<form name=FTaskReady action="do?command=TaskReady" method="post">
  <input type=hidden name="taskid">
</form>

<script>

  function TaskDelete(TaskId,TaskName)
  {
    if ( confirm("Вы уверены, что хотите удалить задачу:\n"+TaskName) )
    {
      var Form=document.forms.FTaskDelete;
      Form.elements.taskid.value=TaskId;
      Form.submit();
    }
  }

  function TaskGet(TaskId,TaskName)
  {
    if ( confirm("Вы уверены, что хотите взять в работу задачу:\n"+TaskName) )
    {
      var Form=document.forms.FTaskGet;
      Form.elements.taskid.value=TaskId;
      Form.submit();
    }
  }

  function TaskReady(TaskId,TaskName)
  {
    if ( confirm("Вы уверены, что исполнена задача:\n"+TaskName) )
    {
      var Form=document.forms.FTaskReady;
      Form.elements.taskid.value=TaskId;
      Form.submit();
    }
  }

</script>

<%@ include file="include/end-html.jsp" %>
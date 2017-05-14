<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=TaskEdit" method="post">

<input type=hidden name="taskid" value="${taskid}">

<fieldset>

<!-- Form Name -->
<legend>Редактирование задачи</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Наименование</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="" class="form-control input-md" value="${task.name}">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="enddate">Срок исполнения</label>
  <div class="col-md-2">
  <input id="enddate" name="enddate" type="date" placeholder="" class="form-control input-md" value="${task.htmlEndDate}">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Стоимость</label>
  <div class="col-md-2">
  <input id="price" name="price" type="number" step="0.01" placeholder="" class="form-control input-md" value="${task.htmlPrice}">

  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="status">Состояние</label>
  <div class="col-md-4">
    <select id="status" name="status" class="form-control">
      <c:forEach items="${statuses}" var="status">
        <c:if test="${status.id==task.statusId}">
          <option value="${status.id}" selected>${status.name}</option>
        </c:if>
        <c:if test="${status.id!=task.statusId}">
          <option value="${status.id}">${status.name}</option>
        </c:if>
      </c:forEach>
    </select>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="status">Исполнитель</label>
  <div class="col-md-4">
    <select id="execuser" name="execuser" class="form-control">
      <c:forEach items="${users}" var="user">
        <c:if test="${user.id==task.execUserId}">
          <option value="${user.id}" selected>${user.login}</option>
        </c:if>
        <c:if test="${user.id!=task.execUserId}">
          <option value="${user.id}">${user.login}</option>
        </c:if>
      </c:forEach>
    </select>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="" type=submit name="buttonsave" class="btn btn-primary">Сохранить</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
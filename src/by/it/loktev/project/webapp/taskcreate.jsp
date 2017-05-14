<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=TaskCreate" method="post">

<input type=hidden name="taskid" value="${taskid}">

<fieldset>

<!-- Form Name -->
<legend>Добавление задачи</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Наименование</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="enddate">Срок исполнения</label>
  <div class="col-md-2">
  <input id="enddate" name="enddate" type="date" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="price">Стоимость</label>
  <div class="col-md-2">
  <input id="price" name="price" type="number" step="0.01" placeholder="" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for=""></label>
  <div class="col-md-4">
    <button id="" type=submit name="actioncreate" class="btn btn-primary">Добавить задачу</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
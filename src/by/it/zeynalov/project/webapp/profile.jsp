<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="page-header">
  <h1>Данные профиля</h1>
  <div class="row">
    <div class="col-md-1">Ваш логин: ${user.login}</div>
    <div class="col-md-1">Ваш Email: ${user.email}</div>
  </div>
</div>

<form class="form-horizontal" action="do?command=profile" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Exit</legend>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-danger">Logout</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
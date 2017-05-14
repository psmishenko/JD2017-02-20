<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=UserEdit" method="post">

<input type=hidden name="usid" value="${usid}">

<fieldset>

<!-- Form Name -->
<legend>Редактирование пользователя</legend>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">Логин</label>
  <div class="col-md-4">
    <input id="login" name="login" type="text" placeholder="" class="form-control input-md" value="${us.login}">
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="name">E-mail</label>
  <div class="col-md-4">
    <input id="email" name="email" type="text" placeholder="" class="form-control input-md" value="${us.email}">
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="role">Роль</label>
  <div class="col-md-4">
    <select id="role" name="role" class="form-control">
      <c:forEach items="${roles}" var="role">
        <c:if test="${role.id==us.roleId}">
          <option value="${role.id}" selected>${role.name}</option>
        </c:if>
        <c:if test="${role.id!=us.roleId}">
          <option value="${role.id}">${role.name}</option>
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
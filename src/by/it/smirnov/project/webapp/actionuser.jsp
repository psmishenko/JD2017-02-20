<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="do?command=actionUser" method="POST">
<fieldset>

<input type="hidden" name="id" value="<c:if test="${user == null}" >0</c:if><c:if test="${user != null}" >${user.id}</c:if>" />

<!-- Form Name -->
<legend>
<c:if test="${user == null}" >Добавление нового пользователя</c:if>
<c:if test="${user != null}" >Редактирование пользователя</c:if>
</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="login">Имя пользователя</label>
  <div class="col-md-4">
  <input id="name" name="name" type="text" placeholder="Имя пользователя" required="" class="form-control input-md"
    value="<c:if test="${user != null}" >${user.name}</c:if>"
  >
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="login">Логин</label>
  <div class="col-md-4">
  <input id="login" name="login" type="text" placeholder="Логин" required="" class="form-control input-md"
    value="<c:if test="${user != null}" >${user.login}</c:if>"
  >
  <span class="help-block">Английские буквы и цифры. Не менее 5 символов</span>
  </div>
</div>

<!-- Password input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="password">Пароль</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" required="" placeholder="Пароль" class="form-control input-md">
  <span class="help-block">Английские буквы и цифры. Не менее 8 символов</span>
  </div>
</div>

<div class="form-group">
  <label class="col-md-4 control-label" for="checkboxes">Роли</label>
  <div class="col-md-4">
  <c:forEach items="${roles}" var="role">
  <div class="checkbox">
    <label>
      <input type="checkbox" name="checkboxes-${role.id}"
        <c:forEach items="${userroles}" var="userrole">
          <c:if test="${role.id == userrole.idrole}" >checked</c:if>
        </c:forEach>
        value="${role.id}"
      >${role.name}
    </label>
	</div>
  </c:forEach>
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
<c:remove var="user" scope="session" />
<c:remove var="userroles" scope="session" />

<%@ include file="include/end-html.jsp" %>



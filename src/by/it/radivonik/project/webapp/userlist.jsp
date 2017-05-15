<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/inc_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-inline" action="do" method="post">
  <legend>Пользователи</legend>
  <input type="hidden" name="command" value="UserEdit" />
  <div class="btn-toolbar navbar-form navbar-left">
    <button class="btn btn-xs btn-primary" type="submit" name="action" value="create" >
      <span class="glyphicon glyphicon-plus" aria-hidden="true" title="Добавить"/>
      Добавить
    </button>
    <c:if test="${users.size() > 0}">
    <button class="btn btn-xs btn-primary" type="submit" name="action" value="update" >
      <span class="glyphicon glyphicon-pencil" aria-hidden="true" title="Изменить"/>
      Изменить
    </button>
    <button class="btn btn-xs btn-primary" type="submit" name="action" value="delete">
      <span class="glyphicon glyphicon-minus" aria-hidden="true" title="Удалить"/>
      Удалить
    </button>
    </c:if>
  </div>

  <table class="table table-hover table-striped table-bordered">
    <thead>
      <tr>
        <th>Выбор</tр>
        <th>ID</th>
        <th>Имя пользователя</th>
        <th>Пароль</th>
        <th>Адрес электронной почты</th>
        <th>Роль</th>
      </tr>
    </thead>
    <tbody>
      <c:set var="selectChecked" scope="page" value="" />
      <c:set var="id" scope="page" value="0" />
      <c:forEach var="user" items="${users}">
        <c:if test="${user_id == user.id}">
          <c:set var="id" scope="page" value="${user.id}" />
        </c:if>
      </c:forEach>
      <c:forEach var="user" items="${users}">
      <tr>
        <c:if test="${id == 0 || id == user.id}">
        <c:set var="selectChecked" scope="page" value="checked" />
        <c:set var="id" scope="page" value="${user.id}" />
        </c:if>
        <td><input class="radio-inline" type="radio" name="id" value="${user.id}" ${selectChecked}/></td>
        <c:set var="selectChecked" scope="page" value="" />
        <td align="right"><c:out value="${user.id}"/></td>
        <td align="left"><c:out value="${user.login}"/></td>
        <td align="left">*****</td>
        <td align="left"><c:out value="${user.email}"/></td>
        <td align="left"><c:out value="${user.nameRole}"/></td>
      </tr>
      </c:forEach>
      <c:remove var="selectChecked" scope="page" />
      <c:remove var="id" scope="page" />
    </tbody>
  </table>
</form>

<%@ include file="include/inc_footer.jsp" %>
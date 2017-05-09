<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="btn-group" role="group">
  <a href="do?command=AddUser" class="btn btn-primary" role="button">Добавить пользователя</a>
</div>
<p></p>

<div class="panel panel-default">

  <!-- Default panel contents -->
  <div class="panel-heading">Справочник пользователей</div>
  <!-- Table -->
  <table class="table">
    <tr>
      <td><b>Пользователь</b></td>
      <td><b>Логин</b></td>
      <td><b>Роли</b></td>
    </tr>
  <c:forEach items="${users}" var="user">
    <tr>
      <td><c:out value="${user.name}" /></td>
      <td><c:out value="${user.login}" /></td>
      <td>
        <c:forEach items="${user.listRoles}" var="role">
          <p><c:out value="${role}" /></p>
        </c:forEach>
      </td>
      <td align="right">
         <button type="button" class="btn btn-primary btn-xs">Редактировать</button>
         <button type="button" class="btn btn-primary btn-xs">Удалить</button>
      </td>

    </tr>
  </c:forEach>
  </table>
</div>

<%@ include file="include/end-html.jsp" %>
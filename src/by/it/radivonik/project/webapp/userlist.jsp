<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/inc_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-inline" action="do" method="post">
  <legend>Пользователи</legend>
  <input type="hidden" name="command" value="UserEdit" />
  <t:listbutton list="${users}" textcreate="Добавить" textupdate="Изменить" textdelete="Удалить"/>

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
      <c:forEach var="user" items="${users}">
      <tr >
      <td><t:listselect list="${users}" id="${user.id}" idselect="${user_id}"/></td>
        <td align="right"><c:out value="${user.id}"/></td>
        <td align="left"><c:out value="${user.login}"/></td>
        <td align="left">*****</td>
        <td align="left"><c:out value="${user.email}"/></td>
        <td align="left"><c:out value="${user.nameRole}"/></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</form>

<%@ include file="include/inc_footer.jsp" %>
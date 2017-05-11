<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="inc_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<table class="table table-hover table-striped table-bordered">
      <thead>
        <tr>
          <td align="center"><span class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span></td>
          <th align="center">ID</th>
          <th align="center">Имя пользователя</th>
          <th align="center">Пароль</th>
          <th align="center">Адрес электронной почты</th>
          <th align="center">Роль</th>
        </tr>
      </thead>
      <tbody>
        <c:forEach var="user" items="${users}">
        <tr>
          <td align="center">
            <form class="form-inline" action="do" method="post">
              <input type="hidden" name="command" value="UserEdit" />
              <input type="hidden" name="id" value="<c:out value="${user.id}"/>" />
              <button class="btn btn-xs" type="submit" name="action" value="update" >
                <span class="glyphicon glyphicon-pencil" aria-hidden="true" title="Изменить"/>
              </button>
              <button class="btn btn-xs" type="submit" name="action" value="delete">
                <span class="glyphicon glyphicon-minus" aria-hidden="true" title="Удалить"/>
              </button>
            </form>
          </td>
          <td align="right"><c:out value="${user.id}"/></td>
          <td align="left"><c:out value="${user.login}"/></td>
          <td align="left">*****</td>
          <td align="left"><c:out value="${user.email}"/></td>
          <td align="left"><c:out value="${user.nameRole}"/></td>
        </tr>
        </c:forEach>
        <tr>
          <td align="center">
            <form class="form-inline" action="do" method="post">
              <input type="hidden" name="command" value="UserEdit" />
              <input type="hidden" name="id" value="0" />
              <button class="btn btn-xs" type="submit" name="action" value="create" >
                <span class="glyphicon glyphicon-plus" aria-hidden="true" title="Добавить"/>
              </button>
            </form>
          </td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
      </tbody>
	</table>

<%@ include file="inc_footer.jsp" %>
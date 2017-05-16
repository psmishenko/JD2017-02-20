<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="row">
<c:if test="${admin == 1}" >
  <div class="col-sm-2">
      <div class="btn-group" role="group">
        <a href="do?command=actionUser" class="btn btn-primary" role="button">Добавить пользователя</a>
      </div>
  </div>
</c:if>
  <div class="col-sm-4">
    <form action="do?command=Users" method="POST">
      <div class="input-group">
          <input name="searchText" class="form-control" placeholder="Поиск по имени пользователя..."
           value="<c:if test="${searchText != null}" >${searchText}</c:if>"
          >
          <span class="input-group-btn">
            <button name="btnSearch" class="btn btn-default" type="submit">Поиск</button>
          </span>
      </div>
    </form>
  </div>
</div>

<p></p>

<div class="panel panel-primary">

  <!-- Default panel contents -->
  <div class="panel-heading">Справочник пользователей</div>
  <!-- Table -->
  <table class="table table-striped">
    <tr>
      <td><b>Пользователь</b></td>
      <td><b>Логин</b></td>
      <td><b>Роли</b></td>
<c:if test="${admin == 1}" >
      <td></td>
</c:if>
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
<c:if test="${admin == 1}" >
      <td align="right">
      <form class="form-horizontal" action="do?command=ActionUser" method="POST">
          <input type="hidden" name="id" value="${user.id}" />
          <button type="submit" class="btn btn-primary btn-xs" name="btnEdit">Редактировать</button>
          <button type="submit" class="btn btn-primary btn-xs" name="btnDelete">Удалить</button>
      </form>
      </td>
</c:if>

    </tr>
  </c:forEach>
  </table>
</div>

<%@ include file="include/end-html.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="inc_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-inline" action="do" method="post">
  <legend>Клиенты</legend>
  <input type="hidden" name="command" value="KlientEdit" />
  <div class="btn-toolbar navbar-form navbar-left">
    <button class="btn btn-xs btn-primary" type="submit" name="action" value="create" >
      <span class="glyphicon glyphicon-plus" aria-hidden="true" title="Добавить"/>
      Добавить
    </button>
    <c:if test="${klients.size() > 0}">
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
        <th>Наименование</th>
        <th>УНП</th>
        <th>Адрес</th>
     </tr>
    </thead>
    <tbody>
      <c:set var="selectChecked" scope="page" value="" />
      <c:set var="id" scope="page" value="0" />
      <c:forEach var="klient" items="${klients}">
        <c:if test="${klient_id == klient.id}">
          <c:set var="id" scope="page" value="${klient.id}" />
        </c:if>
      </c:forEach>
      <c:forEach var="klient" items="${klients}">
      <tr >
       <c:if test="${id == 0 || id == klient.id}">
          <c:set var="selectChecked" scope="page" value="checked" />
          <c:set var="id" scope="page" value="${klient.id}" />
        </c:if>
        <td><input class="radio-inline" type="radio" name="id" value="${klient.id}" ${selectChecked}/></td>
        <c:set var="selectChecked" scope="page" value="" />
        <td align="right"><c:out value="${klient.id}"/></td>
        <td align="left"><c:out value="${klient.name}"/></td>
        <td align="left"><c:out value="${klient.unp}"/></td>
        <td align="left"><c:out value="${klient.adres}"/></td>
      </tr>
      </c:forEach>
      <c:remove var="selectChecked" scope="page" />
    </tbody>
  </table>
</form>

<%@ include file="inc_footer.jsp" %>
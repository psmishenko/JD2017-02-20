<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/inc_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-inline" action="do" method="post">
  <legend>Клиенты</legend>
  <input type="hidden" name="command" value="KlientEdit" />
  <t:listbutton list="${klients}" textcreate="Добавить" textupdate="Изменить" textdelete="Удалить"/>

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
      <c:forEach var="klient" items="${klients}">
      <tr >
        <td><t:listselect list="${klients}" id="${klient.id}" idselect="${klient_id}"/></td>
        <td align="right"><c:out value="${klient.id}"/></td>
        <td align="left"><c:out value="${klient.name}"/></td>
        <td align="left"><c:out value="${klient.unp}"/></td>
        <td align="left"><c:out value="${klient.adres}"/></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</form>

<%@ include file="include/inc_footer.jsp" %>
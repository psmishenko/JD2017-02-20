<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/inc_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-inline" action="do" method="post">
  <legend>Товарные накладные</legend>
  <input type="hidden" name="command" value="NakladEdit" />
  <t:listbutton list="${naklads}" textcreate="Добавить" textupdate="Изменить" textdelete="Удалить"/>

  <table class="table table-hover table-striped table-bordered">
    <thead>
      <tr>
        <th>Выбор</th>
        <th>ID</th>
        <th>Тип</th>
        <th>Дата</th>
        <th>Номер</th>
        <th>Серия</th>
        <th>Клиент</th>
        <th>Автомобиль</th>
     </tr>
    </thead>
    <tbody>
      <c:forEach var="naklad" items="${naklads}">
      <tr >
        <td><t:listselect list="${naklads}" id="${naklad.id}" idselect="${naklad_id}"/></td>
        <td align="right"><c:out value="${naklad.id}"/></td>
        <td align="left"><c:out value="${naklad.type.name}"/></td>
        <td align="left"><c:out value="${naklad.date}"/></td>
        <td align="left"><c:out value="${naklad.num}"/></td>
        <td align="left"><c:out value="${naklad.seria}"/></td>
        <td align="left"><c:out value="${naklad.klient.name}"/></td>
        <td align="left"><c:out value="${naklad.avto.numgos} ${naklad.avto.voditel}"/></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</form>

<%@ include file="include/inc_footer.jsp" %>
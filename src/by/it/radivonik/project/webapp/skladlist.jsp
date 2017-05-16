<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/inc_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-inline" action="do" method="post">
  <legend>Товары на складе</legend>
  <input type="hidden" name="command" value="SkladEdit" />
  <t:listbutton list="${sklads}" textcreate="Добавить" textupdate="Изменить" textdelete="Удалить"/>

  <table class="table table-hover table-striped table-bordered">
    <thead>
      <tr>
        <th>Выбор</th>
        <th>ID</th>
        <th>Товар</th>
        <th>Количество</th>
        <th>Цена</th>
        <th>Стоимость</th>
     </tr>
    </thead>
    <tbody>
      <c:forEach var="sklad" items="${sklads}">
      <tr >
        <td><t:listselect list="${sklads}" id="${sklad.id}" idselect="${sklad_id}"/></td>
        <td align="right"><c:out value="${sklad.id}"/></td>
        <td align="left"><c:out value="${sklad.tovar.name}"/></td>
        <td align="right"><c:out value="${sklad.count}"/></td>
        <td align="right"><c:out value="${sklad.cena}"/></td>
        <td align="right"><c:out value="${sklad.stoim}"/></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</form>

<%@ include file="include/inc_footer.jsp" %>
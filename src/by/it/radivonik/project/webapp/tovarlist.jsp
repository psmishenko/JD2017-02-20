<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/inc_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-inline" action="do" method="post">
  <legend>Товары</legend>
  <input type="hidden" name="command" value="TovarEdit" />
  <t:listbutton list="${tovars}" textcreate="Добавить" textupdate="Изменить" textdelete="Удалить"/>

  <table class="table table-hover table-striped table-bordered">
    <thead>
      <tr>
        <th>Выбор</tр>
        <th>ID</th>
        <th>Наименование</th>
        <th>Единица измерения</th>
     </tr>
    </thead>
    <tbody>
      <c:forEach var="tovar" items="${tovars}">
      <tr >
        <td><t:listselect list="${tovars}" id="${tovar.id}" idselect="${tovar_id}"/></td>
        <td align="right"><c:out value="${tovar.id}"/></td>
        <td align="left"><c:out value="${tovar.name}"/></td>
        <td align="left"><c:out value="${tovar.edizm}"/></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</form>

<%@ include file="include/inc_footer.jsp" %>
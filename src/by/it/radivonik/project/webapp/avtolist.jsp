<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/inc_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags"%>

<form class="form-inline" action="do" method="post">
  <legend>Автомобили</legend>
  <input type="hidden" name="command" value="AvtoEdit" />
  <t:listbutton list="${avtos}" textcreate="Добавить" textupdate="Изменить" textdelete="Удалить"/>

  <table class="table table-hover table-striped table-bordered">
    <thead>
      <tr>
        <th>Выбор</tр>
        <th>ID</th>
        <th>Гос. номер</th>
        <th>Водитель (ФИО)</th>
     </tr>
    </thead>
    <tbody>
      <c:forEach var="avto" items="${avtos}">
      <tr >
        <td><t:listselect list="${avtos}" id="${avto.id}" idselect="${avto_id}"/></td>
        <td align="right"><c:out value="${avto.id}"/></td>
        <td align="left"><c:out value="${avto.numgos}"/></td>
        <td align="left"><c:out value="${avto.voditel}"/></td>
      </tr>
      </c:forEach>
    </tbody>
  </table>
</form>

<%@ include file="include/inc_footer.jsp" %>
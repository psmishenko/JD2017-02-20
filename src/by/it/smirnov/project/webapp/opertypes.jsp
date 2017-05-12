<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="btn-group" role="group">
  <a href="do?command=actionOperType" class="btn btn-primary" role="button">Добавить тип операции</a>
</div>
<p></p>

<div class="panel panel-primary">
  <!-- Default panel contents -->
  <div class="panel-heading">Справочник типов операций</div>
  <!-- Table -->
  <table class="table table-striped">
    <tr>
      <td><b>Наименование</b></td>
      <td></td>
    </tr>
  <c:forEach items="${operTypes}" var="operType">
    <tr>
      <td><c:out value="${operType.name}" /></td>
      <td align="right">
      <form class="form-horizontal" action="do?command=ActionOperType" method="POST">
          <input type="hidden" name="id" value="${opertype.id}" />
          <button type="submit" class="btn btn-primary btn-xs" name="btnEdit">Редактировать</button>
          <button type="submit" class="btn btn-primary btn-xs" name="btnDelete">Удалить</button>
      </form>
      </td>
    </tr>
  </c:forEach>
  </table>
</div>

<%@ include file="include/end-html.jsp" %>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="btn-group" role="group">
  <a href="do?command=AddOperType" class="btn btn-primary" role="button">Добавить тип операции</a>
</div>
<p></p>

<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Справочник типов операций</div>
  <!-- Table -->
  <table class="table">
    <tr>
      <td><b>Наименование</b></td>
    </tr>
  <c:forEach items="${operTypes}" var="operType">
    <tr>
      <td><c:out value="${operType.name}" /></td>
      <td align="right">
          <button type="button" class="btn btn-primary btn-xs">Редактировать</button>
          <button type="button" class="btn btn-primary btn-xs">Удалить</button>
      </td>
    </tr>
  </c:forEach>
  </table>
</div>

<%@ include file="include/end-html.jsp" %>

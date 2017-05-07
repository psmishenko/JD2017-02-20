<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="btn-group" role="group">
  <a href="do?command=AddBank" class="btn btn-primary" role="button">Добавить банк</a>
</div>
<p></p>

<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Справочник банков</div>
  <!-- Table -->
  <table class="table">
    <tr>
      <td><b>Наименование банка</b></td>
      <td><b>БИК</b></td>
      <td><b>Страна</b></td>
      <td><b>Группа</b></td>
    </tr>
  <c:forEach items="${banks}" var="bank">
    <tr>
      <td><c:out value="${bank.name}" /></td>
      <td><c:out value="${bank.bic}" /></td>
      <td><c:out value="${bank.country.name}" /></td>
      <td><c:out value="${bank.groupBank.name}" /></td>
      <td align="right">
          <button type="button" class="btn btn-primary btn-xs">Редактировать</button>
          <button type="button" class="btn btn-primary btn-xs">Удалить</button>
      </td>
    </tr>
  </c:forEach>
  </table>
</div>

<%@ include file="include/end-html.jsp" %>

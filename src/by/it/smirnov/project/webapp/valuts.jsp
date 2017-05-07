<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="btn-group" role="group">
  <a href="do?command=AddValut" class="btn btn-primary" role="button">Добавить валюту</a>
</div>
<p></p>

<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Справочник валют</div>
  <!-- Table -->
  <table class="table">
    <tr>
      <td><b>Код</b></td>
      <td><b>Сокращенное наименование</b></td>
      <td><b>Полное наименование</b></td>
    </tr>
  <c:forEach items="${valuts}" var="valut">
    <tr>
      <td><c:out value="${valut.id}" /></td>
      <td><c:out value="${valut.namesokr}" /></td>
      <td><c:out value="${valut.namefull}" /></td>
      <td align="right">
          <button type="button" class="btn btn-primary btn-xs">Редактировать</button>
          <button type="button" class="btn btn-primary btn-xs">Удалить</button>
      </td>
    </tr>
  </c:forEach>
  </table>
</div>

<%@ include file="include/end-html.jsp" %>

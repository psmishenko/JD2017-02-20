<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="btn-group" role="group">
  <a href="do?command=actionValut" class="btn btn-primary" role="button">Добавить валюту</a>
</div>
<p></p>

<div class="panel panel-primary">
  <!-- Default panel contents -->
  <div class="panel-heading">Справочник валют</div>
  <!-- Table -->
  <table class="table table-striped">
    <tr>
      <td><b>Код</b></td>
      <td><b>Сокращенное наименование</b></td>
      <td><b>Полное наименование</b></td>
      <td></td>
    </tr>
  <c:forEach items="${valuts}" var="valut">
    <tr>
      <td><c:out value="${valut.id}" /></td>
      <td><c:out value="${valut.namesokr}" /></td>
      <td><c:out value="${valut.namefull}" /></td>
      <td align="right">
      <form class="form-horizontal" action="do?command=ActionValut" method="POST">
          <input type="hidden" name="id" value="${valut.id}" />
          <button type="submit" class="btn btn-primary btn-xs" name="btnEdit">Редактировать</button>
          <button type="submit" class="btn btn-primary btn-xs" name="btnDelete">Удалить</button>
      </form>
      </td>
    </tr>
  </c:forEach>
  </table>
</div>

<%@ include file="include/end-html.jsp" %>

<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="btn-group" role="group">
  <a href="do?command=AddKursValut" class="btn btn-primary" role="button">Добавить курс</a>
</div>
<p></p>

<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Журнал курсов валют</div>
  <!-- Table -->
  <table class="table">
    <tr>
      <td><b>Дата</b></td>
      <td><b>Сумма</b></td>
      <td><b>Валюта</b></td>
      <td><b>Сумма</b></td>
      <td><b>Валюта</b></td>
    </tr>
  <c:forEach items="${kursvaluts}" var="kursvalut">
    <tr>
      <td><c:out value="${kursvalut.datekurs}" /></td>
      <td><c:out value="${kursvalut.za}" /></td>
      <td><c:out value="${kursvalut.zavalut.namesokr}" /></td>
      <td><c:out value="${kursvalut.dat}" /></td>
      <td><c:out value="${kursvalut.datvalut.namesokr}" /></td>
      <td align="right">
          <button type="button" class="btn btn-primary btn-xs">Редактировать</button>
          <button type="button" class="btn btn-primary btn-xs">Удалить</button>
      </td>
    </tr>
  </c:forEach>
  </table>
</div>

<%@ include file="include/end-html.jsp" %>

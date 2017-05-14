<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="btn-group" role="group">
  <a href="do?command=actionKursValut" class="btn btn-primary" role="button">Добавить курс</a>
</div>
<p></p>

<div class="panel panel-primary">
  <!-- Default panel contents -->
  <div class="panel-heading">Журнал курсов валют</div>
  <!-- Table -->
  <table class="table table-striped">
    <tr>
      <td><b>Дата</b></td>
      <td><b>Сумма</b></td>
      <td><b>Валюта</b></td>
      <td><b>Сумма</b></td>
      <td><b>Валюта</b></td>
      <td></td>
    </tr>
  <c:forEach items="${kursvaluts}" var="kursvalut">
    <tr>
      <td><c:out value="${kursvalut.datekurs}" /></td>
      <td><c:out value="${kursvalut.za}" /></td>
      <td><c:out value="${kursvalut.zavalut.namesokr}" /></td>
      <td><c:out value="${kursvalut.dat}" /></td>
      <td><c:out value="${kursvalut.datvalut.namesokr}" /></td>
      <td align="right">
      <form class="form-horizontal" action="do?command=ActionKursValut" method="POST">
          <input type="hidden" name="id" value="${kursvalut.id}" />
          <button type="submit" class="btn btn-primary btn-xs" name="btnEdit">Редактировать</button>
          <button type="submit" class="btn btn-primary btn-xs" name="btnDelete">Удалить</button>
      </form>
      </td>
    </tr>
  </c:forEach>
  </table>
</div>

<%@ include file="include/end-html.jsp" %>

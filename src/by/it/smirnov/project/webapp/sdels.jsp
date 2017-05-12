<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="btn-group" role="group">
  <a href="do?command=ActionSdel" class="btn btn-primary" role="button">Добавить сделку</a>
</div>
<p></p>

<div class="panel panel-primary">
  <!-- Default panel contents -->
  <div class="panel-heading">Журнал сделок</div>
  <!-- Table -->
  <table class="table table-striped">
    <tr>
      <td><b>Наименование банка</b></td>
      <td><b>Сумма</b></td>
      <td><b>Валюта</b></td>
      <td><b>Тип операции</b></td>
      <td><b>С даты</b></td>
      <td><b>По дату</b></td>
      <td></td>
    </tr>
  <c:forEach items="${sdels}" var="sdel">
    <tr>
      <td><c:out value="${sdel.bank.name}" /></td>
      <td><c:out value="${sdel.summa}" /></td>
      <td><c:out value="${sdel.valut.namesokr}" /></td>
      <td><c:out value="${sdel.operType.name}" /></td>
      <td><c:out value="${sdel.fromdate}" /></td>
      <td><c:out value="${sdel.todate}" /></td>
      <td align="right">
      <form class="form-horizontal" action="do?command=ActionSdel" method="POST">
          <input type="hidden" name="id" value="${sdel.id}" />
          <button type="submit" class="btn btn-primary btn-xs" name="btnEdit">Редактировать</button>
          <button type="submit" class="btn btn-primary btn-xs" name="btnDelete">Удалить</button>
      </form>
      </td>
    </tr>
  </c:forEach>
  </table>
</div>

<%@ include file="include/end-html.jsp" %>

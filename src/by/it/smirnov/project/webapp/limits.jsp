<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="btn-group" role="group">
  <a href="do?command=actionLimit" class="btn btn-primary" role="button">Добавить лимит</a>
</div>
<p></p>

<div class="panel panel-primary">
  <!-- Default panel contents -->
  <div class="panel-heading">Журнал лимитов</div>
  <!-- Table -->
  <table class="table table-striped">
    <tr>
      <td><b>Наименование групы банков</b></td>
      <td><b>Тип операции</b></td>
      <td><b>С даты</b></td>
      <td><b>Сумма</b></td>
      <td><b>Валюта</b></td>
      <td></td>
    </tr>
  <c:forEach items="${limits}" var="limit">
    <tr>
      <td><c:out value="${limit.groupbank.name}" /></td>
      <td><c:out value="${limit.opertype.name}" /></td>
      <td><c:out value="${limit.fromdate}" /></td>
      <td><c:out value="${limit.summa}" /></td>
      <td><c:out value="${limit.valut.namesokr}" /></td>
      <td align="right">
      <form class="form-horizontal" action="do?command=ActionLimit" method="POST">
          <input type="hidden" name="id" value="${limit.id}" />
          <button type="submit" class="btn btn-primary btn-xs" name="btnEdit">Редактировать</button>
          <button type="submit" class="btn btn-primary btn-xs" name="btnDelete">Удалить</button>
      </form>
      </td>
    </tr>
  </c:forEach>
  </table>
</div>

<%@ include file="include/end-html.jsp" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${admin == 1}" >
  <div class="btn-group" role="group">
    <a href="do?command=actionBank" class="btn btn-primary" role="button">Добавить банк</a>
  </div>
</c:if>

<p></p>

<div class="panel panel-primary">
  <!-- Default panel contents -->
  <div class="panel-heading">Справочник банков</div>
  <!-- Table -->
  <table class="table table-striped">
    <tr>
      <td><b>Наименование банка</b></td>
      <td><b>БИК</b></td>
      <td><b>Страна</b></td>
      <td><b>Группа</b></td>
      <c:if test="${admin == 1}" >
        <td></td>
      </c:if>
    </tr>
  <c:forEach items="${banks}" var="bank">
    <tr>
      <td><c:out value="${bank.name}" /></td>
      <td><c:out value="${bank.bic}" /></td>
      <td><c:out value="${bank.country.name}" /></td>
      <td><c:out value="${bank.groupBank.name}" /></td>
      <c:if test="${admin == 1}" >
        <td align="right">
        <form class="form-horizontal" action="do?command=ActionBank" method="POST">
            <input type="hidden" name="id" value="${bank.id}" />
            <button type="submit" class="btn btn-primary btn-xs" name="btnEdit">Редактировать</button>
            <button type="submit" class="btn btn-primary btn-xs" name="btnDelete">Удалить</button>
        </form>
        </td>
      </c:if>
    </tr>
  </c:forEach>
  </table>
</div>

<%@ include file="include/end-html.jsp" %>

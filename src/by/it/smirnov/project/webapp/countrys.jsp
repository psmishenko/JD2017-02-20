<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="btn-group" role="group">
  <a href="do?command=actionCountry" class="btn btn-primary" role="button">Добавить страну</a>
</div>
<p></p>

<div class="panel panel-primary">
  <!-- Default panel contents -->
  <div class="panel-heading">Справочник стран</div>
  <!-- Table -->
  <table class="table table-striped">
    <tr>
      <td><b>Наименование</b></td>
      <td></td>
    </tr>
  <c:forEach items="${countrys}" var="country">
    <tr>
      <td><c:out value="${country.name}" /></td>
      <td align="right">
      <form class="form-horizontal" action="do?command=ActionCountry" method="POST">
          <input type="hidden" name="id" value="${country.id}" />
          <button type="submit" class="btn btn-primary btn-xs" name="btnEdit">Редактировать</button>
          <button type="submit" class="btn btn-primary btn-xs" name="btnDelete">Удалить</button>
      </form>
      </td>
    </tr>
  </c:forEach>
  </table>
</div>

<%@ include file="include/end-html.jsp" %>

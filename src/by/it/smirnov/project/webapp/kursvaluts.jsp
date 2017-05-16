<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<c:if test="${admin == 1}" >
<div class="btn-group" role="group">
  <a href="do?command=actionKursValut" class="btn btn-primary" role="button">Добавить курс</a>
</div>
</c:if>
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
<c:if test="${admin == 1}" >
      <td></td>
</c:if>
    </tr>
  <c:forEach items="${kursvaluts}" var="kursvalut">
    <tr>
      <td><fmt:formatDate pattern = "dd.MM.yyyy" value = "${kursvalut.datekurs}" /></td>
      <td>
        <fmt:setLocale value = "ru_RU"/>
        <fmt:formatNumber value = "${kursvalut.za}" type = "number"/>
      </td>
      <td><c:out value="${kursvalut.zavalut.namesokr}" /></td>
      <td>
        <fmt:setLocale value = "ru_RU"/>
        <fmt:formatNumber value = "${kursvalut.dat}" type = "number"/>
      </td>
      <td><c:out value="${kursvalut.datvalut.namesokr}" /></td>
<c:if test="${admin == 1}" >
      <td align="right">
      <form class="form-horizontal" action="do?command=ActionKursValut" method="POST">
          <input type="hidden" name="id" value="${kursvalut.id}" />
          <button type="submit" class="btn btn-primary btn-xs" name="btnEdit">Редактировать</button>
          <button type="submit" class="btn btn-primary btn-xs" name="btnDelete">Удалить</button>
      </form>
      </td>
</c:if>
    </tr>
  </c:forEach>
  </table>
</div>

<p></p>

<t:paginator prefix="Страница: " currstart="${param.start}" count="${countRec}" step="10" urlprefix="?command=KursValuts&start="/>


<%@ include file="include/end-html.jsp" %>

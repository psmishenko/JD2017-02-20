<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="jumbotron">
  <h1>Добро пожаловать<c:if test="${user != null}" >, <c:out value="${user.name}"/></c:if>!</h1>
  <p>ПК "Лимиты на банки-контрагенты"</p>
</div>
<%@ include file="include/end-html.jsp" %>
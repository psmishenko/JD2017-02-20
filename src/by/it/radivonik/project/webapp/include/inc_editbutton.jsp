<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="nameAction" scope="page" value="exec" />
<c:set var="classBtn" scope="page" value="btn-success" />
<c:set var="nameBtn" scope="page" value="Сохранить" />

<c:if test='${param.action.equals("create") || param.action.equals("update") || param.action.equals("delete")}'>
  <c:set var="nameAction" scope="page" value="${param.action}_exec" />
</c:if>
<c:if test='${action.equals("create_exec") || action.equals("update_exec") || action.equals("delete_exec")}'>
  <c:set var="nameAction" scope="page" value="${action}" />
</c:if>
<c:if test='${param.action.equals("delete") || action.equals("delete_exec")}'>
  <c:set var="classBtn" scope="page" value="btn-danger" />
  <c:set var="nameBtn" scope="page" value="Удалить" />
</c:if>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="action"></label>
  <div class="col-md-4">
    <button class="btn ${classBtn}" type="submit" id="action" name="action" value="${nameAction}">
    <c:out value="${nameBtn}"/>
    </button>
  </div>
</div>

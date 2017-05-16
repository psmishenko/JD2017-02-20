<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/inc_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="do" method="post">
<fieldset>

<!-- Form Name -->
<legend>Товарная накладная</legend>

<input type="hidden" name="command" value="NakladEdit" />
<input type="hidden" name="id" value="${naklad.id}">
<c:choose>
<c:when test='${param.action.equals("create") || action.equals("create_exec")}'>
<input type="hidden" name="id_user" value="${userActive.id}">
</c:when>
<c:otherwise>
<input type="hidden" name="id_user" value="${naklad.user.id}">
</c:otherwise>
</c:choose>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="type">Тип</label>
  <div class="col-md-4">
    <select class="form-control" id="type" name="id_type">
      <c:forEach var="type" items="${typenaklads_spr}">
        <option value="${type.id}" <c:if test="${type.id == naklad.type.id}">selected</c:if>>${type.name}</option>
      </c:forEach>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="date">Дата</label>
  <div class="col-md-4">
    <input class="form-control input-md" type="date" id="date" name="date" value="${naklad.date}" placeholder="" required="true">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="num">Номер</label>
  <div class="col-md-4">
    <input class="form-control input-md" type="text" id="num" name="num" value="${naklad.num}" placeholder="" required="true">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="seria">Серия</label>
  <div class="col-md-4">
    <input class="form-control input-md" type="text" id="seria" name="seria" value="${naklad.seria}" placeholder="" required="true">
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="klient">Клиент</label>
  <div class="col-md-4">
    <select class="form-control" id="klient" name="id_klient">
      <c:forEach var="klient" items="${klients_spr}">
        <option value="${klient.id}" <c:if test="${klient.id == naklad.klient.id}">selected</c:if>>${klient.name}</option>
      </c:forEach>
    </select>
  </div>
</div>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="avto">Автомобиль</label>
  <div class="col-md-4">
    <select class="form-control" id="avto" name="id_avto">
      <option value=""/>
      <c:forEach var="avto" items="${avtos_spr}">
        <option value="${avto.id}" <c:if test="${avto.id == naklad.avto.id}">selected</c:if>>${avto.numgos} ${avto.voditel}</option>
      </c:forEach>
    </select>
  </div>
</div>

<%@ include file="include/inc_editbutton.jsp" %>

</fieldset>
</form>

<%@ include file="include/inc_footer.jsp" %>

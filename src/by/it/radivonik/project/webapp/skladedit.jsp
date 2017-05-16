<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/inc_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="do" method="post">
<fieldset>

<!-- Form Name -->
<legend>Товар на складе</legend>

<input type="hidden" name="command" value="SkladEdit" />
<input type="hidden" name="id" value="${sklad.id}">
<c:choose>
<c:when test='${param.action.equals("create") || action.equals("create_exec")}'>
<input type="hidden" name="id_user" value="${userActive.id}">
</c:when>
<c:otherwise>
<input type="hidden" name="id_user" value="${sklad.user.id}">
</c:otherwise>
</c:choose>

<!-- Select Basic -->
<div class="form-group">
  <label class="col-md-4 control-label" for="tovar">Товар</label>
  <div class="col-md-4">
    <select class="form-control" id="tovar" name="id_tovar">
      <c:forEach var="tovar" items="${tovars_spr}">
        <option value="${tovar.id}" <c:if test="${tovar.id == sklad.tovar.id}">selected</c:if>>${tovar.name}</option>
      </c:forEach>
    </select>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="count">Количество</label>
  <div class="col-md-4">
    <input class="form-control input-md" type="number" step="any" id="count" name="count" value="${sklad.count}" placeholder="" required="true">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="cena">Цена</label>
  <div class="col-md-4">
    <input class="form-control input-md" type="number" step="any" id="cena" name="cena" value="${sklad.cena}" placeholder="" required="true">
  </div>
</div>

<%@ include file="include/inc_editbutton.jsp" %>

</fieldset>
</form>

<%@ include file="include/inc_footer.jsp" %>

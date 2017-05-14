<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="inc_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="do" method="post">
<fieldset>

<!-- Form Name -->
<legend>Товар на складе</legend>

<input type="hidden" name="command" value="SkladEdit" />
<input type="hidden" name="id" value="${sklad.id}">
<input type="hidden" name="id_user" value="${userActive.id}">

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
    <input class="form-control input-md" type="text" id="count" name="count" value="${sklad.count}" placeholder="" required="true">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="cena">Цена</label>
  <div class="col-md-4">
    <input class="form-control input-md" type="text" id="cena" name="cena" value="${sklad.cena}" placeholder="" required="true">
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="action"></label>
  <div class="col-md-4">
    <c:if test='${param.action.equals("create") || param.action.equals("update")}'>
    <button class="btn btn-success" type="submit" id="action" name="action" value="${param.action}_exec">
    Сохранить
    </button>
    </c:if>
    <c:if test='${param.action.equals("delete")}'>
    <button class="btn btn-danger" type="submit" id="action" name="action" value="${param.action}_exec">
    Удалить
    </button>
    </c:if>
  </div>
</div>

</fieldset>
</form>

<%@ include file="inc_footer.jsp" %>

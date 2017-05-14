<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="inc_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="do" method="post">
<fieldset>

<!-- Form Name -->
<legend>Товар</legend>

<input type="hidden" name="command" value="TovarEdit" />
<input type="hidden" name="id" value="${tovar.id}">

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="name">Наименование</label>
  <div class="col-md-4">
    <input class="form-control input-md" type="text" id="name" name="name" value="${tovar.name}" placeholder="" required="true">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="edizm">Единица измерения</label>
  <div class="col-md-4">
    <input class="form-control input-md" type="text" id="edizm" name="edizm" value="${tovar.edizm}" placeholder="" required="true">
  </div>
</div>

<%@ include file="inc_editbutton.jsp" %>

</fieldset>
</form>

<%@ include file="inc_footer.jsp" %>

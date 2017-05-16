<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/inc_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-horizontal" action="do" method="post">
<fieldset>

<!-- Form Name -->
<legend>Автомобиль</legend>

<input type="hidden" name="command" value="AvtoEdit" />
<input type="hidden" name="id" value="${avto.id}">

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="numgos">Гос. номер</label>
  <div class="col-md-4">
    <input class="form-control input-md" type="text" id="numgos" name="numgos" value="${avto.numgos}" placeholder="" required="true">
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="voditel">Водитель (ФИО)</label>
  <div class="col-md-4">
    <input class="form-control input-md" type="text" id="voditel" name="voditel" value="${avto.voditel}" placeholder="" required="true">
  </div>
</div>

<%@ include file="include/inc_editbutton.jsp" %>

</fieldset>
</form>

<%@ include file="include/inc_footer.jsp" %>

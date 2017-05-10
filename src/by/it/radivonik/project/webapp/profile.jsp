<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="inc_header.jsp" %>

<p>User debug: ${userActive}</p>

<form class="form-horizontal" action="do?command=Logout" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Профиль</legend>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-primary">Выход</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="inc_footer.jsp" %>
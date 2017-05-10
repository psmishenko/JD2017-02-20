<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<p>User debug: ${user}</p>

<p>User ads: ${ads}</p>

<form class="form-horizontal"  action="do?command=profile" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Выход</legend>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-danger">Logout</button>
  </div>
</div>

</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
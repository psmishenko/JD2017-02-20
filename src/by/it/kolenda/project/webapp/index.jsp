<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ include file="include/begin-html.jsp" %>

<p>INDEX: ${message}</p>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>index</legend>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="textarea">Index text</label>
  <div class="col-md-4">
    <textarea class="form-control" id="textarea" name="textarea">Hello friend!</textarea>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>
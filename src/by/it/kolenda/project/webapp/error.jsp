<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ include file="include/begin-html.jsp" %>

<p>Cmd ERROR: ${message}</p>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Error</legend>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="textarea">Error Text</label>
  <div class="col-md-4">
    <textarea class="form-control" id="textarea" name="textarea">You did something wrong!</textarea>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>



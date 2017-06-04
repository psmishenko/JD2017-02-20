<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal">
<fieldset>

<!-- Form Name -->
<legend>Error page</legend>

<!-- Textarea -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Error">Error</label>
  <div class="col-md-4">
    <textarea class="form-control" id="Error" name="Error">- Unfortunately the data in previous page was input incorrectly or not fully.
- Unfortunately You operation is not correct on previous page
- Unfortunately We have some issue with internet connetction.

Please, press 'Return' button and try it again</textarea>
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="Return">Return</label>
  <div class="col-md-4">
    <button id="Return" name="Return" class="btn btn-warning">Return</button>
  </div>
</div>

</fieldset>
</form>

<p>Cmd ERROR: ${message}</p>

<%@ include file="include/end-html.jsp" %>



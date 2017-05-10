<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=addbook" method="POST">
<fieldset>

<!-- Form Name -->
<legend align="center">Add new book</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="author">Author</label>  
  <div class="col-md-6">
  <input id="author" name="author" type="text" placeholder="author" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="title">Title</label>  
  <div class="col-md-6">
  <input id="title" name="title" type="text" placeholder="title" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="year">Year</label>  
  <div class="col-md-2">
  <input id="year" name="year" type="text" placeholder="year" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="isbn">ISBN</label>  
  <div class="col-md-6">
  <input id="isbn" name="isbn" type="text" placeholder="ISBN" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="lid">LID</label>  
  <div class="col-md-6">
  <input id="lid" name="lid" type="text" placeholder="LID" class="form-control input-md" required="">
    
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="accept"></label>
  <div class="col-md-4">
    <button id="accept" name="accept" class="btn btn-success">Save</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>
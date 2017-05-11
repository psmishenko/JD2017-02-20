<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


<form class="form-horizontal" action="do?command=Search" method="GET">
<fieldset>

<!-- Form Name -->
<legend>Search</legend>

<!-- Search input-->
<div class="form-group">
  <label class="col-md-4 control-label" for="SearchBar"> </label>
  <div class="col-md-5">
    <input id="SearchBar" name="SearchBar" type="search" placeholder="BookTitle, Author" class="form-control input-md">

  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="singlebutton"></label>
  <div class="col-md-4">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Search!</button>
  </div>
</div>

</fieldset>
</form>

<p>Cmd SEARCH: ${message}</p>


<%@ include file="include/end-html.jsp" %>
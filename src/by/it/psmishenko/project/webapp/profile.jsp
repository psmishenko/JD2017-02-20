<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="page-header">
  <h1>Данные профиля</h1>
  <div class="row">
    <div class="col-md-1">Ваш логин: ${user.login}</div>
    <div class="col-md-1">Ваш Email: ${user.email}</div>
  </div>
</div>
<div class="panel-heading">My Books</div>
 <!-- Table -->
  <table class="table">
   <tr>
   	<th>Author</th>
   	<th>Title</th>
   	<th>Year</th>
   	<th>ISBN</th>
   	<th>LID</th>
   </tr>
    <c:forEach  items="${books}" var="book"  >
   <tr>
 <td>${book.author}</td>
 <td>${book.title}</td>
 <td>${book.year}</td>
 <td>${book.isbn}</td>
 <td>${book.lid}</td>
</c:forEach>
   </tr>
  </table>

<form class="form-horizontal"  action="do?command=profile" method="POST">
<fieldset>
<legend>Выход</legend>
<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-danger">Logout</button>
  </div>
</div>

</fieldset>
</form>


<%@ include file="include/end-html.jsp" %>
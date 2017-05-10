<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">All Books</div>

  <!-- Table -->
  <table class="table">
   <tr>
   	<th>Author</th>
   	<th>Title</th>
   	<th>Year</th>
   	<th>ISBN</th>
   	<th>LID</th>
   	<th>Add to My Books</th>
   </tr>
   <tr>
   
   </tr>
  </table>
  <p>All books: ${allbooks}</p>
  <p>Если пользователь незалогинен - кнопки Add to My Books будут заблокированы или переводить на login</p>
</div>

<%@ include file="include/end-html.jsp" %>
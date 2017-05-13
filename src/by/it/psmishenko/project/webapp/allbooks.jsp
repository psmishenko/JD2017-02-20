<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">All Books</div>

  <!-- Table -->
  <table class="table">
   <tr>
    <th>ID</th>
   	<th>Author</th>
   	<th>Title</th>
   	<th>Year</th>
   	<th>ISBN</th>
   	<th>LID</th>
   	<th></th>
   </tr>
    <c:forEach  items="${allbooks}" var="book"  >
   <tr>
  <td>${book.id}</td>
 <td>${book.author}</td>
 <td>${book.title}</td>
 <td>${book.year}</td>
 <td>${book.isbn}</td>
 <td>${book.lid}</td>
<td>
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Add to My books</button>
  </td>
</c:forEach>
   </tr>
  </table>
</div>

<%@ include file="include/end-html.jsp" %>
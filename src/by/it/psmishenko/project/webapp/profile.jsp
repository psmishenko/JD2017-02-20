<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="page-header">
  <h2 align="center">My profile</h2>
  <div class="row">
    <div class="col-md-2">Login: ${user.login}</div>
    <div class="col-md-2">Email: ${user.email}</div>
   <div class="col-md-2"> 
    <form class="form-horizontal"  action="do?command=profile" method="POST">
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-danger">Logout</button>
  </div>
</form>
</div>
  </div>
</div>
<div class="panel panel-default">
<div class="panel-heading">My Books</div>
 <!-- Table -->
  <table class="table">
   <tr>
   	<th>Author</th>
   	<th>Title</th>
   	<th>Year</th>
   	<th>ISBN</th>
   	<th>LID</th>
    <th></th>
    <th></th>
   </tr>
    <c:forEach  items="${books}" var="book"  >
   <tr>
 <td>${book.author}</td>
 <td>${book.title}</td>
 <td>${book.year}</td>
 <td>${book.isbn}</td>
 <td>${book.lid}</td>
<td>
 <form class="form-edit-userbook-${book.id}" action="do" method=GET>
       <input type="hidden" name="id" value="${book.id}"/>
        <input type="hidden" name="command" value="EditUserBook"/>
                <div class=col-md-1>
                    <button id="edituserbook" class="btn btn-success">
                      Edit (doesn't work)
                    </button>
                </div>
    </form>
 </td>
 <td>
 <form class="form-del-userbook-${book.id}" action="do?command=DeleteUserBook" method=POST>
       <input type="hidden" name="id" value="${book.id}"/>
                <div class=col-md-1>
                    <button id="Del" name="DelBook" class="btn btn-danger">
                      Delete
                    </button>
                </div>
    </form>
 </td>
</c:forEach>
   </tr>
  </table>
</div>
<div align="center">
<t:paginator count="${bookCount}" step="5" urlprefix="?command=Profile&start="/>
</div>
<%@ include file="include/end-html.jsp" %>
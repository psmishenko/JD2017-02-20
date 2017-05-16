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
    <th>User</th>
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
 <td>   <c:forEach items="${users}" var="user">
 <c:if test="${book.fk_users==user.id}" >${user.login}</c:if> 
   </c:forEach>
</td>
<td>
    <form class="form-user-${book.id}" action="do?command=AllBooks" method=POST>
       <input type="hidden" name="id" value="${book.id}"/>
                <div class=col-md-1>
<c:choose>
<c:when test="${book.fk_users==user.id}">
<button id="Add" name="AddBook" class="btn btn-primary" disabled="disabled">
                      Add to My books
                    </button>
</c:when>

                  <c:otherwise>
<button id="Add" name="AddBook" class="btn btn-primary">
                      Add to My books
                    </button>
                  </c:otherwise>
</c:choose>
                </div>
    </form>
  </td>
</c:forEach>
   </tr>
  </table>
</div>
<div align="center">
<t:paginator count="${bookCount}" step="8" urlprefix="?command=AllBooks&start="/></div>
<%@ include file="include/end-html.jsp" %>
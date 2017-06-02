<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
</div> <!-- container -->
<br><br><br><br><br><br>
<div class="navbar-fixed-bottom row">
<div class="container">
<c:if test="${user!=null}">
<c:if test="${user.fkRole==1}">
<nav class="navbar navbar-inverse">
  <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand">Admin panel</a>
      </div>
<ul class="nav nav navbar-nav navbar-left">

            <li><a href=do?command=catalog>catalog</a></li>
            <li><a href=do?command=editblacklist>Edit Black List</a></li>
            <li><a href=do?command=editcatalog>Edit Catalog</a></li>
</ul>
</nav>
</div>
</div>
</c:if>
</c:if>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<h2>${message}</h2>
<div class="row">
<c:forEach items="${blacklist}" var="blacklist">

  <div class="col-sm-6 col-md-4">
    <div class="thumbnail">
      <div class="caption">
        <h2>${blacklist.blacklist}</h2>
        <form action="do?command=blacklist" method="POST">
                 <input type="hidden" name="id" value="${blacklist.Black_list_ID}"/>


                <p><button class="btn btn-success" name="chooselist">Select List</button></p>


                </form>
        <p>Client_id: ${blacklist.Client_id_fk} <span class="glyphicon glyphicon-globe" aria-hidden="true"></span></p>
      </div>
    </div>
  </div>

</c:forEach>
</div>



<%@ include file="include/end-html.jsp" %>



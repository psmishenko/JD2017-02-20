<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<p>Cmd CARS: ${cars}</p>

<c:forEach items="${cars}" var="car">
    <div class="row">
        <div class="col-md-1">${car.id} </div>

    </div>
    <!-- ${car.field} -->
</c:forEach>


<%@ include file="include/end-html.jsp" %>
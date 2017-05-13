<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="" method="POST">
    <h1>Current flights</h1>
    <fieldset>
        <div>
            <b>
                <div class = col-md-5>Destination</div>
                <div class = col-md-5>BrigadeID</div>
            </b>
        </div>

        <c:forEach items = "${flights}" var = "flight">
            <div class = col-md-5>${flight.destination}</div>
            <div class = col-md-5>${flight.brigadeID}</div>
        </c:forEach>
    </fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
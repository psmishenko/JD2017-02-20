<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<p>Authorized user: ${userlogin} ${userpasshash}</p>

<p>Список заданий:</p>

<div class="row">
    <div class="col-md-7">Наименование</div>
    <div class="col-md-2">Срок исполнения</div>
    <div class="col-md-1">Стоимость</div>
    <div class="col-md-2">Состояние</div>
</div>

<c:forEach items="${tasks}" var="task">
    <div class="row">
        <div class="col-md-7">${task.name} </div>
        <div class="col-md-2">${task.formattedEndDate} </div>
        <div class="col-md-1">${task.formattedPrice} </div>
        <div class="col-md-2">${task.statusName} </div>
    </div>
</c:forEach>


<%@ include file="include/end-html.jsp" %>
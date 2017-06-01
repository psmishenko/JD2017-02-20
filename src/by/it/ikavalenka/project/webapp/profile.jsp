
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<form class="form-horizontal" action="do?command=profile" method="POST">
<fieldset>

<!-- Form Name -->
<legend>Пользователь ${user.login}</legend>


<p>Ваш логин: <b>${user.login}</b></p>
<p>Ваши пасспортные данные: <b>${user.passportData}</b></p>
<p>Ваш E-mail: <b>${user.email}</b></p>

<legend>Арендованные машины</legend>
<c:forEach items="${orders}" var="order">
<c:forEach items="${cars}" var="car">
<c:if test="${order.fk_Cars==car.id}">
 <h4>Арендованная машина: ${car.mark} ${car.model}</h4>
 </c:if>
 </c:forEach>
    <div class="row">
        <div class="col-md-2">ID заказа: <b>${order.id}</b></div>
        <div class="col-md-3">Срок аренды: <b>${order.orderDuration} дней</b> </div>
        <div class="col-md-4">Номер карты: <b>${order.cardNumber}</b></div>
        <div class="col-md-3">Телефон: <b>${order.telephone}</b></div>
    </div>


</c:forEach>
<hr>
<!-- Button -->
<div class="form-group">
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-danger">Logout</button>
  </div>
</div>


</fieldset>
</form>

<%@ include file="include/end-html.jsp" %>
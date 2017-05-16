<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<h1>Все запчасти</h1>
<div class="row">
  <div class="col-md-2">Модель авто</div>
      <div class="col-md-2">Год выпуска</div>
      <div class="col-md-2">Запчасть</div>
      <div class="col-md-2">Тип двигателя</div>
      <div class="col-md-2">Объем двигателя</div>
</div>
<c:forEach items="${goods}" var="good">
    <div class="row">
        <div class="col-md-2">${good.modelCar} </div>
        <div class="col-md-2">${good.yearOfIssue} </div>
        <div class="col-md-2">${good.spare} </div>
        <div class="col-md-2">${good.typeEngine} </div>
        <div class="col-md-2">${good.capacityEngine} </div>
</div>
</c:forEach>
<br><br>



<%@ include file="include/end-html.jsp" %>



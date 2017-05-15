<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


<c:choose>
<c:when test="${admin.fkRole==1}">

<c:forEach items="${orders}" var="order">
<div class="well well-lg">

    <div class="row">Заказ #${order.id}</div>

<hr>
 <b>Данные клиента</b>
         <div class="row">
         <br>
<div class="row">
    <b>
        <div class=col-md-2>Пасспортные данные</div>
        <div class=col-md-3>Данные карты</div>
        <div class=col-md-1>Срок аренды</div>
        <div class=col-md-2>Телефон</div>
        <div class=col-md-1>ID Клиента</div>
        <div class=col-md-1>ID Автомобиля</div>
    </b>
</div>
        <form class="update-order-${order.id}" action="do?command=adminorders" method=POST>
             <div>
                            <input id="id" type="hidden" name="id"
                                   value="${order.id}"/>
                        </div>

            <b> <div class=col-md-2>
                    <input id="passportdata" class="form-control input-md" name="passportdata"
                           value="${order.passportData}"/>
                </div>
                <div class=col-md-3>
                    <input id="cardnumber" class="form-control input-md" name="cardnumber"
                           value="${order.cardNumber}"/>
                </div>

                <div class=col-md-1>
                                    <input id="orderduration" class="form-control input-md" name="orderduration"
                                           value="${order.orderDuration}"/>
                                </div>

                <div class=col-md-2>
                    <input id="telephone" class="col-md-2 form-control input-md" name="telephone"
                           value="${order.telephone}"/>
                </div>
                <div class=col-md-1>
                    <input id="fk_users" class="col-md-2 form-control input-md" name="fk_users"
                           value="${order.fk_Users}"/>
                </div>
                  <div class=col-md-1>
                    <input id="fk_users" class="col-md-2 form-control input-md" name="fk_cars"
                           value="${order.fk_Cars}"/>
                </div>

                <div class=col-md-1>
                    <button id="Update" name="Update" class="btn btn-success">
                        Обновить
                    </button>
                </div>

            </b>
        </form>
        <form class="form-order-${order.id}" action="do?command=adminorders" method=POST>
            <b>
                 <input type="hidden" name="id" value="${order.id}"/>
                <div class=col-md-1>
                    <button id="Delete" name="Delete" class="btn btn-danger">
                        Удалить
                    </button>
                </div>

            </b>
        </form>

    </div>
    <hr>
     <b>Данные автомобиля</b>
     <div class="row">
         <b>
             <div class=col-md-1>ID</div>
             <div class=col-md-3>Марка</div>
             <div class=col-md-3>Модель</div>
             <div class=col-md-2>Цена</div>
             <div class=col-md-2>HP</div>
         </b>
     </div>
    <c:forEach items="${cars}" var="car">
    <c:if test="${order.fk_Cars==car.id}">
    <div class="row">
     <div class=col-md-1>${car.id}</div>
     <div class=col-md-3>${car.mark}</div>
     <div class=col-md-3>${car.model}</div>
     <div class=col-md-2>${car.price}</div>
     <div class=col-md-2>${car.hp}</div>
     </div>
     </c:if>
     </c:forEach>


</div>
</c:forEach>
</c:when>
<c:otherwise>
<h1>Доступ запрещён</h1>
</c:otherwise>
</c:choose>

<%@ include file="include/end-html.jsp" %>



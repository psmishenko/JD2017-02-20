<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>




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
    </b>
</div>
        <form class="update-order-${order.id}" action="do?command=AdminOrders" method=POST>

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
                    <button id="Update" name="Update" class="btn btn-success">
                        Обновить
                    </button>
                </div>

            </b>
        </form>
        <form class="form-user-${user.id}" action="do?command=EditUsers" method=POST>
            <b>
                 <input type="hidden" name="id" value="${user.id}"/>
                <div class=col-md-1>
                    <button id="Delete" name="Delete" class="btn btn-danger">
                        Удалить
                    </button>
                </div>

            </b>
        </form>
    </div>
</div>
</c:forEach>


<p>Cmd ADMINORDERS: ${message}</p>

<%@ include file="include/end-html.jsp" %>



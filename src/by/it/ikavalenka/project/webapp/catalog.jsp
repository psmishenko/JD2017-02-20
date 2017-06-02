<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>


<c:choose>
<c:when test="${client.Client_ID==1}">

<c:forEach items="${client}" var="client">
<div class="well well-lg">

    <div class="row">Order #${client.order_ID}   <span class="label label-success">Done</span></div>

<hr>
 <b>Info</b>
         <div class="row">
         <br>
<div class="row">
    <b>
        <div class=col-md-2>Client_ID</div>
        <div class=col-md-3>Login</div>
        <div class=col-md-1>order_ID</div>
        <div class=col-md-2>cost_order</div>
    </b>
</div>
        <form class="update-order-${client.order_ID}" action="do?command=catalog" method=POST>
             <div>
                            <input id="id" type="hidden" name="id"
                                   value="${client.order_ID}/>
                        </div>

            <b> <div class=col-md-2>
                    <input id="Login" class="form-control input-md" name="Login"
                           value="${client.Login}"/>
                </div>
                                <div class=col-md-3>
                                    <input id="order_ID" class="form-control input-md" name="order_ID"
                                           value="${client.order_ID}"/>
                                </div>
                <div class=col-md-3>
                    <input id="cost_order" class="form-control input-md" name="cost_order"
                           value="${client.cost_order}"/>
                </div>

                <div class=col-md-1>
                    <button id="Update" name="Update" class="btn btn-success">
                        Refresh data
                    </button>
                </div>

            </b>
        </form>
        <form class="form-order-${client.order_ID}" action="do?command=catalog" method=POST>
            <b>
                 <input type="hidden" name="id" value="${client.order_ID}"/>
                <div class=col-md-1>
                    <button id="Delete" name="Delete" class="btn btn-danger">
                        Delete data
                    </button>
                </div>

            </b>
        </form>

    </div>
    <hr>
     <b>Client Information</b>
     <div class="row">
         <b>
             <div class=col-md-1>Client_ID</div>
             <div class=col-md-3>Login</div>
             <div class=col-md-3>Password</div>
             <div class=col-md-2>order_ID</div>
             <div class=col-md-2>cost_order</div>
         </b>
     </div>
    <c:forEach items="${client}" var="client">
    <c:if test="${administrator.FullOrder_id==client.Client_ID}">
    <div class="row">
     <div class=col-md-1>${client.Client_ID}</div>
     <div class=col-md-3>${client.Login}</div>
     <div class=col-md-3>${client.Password}</div>
     <div class=col-md-2>${client.order_ID}</div>
     <div class=col-md-2>${client.cost_order}</div>
     </div>
     </c:if>
     </c:forEach>


</div>
</c:forEach>
</c:when>
<c:otherwise>
<h1>Access  is banned</h1>
</c:otherwise>
</c:choose>

<%@ include file="include/end-html.jsp" %>



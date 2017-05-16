<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="row">
    <b>
<div class=col-md-1>id</div>
        <div class=col-md-2>Модель авто</div>
        <div class=col-md-2>Год выпуска</div>
        <div class=col-md-2>Запчасть</div>
        <div class=col-md-2>Тип двигателя</div>
        <div class=col-md-2>Объем двигателя</div>
    </b>
</div>
<br>


<c:forEach items="${goods}" var="good">
    <br>
    <div class="row">
<form class="delete-good-${good.id}" action="do?command=BuyGoods" method=POST>
            <b>
<div class=col-md-1>
                    <input id="id1" class="form-control input-md" name="id"
                           value="${good.id}"/>
                </div>
                <div class=col-md-2>
                    <input id="modelCar" class="form-control input-md" name="modelCar"
                           value="${good.modelCar}"/>
                </div>
                <div class=col-md-2>
                    <input id="yearOfIssue" class="form-control input-md" name="yearOfIssue"
                           value="${good.yearOfIssue}"/>
                </div>
                <div class=col-md-2>
                    <input id="spare" class="col-md-2 form-control input-md" name="spare"
                           value="${good.spare}"/>
                </div>

                <div class=col-md-2>
                <input id="typeEngine" class="col-md-2 form-control input-md" name="typeEngine"
                                           value="${good.typeEngine}"/>
                                </div>
                <div class=col-md-2>
                <input id="capacityEngine" class="col-md-2 form-control input-md" name="capacityEngine"
                                                           value="${good.capacityEngine}"/>
                                                </div>



                <div class=col-md-1>
                    <button id="Delete" name="Delete" class="btn btn-success">
                        Купить
                    </button>
                </div>

            </b>
        </form>

    </div>

</c:forEach>


<%@ include file="include/end-html.jsp" %>



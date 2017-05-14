<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="row">
    <b>
        <div class=col-md-2>Марка</div>
        <div class=col-md-2>Модель</div>
        <div class=col-md-1>Horse Power</div>
        <div class=col-md-2>Месторасположение</div>
        <div class=col-md-1>Вместимость багажника</div>
        <div class=col-md-1>Цена $</div>
        <div class=col-md-1>Мест для сидения</div>
        <div class=col-md-1>Средний расход</div>
    </b>
</div>
<br>

 <div class="row">
        <form class="create-cars-${car.id}" action="do?command=EditCars" method=POST>
            <b>
                <div class=col-md-2>
                    <input id="mark" class="form-control input-md" name="mark"/>
                </div>
                <div class=col-md-2>
                    <input id="model" class="form-control input-md" name="model"/>
                </div>

                <div class=col-md-1>
                   <input id="hp" class="form-control input-md" name="hp"/>
                 </div>

                <div class=col-md-2>
                    <input id="location" class="col-md-2 form-control input-md" name="location"/>
                </div>
                <div class=col-md-1>
                    <input id="luggagecapacity" class="col-md-2 form-control input-md" name="luggagecapacity"/>
                </div>
                <div class=col-md-1>
                    <input id="price" class="col-md-2 form-control input-md" name="price"/>
                </div>
                <div class=col-md-1>
                    <input id="seats" class="col-md-2 form-control input-md" name="seats"/>
                </div>
                <div class=col-md-1>
                    <input id="fuelconsumption" class="col-md-2 form-control input-md" name="fuelconsumption"/>
                </div>

<br><br>
                <div class=col-md-2>
                    <button id="Create" name="Create" class="btn btn-success">
                        Create <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                    </button>
                </div>

            </b>
        </form>
        </div>

<c:forEach items="${cars}" var="car">
    <hr>
    <div class="row">
        <form class="update-cars-${car.id}" action="do?command=EditCars" method=POST>
            <b>
                <div class=col-md-1>
                    <input disabled id="id" class="form-control input-md" name="showid"
                           value="${car.id}"/>

                </div>
                <div>
                    <input type="hidden" id="id" class="form-control input-md" name="id"
                           value="${car.id}"/>

                </div>
                <div class=col-md-2>
                    <input id="mark" class="form-control input-md" name="mark"
                           value="${car.mark}"/>
                </div>
                <div class=col-md-2>
                    <input id="model" class="form-control input-md" name="model"
                           value="${car.model}"/>
                </div>

                <div class=col-md-1>
                   <input id="hp" class="form-control input-md" name="hp"
                                           value="${car.hp}"/>
                 </div>

                <div class=col-md-2>
                    <input id="location" class="col-md-2 form-control input-md" name="location"
                           value="${car.location}"/>
                </div>
                <div class=col-md-1>
                    <input id="luggagecapacity" class="col-md-2 form-control input-md" name="luggagecapacity"
                           value="${car.luggageCapacity}"/>
                </div>
                <div class=col-md-1>
                    <input id="price" class="col-md-2 form-control input-md" name="price"
                           value="${car.price}"/>
                </div>
                <div class=col-md-1>
                    <input id="seats" class="col-md-2 form-control input-md" name="seats"
                           value="${car.seats}"/>
                </div>
                <div class=col-md-1>
                    <input id="fuelconsumption" class="col-md-2 form-control input-md" name="fuelconsumption"
                           value="${car.fuelConsumption}"/>
                </div>

<br><br>
                <div class=col-md-2>
                    <button id="Update" name="Update" class="btn btn-info">
                        Обновить <span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>
                    </button>
                </div>

            </b>
        </form>
        <form class="form-cars-${car.id}" action="do?command=EditCars" method=POST>
            <b>
                 <input type="hidden" name="id" value="${car.id}"/>
                <div class=col-md-2>
                    <button id="Delete" name="Delete" class="btn btn-danger">
                        Удалить <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    </button>
                </div>

            </b>
        </form>
    </div>

</c:forEach>
${message}

<%@ include file="include/end-html.jsp" %>



<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<c:choose>
<c:when test="${admin.fkRole==1}">
<div class="row">
    <b>
        <div class=col-md-1>ID</div>
        <div class=col-md-2>Имя</div>
        <div class=col-md-2>Пароль</div>
        <div class=col-md-2>Пасспортные данные</div>
        <div class=col-md-2>Email</div>
        <div class=col-md-2>Роль</div>
    </b>
</div>
<br>

 <div class="row">
        <form class="update-user-${user.id}" action="do?command=EditUsers" method=POST>
            <b>
                <div class=col-md-1>

                </div>
                <div class=col-md-2>
                    <input id="login" class="form-control input-md" name="login"/>
                </div>
                <div class=col-md-2>
                    <input id="password" class="form-control input-md" name="password"/>
                </div>

                <div class=col-md-2>
                    <input id="password" class="form-control input-md" name="passportdata"/>
                </div>

                <div class=col-md-2>
                    <input id="email" class="col-md-2 form-control input-md" name="email"/>
                </div>
                     <div class=col-md-1>
                                        <button id="Create" name="Create" class="btn btn-success">
                                            Добавить <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                        </button>
                                        </b>
                                        </form>
                                    </div>

                                    </div>



<c:forEach items="${users}" var="user">
    <hr>
    <div class="row">
        <form class="update-user-${user.id}" action="do?command=EditUsers" method=POST>
            <b>
                <div class=col-md-1>
                    <input disabled id="id1" class="form-control input-md" name="showid"
                           value="${user.id}"/>
                </div>

                <div>
                    <input type="hidden" id="id1" class="form-control input-md" name="id"
                           value="${user.id}"/>
                </div>
                <div class=col-md-2>
                    <input id="login" class="form-control input-md" name="login"
                           value="${user.login}"/>
                </div>
                <div class=col-md-2>
                    <input id="password" class="form-control input-md" name="password"
                           value="${user.password}"/>
                </div>

                <div class=col-md-2>
                                    <input id="password" class="form-control input-md" name="passportdata"
                                           value="${user.passportData}"/>
                                </div>

                <div class=col-md-2>
                    <input id="email" class="col-md-2 form-control input-md" name="email"
                           value="${user.email}"/>
                </div>

                <div class=col-md-1>
                    <select id="role" name="fk_role" class="form-control">
                        <c:forEach items="${roles}" var="role">
                            <option value="${role.id}" role=${role.id} ${role.id==user.fkRole?"selected":""}>
                                    ${role.role}
                            </option>
                        </c:forEach>
                    </select>
                </div>


                <div class=col-md-1>
                    <button id="Update" name="Update" class="btn btn-info">
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
                        Удалить<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                    </button>
                </div>

            </b>
        </form>
    </div>

</c:forEach>
</c:when>
<c:otherwise>
<h1>Доступ запрещён</h1>
</c:otherwise>
</c:choose>
${message}

<%@ include file="include/end-html.jsp" %>



<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<c:choose>
<c:when test="${administrator.Adm_id==1}">
<div class="row">
    <b>
        <div class=col-md-1>Adm_id</div>
        <div class=col-md-2>Login</div>
        <div class=col-md-2>Password</div>
        <div class=col-md-2>Catalog</div>
        <div class=col-md-2>FullOrder_id</div>
        <div class=col-md-2>BlackList_id_fk</div>
    </b>
</div>
<br>

 <div class="row">
        <form class="update-catalog-${administrator.Adm_id}" action="do?command=EditCatalog" method=POST>
            <b>
                <div class=col-md-1>

                </div>
                <div class=col-md-2>
                    <input id="Login" class="form-control input-md" name="Login"/>
                </div>
                <div class=col-md-2>
                    <input id="Password" class="form-control input-md" name="Password"/>
                </div>

                <div class=col-md-2>
                    <input id="Catalog" class="form-control input-md" name="Catalog"/>
                </div>

                <div class=col-md-2>
                    <input id="FullOrder_id" class="col-md-2 form-control input-md" name="FullOrder_id"/>
                </div>
                          <div class=col-md-2>
                                    <input id="BlackList_id_fk" class="col-md-2 form-control input-md" name="BlackList_id_fk"/>
                                </div>
                     <div class=col-md-1>
                                        <button id="Create" name="Create" class="btn btn-success">
                                            Добавить <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                        </button>
                                        </b>
                                        </form>
                                    </div>

                                    </div>



<c:forEach items="${administrator}" var="administrator">
    <hr>
    <div class="row">
        <form class="update-administrator-${administrator.Adm_id}" action="do?command=EditCatalog" method=POST>
            <b>
                <div class=col-md-1>
                    <input disabled id="Id1" class="form-control input-md" name="showid"
                           value="${{administrator.Adm_id}"/>
                </div>

                <div>
                    <input type="hidden" id="id1" class="form-control input-md" name="id"
                           value="${{administrator.Adm_id}"/>
                </div>
                <div class=col-md-2>
                    <input id="Login" class="form-control input-md" name="Login"
                           value="${administrator.Login}"/>
                </div>
                <div class=col-md-2>
                    <input id="Password" class="form-control input-md" name="Password"
                           value="${administrator.Password}"/>
                </div>

                <div class=col-md-2>
                                    <input id="Password" class="form-control input-md" name="Password"
                                           value="${administrator.Password}"/>
                                </div>

                <div class=col-md-2>
                    <input id="Catalog" class="col-md-2 form-control input-md" name="Catalog"
                           value="${administrator.Catalog}"/>
                </div>

                <div class=col-md-2>
                    <input id="FullOrder_id" class="col-md-2 form-control input-md" name="FullOrder_id"
                           value="${administrator.FullOrder_id}"/>
                </div>

                <div class=col-md-1>
                    <select id="BlackList_id_fk" name="BlackList_id_fk" class="form-control">
                        <c:forEach items="${BlackList_id_fk}" var="BlackList_id_fk">
                            <option value="${blacklist.Black_list_ID}" role=${role.id} ${role.id==user.fkRole?"selected":""}>
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
        <form class="form-user-${administrator.Adm_id}" action="do?command=EditCatalog" method=POST>
            <b>
                 <input type="hidden" name="id" value="${administrator.Adm_id}"/>
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



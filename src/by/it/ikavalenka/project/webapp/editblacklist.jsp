<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<c:choose>
<c:when test="${admin.fkRole==1}">
<div class="row">
    <b>
        <div class=col-md-2>Black_list_ID</div>
        <div class=col-md-2>Client_id_fk</div>
    </b>
</div>
<br>

 <div class="row">
        <form class="create-blacklist-${blacklist.Black_list_ID}" action="do?command=EditBlackList" method=POST>
            <b>
                <div class=col-md-2>
                    <input id="Black_list_ID" class="form-control input-md" name="Black_list_ID"/>
                </div>
                <div class=col-md-2>
                    <input id="Client_id_fk" class="form-control input-md" name="Client_id"/>
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

<c:forEach items="${blacklists}" var="blacklist">
    <hr>
    <div class="row">
        <form class="update-blacklists-${blacklist.Black_list_ID}" action="do?command=EditBlackList" method=POST>
            <b>
                <div class=col-md-1>
                    <input disabled id="id" class="form-control input-md" name="showid"
                           value="${blacklist.Black_list_ID}"/>

                </div>
                <div>
                    <input type="hidden" id="id" class="form-control input-md" name="Id"
                           value="${blacklist.Black_list_ID}"/>

                </div>
                <div class=col-md-2>
                    <input id="Client_id_fk" class="form-control input-md" name="Client_id"
                           value="${blacklist.Client_id_fk}"/>
                </div>

<br><br>
                <div class=col-md-2>
                    <button id="Update" name="Update" class="btn btn-info">
                        Обновить <span class="glyphicon glyphicon-refresh" aria-hidden="true"></span>
                    </button>
                </div>

            </b>
        </form>
        <form class="form-blacklists-${blacklists.Black_list_ID}" action="do?command=EditBlackList" method=POST>
            <b>
                 <input type="hidden" name="id" value="${blacklist.Black_list_ID}"/>
                <div class=col-md-2>
                    <button id="Delete" name="Delete" class="btn btn-danger">
                        Delete <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
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



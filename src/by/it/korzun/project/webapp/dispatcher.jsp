<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<legend><h3>Profile</h3></legend>
<div>Name: ${staff.name}</div>
<div>Login: ${staff.login}</div>
<div>Specialization: Dispatcher</div>
<br>
<legend></legend>

<font size = "4">
    <div class=col-md-1>ID</div>
    <div class=col-md-2>First pilot</div>
    <div class=col-md-2>Second pilot</div>
    <div class=col-md-2>Navigator</div>
    <div class=col-md-2>Radio-operator</div>
    <div class=col-md-2>Stewardess</div>
</font>

<c:forEach items="${brigades}" var="brigade">
    <br>
    <div class="row">
        <form class="update-brigade-${brigade.id}" action="do?command=UpdateBrigade" method=POST>
            <b>
                <div class=col-md-1>
                    <input id="id" class="form-control input-md" name="id"
                           value="${brigade.id}"/>
                </div>
                <div class=col-md-2>
                    <input id="firstpilot" class="form-control input-md" name="firstpilot"
                           value="${brigade.firstPilotID}"/>
                </div>
                <div class=col-md-2>
                    <input id="secondpilot" class="form-control input-md" name="secondpilot"
                           value="${brigade.secondPilotID}"/>
                </div>
                <div class=col-md-2>
                    <input id="navigator" class="form-control input-md" name="navigator"
                           value="${brigade.navigatorID}"/>
                </div>
                <div class=col-md-2>
                    <input id="radio_operator" class="form-control input-md" name="radio_operator"
                           value="${brigade.radio_operatorID}"/>
                </div>
                <div class=col-md-1>
                    <input id="stewardess" class="form-control input-md" name="stewardess"
                           value="${brigade.stewardessID}"/>
                </div>

                <div class=col-md-1>
                    <button id="Update" name="Update" class="btn btn-success">
                        Edit
                    </button>
                </div>

            </b>
        </form>
        <form class="form-brigade-${brigade.id}" action="do?command=RemoveBrigade" method=POST>
            <b>
                <input type="hidden" name="id" value="${brigade.id}"/>
                <div class=col-md-1>
                    <button id="removebrigade" name="removebrigade" class="btn btn-danger">
                        Remove
                    </button>
                </div>

            </b>
        </form>
    </div>

</c:forEach>

<form class="form-horizontal" action="do?command=createbrigade" method="POST">
    <br>
    <b>
        <div class = "row">
            <div class=col-md-1></div>
            <div class=col-md-2>
                <input id="firstpilot" class="form-control input-md" name="firstpilot"
                    placeholder="First pilot ID"/>
            </div>
            <div class=col-md-2>
                <input id="secondpilot" class="form-control input-md" name="secondpilot"
                    placeholder="Second pilot ID"/>
            </div>
            <div class=col-md-2>
                <input id="navigator" class="form-control input-md" name="navigator"
                    placeholder="Navigator ID"/>
            </div>
            <div class=col-md-2>
                <input id="radio_operator" class="form-control input-md" name="radio_operator"
                    placeholder="Radio-operator ID"/>
            </div>
            <div class=col-md-2>
                <input id="stewardess" class="form-control input-md" name="stewardess"
                    placeholder="Stewardess ID"/>
            </div>
            <div class=col-md-1>
                <button id="Create" name="Create" class="btn btn-success">
                    Create new brigade
                </button>
            </div>
        </div>
    </b>
</form>

<h3>Current staff</h3>
<font size = "3">
    <b>
    <div class=col-md-1>ID</div>
    <div class=col-md-2>Name</div>
    <div class=col-md-2>Specialization</div>
    </b>
</font>

<c:forEach items = "${staffs}" var = "staff">
    <c:set var = "spec" value = "${staff.fk_specialization}"/>
    <c:if test = "${(spec == 1) || (spec == 2) || (spec == 3) || (spec == 4)}">
        <br>
        <div class = col-md-1>${staff.id}</div>
        <div class = col-md-2>${staff.name}</div>
        <c:set var = "spec" value = "${staff.fk_specialization}"/>
        <c:choose>
            <c:when test = "${spec == 1}">
                <div class = col-md-2>Pilot</div>
                        </c:when>
            <c:when test = "${spec == 2}">
                <div class = col-md-2>Navigator</div>
                        </c:when>
            <c:when test = "${spec == 3}">
                <div class = col-md-2>Radio-operator</div>
                        </c:when>
            <c:when test = "${spec == 4}">
                <div class = col-md-2>Stewardess</div>
            </c:when>
        </c:choose>
    </c:if>
</c:forEach>

<form class="form-horizontal" action="do?command=dispatcher" method="POST">
<fieldset>

<br>
<!-- Button -->
<div class="form-group">
  <label class="col-md-4 control-label" for="logout"></label>
  <div class="col-md-4">
    <button id="logout" name="logout" class="btn btn-danger">Logout</button>
  </div>
</div>

</fieldset>
</form>


<p>Main: ${message}</p>

<%@ include file="include/end-html.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<legend><h3>Profile</h3></legend>
<div>Name: ${staff.name}</div>
<div>Login: ${staff.login}</div>
<div>Specialization: Administrator</div>
<br>
<legend></legend>

<h1>Current Flights</h1>

<font size = "4">
    <div class=col-md-1>ID</div>
    <div class=col-md-2>Destination</div>
    <div class=col-md-2>BrigadeID</div>
</font>

<c:forEach items="${flights}" var="flight">
    <br>
    <div class="row">
        <form class="update-flight-${flight.id}" action="do?command=UpdateFlight" method=POST>
            <b>
                <div class=col-md-1>
                    <input id="id" class="form-control input-md" name="id"
                           value="${flight.id}"/>
                </div>
                <div class=col-md-2>
                    <input id="destination" class="form-control input-md" name="destination"
                           value="${flight.destination}"/>
                </div>
                <div class=col-md-2>
                    <input id="brigadeid" class="form-control input-md" name="brigadeid"
                           value="${flight.brigadeID}"/>
                </div>

                <div class=col-md-1>
                    <button id="Update" name="Update" class="btn btn-success">
                        Edit
                    </button>
                </div>

            </b>
        </form>
        <form class="form-flight-${flight.id}" action="do?command=RemoveFlight" method=POST>
            <b>
                 <input type="hidden" name="id" value="${flight.id}"/>
                <div class=col-md-1>
                    <button id="removeflight" name="removeflight" class="btn btn-danger">
                        Remove
                    </button>
                </div>

            </b>
        </form>
    </div>

</c:forEach>

<form class="form-horizontal" action="do?command=createflight" method="POST">
    <br>
    <b>
        <div class = "row">
            <div class=col-md-1></div>
            <div class=col-md-2>
                <input id="destination" class="form-control input-md" name="destination"
                    placeholder="Destination"/>
            </div>
            <div class=col-md-2>
                <input id="brigade" class="form-control input-md" name="brigade"
                   placeholder="BrigadeID"/>
            </div>
            <div class=col-md-1>
                <button id="Create" name="Create" class="btn btn-success">
                    Create new flight
                </button>
            </div>
        </div>
    </b>
</form>

<form class="form-horizontal" action="do?command=admin" method="POST">
<fieldset>

<h3>Brigades</h3>
<font size = "3">
    <b>
    <div class=col-md-1>ID</div>
    </b>
</font>

<c:forEach items = "${brigades}" var = "brigade">
        <br>
        <div class = col-md-1>${brigade.id}</div>
</c:forEach>

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

<%@ include file="include/end-html.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ include file="include/begin-html.jsp" %>

<p>Cmd Logout: ${message}</p>



<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Form Name</legend>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="logout">EXIT</label>
            <div class="col-md-4">
                <button id="logout" name="logout" class="btn btn-primary">Logout</button>
            </div>
        </div>

    </fieldset>
</form>



<%@ include file="include/end-html.jsp" %>
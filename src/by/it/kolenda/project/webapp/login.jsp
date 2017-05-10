<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%@ include file="include/begin-html.jsp" %>

<p>Cmd Login: ${message}</p>


<form class="form-horizontal">
    <fieldset>

        <!-- Form Name -->
        <legend>Form Name</legend>

        <!-- Text input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="LOGIN">LOGIN</label>
            <div class="col-md-4">
                <input id="LOGIN" name="LOGIN" type="text" placeholder="login" class="form-control input-md" required="">
                <span class="help-block">Enter your login</span>
            </div>
        </div>

        <!-- Password input-->
        <div class="form-group">
            <label class="col-md-4 control-label" for="passwordinput">PASSWORD</label>
            <div class="col-md-4">
                <input id="passwordinput" name="passwordinput" type="password" placeholder="password" class="form-control input-md" required="">
                <span class="help-block">Enter your password</span>
            </div>
        </div>

        <!-- Button -->
        <div class="form-group">
            <label class="col-md-4 control-label" for="submit">SUBMIT</label>
            <div class="col-md-4">
                <button id="submit" name="submit" class="btn btn-primary">Submit</button>
            </div>
        </div>

    </fieldset>
</form>


<%@ include file="include/end-html.jsp" %>
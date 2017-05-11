<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<p>Authorized user: ${userlogin} ${userpasshash}</p>

<p>Список заданий:</p>
<b>${taskslist}</b>


<%@ include file="include/end-html.jsp" %>
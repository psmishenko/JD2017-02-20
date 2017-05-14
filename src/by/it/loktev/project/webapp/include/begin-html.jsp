<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  </head>
  <body>

  <div class="container">

  <nav class="navbar navbar-default">
    <div class="container-fluid">

      <!-- Collect the nav links, forms, and other content for toggling -->
      <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav">
           <li><a href=do?command=Profile>Профиль</a></li>
           <li><a href=do?command=TaskCreate>Добавить задачу</a></li>
           <li><a href=do?command=TaskList>Список задач</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
          <c:if test="${!userauthorized}">
            <li><a href=do?command=Login>Авторизация</a></li>
          </c:if>
          <c:if test="${userauthorized}">
            <li><a href=do?command=Profile>Авторизован: ${userlogin}</a></li>
          </c:if>
          <li><a href=do?command=SignUp>Зарегистрироваться</a></li>
        </ul>
      </div><!-- /.navbar-collapse -->

    </div><!-- /.container-fluid -->
  </nav>




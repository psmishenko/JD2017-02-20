  <!DOCTYPE html>
<html lang="en">
    <head>
      <meta charset="utf-8">
      <meta http-equiv="X-UA-Compatible" content="IE=edge">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <title>Лимиты на банки-контрагенты</title>

      <link href="css/bootstrap.min.css" rel="stylesheet">

      <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
      <![endif]-->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>
<body>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="do?command=Main"><span class="glyphicon glyphicon-home"></span> Home</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li><a href="do?command=Banks"><span class="glyphicon glyphicon-map-marker"></span> Банки</a></li>
        <li><a href="do?command=Limits"><span class="glyphicon glyphicon-flash"></span> Лимиты</a></li>
        <li><a href="do?command=KursValuts"><span class="glyphicon glyphicon-usd"></span> Курсы валют</a></li>
        <li><a href="do?command=Sdels"><span class="glyphicon glyphicon-retweet"></span> Сделки</a></li>
        <li><a href="do?command=Users"><span class="glyphicon glyphicon-user"></span> Пользователи</a></li>
        <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-cog"></span> Справочники
                <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="do?command=Valuts">Валют</a></li>
                  <li><a href="do?command=Roles">Ролей</a></li>
                  <li><a href="do?command=OperTypes">Типов операций</a></li>
                  <li><a href="do?command=Countrys">Стран</a></li>
                  <li><a href="do?command=GroupBanks">Групп банков</a></li>
                </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <c:if test="${user == null}" >
        <li><a href="do?command=Login"><span class="glyphicon glyphicon-log-in"></span> Вход</a></li>
      </c:if>
      <c:if test="${user != null}" >
        <p class="navbar-text">Пользователь: <strong><c:out value="${user.name}" /></strong></p>
        <li><a href="do?command=Logout"><span class="glyphicon glyphicon-log-out"></span> Выход</a></li>
      </c:if>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


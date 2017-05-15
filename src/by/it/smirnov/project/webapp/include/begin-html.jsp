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
<%@ taglib tagdir="/WEB-INF/tags/menu" prefix="menu" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>

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
        <menu:li command="Banks" spanclass="glyphicon glyphicon-map-marker" text=" Банки" />
        <menu:li command="Limits" spanclass="glyphicon glyphicon-flash" text=" Лимиты" />
        <menu:li command="KursValuts" spanclass="glyphicon glyphicon-usd" text=" Курсы валют" />
        <menu:li command="Sdels" spanclass="glyphicon glyphicon-retweet" text=" Сделки" />
        <menu:li command="Users" spanclass="glyphicon glyphicon-user" text=" Пользователи" />
        <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-cog"></span> Справочники
                <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <menu:li command="Valuts" spanclass="" text="Валют" />
                  <menu:li command="Roles" spanclass="" text="Ролей" />
                  <menu:li command="OperTypes" spanclass="" text="Типов операций" />
                  <menu:li command="Countrys" spanclass="" text="Стран" />
                  <menu:li command="GroupBanks" spanclass="" text="Групп банков" />
                </ul>
        </li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      <c:if test="${currentuser == null}" >
        <menu:li command="Login" spanclass="glyphicon glyphicon-log-in" text=" Вход" />
      </c:if>
      <c:if test="${currentuser != null}" >
        <p class="navbar-text">Пользователь: <strong><c:out value="${currentuser.name}" /></strong></p>
        <menu:li command="Logout" spanclass="glyphicon glyphicon-log-out" text=" Выход" />
      </c:if>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


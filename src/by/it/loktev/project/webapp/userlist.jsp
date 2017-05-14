<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<c:if test="${userroleid==1}">

<p>Список пользователей:</p>

<style>

  .SUsersTable th
  {
    text-align: center;
  }

</style>

<table class="table table-bordered SUsersTable">
    <tr>
        <th>Логин</th>
        <th>E-mail</th>
        <th>Роль</th>
        <th></th>
    </tr>
    <c:forEach items="${users}" var="us">
    <tr>
        <td>${us.login}</td>
        <td>${us.email}</td>
        <td>${us.roleName}</td>
        <td>
          <form action="do?command=UserEdit" method="post" style="display: inline-block">
            <input type=hidden name="usid" value="${us.id}">
            <input type=submit class="btn btn-primary" value="редактировать">
          </form>
          <input type=button class="btn btn-info" value="задать пароль" onclick="javascript:UserPassword(${us.id},'${us.login}')">
          <input type=button class="btn btn-danger" value="удалить" onclick="javascript:UserDelete(${us.id},'${us.login}')">
        </td>
    </tr>
    </c:forEach>
</table>

<form name=FUserDelete action="do?command=UserDelete" method="post">
  <input type=hidden name="usid">
</form>

<form name=FUserPassword action="do?command=UserSetPass" method="post">
  <input type=hidden name="usid">
  <input type=hidden name="uspass">
</form>

<script>

  function UserDelete(UserId,UserLogin)
  {
    if ( confirm("Вы уверены, что хотите удалить пользователя "+UserLogin+"?") )
    {
      var Form=document.forms.FUserDelete;
      Form.elements.usid.value=UserId;
      Form.submit();
    }
  }

  function UserPassword(UserId,UserLogin)
  {
    var Pass=prompt("Введите новый пароль для пользователя "+UserLogin);
    if ( Pass )
    {
      var Form=document.forms.FUserPassword;
      Form.elements.usid.value=UserId;
      Form.elements.uspass.value=Pass;
      Form.submit();
    }
  }

</script>

</c:if>

<%@ include file="include/end-html.jsp" %>
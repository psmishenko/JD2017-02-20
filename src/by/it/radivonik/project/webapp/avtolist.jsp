<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ include file="inc_header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form class="form-inline" action="do" method="post">
 <legend>Автомобили</legend>
 <input type="hidden" name="command" value="AvtoEdit" />
  <div class="btn-toolbar navbar-form navbar-left">
    <button class="btn btn-xs btn-primary" type="submit" name="action" value="create" >
      <span class="glyphicon glyphicon-plus" aria-hidden="true" title="Добавить"/>
      Добавить
    </button>
    <c:if test="${avtos.size() > 0}">
    <button class="btn btn-xs btn-primary" type="submit" name="action" value="update" >
      <span class="glyphicon glyphicon-pencil" aria-hidden="true" title="Изменить"/>
      Изменить
    </button>
    <button class="btn btn-xs btn-primary" type="submit" name="action" value="delete">
      <span class="glyphicon glyphicon-minus" aria-hidden="true" title="Удалить"/>
      Удалить
    </button>
    </c:if>
  </div>

  <table class="table table-hover table-striped table-bordered">
    <thead>
      <tr>
        <th>Выбор</tр>
        <th>ID</th>
        <th>Гос. номер</th>
        <th>Водитель (ФИО)</th>
     </tr>
    </thead>
    <tbody>
      <c:set var="selectChecked" scope="page" value="" />
      <c:set var="id" scope="page" value="0" />
      <c:forEach var="avto" items="${avtos}">
        <c:if test="${avto_id == avto.id}">
          <c:set var="id" scope="page" value="${avto.id}" />
        </c:if>
      </c:forEach>
      <c:forEach var="avto" items="${avtos}">
      <tr >
       <c:if test="${id == 0 || id == avto.id}">
          <c:set var="selectChecked" scope="page" value="checked" />
          <c:set var="id" scope="page" value="${avto.id}" />
        </c:if>
        <td><input class="radio-inline" type="radio" name="id" value="${avto.id}" ${selectChecked}/></td>
        <c:set var="selectChecked" scope="page" value="" />
        <td align="right"><c:out value="${avto.id}"/></td>
        <td align="left"><c:out value="${avto.numgos}"/></td>
        <td align="left"><c:out value="${avto.voditel}"/></td>
      </tr>
      </c:forEach>
      <c:remove var="selectChecked" scope="page" />
      <c:remove var="id" scope="page" />
    </tbody>
  </table>
</form>

<%@ include file="inc_footer.jsp" %>
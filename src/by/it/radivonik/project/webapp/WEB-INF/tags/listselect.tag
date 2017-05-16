<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ attribute name="list" required="true" rtexprvalue="true" type="java.util.List"%>
<%@ attribute name="id" required="true" rtexprvalue="true" type="java.lang.Integer"%>
<%@ attribute name="idselect" required="true" rtexprvalue="true" type="java.lang.Integer"%>

<c:set var="selectchecked" scope="page" value="" />
<c:if test="${idselect == 0 && list.get(0).id == id || idselect == id}">
  <c:set var="selectchecked" scope="page" value="checked" />
</c:if>
<input class="radio-inline" type="radio" name="id" value="${id}" ${selectchecked}/>


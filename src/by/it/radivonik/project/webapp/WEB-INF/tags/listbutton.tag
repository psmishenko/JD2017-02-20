<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ attribute name="list" required="true" rtexprvalue="true" type="java.util.List"%>
<%@ attribute name="textcreate" required="true" rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="textupdate" required="true" rtexprvalue="true" type="java.lang.String"%>
<%@ attribute name="textdelete" required="true" rtexprvalue="true" type="java.lang.String"%>

<div class="btn-toolbar navbar-form navbar-left">
  <button class="btn btn-xs btn-primary" type="submit" name="action" value="create" >
    <span class="glyphicon glyphicon-plus" aria-hidden="true" title="${textcreate}"/>
    ${textcreate}
  </button>
  <c:if test="${list.size() > 0}">
  <button class="btn btn-xs btn-primary" type="submit" name="action" value="update" >
    <span class="glyphicon glyphicon-pencil" aria-hidden="true" title="${textupdate}"/>
    ${textupdate}
  </button>
  <button class="btn btn-xs btn-primary" type="submit" name="action" value="delete">
    <span class="glyphicon glyphicon-minus" aria-hidden="true" title="${textdelete}"/>
    ${textdelete}
  </button>
  </c:if>
</div>

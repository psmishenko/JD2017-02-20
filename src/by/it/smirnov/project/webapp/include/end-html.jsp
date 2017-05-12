<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</div>

    <footer class="navbar-fixed-bottom row-fluid">
    <div class = "container">
        <c:if test="${message != null}" >
        <div class="alert alert-info">
          <strong>Server messages:</strong> ${message}
        </div>
        </c:if>
        <c:if test="${msg_error != null}" >
        <div class="alert alert-danger">
          <strong>Server errors:</strong> ${msg_error}
        </div>
        </c:if>
        <p>IT-Academy / Smirnov A.V.</p>
    </div>
    </footer>
</div>
</body>
</html>
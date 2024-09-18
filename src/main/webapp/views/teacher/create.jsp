<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher create JSP</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post" class="mt-5 mb-3 m-5">
    <div>
        <label for="name" class="form-label">Full name</label>
        <input id="name" type="text" name="name" class="form-control"/>
    </div>
    <div>
        <label for="phone" class="form-label">Phone number</label>
        <input id="phone" type="text" name="phone" class="form-control"/>
    </div>
    <div>
        <label for="gender" class="form-label">Gender</label>
        <input id="gender" type="text" name="gender" class="form-control"/>
    </div>
    <div class="mt-3">
        <button type="submit" class="btn btn-success">Save</button>
    </div>
</form>
<jsp:include page="/fragments/js.jsp"/>
</body>
</html>

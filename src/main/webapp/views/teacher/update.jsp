<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher update JSP</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post" class="mt-5 mb-3 m-5">
    <div>
        <label for="phone" class="form-label">Phone number</label>
        <input id="phone" type="text" name="phone" value="${teacher.phone_number}" class="form-control"/>
    </div>
    <div class="mt-3">
        <button type="submit" class="btn btn-success">Update</button>
        <a href="/teacher/list" class="btn btn-danger">Back</a>
    </div>
</form>
<jsp:include page="/fragments/js.jsp"/>
</body>
</html>

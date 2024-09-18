<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Group create</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post" class="mt-5 mb-3 m-5">
    <div>
        <label for="name" class="form-label">Group name</label>
        <input id="name" type="text" name="name" class="form-control"/>
    </div>
    <div>
        <label for="count" class="form-label">Count</label>
        <input id="count" type="number" name="count" class="form-control"/>
    </div>
    <div>
        <label for="teacherId">Teacher</label>
        <select id="teacherId" type="button" name="teacherId" required>
            <c:forEach items="${teachers}" var="teacher">
                <option value="${teacher.id}">${teacher.full_name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="mt-3">
        <button type="submit" class="btn btn-success">Save</button>
    </div>
</form>
<jsp:include page="/fragments/js.jsp"/>
</body>
</html>

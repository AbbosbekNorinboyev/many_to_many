<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Teacher List JSP</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form>
    <div class="container mt-5">
        <div class="row">
            <div class="col-md-10 offset-1">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Full name</th>
                        <th scope="col">Phone number</th>
                        <th scope="col">Gender</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${teacherList}" var="teacher">
                        <tr>
                            <td>${teacher.id}</td>
                            <td>${teacher.full_name}</td>
                            <td>${teacher.phone_number}</td>
                            <td>${teacher.gender}</td>
                            <td>
                                <a href="/delete/teacher/${teacher.id}" class="btn btn-danger">Delete</a>
                                <a href="/update/teacher/${teacher.id}" class="btn btn-warning">Update</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</form>
<jsp:include page="/fragments/js.jsp"/>
</body>
</html>

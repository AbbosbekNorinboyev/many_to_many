<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subject List JSP</title>
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
                        <th scope="col">Name</th>
                        <th scope="col">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${subjectList}" var="subject">
                        <tr>
                            <td>${subject.id}</td>
                            <td>${subject.name}</td>
                            <td>
                                <a href="/delete/subject/${subject.id}" class="btn btn-danger">Delete</a>
                                <a href="/update/subject/${subject.id}" class="btn btn-warning">Update</a>
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

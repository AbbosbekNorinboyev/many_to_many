<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Subject delete JSP</title>
    <jsp:include page="/fragments/css.jsp"/>
</head>
<body>
<jsp:include page="/fragments/navbar.jsp"/>
<form method="post" class="mt-5 mb-3 m-5">
    <div class="alert alert-danger">
        <h1>Are you sure this delete subject <i>${subject.name}</i></h1>
    </div>
    <div>
        <button type="submit" class="btn btn-success">Delete</button>
        <a href="/subject/list" class="btn btn-danger">Back</a>
    </div>
</form>
<jsp:include page="/fragments/js.jsp"/>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Navbar</title>
</head>
<body>
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/user/list">User List</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/create/user">User Create</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/group/list">Group List</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/create/group">Group Create</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/student/list">Student List</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/create/student">Add New Student</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/teacher/list">Teacher List</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/create/teacher">Add New Teacher</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/subject/list">Subject List</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/create/subject">Create Subject</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
</body>
</html>

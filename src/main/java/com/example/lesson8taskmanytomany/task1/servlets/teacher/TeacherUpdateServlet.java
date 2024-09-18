package com.example.lesson8taskmanytomany.task1.servlets.teacher;

import com.example.lesson8taskmanytomany.task1.entity.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet(
        name = "com.example.lesson8taskmanytomany.task1.servlets.teacher.TeacherUpdateServlet",
        value = "/update/teacher/*"
)
public class TeacherUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        int id = Integer.parseInt(pathInfo.substring(1));
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Teacher teacher = entityManager.find(Teacher.class, id);
        entityManager.getTransaction().commit();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/teacher/update.jsp");
        req.setAttribute("teacher", teacher);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        int id = Integer.parseInt(pathInfo.substring(1));
        String phone = req.getParameter("phone");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Teacher teacher = entityManager.find(Teacher.class, id);
        if (Objects.isNull(teacher)) {
            resp.sendError(404, "Teacher with id '%s' not found".formatted(id));
        } else {
            teacher.setPhone_number(Objects.requireNonNullElse(phone, teacher.getPhone_number()));
            entityManager.merge(teacher);
        }
        entityManager.getTransaction().commit();
        resp.sendRedirect("/teacher/list");
    }
}

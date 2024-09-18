package com.example.lesson8taskmanytomany.task1.servlets.teacher;

import com.example.lesson8taskmanytomany.task1.entity.Subject;
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
import java.util.List;

@WebServlet(
        name = "com.example.lesson8taskmanytomany.task1.servlets.teacher.TeacherCreateServlet",
        value = "/create/teacher"
)
public class TeacherCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Subject> subjects = entityManager.createQuery("from Subject", Subject.class).getResultList();
        entityManager.getTransaction().commit();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/teacher/create.jsp");
        req.setAttribute("subjects", subjects);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String gender = req.getParameter("gender");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Subject> subjects = entityManager.createQuery("from Subject ",Subject.class).getResultList();
        Teacher teacher = Teacher.builder()
                .full_name(name)
                .phone_number(phone)
                .gender(Boolean.parseBoolean(gender))
                .subject(subjects)
                .build();
        entityManager.getTransaction().begin();
        entityManager.persist(teacher);
        entityManager.getTransaction().commit();
        resp.sendRedirect("/teacher/list");
    }
}

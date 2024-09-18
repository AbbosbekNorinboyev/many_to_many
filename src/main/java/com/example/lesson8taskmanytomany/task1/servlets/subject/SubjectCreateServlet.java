package com.example.lesson8taskmanytomany.task1.servlets.subject;

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
        name = "com.example.lesson8taskmanytomany.task1.servlets.subject.SubjectCreateServlet",
        value = "/create/subject"
)
public class SubjectCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Teacher> teachers = entityManager.createQuery("from Teacher", Teacher.class).getResultList();
        entityManager.getTransaction().commit();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/subject/create.jsp");
        req.setAttribute("teachers", teachers);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String subjectName = req.getParameter("subjectName");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Teacher> teachers = entityManager.createQuery("from Teacher", Teacher.class).getResultList();
        Subject subject = Subject.builder()
                .name(subjectName)
                .teacher(teachers)
                .build();
        entityManager.getTransaction().begin();
        entityManager.persist(subject);
        entityManager.getTransaction().commit();
        resp.sendRedirect("/subject/list");
    }
}

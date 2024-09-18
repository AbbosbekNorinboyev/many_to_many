package com.example.lesson8taskmanytomany.task1.servlets.subject;

import com.example.lesson8taskmanytomany.task1.entity.Subject;
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
        name = "com.example.lesson8taskmanytomany.task1.servlets.subject.SubjectDeleteServlet",
        value = "/delete/subject/*"
)
public class SubjectDeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        int id = Integer.parseInt(pathInfo.substring(1));
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Subject subject = entityManager.find(Subject.class, id);
        entityManager.getTransaction().commit();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/subject/delete.jsp");
        req.setAttribute("subject", subject);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo();
        int id = Integer.parseInt(pathInfo.substring(1));
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Subject subject = entityManager.find(Subject.class, id);
        if (Objects.isNull(subject)) {
            resp.sendError(404, "Subject with id '%s' not found".formatted(id));
        } else {
            entityManager.remove(subject);
        }
        entityManager.getTransaction().commit();
        resp.sendRedirect("/subject/list");
    }
}

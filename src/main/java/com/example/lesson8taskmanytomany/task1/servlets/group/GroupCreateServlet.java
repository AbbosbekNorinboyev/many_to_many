package com.example.lesson8taskmanytomany.task1.servlets.group;

import com.example.lesson8taskmanytomany.task1.entity.Groups;
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
        name = "com.example.lesson8taskmanytomany.task1.servlets.group.GroupCreateServlet",
        value = "/create/group"
)
public class GroupCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Teacher> teachers = entityManager.createQuery("from Teacher ", Teacher.class).getResultList();
        entityManager.getTransaction().commit();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/group/create.jsp");
        req.setAttribute("teachers", teachers);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int count = Integer.parseInt(req.getParameter("count"));
        String teacherId = req.getParameter("teacherId");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Teacher teacher = entityManager.find(Teacher.class, teacherId);
        Groups group = Groups.builder()
                .group_name(name)
                .count(count)
                .teacher(teacher)
                .build();
        entityManager.getTransaction().begin();
        entityManager.persist(group);
        entityManager.getTransaction().commit();
        resp.sendRedirect("/group/list");
    }
}

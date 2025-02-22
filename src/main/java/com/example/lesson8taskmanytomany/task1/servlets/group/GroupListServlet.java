package com.example.lesson8taskmanytomany.task1.servlets.group;

import com.example.lesson8taskmanytomany.task1.entity.Groups;
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
        name = "com.example.lesson8taskmanytomany.task1.servlets.group.GroupListServlet",
        value = "/group/list"
)
public class GroupListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Groups> groupsList = entityManager.createQuery("from Groups", Groups.class).getResultList();
        entityManager.getTransaction().commit();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/group/groupList.jsp");
        req.setAttribute("groupsList", groupsList);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

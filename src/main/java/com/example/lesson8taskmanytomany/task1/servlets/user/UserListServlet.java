package com.example.lesson8taskmanytomany.task1.servlets.user;

import com.example.lesson8taskmanytomany.task1.entity.Users;
import jakarta.persistence.Entity;
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
        name = "com.example.lesson8taskmanytomany.task1.servlets.user.UserListServlet",
        value = "/user/list"
)
public class UserListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Users> usersList = entityManager.createQuery("from Users", Users.class).getResultList();
        entityManager.getTransaction().commit();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/user/userList.jsp");
        req.setAttribute("usersList", usersList);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}

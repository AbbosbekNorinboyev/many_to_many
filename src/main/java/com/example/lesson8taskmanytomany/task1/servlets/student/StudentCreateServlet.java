package com.example.lesson8taskmanytomany.task1.servlets.student;

import com.example.lesson8taskmanytomany.task1.entity.Groups;
import com.example.lesson8taskmanytomany.task1.entity.Student;
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
        name = "com.example.lesson8taskmanytomany.task1.servlets.student.StudentCreateServlet",
        value = "/create/student"
)
public class StudentCreateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Groups> groupsList = entityManager.createQuery("from Groups ", Groups.class).getResultList();
        entityManager.getTransaction().commit();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/student/create.jsp");
        req.setAttribute("groupsList", groupsList);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String number = req.getParameter("number");
        String date = req.getParameter("date");
        String groupId = req.getParameter("groupId");
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("orm_example");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Groups group = entityManager.find(Groups.class, groupId);
        Student student = Student.builder()
                .full_name(name)
                .phone_number(number)
                .birth_date(date)
                .groups(group)
                .build();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        resp.sendRedirect("/student/list");
    }
}

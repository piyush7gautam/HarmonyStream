package com.musicstreaming.servlet;

import com.musicstreaming.dao.UserDAO;
import com.musicstreaming.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if ("create".equals(action)) {
            String name = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");
            String role = req.getParameter("role");
            User u = new User(UserDAO.getAllUsers().size() + 1, name, email, password, role);
            UserDAO.addUser(u);
        } else if ("delete".equals(action)) {
            String email = req.getParameter("email");
            UserDAO.deleteUserByEmail(email);
        }
        resp.sendRedirect(req.getContextPath() + "/dashboard");
    }
}

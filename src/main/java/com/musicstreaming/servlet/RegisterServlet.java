package com.musicstreaming.servlet;

import com.musicstreaming.dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * RegisterServlet - handles simple registration and server-side validation.
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        if (name == null || name.trim().isEmpty() || email == null || email.trim().isEmpty() ||
                password == null || password.length() < 6) {
            req.setAttribute("error", "Invalid input: name/email required and password must be at least 6 characters.");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
            return;
        }
        boolean ok = UserDAO.createUser(name.trim(), email.trim(), password, role == null ? "LISTENER" : role);
        if (ok) {
            resp.sendRedirect(req.getContextPath() + "/login.jsp?registered=1");
        } else {
            req.setAttribute("error", "Registration failed (email may already exist).");
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        }
    }
}

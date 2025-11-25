package com.musicstreaming.servlet;

import com.musicstreaming.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class DashboardServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("currentUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        User user = (User) session.getAttribute("currentUser");
        String role = user.getRole();

        if ("ADMIN".equalsIgnoreCase(role)) {
            req.getRequestDispatcher("adminDashboard.jsp").forward(req, resp);
        } else if ("ARTIST".equalsIgnoreCase(role)) {
            req.getRequestDispatcher("artistDashboard.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("listenerDashboard.jsp").forward(req, resp);
        }
    }
}

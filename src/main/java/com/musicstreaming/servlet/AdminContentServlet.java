package com.musicstreaming.servlet;

import com.musicstreaming.dao.MusicDAO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AdminContentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int id = Integer.parseInt(req.getParameter("id"));
        if ("approve".equals(action)) {
            MusicDAO.approveTrack(id);
        } else if ("reject".equals(action)) {
            MusicDAO.rejectTrack(id);
        }
        resp.sendRedirect(req.getContextPath() + "/dashboard");
    }
}

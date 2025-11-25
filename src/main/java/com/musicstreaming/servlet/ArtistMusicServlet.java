package com.musicstreaming.servlet;

import com.musicstreaming.dao.MusicDAO;
import com.musicstreaming.dao.MessageDAO;
import com.musicstreaming.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class ArtistMusicServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("currentUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        User user = (User) session.getAttribute("currentUser");
        String action = req.getParameter("action");

        if ("upload".equals(action)) {
            String title = req.getParameter("title");
            String album = req.getParameter("album");
            String genre = req.getParameter("genre");
            MusicDAO.addTrack(title, user.getName(), album, genre, user.getEmail());
        } else if ("reply".equals(action)) {
            String toEmail = req.getParameter("toEmail");
            String content = req.getParameter("content");
            MessageDAO.addMessage(user.getEmail(), toEmail, content);
        }
        resp.sendRedirect(req.getContextPath() + "/dashboard");
    }
}

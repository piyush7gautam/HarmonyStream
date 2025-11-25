package com.musicstreaming.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.musicstreaming.model.User;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FollowArtistServlet extends HttpServlet {

    @SuppressWarnings("unchecked")
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("currentUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        User user = (User) session.getAttribute("currentUser");
        String artistName = req.getParameter("artistName");

        String key = "followedArtists_" + user.getEmail();
        Set<String> followed = (Set<String>) session.getAttribute(key);
        if (followed == null) {
            followed = new HashSet<>();
        }
        followed.add(artistName);
        session.setAttribute(key, followed);

        resp.sendRedirect(req.getContextPath() + "/dashboard");
    }
}

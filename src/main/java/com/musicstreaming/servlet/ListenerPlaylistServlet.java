package com.musicstreaming.servlet;

import com.musicstreaming.dao.MusicDAO;
import com.musicstreaming.dao.PlaylistDAO;
import com.musicstreaming.model.MusicTrack;
import com.musicstreaming.model.Playlist;
import com.musicstreaming.model.User;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class ListenerPlaylistServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("currentUser") == null) {
            resp.sendRedirect(req.getContextPath() + "/index.jsp");
            return;
        }
        User user = (User) session.getAttribute("currentUser");
        String action = req.getParameter("action");

        if ("create".equals(action)) {
            String title = req.getParameter("title");
            PlaylistDAO.createPlaylist(user.getEmail(), title);
        } else if ("addTrack".equals(action)) {
            int playlistId = Integer.parseInt(req.getParameter("playlistId"));
            int trackId = Integer.parseInt(req.getParameter("trackId"));
            MusicTrack selected = null;
            for (MusicTrack t : MusicDAO.getApprovedTracks()) {
                if (t.getId() == trackId) {
                    selected = t;
                    break;
                }
            }
            if (selected != null) {
                PlaylistDAO.addTrackToPlaylist(playlistId, selected);
            }
        }
        resp.sendRedirect(req.getContextPath() + "/dashboard");
    }
}

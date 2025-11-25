package com.musicstreaming.dao;

import com.musicstreaming.model.MusicTrack;
import com.musicstreaming.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * MusicDAO - JDBC backed music data access
 */
public class MusicDAO {

    public static List<MusicTrack> findAll() {
        List<MusicTrack> list = new ArrayList<>();
        String sql = "SELECT id, title, artist, url, uploaded_by FROM music";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new MusicTrack(rs.getInt("id"), rs.getString("title"), rs.getString("artist"), rs.getString("url"), rs.getInt("uploaded_by")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean create(MusicTrack t) {
        String sql = "INSERT INTO music (title, artist, url, uploaded_by) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, t.getTitle());
            ps.setString(2, t.getArtist());
            ps.setString(3, t.getUrl());
            ps.setInt(4, t.getUploadedBy());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

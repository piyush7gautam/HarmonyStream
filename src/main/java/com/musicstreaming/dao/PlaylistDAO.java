package com.musicstreaming.dao;

import com.musicstreaming.model.Playlist;
import com.musicstreaming.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * PlaylistDAO - JDBC backed playlist storage
 */
public class PlaylistDAO {

    public static List<Playlist> findByOwner(int ownerId) {
        List<Playlist> list = new ArrayList<>();
        String sql = "SELECT id, name, owner_id FROM playlists WHERE owner_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, ownerId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Playlist(rs.getInt("id"), rs.getString("name"), rs.getInt("owner_id")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static boolean create(Playlist p) {
        String sql = "INSERT INTO playlists (name, owner_id) VALUES (?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getName());
            ps.setInt(2, p.getOwnerId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

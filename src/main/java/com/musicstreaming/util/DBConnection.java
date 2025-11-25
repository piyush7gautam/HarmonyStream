package com.musicstreaming.util;

import java.sql.*;
import java.nio.file.*;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * DBConnection - SQLite-based utility for this project.
 * Creates a local file database `data/harmonystream.db` and initializes schema if missing.
 */
public class DBConnection {
    private static final String DB_DIR = "data";
    private static final String DB_FILE = DB_DIR + "/harmonystream.db";
    private static final String JDBC_URL = "jdbc:sqlite:" + DB_FILE;

    static {
        try {
            initializeDatabase();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL);
    }

    private static void initializeDatabase() throws Exception {
        Path dataDir = Paths.get(DB_DIR);
        if (!Files.exists(dataDir)) {
            Files.createDirectories(dataDir);
        }
        Path dbPath = Paths.get(DB_FILE);
        boolean exists = Files.exists(dbPath);
        if (!exists) {
            // Create DB and run schema from bundled resource schema.sql
            try (Connection conn = getConnection()) {
                runSchema(conn);
            }
        } else {
            // Optionally we could verify tables
        }
    }

    private static void runSchema(Connection conn) throws Exception {
        // Read schema.sql from resources (placed under src/main/resources/schema.sql)
        try (InputStream in = DBConnection.class.getResourceAsStream("/schema.sql")) {
            if (in == null) {
                System.err.println("schema.sql not found in resources");
                return;
            }
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\\n");
                }
                String[] statements = sb.toString().split(";");
                for (String st : statements) {
                    if (st.trim().isEmpty()) continue;
                    try (Statement s = conn.createStatement()) {
                        s.execute(st);
                    } catch (SQLException ex) {
                        System.err.println("Failed to execute statement: " + st);
                        ex.printStackTrace();
                    }
                }
            }
        }
    }
}

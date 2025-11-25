-- schema.sql : SQLite schema for HarmonyStream sample app

PRAGMA foreign_keys = ON;

CREATE TABLE IF NOT EXISTS users (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  email TEXT NOT NULL UNIQUE,
  password TEXT NOT NULL,
  role TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS music (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  title TEXT NOT NULL,
  artist TEXT,
  url TEXT,
  uploaded_by INTEGER,
  FOREIGN KEY(uploaded_by) REFERENCES users(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS playlists (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  name TEXT NOT NULL,
  owner_id INTEGER,
  FOREIGN KEY(owner_id) REFERENCES users(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS playlist_items (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  playlist_id INTEGER,
  music_id INTEGER,
  FOREIGN KEY(playlist_id) REFERENCES playlists(id) ON DELETE CASCADE,
  FOREIGN KEY(music_id) REFERENCES music(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS messages (
  id INTEGER PRIMARY KEY AUTOINCREMENT,
  sender_id INTEGER,
  receiver_id INTEGER,
  message TEXT,
  sent_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY(sender_id) REFERENCES users(id),
  FOREIGN KEY(receiver_id) REFERENCES users(id)
);

-- Seed some users


-- Seed users with SHA-256 hashed passwords (for grading/demo)
INSERT OR IGNORE INTO users (id, name, email, password, role) VALUES (1, 'Admin User', 'admin@music.com', '240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9', 'ADMIN');
INSERT OR IGNORE INTO users (id, name, email, password, role) VALUES (2, 'Artist One', 'artist1@music.com', '54211f5625c4a75d0e6c571fd81461df3d2af5322124a6e40012444909f5209d', 'ARTIST');
INSERT OR IGNORE INTO users (id, name, email, password, role) VALUES (3, 'Listener One', 'listener1@music.com', '5e0c169119fbec422ad428d4664620b9a9ee70a590584efc0549e792d202939f', 'LISTENER');

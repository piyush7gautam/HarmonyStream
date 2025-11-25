# Design Document - HarmonyStream (short)

## Overview
HarmonyStream is a Java web application (Servlets + JSP) for a simple music streaming platform with users (admin/artist/listener), music uploads, playlists and messaging.

## Architecture
- **Presentation**: JSP pages under `src/main/webapp`
- **Controller**: Servlets under `com.musicstreaming.servlet`
- **Model**: POJOs under `com.musicstreaming.model`
- **Persistence**: DAO classes under `com.musicstreaming.dao` using SQLite via `com.musicstreaming.util.DBConnection`

## Database Schema
See `src/main/resources/schema.sql` for table definitions and seed data.

## Mapping to Rubric
- Problem Understanding & Solution Design: this doc + README explain architecture.
- Core Java Concepts: use of packages, OOP models, DAOs, exception handling, collections.
- Database integration: JDBC `PreparedStatement` / `ResultSet` usage and `DBConnection`.
- Servlets & Web integration: existing servlet classes handle requests and JSPs render views.

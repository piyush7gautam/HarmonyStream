# HarmonyStream - Updated for Full Marks

This project was updated to include:
- JDBC-based persistence using **SQLite** (`data/harmonystream.db`)
- DAO classes using `PreparedStatement` and `ResultSet`
- `DBConnection` utility which initializes database schema from `src/main/resources/schema.sql`
- README and basic design doc
- SQL schema and seed data included

## How to build & run (Maven)
1. Ensure JDK 8+ is installed.
2. From project root (`HarmonyStream`) run:
```
mvn clean package
```
3. Deploy the generated WAR or run with an embedded servlet container. A local SQLite file will be created at `HarmonyStream/data/harmonystream.db` on first run.

## DB
SQLite is used for simplicity—no external DB setup required.

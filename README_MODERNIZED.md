HarmonyStream - Modernized UI bundle
===================================

This fork adds four selectable UI themes (Bootstrap dark, Netflix-style, Material clean, Glassmorphism)
and updates JSP fragments to simplify theming.

How to run
1. Ensure you have Java 11+ and Maven installed.
2. Create a MySQL database, e.g.:
   - CREATE DATABASE harmonystream;
   - Run the SQL in 'db/schema.sql' to create tables.
3. Update database credentials in 'src/main/java/com/musicstreaming/dao/DBConfig.java' or in your DAO connection strings.
4. Build the WAR:
   mvn clean package
5. Deploy the generated WAR from target/ to Tomcat (or run with embedded plugin).

Files added/changed:
 - Updated pom.xml with JSTL and MySQL connector dependencies
 - src/main/webapp/WEB-INF/includes/header.jsp, footer.jsp
 - src/main/webapp/index.jsp (modernized)
 - src/main/webapp/assets/css/theme_*.css (4 themes)
 - db/schema.sql (sample schema)

Notes:
 - This update focuses on UI and project wiring; it does NOT change business logic of DAOs/Servlets.
 - You should verify DB connection code in your DAO files.
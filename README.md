 HarmonyStream – Music Streaming Web App

HarmonyStream is a simple and clean music-streaming web application built using Java, JSP, Servlets, and JDBC.
It allows users to listen to music, create playlists, follow artists, and enjoy a personalized dashboard experience.

We built this project as part of my Java Web Development coursework, focusing on OOP, JDBC, MVC, and complete web-based functionality.

 What You Can Do in This App
1. For All Users
-\Create an account
-\Log in securely
-\Enjoy a personal dashboard

2.For Listeners
-\Browse available songs
-\Create your own playlists
-\Add/remove songs anytime
-\Follow your favorite artists

 3.For Artists
-\Upload your music
-\Manage your uploaded tracks
-\Connect with listeners

Everything is built with simple and clean user flows so both artists and listeners can use the platform without confusion.

How the Project Is Built
 The entire project follows the MVC structure, so everything stays organized:
 JSP → Views (User Interface)
 Servlets → Controllers (Logic)
 DAO + JDBC → Models/Database Layer
 MySQL → Database
 We also used Maven to manage dependencies and Tomcat as the server.

 Project Layout (Simple View)
  HarmonyStream/
 │── src/main/java/com/musicstreaming/
 │     ├── model/        # Data models (User, Playlist, Track)
 │     ├── dao/          # Database access code
 │     ├── servlet/      # Login, Register, Dashboard, etc.
 │
 │── src/main/webapp/
 │     └── jsp/          # JSP pages
 │
 │── db/                 # Database schema
 │── data/               # SQLite database file
 │── pom.xml
 │── README.md

How to Run the Project
You need:
--/Java 8 or higher
--/Apache Tomcat (9 or 10 recommended)
--/Maven
Steps:
Build the project:
    mvn clean install
Copy the .war file from:
    target/HarmonyStream.war
Paste it inside:
   tomcat/webapps/
Start Tomcat and open your browser:
  http://localhost:8080/HarmonyStream

Java Concepts Used
--This project demonstrates almost all important Java concepts:
--Classes, objects, and packages
--Interfaces and inheritance
--Constructors and getters/setters
--Collections (Lists)
--Exception handling
--JDBC
--Servlets and sessions
--JSP + JSTL
Made by CodexCrew 
Piyush Kumar Gautam (Leader)
Sanad Shakya
Anuj Rajpoot

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    // Only ONE variable defined
    String currentTheme = request.getParameter("theme");

    if (currentTheme == null) {
        currentTheme = (String) session.getAttribute("theme");
    }
    if (currentTheme == null) {
        currentTheme = "light";  // default theme
    }

    session.setAttribute("theme", currentTheme);
%>

<!DOCTYPE html>
<html>
<head>
    <title>HarmonyStream</title>

    <link rel="stylesheet" href="<c:url value='/css/style.css' />">

    <style>
        body.light { background: #f5f5f5; color: #222; }
        body.dark { background: #111; color: #eee; }
        .topbar {
            display:flex;
            justify-content: space-between;
            background:#222;
            padding:12px;
            color:#fff;
        }
        .topbar a { color:#0af; margin-right:10px; }
    </style>
</head>

<body class="<%= currentTheme %>">

<div class="topbar">
    <div class="logo">HarmonyStream</div>

    <div>
        <a href="?theme=light">Light</a> |
        <a href="?theme=dark">Dark</a> |
        <a href="login.jsp">Login</a> |
        <a href="register.jsp">Register</a>
    </div>
</div>

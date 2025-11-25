<%@ include file="/WEB-INF/includes/header.jsp" %>
<%@ page import="com.musicstreaming.dao.UserDAO"%>
<%@ page import="com.musicstreaming.dao.MusicDAO"%>
<%@ page import="com.musicstreaming.model.User"%>
<%@ page import="com.musicstreaming.model.MusicTrack"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container my-4">
<!-- ORIGINAL CONTENT START (trimmed) -->
<div class="card p-3">
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <h1>Admin Dashboard</h1>

    <h2>User Management</h2>
    <table>
        <tr><th>ID</th><th>Name</th><th>Email</th><th>Role</th><th>Action</th></tr>
        <%
            for (User u : UserDAO.getAllUsers()) {
        %>
        <tr>
            <td><%= u.getId() %></td>
            <td><%= u.getName() %></td>
            <td><%= u.getEmail() %></td>
            <td><%= u.getRole() %></td>
            <td>
                <form action="admin/users" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete"/>
                    <input type="hidden" name="email" value="<%= u.getEmail() %>"/>
                    <button type="submit">Delete</button>
                </form>
            </td>
        </tr>
        <% } %>
    </table>

    <h3>Create New User</h3>
    <form action="admin/users" method="post" class="card-inline">
        <input type="hidden" name="action" value="create"/>
        <input type="text" name="name" placeholder="Name" required/>
        <input type="email" name="email" placeholder="Email" required/>
        <input type="password" name="password" placeholder="Password" required/>
        <select name="role">
            <option value="ADMIN">ADMIN</option>
            <option value="ARTIST">ARTIST</option>
            <option value="LISTENER">LISTENER</option>
        </select>
        <button type="submit">Create</button>
    </form>

    <h2>Music Content Management (Pending Approval)</h2>
    <table>
        <tr><th>ID</th><th>Title</th><th>Artist</th><th>Album</th><th>Genre</th><th>Action</th></tr>
        <%
            for (MusicTrack t : MusicDAO.getPendingTracks()) {
        %>
        <tr>
            <td><%= t.getId() %></td>
            <td><%= t.getTitle() %></td>
            <td><%= t.getArtistName() %></td>
            <td><%= t.getAlbum() %></td>
            <td><%= t.getGenre() %></td>
            <td>
                <form action="admin/content" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= t.getId() %>"/>
                    <input type="hidden" name="action" value="approve"/>
                    <button type="submit">Approve</button>
                </form>
                <form action="admin/content" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= t.getId() %>"/>
                    <input type="hidden" name="action" value="reject"/>
                    <button type="submit">Reject</button>
                </form>
            </td>
        </tr>
        <% } %>
    </table>

    <h2>Music Overview</h2>
    <div class="stats-grid">
        <div class="stat-card">
            <h3>Total Tracks</h3>
            <p><%= MusicDAO.getAllTracks().size() %></p>
        </div>
        <div class="stat-card">
            <h3>Approved Tracks</h3>
            <p><%= MusicDAO.getApprovedTracks().size() %></p>
        </div>
        <div class="stat-card">
            <h3>Pending Tracks</h3>
            <p><%= MusicDAO.getPendingTracks().size() %></p>
        </div>
    </div>

    <h2>User Feedback / Tickets</h2>
    <p>For simplicity, this demo does not implement a full ticket system.
       You can extend this section with a separate Feedback entity and DAO.</p>
</div>
</body>
</html>

<%@ include file="/WEB-INF/includes/footer.jsp" %>
</div>
<!-- ORIGINAL CONTENT END -->
</div>


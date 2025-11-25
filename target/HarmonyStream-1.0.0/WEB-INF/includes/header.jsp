<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String theme = request.getParameter("theme");
    if (theme == null) {
        theme = (String)session.getAttribute("theme");
    }
    if (theme == null) theme = "bootstrap";
    session.setAttribute("theme", theme);
%>
<!doctype html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>HarmonyStream</title>
    <!-- Bootstrap from CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/assets/css/theme_bootstrap.css" rel="stylesheet" id="theme_bootstrap" disabled/>
    <link href="${pageContext.request.contextPath}/assets/css/theme_netflix.css" rel="stylesheet" id="theme_netflix" disabled/>
    <link href="${pageContext.request.contextPath}/assets/css/theme_material.css" rel="stylesheet" id="theme_material" disabled/>
    <link href="${pageContext.request.contextPath}/assets/css/theme_glass.css" rel="stylesheet" id="theme_glass" disabled/>
    <script>
        // enable selected theme stylesheet
        (function(){
            var theme = '<%=theme%>';
            document.addEventListener("DOMContentLoaded", function(){
                var mapping = { "bootstrap":"theme_bootstrap", "netflix":"theme_netflix", "material":"theme_material", "glass":"theme_glass" };
                for (var k in mapping) {
                    var el = document.getElementById(mapping[k]);
                    if (el) el.disabled = true;
                }
                var chosen = mapping[theme] || mapping["bootstrap"];
                var el = document.getElementById(chosen);
                if (el) el.disabled = false;
            });
        })();
    </script>
</head>
<body>
<nav class="navbar navbar-expand-lg">
  <div class="container-fluid">
    <a class="navbar-brand text-white" href="${pageContext.request.contextPath}/index.jsp">HarmonyStream</a>
    <div class="collapse navbar-collapse">
      <ul class="navbar-nav me-auto">
        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/browse.jsp">Browse</a></li>
      </ul>
      <form class="d-flex" method="get" action="">
        <select name="theme" class="form-select form-select-sm" onchange="this.form.submit()">
            <option value="bootstrap" ${theme.equals("bootstrap")? "selected":""}>Bootstrap (Dark)</option>
            <option value="netflix" ${theme.equals("netflix")? "selected":""}>Netflix-Style</option>
            <option value="material" ${theme.equals("material")? "selected":""}>Material</option>
            <option value="glass" ${theme.equals("glass")? "selected":""}>Glass</option>
        </select>
      </form>
    </div>
  </div>
</nav>
<div class="container my-4">
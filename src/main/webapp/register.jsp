<%@ include file="/WEB-INF/includes/header.jsp" %>

<div class="container my-4">
<!-- ORIGINAL CONTENT START (trimmed) -->
<div class="card p-3">
<div class="row justify-content-center">
  <div class="col-md-7">
    <div class="card p-4">
      <h3>Register</h3>
      <form action="RegisterServlet" method="post">
        <div class="mb-3">
          <label class="form-label">Username</label>
          <input name="username" class="form-control" required />
        </div>
        <div class="mb-3">
          <label class="form-label">Email</label>
          <input name="email" type="email" class="form-control" required />
        </div>
        <div class="mb-3">
          <label class="form-label">Password</label>
          <input name="password" type="password" class="form-control" required />
        </div>
        <button class="btn btn-success">Create account</button>
        <a href="login.jsp" class="btn btn-link">Already have an account?</a>
      </form>
    </div>
  </div>
</div>
<%@ include file="/WEB-INF/includes/footer.jsp" %>
</div>
<!-- ORIGINAL CONTENT END -->
</div>


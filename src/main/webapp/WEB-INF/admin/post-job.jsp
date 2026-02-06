<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
<title>Post Job</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/postjob.css">
</head>

<body>

<div class="post-container">

<h2>Post New Job</h2>

<form action="<%=request.getContextPath()%>/admin/post-job" method="post">

<label>Job Title</label>
<input type="text" name="title" required>

<label>Company</label>
<input type="text" name="company" required>

<label>Location</label>
<input type="text" name="location" required>

<label>Description</label>
<textarea name="description" rows="4" required></textarea>

<label>Skills</label>
<input type="text" name="skills" placeholder="Java,Spring,SQL" required>
<button type="submit">Post Job</button>

</form>

<a class="back" href="<%=request.getContextPath()%>/admin/dashboard">⬅ Back to Dashboard</a>

</div>

</body>
</html>
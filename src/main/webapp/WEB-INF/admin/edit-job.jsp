<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="com.jobportal.model.Job" %>

<%
Job job = (Job) request.getAttribute("job");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Job</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/postjob.css">
</head>

<body>

<div class="post-container">

<h2>Edit Job</h2>

<form action="<%=request.getContextPath()%>/admin/update-job" method="post">

<input type="hidden" name="jobId" value="<%=job.getJobId()%>">

<label>Job Title</label>
<input type="text" name="title" value="<%=job.getTitle()%>" required>

<label>Company</label>
<input type="text" name="company" value="<%=job.getCompany()%>" required>

<label>Location</label>
<input type="text" name="location" value="<%=job.getLocation()%>" required>

<label>Description</label>
<textarea name="description" rows="5" required><%=job.getDescription()%></textarea>
 
 <label>Skills</label>
 <textarea name="skills" required><%=job.getSkills() %></textarea>
<button type="submit">Update Job</button>

<a href="<%=request.getContextPath()%>/admin/dashboard" class="back">
← Back to Dashboard
</a>

</form>

</div>

</body>
</html>
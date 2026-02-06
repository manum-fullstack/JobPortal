<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.jobportal.model.Job" %>

<%
String error=request.getParameter("error");
String success=request.getParameter("success");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Dashboard</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/dashboard.css">
</head>

<body>

<div class="dashboard">

<h2>Welcome, ${sessionScope.loggedUser.username} 👋</h2>

<% if("already_applied".equals(error)){ %>
<p style="color:red;text-align:center;">Already applied</p>
<% } %>

<% if("true".equals(success)){ %>
<p style="color:green;text-align:center;">Applied successfully</p>
<% } %>

<a href="<%=request.getContextPath()%>/logout" class="logout-btn">Logout</a>

<h3>Available Jobs</h3>

<div class="job-list">

<%
List<Job> jobs = (List<Job>) request.getAttribute("jobs");

if(jobs!=null){
for(Job job:jobs){
%>

<div class="job-card">
    <h4><%= job.getTitle() %></h4>

    <p><b>Company:</b> <%= job.getCompany() %></p>
    <p><b>Location:</b> <%= job.getLocation() %></p>

    <p><b>Skills:</b> <%= job.getSkills() %></p>

    <p><b>Description:</b></p>
    <p style="font-size:13px;color:#555;">
        <%= job.getDescription() %>
    </p>

    <form action="<%=request.getContextPath()%>/apply-job" method="post">
        <input type="hidden" name="jobId" value="<%=job.getJobId() %>">
        <button type="submit">Apply</button>
    </form>
</div>

<% }} %>

</div>
</div>
</body>
</html>
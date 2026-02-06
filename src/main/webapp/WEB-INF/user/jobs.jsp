<%@ page import="java.util.List" %>
<%@ page import="com.jobportal.model.Job" %>

<%
String error = request.getParameter("error");
String success = request.getParameter("success");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Available Jobs</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/dashboard.css">
</head>

<body>

<div class="dashboard">

<h2>Available Jobs</h2>

<% if("already_applied".equals(error)){ %>
<p style="color:red;text-align:center;">You already applied for this job.</p>
<% } %>

<% if("true".equals(success)){ %>
<p style="color:green;text-align:center;">Application submitted successfully!</p>
<% } %>

<table>
    <tr>
        <th>Job Title</th>
        <th>Company</th>
        <th>Location</th>
        <th>Description</th>
        <th>Action</th>
    </tr>

<%
List<Job> jobs = (List<Job>) request.getAttribute("jobs");

if(jobs != null){
    for(Job job : jobs){
%>

<tr>
    <td><%= job.getTitle() %></td>
    <td><%= job.getCompany() %></td>
    <td><%= job.getLocation() %></td>
    <td><%= job.getDescription() %></td>
    <td>
        <form action="<%=request.getContextPath()%>/applyJob" method="post">
            <input type="hidden" name="jobId" value="<%=job.getJobId()%>">
            <button type="submit">Apply</button>
        </form>
    </td>
</tr>

<%
    }
}
%>

</table>

<br>

<a href="<%=request.getContextPath()%>/user/dashboard" class="back">
    ← Back to Dashboard
</a>

</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.jobportal.model.Job" %>

<!DOCTYPE html>
<html>
<head>
    <title>HireHub Admin</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/dashboard.css">
</head>

<body>

<div class="admin-container">

    <!-- HEADER -->
    <div class="admin-header">
        <h2>HireHub Admin Dashboard</h2>
        <a href="<%=request.getContextPath()%>/logout" class="logout-btn">Logout</a>
    </div>

    <!-- TOP ACTIONS -->
    <div style="margin-bottom:20px;">
        <a href="<%= request.getContextPath() %>/admin/post-job" class="link">➕ Post New Job</a>
        |
        <a href="<%= request.getContextPath() %>/admin/applications" class="link">📄 View Applications</a>
    </div>

    <h3>All Jobs</h3>

    <table>
        <tr>
            <th>Title</th>
            <th>Company</th>
            <th>Location</th>
            <th>Skills</th>
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
            <td><%= job.getSkills() %></td>

            <td>

                <!-- EDIT -->
                <form action="<%=request.getContextPath()%>/admin/edit-job"
                      method="get" style="display:inline;">
                    <input type="hidden" name="jobId" value="<%= job.getJobId() %>">
                    <button type="submit">Edit</button>
                </form>

                <!-- DELETE -->
                <form action="<%=request.getContextPath()%>/admin/delete-job"
                      method="post" style="display:inline;">
                    <input type="hidden" name="jobId" value="<%= job.getJobId() %>">
                    <button type="submit" style="background:#e74c3c;">Delete</button>
                </form>

            </td>
        </tr>

<%
    }
}
%>

    </table>

</div>

</body>
</html>
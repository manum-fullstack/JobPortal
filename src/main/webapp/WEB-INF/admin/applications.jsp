<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.jobportal.model.Application" %>

<!DOCTYPE html>
<html>
<head>
    <title>All Applications</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/applications.css">
</head>

<body>

<div class="app-container">

<h2>All Job Applications (Admin)</h2>

<table>
    <tr>
        <th>User</th>
        <th>Job</th>
        <th>Company</th>
        <th>Status</th>
        <th>Applied At</th>
    </tr>

<%
    List<Application> list = (List<Application>) request.getAttribute("applications");

    if(list != null && !list.isEmpty()){
        for(Application a : list){
%>

<tr>
    <td><%= a.getUsername() %></td>
    <td><%= a.getTitle() %></td>
    <td><%= a.getCompany() %></td>
    <td><%= a.getStatus() %></td>
    <td><%= a.getAppliedAt() %></td>
</tr>

<%
        }
    } else {
%>

<tr>
    <td colspan="5">No applications found.</td>
</tr>

<%
    }
%>

</table>

<a href="<%=request.getContextPath()%>/admin/dashboard" class="back-btn">
Back to Dashboard
</a>

</div>

</body>
</html>
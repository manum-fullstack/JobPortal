<%@ page language="java" %>
<%@ page import="java.util.*, com.jobportal.model.Application" %>

<h2>My Applications</h2>

<table border="1">
    <tr>
        <th>Job</th>
        <th>Company</th>
        <th>Status</th>
        <th>Applied At</th>
    </tr>

<%
    List<Application> list =
        (List<Application>) request.getAttribute("applications");

    for (Application a : list) {
%>
    <tr>
        <td><%= a.getTitle() %></td>
        <td><%= a.getCompany() %></td>
        <td><%= a.getStatus() %></td>
        <td><%= a.getAppliedAt() %></td>
    </tr>
<%
    }
%>
</table>

<br>
<a href="<%=request.getContextPath()%>/user/dashboard">Back to Dashboard</a>
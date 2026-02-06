<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>403- Access Denied</h2>
<p>You do not have permission to access this page.</p>
<a href="<%=request.getContextPath() %>/login.jsp">Go to Login</a>
</body>
</html>
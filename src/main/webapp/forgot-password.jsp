<!DOCTYPE html>
<html>
<head>
    <title>Forgot Password</title>
    <link rel="stylesheet" href="style.css">
</head>
<body class="auth-body">

<div class="container">

<div class="logo">HireHub</div>
<div class="quote">Reset your password</div>

<h2>Forgot Password</h2>

<form action="<%=request.getContextPath()%>/reset-password" method="post">

<div class="field">
<input type="text" name="username" placeholder="Username" required>
</div>

<div class="field">
<input type="password" name="newPassword" placeholder="New Password" required>
</div>

<button type="submit">Reset Password</button>

<a href="login.jsp" class="link">Back to Login</a>

</form>

</div>
</body>
</html>
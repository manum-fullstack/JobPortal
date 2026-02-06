<!DOCTYPE html>
<html>
<head>
<title>HireHub Login</title>
<link rel="stylesheet" href="style.css">
</head>

<body class="auth-body">

<div class="container">

<div class="logo">HireHub</div>
<div class="quote">Connecting Talent with Opportunity</div>

<h2>Login</h2>

<form action="<%=request.getContextPath()%>/login"
      method="post"
      onsubmit="return validateForm()">

<div class="field">
<input type="text" name="username" placeholder="Username" required>
</div>

<div class="field">
<input type="password" name="password" placeholder="Password" required>
<small id="passMsg"></small>
</div>

<a href="<%=request.getContextPath()%>/forgot-password.jsp" class="link">
Forgot Password?
</a>

<button type="submit">Login</button>

</form>

<a href="signup.jsp" class="link">Create Account</a>

</div>

<script>
function validateForm(){
const pass=document.querySelector('input[name="password"]').value;
const msg=document.getElementById("passMsg");

if(pass.length<6){
msg.textContent="Password must be at least 6 characters";
msg.style.color="red";
return false;
}
msg.textContent="";
return true;
}
</script>

</body>
</html>
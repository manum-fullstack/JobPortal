<!DOCTYPE html>
<html>
<head>
<title>HireHub Signup</title>
<link rel="stylesheet" href="style.css">
</head>

<body class="auth-body">

<div class="container">

<div class="logo">HireHub</div>
<div class="quote">Where Talent Meets Opportunity</div>

<h2>Sign Up</h2>

<form action="<%=request.getContextPath()%>/signup"
      method="post"
      onsubmit="return validateForm()">

<div class="field">
<input type="text" name="username" placeholder="Username" required>
</div>

<div class="field">
<input type="email" name="email" placeholder="Email" required>
</div>

<div class="field">
<input type="password" name="password" placeholder="Password" required>
<small id="passMsg"></small>
</div>

<button>Create Account</button>

</form>

<a href="login.jsp" class="link">Already have an account? Login</a>

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
function validateForm() {

    let email = document.getElementById("email").value.trim();
    let password = document.getElementById("password").value;

    let emailPattern = /^[^ ]+@[^ ]+\.[a-z]{2,3}$/;

    // Email check
    if (!emailPattern.test(email)) {
        alert("Enter valid email!");
        return false;
    }

    // Password length
    if (password.length < 6) {
        alert("Password must be at least 6 characters!");
        return false;
    }

    // Must contain number
    if (!/\d/.test(password)) {
        alert("Password must include a number!");
        return false;
    }

    return true;
}

document.getElementById("password").addEventListener("input", function() {
    let msg = document.getElementById("passMsg");

    if(this.value.length < 6){
        msg.innerText = "Weak password";
        msg.style.color = "red";
    } else {
        msg.innerText = "Strong password";
        msg.style.color = "green";
    }
});
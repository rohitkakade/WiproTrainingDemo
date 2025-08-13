function validateEmail() {
    let email = document.getElementById("email").value.trim();
    let emailError = document.getElementById("emailError");
    let emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (email === "" || !emailPattern.test(email)) {
        emailError.style.visibility = "visible";
        return false;
    } else {
        emailError.style.visibility = "hidden";
        return true;
    }
}

function validatePassword() {
    let password = document.getElementById("password").value.trim();
    let passwordError = document.getElementById("passwordError");

    if (password === "") {
        passwordError.style.visibility = "visible";
        return false;
    } else {
        passwordError.style.visibility = "hidden";
        return true;
    }
}

function handleLogin() {
    let emailValid = validateEmail();
    let passwordValid = validatePassword();

    if (emailValid && passwordValid) {
        alert("Login successful!");
    }
}

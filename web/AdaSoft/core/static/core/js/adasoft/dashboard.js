document.addEventListener("DOMContentLoaded", function() {
    if (localStorage.getItem('sessionId') == null) {
        window.location.href = "http://localhost:8000/sign-in";
    }
});
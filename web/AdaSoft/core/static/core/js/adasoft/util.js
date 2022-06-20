function Logout() {
    console.log("logout");
    window.location.href = "http://localhost:8000/sign-in";
    localStorage.removeItem('sessionId');
}
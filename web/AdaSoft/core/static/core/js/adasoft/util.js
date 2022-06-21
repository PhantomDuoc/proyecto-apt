document.addEventListener("DOMContentLoaded", function() {

    console.log("cargando usuario");
    console.log(localStorage.getItem('sessionId'));
    getUserById();
    console.log("usuario cargado");
});

function Logout() {
    console.log("logout");
    window.location.href = "http://localhost:8000/sign-in";
    localStorage.removeItem('sessionId');
}

function getUserById() {
    var id = localStorage.getItem('sessionId');
    fetch('http://localhost:8091/v1/departamento/gerencia/usuario/findById/' + id, {
            method: "GET",
            headers: {
                'Content-type': 'application/json',
                'Allow-Control-Allow-Origin': '*'
            },
        })
        .then(res => {
            if (res.ok) {
                console.log("HTTP request successful")
            } else {
                console.log("HTTP request unsuccessful")
            }
            return res
        })
        .then(res => res.json())
        .then(data => {
            console.log(data);
            document.getElementById("usuarioLogeado").innerHTML = data.username;
        })
        .catch(error => console.log(error));
}
document.addEventListener("DOMContentLoaded", function() {

});


function validarFormulario(evento) {
    var usuario = document.getElementById('username').value;
    var password = document.getElementById('password').value;

    fetchAsync("http://localhost:8091/v1/departamento/gerencia/usuario/findByUsername/" + usuario, { mode: 'no-cors' }).then(function(data) {
        console.log(data);
        if (data.length === 0) {
            alert('Usuario no existe');
            return;
        }
        if (data.password !== password) {
            alert('Contraseña Incorrecta');
            return;
        } else {
            if (data.password === password) {
                localStorage.setItem('sessionId', data.id);
                if (data.type == 0) {
                    window.location.href = "http://localhost:8000/dashboard";
                }
                if (data.type != 0) {
                    alert('Sesión Iniciada Exitosamente')
                        /* window.location.href = ""; */
                }
            }
        }
    });
}

async function fetchAsync(url) {
    let response = await fetch(url);
    let data = await response.json();
    return data;
}

function saveValue(e) {
    var id = e.id; // get the sender's id to save it . 
    var val = e.value; // get the value. 
    console.log(id + ": " + val);
    localStorage.setItem(id, val); // Every time user writing something, the localStorage's value will override . 
}

//get the saved value function - return the value of "v" from localStorage. 
function getSavedValue(v) {
    if (!localStorage.getItem(v)) {
        return "None"; // You can change this to your defualt value. 
    }
    return localStorage.getItem(v);
}

function checkSubmit(e) {
    if (e && e.keyCode == 13) {
        validarFormulario();
    }
}
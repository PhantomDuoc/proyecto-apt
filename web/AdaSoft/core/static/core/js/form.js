document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("formulario").addEventListener('submit', validarFormulario);
});


function validarFormulario(evento) {
    evento.preventDefault();
    var usuario = document.getElementById('user').value;
    var password = document.getElementById('pass').value;

    fetchAsync("http://localhost:8091/v1/departamento/gerencia/usuario/findByUsername/" + usuario, { mode: 'no-cors' }).then(function(data) {
        console.log('aqui');
        console.log(data);
        if (data.length === 0) {
            alert('Usuario no existe');
            return;
        }
        if (data.password !== password) {
            alert('Contraseña Incorrecta');
            return;
        }
        if (data.password === password) {
            alert('Bienvenido ' + data.username);
        }
        if (data.type == 0) {
            alert('Redireccionando a Panel de Administración')
            window.location.href = "http://localhost:8000/usuarios";
        }
        if (data.type != 0) {
            alert('Sesión Iniciada Exitosamente')
            window.location.href = "http://localhost:8000/indexlog";
        }
    });
}

var usuario = document.getElementById('user').value;
if (!(usuario === usuario1) || (usuario.length < 7)) {
    alert('Usuario Incorrecto, Debes ingresar un usuario válido de almenos 6 caracteres');
    return;

}

var password = document.getElementById('pass').value;
if (!(password === contrasena1) || (password.length < 4)) {
    alert('Contraseña Incorrecta, Debes ingresar contraseña valida de almenos 4-8 caracteres');
    return;
}
this.submit();
alert('Inicio Sesion Con Exito');
}
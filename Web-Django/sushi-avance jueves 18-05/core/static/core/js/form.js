document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("formulario").addEventListener('submit', validarFormulario);
});


function validarFormulario(evento) {
    evento.preventDefault();
    var usuario1 = "pepito97"
    var contrasena1 = "12345"
    
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
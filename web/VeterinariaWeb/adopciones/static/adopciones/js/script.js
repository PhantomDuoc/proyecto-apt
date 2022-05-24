$(document).ready(function() {
    alert('paso1')
    $.getJSON('http://127.0.0.1:8000/api/lista_adopciones', function(data) {
        console.log(data)
        var estado = data;
        var today = new Date();
        var dd = today.getDate();
        var mm = today.getMonth() + 1; //January is 0!
        var yyyy = today.getFullYear();
        if (dd < 10) {
            dd = '0' + dd;
        }
        if (mm < 10) {
            mm = '0' + mm;
        }

        today = dd + '/' + mm + '/' + yyyy;

        $('#fecha').html(today);
        $('#estado_id').html(estado.estado_id);
        $('#estado').html(estado.estado);
    }).fail(function() {
        console.log('Error al consumir la API!');
    });

});
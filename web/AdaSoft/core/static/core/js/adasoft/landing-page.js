document.addEventListener("DOMContentLoaded", function () {
    sessionId = localStorage.getItem('sessionId');
    console.log(sessionId);
    checkLogin();
    carrito = []
    total = 0;
    i = 0;
});

function addToCart(id, price) {
    total += price;
    carrito.push(id);
    console.log(carrito);
    console.log(total)
    updateCart(id);
    i++;
}

function remove(el, id, precio) {
    var element = el;
    element.remove();
    carrito.splice(carrito.indexOf(id), 1);
    total -= precio;
    document.getElementById("sum").textContent = "$" + total;
    document.getElementById("count").textContent = carrito.length;
    console.log(carrito);
}

function vaciar() {
    var tbody = document.getElementById('tbody');
    tbody.innerHTML = "";
    carrito.length = 0;
    document.getElementById("sum").textContent = "$" + 0;
    document.getElementById("count").textContent = carrito.length;
    console.log(carrito);
}

function updateCart(id) {
    fetchAsync("http://localhost:8090/v1/departamento/gerencia/producto/findById/" + id, {
            'method': 'GET',
            'headers': {
                'Content-type': 'application/json',
                'Access-Control-Allow-Origin': '*',
                'Access-Control-Allow-Methods': 'GET, POST, PUT, DELETE, OPTIONS',
                'Access-Control-Allow-Headers': 'Content-Type',
            }
        })
        .then(function (data) {
            console.log(data);
            var tbody = document.getElementById('tbody');
            var tr = "<tr id='count" + i + "'>";
            tr += "<td>" + data.nombre + "</td>";
            tr += "<td>" + data.precio + "</td>";
            tr += "<td>" + "<a onclick='remove(count" + i + ", " + data.id + ", " + data.precio + ")' class='text-secondary font-weight-bold text-xs' data-toggle='tooltip' data-original-title='Edit user' onclick=(deleteProduct({{i.id}}))>Eliminar</a>" + "</td>";

            console.log("producto a mostrar en Modal: ", data);
            /*             document.getElementById("updateName").value = data.nombre;
                        document.getElementById("updatePrecio").value = data.precio;
                        document.getElementById("updateImagen").value = data.imagen;
                        document.getElementById("updateName").focus();
                        document.getElementById("updatePrecio").focus();
                        document.getElementById("updateImagen").focus(); */
            tbody.innerHTML += tr;
        }).catch(error => console.log(error));
    document.getElementById("sum").textContent = "$" + total;
    document.getElementById("count").textContent = carrito.length;

}

function buy(){
    confirm('¿Estás seguro de que quieres comprar?');
    var modal = document.getElementById("myModal");
    modal.style.display = "none";

    var modalNew = document.getElementById("myModalNew");
    var span = document.getElementsByClassName("close")[1];
    modalNew.style.display = "block";

    
    document.onkeyup = function (e) {
        if (e.key == "Escape") {
            modal.style.display = "none";
        }
    }
    span.onclick = function () {
        modal.style.display = "none";
    }
}

function crearPedido() {
    var modal = document.getElementById("myModal");
    /* AGREGAR MODAL Y CARGAR DATOS DE LOCALSTORAGE */
    var span = document.getElementsByClassName("close")[0];


    modal.style.display = "block";

    // When the user clicks on <span> (x), close the modal

    document.onkeyup = function (e) {
        if (e.key == "Escape") {
            modal.style.display = "none";
        }
    }
    span.onclick = function () {
        modal.style.display = "none";
    }

}

function checkLogin() {
    if (sessionId != null) {
        document.getElementById("login").style.display = "none";
        document.getElementById("register").style.display = "none";
        document.getElementById("logout").style.display = "block";
        document.getElementById("pideAquiButton").style.display = "";
    }
    if (sessionId == null) {
        document.getElementById("login").style.display = "block";
        document.getElementById("register").style.display = "block";
        document.getElementById("pide").style.display = "none";
        document.getElementById("pideAqui").style.display = "none";
        document.getElementById("logout").style.display = "none";
        document.getElementById("usuarioLogeado").style.display = "none";
        document.getElementById("pideAquiButton").style.display = "none";
        var botones = document.getElementsByClassName("add-to-cart");
        for (var i = 0; i < botones.length; i++) {
            botones[i].style.display = "none";
        }
    }
}

async function fetchAsync(url) {
    let response = await fetch(url);
    let data = await response.json();
    return data;
}
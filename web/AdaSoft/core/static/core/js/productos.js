var inputGroup = document.getElementById('input-group');
var inputs = inputGroup.getElementsByTagName('input');

for (i = 0; i < inputs.length; i++) {
    var id = inputs[i].getAttribute('id');
    inputs[i].value = getSavedValue(id);
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


function updateUser(id, nombre, codigo, precio, stock, descripcion, categoria, imagen) {
    fetch('http://localhost:8090/v1/departamento/gerencia/producto/update', {
            method: "PUT",
            headers: {
                'Content-type': 'application/json',
                'Allow-Control-Allow-Origin': '*'
            },
            body: JSON.stringify({
                id: id,
                nombre: nombre,
                codigo: codigo,
                precio: precio,
                stock: stock,
                descripcion: descripcion,
                categoria: categoria,
                imagen: imagen,
            }),
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
        .then(data => console.log(data))
        .catch(error => console.log(error))
        /* window.location.reload(); */
}

function crearUser(nombre, codigo, precio, stock, descripcion, categoria, imagen) {
    fetch('http://localhost:8090/v1/departamento/gerencia/producto/update', {
            method: "PUT",
            headers: {
                'Content-type': 'application/json',
                'Allow-Control-Allow-Origin': '*'
            },
            body: JSON.stringify({
                nombre: nombre,
                codigo: codigo,
                precio: precio,
                stock: stock,
                descripcion: descripcion,
                categoria: categoria,
                imagen: imagen,
            })
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
        .then(data => console.log(data))
        .catch(error => console.log(error))
    window.location.reload();
}

function deleteUser(id) {
    fetch('http://localhost:8090/v1/departamento/gerencia/producto/delete/' + id, {
            method: "DELETE",
            headers: {
                'Content-type': 'application/json',
                'Access-Control-Allow-Origin': '*'
            }
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
        .then(data => console.log(data))
        .catch(error => console.log(error))
    window.location.reload();
}
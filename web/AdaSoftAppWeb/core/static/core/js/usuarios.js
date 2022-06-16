function updateUser(id, username, password, email, direccion, telefono, rut, type) {
    fetch('http://localhost:8091/v1/departamento/gerencia/usuario/update', {
            method: "PUT",
            headers: {
                'Content-type': 'application/json',
                'Allow-Control-Allow-Origin': '*'
            },
            body: JSON.stringify({
                id: id,
                username: username,
                password: password,
                email: email,
                direccion: direccion,
                telefono: telefono,
                rut: rut,
                type: type
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
        /* window.location.reload(); */
}

function crearUser(username, password, email, direccion, telefono, rut, type) {
    fetch('http://localhost:8091/v1/departamento/gerencia/usuario/update', {
            method: "PUT",
            headers: {
                'Content-type': 'application/json',
                'Allow-Control-Allow-Origin': '*'
            },
            body: JSON.stringify({
                username: username,
                password: password,
                email: email,
                direccion: direccion,
                telefono: telefono,
                rut: rut,
                type: type
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
    fetch('http://localhost:8091/v1/departamento/gerencia/usuario/delete/' + id, {
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
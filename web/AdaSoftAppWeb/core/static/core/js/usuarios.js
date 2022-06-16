function updateUser() {
    fetch('http://localhost:8091/v1/departamento/gerencia/usuario/update', {
            method: "PUT",
            headers: {
                'Content-type': 'application/json',
                'Allow-Control-Allow-Origin': '*'
            },
            body: JSON.stringify({
                id: 2,
                username: "admin",
                password: "admin",
                rut: 123456789,
                direccion: "direccion",
                email: "email",
                type: 0,
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
}

function deleteUser() {
    fetch('http://localhost:8091/v1/departamento/gerencia/usuario/delete/5', {
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
}
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("prod1");
});

function producto(evento) {
    evento.preventDefault();
    fetchAsync("" + usuario).then(function(data) {



    });



}
async function fetchAsync(url) {
    let response = await fetch(url);
    let data = await response.json();
    return data;
}
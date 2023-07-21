$(document).ready(function() {
    let documentoUsu=window.sessionStorage.getItem("id_usuario")
    $.ajax({
        url: 'https://bdagroexpress-production.up.railway.app/totalproductos/'+documentoUsu,
        type: 'GET',
        dataType: "JSON",
        success: function(respuesta) {
            // Aquí actualizamos el contenido del elemento con la respuesta del AJAX
            $(".cantidad-number").text(respuesta);
            console.log(documentoUsu)
        }
    });
});
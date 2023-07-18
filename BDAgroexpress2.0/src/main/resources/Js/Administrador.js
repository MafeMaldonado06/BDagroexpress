$(document).ready(function(){
    const productos = document.getElementById('productos')

    $.ajax({
        url : 'http://localhost:8080/Listarproductos',
        type : 'GET',
        dataType : "JSON",
        success : function(respuesta){

            if(respuesta.lenght = null){
                productos.innerHTML = '<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay productos de esta categoria</span></div>'
            }else{
                for (let producto = 0; producto < respuesta.length; producto++) {
                    productos.innerHTML += '<div class="card-producto card shadow"><div class="d-flex justify-content-center overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-75" alt=""></div><div class="ms-3"><h3>' + respuesta[producto].det_Nombre_poduct + '</h3><h6>' + '$' + respuesta[producto].det_precio + '</h6></div><div class="d-flex justify-content-center"><button class="boton-verMas-cartaProducto" type="button" data-bs-toggle="modal" data-bs-target="#staticBackdrop'+ producto +'"><span>Ver más</span></button></div><div class="modal fade" id="staticBackdrop' + producto + '" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="staticBackdropLabel">' + respuesta[producto].det_Nombre_poduct +'</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body d-flex"><div class="col d-flex justify-content-center align-items-center"><div class="producto-img-modal bg-info"><img src="../Img/Durazno.JPG" alt=""></div></div><div class="col"><ul class="datos-usuario-bandeja list-unstyled"><li><span class="tutilo-dato-usuario-bandeja">Referencia:</span><span>' + respuesta[producto].det_Referencia + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Usuario:</span><span>' + respuesta[producto].det_IdUsuario.usu_Nombre + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Categoria</span><span>' + respuesta[producto].det_Categoria +'</span></li><li><span class="tutilo-dato-usuario-bandeja">Precio:</span><span>' + respuesta[producto].det_precio + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Cantidad disponible:</span><span>'+ respuesta[producto].det_cantidad +'</span></li></ul></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="btn btn-dark">Actualizar</button></div></div></div></div></div>'
                };
            }
        }

    })


    //Usuarios
    const usuarios = document.getElementById('usuarios')

    $.ajax({
        url : 'http://localhost:8080/ListarUsuarios',
        type : 'GET',
        dataType : "JSON",
        success : function(respuesta){
            
        }
    })
})
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
                let id = 1;
                for (let producto = 0; producto < respuesta.length; producto++, id++) {
                    let detReferencia = respuesta[producto].det_Referencia;
                    productos.innerHTML += '<div class="card-producto card shadow"><div class="d-flex justify-content-center overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-75" alt=""></div><div class="ms-3"><h3>' + respuesta[producto].det_Nombre_product + '</h3><h6>' + '$' + respuesta[producto].det_precio + '</h6></div><div class="d-flex justify-content-center"><button class="boton-verMas-cartaProducto" type="button" data-bs-toggle="modal" data-bs-target="#staticBackdrop' + producto + '" data-det-referencia="' + detReferencia + '"><span>Ver más</span></button></div><div class="modal fade" id="staticBackdrop' + producto + '" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="staticBackdropLabel">' + respuesta[producto].det_IdUsuario.usu_Nombre + '</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body d-flex"><div class="col d-flex justify-content-center align-items-center"><div class="producto-img-modal bg-info"><img src="../Img/Durazno.JPG" alt=""></div></div><div class="col"><ul class="datos-usuario-bandeja list-unstyled"><li><span class="tutilo-dato-usuario-bandeja">Referencia:</span><span id="idproducto">' + detReferencia + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Producto:</span><span id="Nomproduct" onclick="convertirEnInput(this)">' + respuesta[producto].det_Nombre_product + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Categoria:</span><span id="categoria" onclick="convertirEnInput(this)">' + respuesta[producto].det_Categoria + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Precio:</span><span id="precio" onclick="convertirEnInput(this)">' + respuesta[producto].det_precio + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Cantidad disponible:</span><span id="cantidad" onclick="convertirEnInput(this)">' + respuesta[producto].det_cantidad + '</span></li></ul></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="btn btn-dark" id="Actualizar">Actualizar</button></div></div></div></div></div>';
                };

            }
        }
    })


    $("#botonfrutas").on("click", function() {
        productos.innerHTML=""
        $.ajax({
            url: "http://localhost:8080/Frutas",
            type: "GET",
            dataType: "JSON",
            success: function(respuesta) {
                if(respuesta.lenght = null){
                    productos.innerHTML = '<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay productos de esta categoria</span></div>'
                }else{
                    for (let producto = 0; producto < respuesta.length; producto++, id++) {
                        let detReferencia = respuesta[producto].det_Referencia;
                        productos.innerHTML += '<div class="card-producto card shadow"><div class="d-flex justify-content-center overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-75" alt=""></div><div class="ms-3"><h3>' + respuesta[producto].det_Nombre_product + '</h3><h6>' + '$' + respuesta[producto].det_precio + '</h6></div><div class="d-flex justify-content-center"><button class="boton-verMas-cartaProducto" type="button" data-bs-toggle="modal" data-bs-target="#staticBackdrop' + producto + '" data-det-referencia="' + detReferencia + '"><span>Ver más</span></button></div><div class="modal fade" id="staticBackdrop' + producto + '" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="staticBackdropLabel">' + respuesta[producto].det_IdUsuario.usu_Nombre + '</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body d-flex"><div class="col d-flex justify-content-center align-items-center"><div class="producto-img-modal bg-info"><img src="../Img/Durazno.JPG" alt=""></div></div><div class="col"><ul class="datos-usuario-bandeja list-unstyled"><li><span class="tutilo-dato-usuario-bandeja">Referencia:</span><span id="idproducto">' + detReferencia + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Producto:</span><span id="Nomproduct" onclick="convertirEnInput(this)">' + respuesta[producto].det_Nombre_product + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Categoria:</span><span id="categoria" onclick="convertirEnInput(this)">' + respuesta[producto].det_Categoria + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Precio:</span><span id="precio" onclick="convertirEnInput(this)">' + respuesta[producto].det_precio + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Cantidad disponible:</span><span id="cantidad" onclick="convertirEnInput(this)">' + respuesta[producto].det_cantidad + '</span></li></ul></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="btn btn-dark" id="botton">Actualizar</button></div></div></div></div></div>';
                    };

                }
            }
        });
    });


    $("#botonverduras").on("click", function() {
        productos.innerHTML=""
        $.ajax({
            url: "http://localhost:8080/Verduras",
            type: "GET",
            dataType: "JSON",
            success: function(respuesta) {
                if(respuesta.lenght = null){
                    productos.innerHTML = '<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay productos de esta categoria</span></div>'
                }else{
                    for (let producto = 0; producto < respuesta.length; producto++, id++) {
                        let detReferencia = respuesta[producto].det_Referencia;
                        productos.innerHTML += '<div class="card-producto card shadow"><div class="d-flex justify-content-center overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-75" alt=""></div><div class="ms-3"><h3>' + respuesta[producto].det_Nombre_product + '</h3><h6>' + '$' + respuesta[producto].det_precio + '</h6></div><div class="d-flex justify-content-center"><button class="boton-verMas-cartaProducto" type="button" data-bs-toggle="modal" data-bs-target="#staticBackdrop' + producto + '" data-det-referencia="' + detReferencia + '"><span>Ver más</span></button></div><div class="modal fade" id="staticBackdrop' + producto + '" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="staticBackdropLabel">' + respuesta[producto].det_IdUsuario.usu_Nombre + '</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body d-flex"><div class="col d-flex justify-content-center align-items-center"><div class="producto-img-modal bg-info"><img src="../Img/Durazno.JPG" alt=""></div></div><div class="col"><ul class="datos-usuario-bandeja list-unstyled"><li><span class="tutilo-dato-usuario-bandeja">Referencia:</span><span id="idproducto">' + detReferencia + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Producto:</span><span id="Nomproduct" onclick="convertirEnInput(this)">' + respuesta[producto].det_Nombre_product + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Categoria:</span><span id="categoria" onclick="convertirEnInput(this)">' + respuesta[producto].det_Categoria + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Precio:</span><span id="precio" onclick="convertirEnInput(this)">' + respuesta[producto].det_precio + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Cantidad disponible:</span><span id="cantidad" onclick="convertirEnInput(this)">' + respuesta[producto].det_cantidad + '</span></li></ul></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="btn btn-dark" id="botton">Actualizar</button></div></div></div></div></div>';
                    };

                }
            }
        });
    });

    $("#botonlegumbres").on("click", function() {
        productos.innerHTML=""
        $.ajax({
            url: "http://localhost:8080/Legumbres",
            type: "GET",
            dataType: "JSON",
            success: function(respuesta) {
                if(respuesta.lenght = null){
                    productos.innerHTML = '<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay productos de esta categoria</span></div>'
                }else{
                    for (let producto = 0; producto < respuesta.length; producto++, id++) {
                        let detReferencia = respuesta[producto].det_Referencia;
                        productos.innerHTML += '<div class="card-producto card shadow"><div class="d-flex justify-content-center overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-75" alt=""></div><div class="ms-3"><h3>' + respuesta[producto].det_Nombre_product + '</h3><h6>' + '$' + respuesta[producto].det_precio + '</h6></div><div class="d-flex justify-content-center"><button class="boton-verMas-cartaProducto" type="button" data-bs-toggle="modal" data-bs-target="#staticBackdrop' + producto + '" data-det-referencia="' + detReferencia + '"><span>Ver más</span></button></div><div class="modal fade" id="staticBackdrop' + producto + '" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="staticBackdropLabel">' + respuesta[producto].det_IdUsuario.usu_Nombre + '</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body d-flex"><div class="col d-flex justify-content-center align-items-center"><div class="producto-img-modal bg-info"><img src="../Img/Durazno.JPG" alt=""></div></div><div class="col"><ul class="datos-usuario-bandeja list-unstyled"><li><span class="tutilo-dato-usuario-bandeja">Referencia:</span><span id="idproducto">' + detReferencia + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Producto:</span><span id="Nomproduct" onclick="convertirEnInput(this)">' + respuesta[producto].det_Nombre_product + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Categoria:</span><span id="categoria" onclick="convertirEnInput(this)">' + respuesta[producto].det_Categoria + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Precio:</span><span id="precio" onclick="convertirEnInput(this)">' + respuesta[producto].det_precio + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Cantidad disponible:</span><span id="cantidad" onclick="convertirEnInput(this)">' + respuesta[producto].det_cantidad + '</span></li></ul></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="btn btn-dark" id="botton">Actualizar</button></div></div></div></div></div>';
                    };

                }
            }
        });
    });


    //Usuarios
    const usuarios = document.getElementById('usuarios')

    $.ajax({
        url: 'http://localhost:8080/ListarUsuarios',
        type: 'GET',
        dataType: "JSON",
        success: function(respuesta) {
            if (respuesta.length === 0) {
                usuarios.innerHTML = '<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay productos de esta categoría</span></div>';
            } else {
                for (let usuario = 0; usuario < respuesta.length; usuario++) {
                    usuarios.innerHTML += '<div class="card-usuario card d-flex justify-content-center shadow"><div class="d-flex justify-content-center w-100 py-3"><div class="imagen-carta-usuario"><img src="../Img/pexels-bruno-salvadori-2330169.jpg" class="d-block w-100" alt=""></div></div><div class="card-body"><div class="d-flex flex-column align-items-center"><span>' + respuesta[usuario].usu_Nombre + '</span><span>' + respuesta[usuario].usu_Apellidos + '</span></div><div class="botones-carta-usuario d-flex justify-content-around my-3"><button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Actualizar</button><button class="btn btn-dark">Eliminar</button></div></div></div></div>';
                }
            }
        }
    });


    $("#todos").on("click",function(){
        const usuarios = document.getElementById('usuarios')
        usuarios.innerHTML=""
        $.ajax({
            url: 'http://localhost:8080/ListarUsuarios',
            type: 'GET',
            dataType: "JSON",
            success: function(respuesta) {
                if (respuesta.length === 0) {
                    usuarios.innerHTML = '<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay productos de esta categoría</span></div>';
                } else {
                    for (let usuario = 0; usuario < respuesta.length; usuario++) {
                        usuarios.innerHTML += '<div class="card-usuario card d-flex justify-content-center shadow"><div class="d-flex justify-content-center w-100 py-3"><div class="imagen-carta-usuario"><img src="../Img/pexels-bruno-salvadori-2330169.jpg" class="d-block w-100" alt=""></div></div><div class="card-body"><div class="d-flex flex-column align-items-center"><span>' + respuesta[usuario].usu_Nombre + '</span><span>' + respuesta[usuario].usu_Apellidos + '</span></div><div class="botones-carta-usuario d-flex justify-content-around my-3"><button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Actualizar</button><button class="btn btn-dark">Eliminar</button></div></div></div></div>';
                    }
                }
            }
        });
    })

    $("#Administrador").on("click",function(){
        const usuarios = document.getElementById('usuarios')
        usuarios.innerHTML=""
        $.ajax({
            url: 'http://localhost:8080/listarAdministradores',
            type: 'GET',
            dataType: "JSON",
            success: function(respuesta) {
                if (respuesta.length === 0) {
                    usuarios.innerHTML = '<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay productos de esta categoría</span></div>';
                } else {
                    for (let usuario = 0; usuario < respuesta.length; usuario++) {
                        usuarios.innerHTML += '<div class="card-usuario card d-flex justify-content-center shadow"><div class="d-flex justify-content-center w-100 py-3"><div class="imagen-carta-usuario"><img src="../Img/pexels-bruno-salvadori-2330169.jpg" class="d-block w-100" alt=""></div></div><div class="card-body"><div class="d-flex flex-column align-items-center"><span>' + respuesta[usuario].usu_Nombre + '</span><span>' + respuesta[usuario].usu_Apellidos + '</span></div><div class="botones-carta-usuario d-flex justify-content-around my-3"><button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Actualizar</button><button class="btn btn-dark">Eliminar</button></div></div></div></div>';
                    }
                }
            }
        });
    })

    $("#Campesino").on("click",function(){
        const usuarios = document.getElementById('usuarios')
        usuarios.innerHTML=""
        $.ajax({
            url: 'http://localhost:8080/ListarCampesinos',
            type: 'GET',
            dataType: "JSON",
            success: function(respuesta) {
                if (respuesta.length === 0) {
                    usuarios.innerHTML = '<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay productos de esta categoría</span></div>';
                } else {
                    for (let usuario = 0; usuario < respuesta.length; usuario++) {
                        usuarios.innerHTML += '<div class="card-usuario card d-flex justify-content-center shadow"><div class="d-flex justify-content-center w-100 py-3"><div class="imagen-carta-usuario"><img src="../Img/pexels-bruno-salvadori-2330169.jpg" class="d-block w-100" alt=""></div></div><div class="card-body"><div class="d-flex flex-column align-items-center"><span>' + respuesta[usuario].usu_Nombre + '</span><span>' + respuesta[usuario].usu_Apellidos + '</span></div><div class="botones-carta-usuario d-flex justify-content-around my-3"><button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Actualizar</button><button class="btn btn-dark">Eliminar</button></div></div></div></div>';
                    }
                }
            }
        });
    })

    $("#Comprador").on("click",function(){
        const usuarios = document.getElementById('usuarios')
        usuarios.innerHTML=""
        $.ajax({
            url: 'http://localhost:8080/listarCompradores',
            type: 'GET',
            dataType: "JSON",
            success: function(respuesta) {
                if (respuesta.length === 0) {
                    usuarios.innerHTML = '<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay productos de esta categoría</span></div>';
                } else {
                    for (let usuario = 0; usuario < respuesta.length; usuario++) {
                        usuarios.innerHTML += '<div class="card-usuario card d-flex justify-content-center shadow"><div class="d-flex justify-content-center w-100 py-3"><div class="imagen-carta-usuario"><img src="../Img/pexels-bruno-salvadori-2330169.jpg" class="d-block w-100" alt=""></div></div><div class="card-body"><div class="d-flex flex-column align-items-center"><span>' + respuesta[usuario].usu_Nombre + '</span><span>' + respuesta[usuario].usu_Apellidos + '</span></div><div class="botones-carta-usuario d-flex justify-content-around my-3"><button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Actualizar</button><button class="btn btn-dark">Eliminar</button></div></div></div></div>';
                    }
                }
            }
        });
    })

    $("#Transportador").on("click",function(){
        const usuarios = document.getElementById('usuarios')
        usuarios.innerHTML=""
        $.ajax({
            url: 'http://localhost:8080/listarTranpsotador',
            type: 'GET',
            dataType: "JSON",
            success: function(respuesta) {
                if (respuesta.length === 0) {
                    usuarios.innerHTML = '<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay productos de esta categoría</span></div>';
                } else {
                    for (let usuario = 0; usuario < respuesta.length; usuario++) {
                        usuarios.innerHTML += '<div class="card-usuario card d-flex justify-content-center shadow"><div class="d-flex justify-content-center w-100 py-3"><div class="imagen-carta-usuario"><img src="../Img/pexels-bruno-salvadori-2330169.jpg" class="d-block w-100" alt=""></div></div><div class="card-body"><div class="d-flex flex-column align-items-center"><span>' + respuesta[usuario].usu_Nombre + '</span><span>' + respuesta[usuario].usu_Apellidos + '</span></div><div class="botones-carta-usuario d-flex justify-content-around my-3"><button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#staticBackdrop">Actualizar</button><button class="btn btn-dark">Eliminar</button></div></div></div></div>';
                    }
                }
            }
        });
    })

})

let nuevoValorNomproduct;
let nuevoValorCategoria;
let nuevoValorPrecio;
let nuevoValorCantidad;

function convertirEnInput(elemento) {
    // Obtén el contenido actual del span
    let contenidoActual = elemento.innerHTML;

    // Crea un nuevo elemento de entrada (input)
    let input = document.createElement('input');
    input.type = 'text';
    input.value = contenidoActual;

    // Reemplaza el span con el nuevo input
    elemento.parentNode.replaceChild(input, elemento);

    // Establece el foco en el input
    input.focus();

    // Establece el evento 'keyup' para capturar el valor ingresado al presionar Enter
    input.addEventListener('keyup', function(event) {
        if (event.keyCode === 13) { // Verifica si se presionó la tecla Enter (código 13)
            let nuevoValor = input.value;
            guardarCambios(elemento.id, nuevoValor);
        }
    });
}

function guardarCambios(elementoId, nuevoValor) {
    // Guarda el nuevo valor en la variable correspondiente según el elemento
    switch (elementoId) {
        case 'Nomproduct':
            nuevoValorNomproduct = nuevoValor;
            break;
        case 'categoria':
            nuevoValorCategoria = nuevoValor;
            break;
        case 'precio':
            nuevoValorPrecio = nuevoValor;
            break;
        case 'cantidad':
            nuevoValorCantidad = nuevoValor;
            break;
    }

    console.log('Nuevo valor de ' + elementoId + ':', nuevoValor);

}

$(document).on("click", "#Actualizar", function() {
    window.sessionStorage.getItem("id_usuario")

    let datos = {
        det_Nombre_product: nuevoValorNomproduct,
        det_Categoria: nuevoValorCategoria,
        det_precio: parseInt(nuevoValorPrecio),
        det_cantidad: parseInt(nuevoValorCantidad)
    };
    console.log(datos)
    let datosEnvio = JSON.stringify(datos)
    console.log(JSON.stringify(datos));

    $.ajax({
        url: 'http://localhost:8080/ActualizarProducto/8/01',
        type: 'PUT',
        dataType: "JSON",
        data: datosEnvio,
        contentType: "application/JSON",
        success: function(response) {
            alert(response)
        },
        error: function(error) {
           alert(error)
        }
    });
});
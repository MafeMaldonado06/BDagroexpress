$(document).ready(function(){
    
    window.sessionStorage.getItem("id_usuario", documento)

    const productos = document.getElementById('productos')

/* FILTRAR PRODUCTOS */
    $('#enviar_filtro').on('click', function(){

        let filtroSelect = document.getElementById("filtrar");
        let categoriaSeleccionada = filtroSelect.value;

        // Hacer la solicitud AJAX
        let xhr = new XMLHttpRequest();

        if (categoriaSeleccionada == 1){
            productos.innerHTML=""
        $.ajax({
            url: "http://bdagroexpress-production.up.railway.app/Frutas",
            type: "GET",
            dataType: "JSON",
            success: function(respuesta) {
                if(respuesta.lenght = null){
                    productos.innerHTML = '<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay productos de esta categoria</span></div>'
                }else{
                for (let producto = 0; producto < respuesta.length; producto++, id++) {
                    let detReferencia = respuesta[producto].det_Referencia;
                    productos.innerHTML += '<div class="card-producto card shadow"><div class="d-flex justify-content-center overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-75" alt=""></div><div class="ms-3"><h3>' + respuesta[producto].det_Nombre_product + '</h3><h6>' + '$' + respuesta[producto].det_precio + '</h6></div><div class="d-flex justify-content-center"><button class="boton-verMas-cartaProducto" type="button" data-bs-toggle="modal" data-bs-target="#staticBackdrop' + producto + '" data-det-referencia="' + detReferencia + '"><span>Ver más</span></button></div><div class="modal fade" id="staticBackdrop' + producto + '" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="staticBackdropLabel">' + respuesta[producto].det_IdUsuario.usu_Nombre + '</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body d-flex"><div class="col d-flex justify-content-center align-items-center"><div class="producto-img-modal bg-info"><img src="../Img/Durazno.JPG" alt=""></div></div><div class="col"><ul class="datos-usuario-bandeja list-unstyled"><li><span class="tutilo-dato-usuario-bandeja">Referencia:</span><span id="idproducto">' + detReferencia + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Producto:</span><span id="Nomproduct" onclick="convertirEnInput(this)">' + respuesta[producto].det_Nombre_product + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Categoria:</span><span id="categoria" onclick="convertirEnInput(this)">' + respuesta[producto].det_Categoria + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Precio:</span><span id="precio" onclick="convertirEnInput(this)">' + respuesta[producto].det_precio + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Cantidad disponible:</span><span id="cantidad" onclick="convertirEnInput(this)">' + respuesta[producto].det_cantidad + '</span></li></ul></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="btn btn-dark" id="Actualizar">Actualizar</button></div></div></div></div></div>';
                };
    
                }
            }
        });
        }
        else if (categoriaSeleccionada == 2){
            productos.innerHTML=""
        $.ajax({
            url: "http://bdagroexpress-production.up.railway.app/Verduras",
            type: "GET",
            dataType: "JSON",
            success: function(respuesta) {
                if(respuesta.lenght = null){
                    productos.innerHTML = '<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay productos de esta categoria</span></div>'
                }else{
                for (let producto = 0; producto < respuesta.length; producto++, id++) {
                    let detReferencia = respuesta[producto].det_Referencia;
                    productos.innerHTML += '<div class="card-producto card shadow"><div class="d-flex justify-content-center overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-75" alt=""></div><div class="ms-3"><h3>' + respuesta[producto].det_Nombre_product + '</h3><h6>' + '$' + respuesta[producto].det_precio + '</h6></div><div class="d-flex justify-content-center"><button class="boton-verMas-cartaProducto" type="button" data-bs-toggle="modal" data-bs-target="#staticBackdrop' + producto + '" data-det-referencia="' + detReferencia + '"><span>Ver más</span></button></div><div class="modal fade" id="staticBackdrop' + producto + '" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="staticBackdropLabel">' + respuesta[producto].det_IdUsuario.usu_Nombre + '</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body d-flex"><div class="col d-flex justify-content-center align-items-center"><div class="producto-img-modal bg-info"><img src="../Img/Durazno.JPG" alt=""></div></div><div class="col"><ul class="datos-usuario-bandeja list-unstyled"><li><span class="tutilo-dato-usuario-bandeja">Referencia:</span><span id="idproducto">' + detReferencia + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Producto:</span><span id="Nomproduct" onclick="convertirEnInput(this)">' + respuesta[producto].det_Nombre_product + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Categoria:</span><span id="categoria" onclick="convertirEnInput(this)">' + respuesta[producto].det_Categoria + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Precio:</span><span id="precio" onclick="convertirEnInput(this)">' + respuesta[producto].det_precio + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Cantidad disponible:</span><span id="cantidad" onclick="convertirEnInput(this)">' + respuesta[producto].det_cantidad + '</span></li></ul></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="btn btn-dark" id="Actualizar">Actualizar</button></div></div></div></div></div>';
                };
    
                }
            }
        });
        }
        else if(categoriaSeleccionada ==3){
            productos.innerHTML=""
        $.ajax({
            url: "http://bdagroexpress-production.up.railway.app/Legumbres",
            type: "GET",
            dataType: "JSON",
            success: function(respuesta) {
                if(respuesta.lenght = null){
                    productos.innerHTML = '<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay productos de esta categoria</span></div>'
                }else{
                for (let producto = 0; producto < respuesta.length; producto++, id++) {
                    let detReferencia = respuesta[producto].det_Referencia;
                    productos.innerHTML += '<div class="card-producto card shadow"><div class="d-flex justify-content-center overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-75" alt=""></div><div class="ms-3"><h3>' + respuesta[producto].det_Nombre_product + '</h3><h6>' + '$' + respuesta[producto].det_precio + '</h6></div><div class="d-flex justify-content-center"><button class="boton-verMas-cartaProducto" type="button" data-bs-toggle="modal" data-bs-target="#staticBackdrop' + producto + '" data-det-referencia="' + detReferencia + '"><span>Ver más</span></button></div><div class="modal fade" id="staticBackdrop' + producto + '" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="staticBackdropLabel">' + respuesta[producto].det_IdUsuario.usu_Nombre + '</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body d-flex"><div class="col d-flex justify-content-center align-items-center"><div class="producto-img-modal bg-info"><img src="../Img/Durazno.JPG" alt=""></div></div><div class="col"><ul class="datos-usuario-bandeja list-unstyled"><li><span class="tutilo-dato-usuario-bandeja">Referencia:</span><span id="idproducto">' + detReferencia + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Producto:</span><span id="Nomproduct" onclick="convertirEnInput(this)">' + respuesta[producto].det_Nombre_product + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Categoria:</span><span id="categoria" onclick="convertirEnInput(this)">' + respuesta[producto].det_Categoria + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Precio:</span><span id="precio" onclick="convertirEnInput(this)">' + respuesta[producto].det_precio + '</span></li><li><span class="tutilo-dato-usuario-bandeja">Cantidad disponible:</span><span id="cantidad" onclick="convertirEnInput(this)">' + respuesta[producto].det_cantidad + '</span></li></ul></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="btn btn-dark" id="Actualizar">Actualizar</button></div></div></div></div></div>';
                };
    
                }
            }
        });
        }
        
    });

/* AGREGAR PRODUCTO NUEVO */

    $('#publicarproducto').on('click', function(){

        var datos = {
            det_Img:null,
            det_Nombre_product: $('#nombre').val(),
            det_Categoria: $('#categoria').val(),
            det_precio: parseInt($('#precio').val()),
            det_cantidad: parseInt($('#cantidad').val()),
        };

        console.log(datos);
        var datosEnvio = JSON.stringify(datos);
        console.log(datosEnvio);

        $.ajax({
            url: "http://bdagroexpress-production.up.railway.app/AgregarProducto/" + documento,
            type: "POST",
            data: datosEnvio,
            contentType: "application/JSON",
        })
        
    });

/* ACTUALIZAR PRODUCTO */

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
convertirEnInput()

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

guardarCambios()

/* LISTAR PRODUCTOS */

    $.ajax({
        url : "http://bdagroexpress-production.up.railway.app/ListarProductosCampesino/" + documento,
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

/* DESPACHOS */ 

    /* TABLA DESPACHOS */

    // Obtener la referencia a la tabla de despachos
    const tablaDespachos = $("#tabladespachos");

    // Realizar la solicitud AJAX para obtener los datos de las órdenes
    $.ajax({
        url: "http://bdagroexpress-production.up.railway.app/OrdenCompra",
        type: "GET",
        dataType: "JSON",
        success: function(respuesta) {
            if (respuesta.length === 0) {
                // No hay órdenes para mostrar
                tablaDespachos.html('<tr><td colspan="5">No hay órdenes disponibles</td></tr>');
            } else {
                // Generar las filas de la tabla con los datos de las órdenes
                for (let i = 0; i < respuesta.length; i++) {
                    const orden = respuesta[i];
                    const noCompra = orden.OrdC_Id;
                    const nombreTransportador = orden.Usu_Nombre;
                    const cantidadSolicitada = orden.OrdC_Cantcomprada;
                    const fechaCompra = orden.Fac_FechaVenta;
                    const fechaDespacho = orden.Fac_FechaVenta;

                    const fila = '<tr>' +
                        '<td>' + noCompra + '</td>' +
                        '<td>' + nombreTransportador + '</td>' +
                        '<td>' + cantidadSolicitada + '</td>' +
                        '<td>' + fechaCompra + '</td>' +
                        '<td>' + fechaDespacho + '</td>' +
                        '</tr>';

                    tablaDespachos.append(fila);
                }
            }
        },
        error: function() {
            // Error al obtener los datos de las órdenes
            tablaDespachos.html('<tr><td colspan="5">Error al cargar las órdenes</td></tr>');
        }
    });

    /* BUSCADOR DESPACHOS */
      
    function buscarDatos() { // Función para filtrar las órdenes por el número de compra
        const inputBuscar = $("#inputBuscar").val();
        const filas = $("#tabladespachos tr").not(":first-child");
    
        filas.hide();
        filas.filter(function() {
            return $(this).text().toLowerCase().indexOf(inputBuscar.toLowerCase()) !== -1;
        }).show();
    }
    buscarDatos()

    
})
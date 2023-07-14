$(document).ready(function(){

    //Bandeja apertura
    $("#img-usuario-navbar").on("click", function(){
        $("#bandeja").animate({right : 0}, 500)
        $("#caja-opacidad-apertura-bandeja").animate({right : 0}, 5)
    })
    

    //bandeja cierre
    $("#boton-cerrar-bandeja").on("click", function(){
        $("#bandeja").animate({right : -5300}, 500)
        $("#caja-opacidad-apertura-bandeja").animate({right : -5000}, 5)
    })

    $("#caja-opacidad-apertura-bandeja").on("click", function(){
        $("#bandeja").animate({right : -480}, 500)
        $("#caja-opacidad-apertura-bandeja").animate({right : -5000}, 5)
    })

    //Bandeja categorias inicio-comprador

    $('#caja-categorias').hide()

    var hoverTimeout;
  
    $('#boton-categorias-inicio-comprador').mouseenter(function() {
        clearTimeout(hoverTimeout);
        $('#caja-categorias').slideDown();
    }).mouseleave(function() {
        hoverTimeout = setTimeout(function() {
            $('#caja-categorias').slideUp();
        }, 300);
    });
    
    $('#caja-categorias').mouseenter(function() {
        clearTimeout(hoverTimeout);
    }).mouseleave(function() {
        $('#caja-categorias').slideUp();
    });
    

    //Popover inicializacion
    const popoverTriggerList = document.querySelectorAll('[data-bs-toggle="popover"]')
    const popoverList = [...popoverTriggerList].map(popoverTriggerEl => new bootstrap.Popover(popoverTriggerEl))

    //Funciones para cantidad de productos en items carrito botones cantidad
    let input = document.getElementById("cantidad-producto") 

    $("#restar-producto").on("click", function(){
        let cantidad = parseInt(input.value)

        if(cantidad > 1){
            cantidad -= 1
            input.value = cantidad
        }
    })

    $("#sumar-producto").on("click", function(){
        let input = document.getElementById("cantidad-producto")

        let cantidad = parseInt(input.value)

        if(cantidad >= 1){
            cantidad += 1
            input.value = cantidad
        }
    })

    //bandeja menu responsive
    $("#boton-hamburguesa").on("click", function(){
        $("#bandeja-menu-navegacion").animate({right : 0}, 500)
    })

    $("#cerrar-bandeja-menu").on("click", function(){
        $("#bandeja-menu-navegacion").animate({right : -477}, 500)
    })

    //bandeja estadistica
    $("#ver-estadisticas").on("click", function(){
        $("#bandeja-estadisticas").animate({left : 0}, 500)
    })

    $("#close-estadisticas").on("click", function(){
        $("#bandeja-estadisticas").animate({left : -550}, 500)
    })

    //categorias bandeja menu navegacion
    let contentVisible = false;
    $("#menu-slide-down").hide()

    $("#boton-activador-slide-down").on("click", function(){
        if(contentVisible){
            $("#menu-slide-down").slideToggle()
            contentVisible = false
        }else{
            $("#menu-slide-down").slideToggle()
            contentVisible = true
        }
    })

    //Detalle mi pedido - historial mis pedidos comprador
    let insertar = document.querySelector("#mis-pedidos")

    insertar.innerHTML = ""

    let cajas = []

    for (let indexA = 0; indexA < 3; indexA++) {
        insertar.innerHTML += '<div class="contendor-caja-mi-pedido"><div class="caja-mi-pedido"><div>27 de junio de 2022</div><div>500.000</div><div class="estado-mi-pedido">Entregado</div><div><i class="icono-down-mi-pedido bi bi-chevron-down  collapsed" id="boton-detalle-mi-pedido' + indexA +'" aria-controls="detalle-mi-pedido" data-bs-toggle="collapse" data-bs-target="#detalle-mi-pedido' + indexA + '" aria-expanded="false"></i></div></div><div class="detalle-mi-pedido accordion-collapse collapse" id="detalle-mi-pedido' + indexA + '"><div class="detalle-datos-pedido"><div class="detalle-header"><div class="caja-detalle-total-compra overflow-hidden"><div class="detalle-total-compra"><div class="detalle-total-tittle">Total pedido</div><div class="detalle-total-compra-valor">500.000</div></div></div><div class="caja-detalle-cantidad overflow-hidden"><div class="detalle-cantidad-tittle">Cantidad de productos</div><div class="detalle-cantidad-valor">10</div></div></div></div><div class="d-flex justify-content-center"><hr class="linea-division"></div><div class="contenedor-detalle-productos"><div class="detalle-productos overflow-hidden"><div class="detalle-productos-header"><div>Referencia</div><div>Nombre</div><div>Campesino</div><div>Cantidad</div><div>Precio Und.</div><div>Total</div></div><div id="detalle-productos-lista' + indexA + '"></div></div></div></div></div></div>'  
        let productos = document.getElementById("detalle-productos-lista" + indexA)
        for (let indexB = 0; indexB < 5; indexB++){
            productos.innerHTML += '<div class="detalle-productos-producto"><div>0001</div><div>Pera</div><div>11102365</div><div>50</div><div>35.000</div><div>1.750.000</div></div>'
        } 
    }


})
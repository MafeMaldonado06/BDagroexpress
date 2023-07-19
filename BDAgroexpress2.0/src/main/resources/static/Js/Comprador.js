$(document).ready(function(){

    //Los metodos del comprador están establecidos por medio de sentencias que permiten identificar el archvo en el que se está por medio de su url. Los metodos están generados por medio de funciones para poder ser reutilizadas en cualquier parte del codigo excepto el metodo ara el carrito 

    var currentUrl = window.location.href;


    function addCart(referencia, cantidad){

        console.log(referencia, cantidad)

        $.ajax({
            url : "https://bdagroexpress-production.up.railway.app/Carrito/" + referencia + "/" + cantidad,
            type : "POST",
            dataType : "JSON",
            contentType : "application/JSON",
            success : (response) =>{
                alert(response)
            }
        })
    }


    if(currentUrl.includes("Comprador_Categorias_Verduras")){

        function listarProductos(){

            let verduras = document.getElementById("cartas-verduras")

            verduras.innerHTML = ""

            $.ajax({
                url: "https://bdagroexpress-production.up.railway.app/Verduras",
                type: "GET",
                dataType: "JSON",
                success: (productos) =>{
                    if(productos.length > 0){
                        for (let producto = 0; producto < productos.length; producto++) {
                            verduras.innerHTML += '<div class="carta-producto-categoria card" aria-valuetext="'+ productos[producto].det_Nombre_product +'"><div class="card-img overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-100" alt=""></div><div class="card-body"><ul class="list-unstyled"><li><h5 class= "nombre-producto">'+ productos[producto].det_Nombre_product +'</h5></li><li><span>' + productos[producto].det_precio + '</span></li></ul><div class="contenedor-boton-agregar-carrito-comprador"><button class="boton-agregar-carrito-comprador" data-bs-toggle="modal" data-bs-target="#agregarCarrito' + producto +'" id="agregar-carrito">Agregar al carrito</button></div></div></div><div class="modal fade" id="agregarCarrito'+ producto +'" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="exampleModalLabel">Agregar al carrito</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body"><div><div class="titulo-modal"><span>'+ productos[producto].det_Nombre_product +'</span></div><div class="d-flex flex-column align-items-center"><div class="imagen-modal d-flex justify-content-center"><img src="../img/CEBOLLA.JPG" class="d-block w-100" alt=""></div><div class="d-flex overflow-hidden rounded-5 my-3"><div class="col"><button class="menos-producto w-100" id="restar-producto"><i class="bi bi-dash"></i></button></div><div class="cantidad-producto col bg-body-tertiary"><input type="text" class="w-100 py-1 border-0" value="1" id="cantidad-producto"></div><div class="col"><button class="mas-producto w-100" id="sumar-producto"><i class="bi bi-plus"></i></button></div></div></div></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="agregar-carrito btn btn-success" value="' + productos[producto].det_Referencia +'">Agregar al carrito</button></div></div></div></div>'
                        }

                        var plus = document.getElementsByClassName("mas-producto")
                        var minus = document.getElementsByClassName("menos-producto")

                        for(var i = 0; i < minus.length; i++){
                            var button = minus[i];
                            button.addEventListener('click', (event)=>{

                                var buttonClicked = event.target;
                                var parent = buttonClicked.parentElement.parentElement;
                                var input = parent.parentElement.children[1].children[0];
                                var inputValue = input.value
                                var newValue = 1;
                                if(parseInt(inputValue) > 1){
                                    newValue = parseInt(inputValue) - 1
                                }
                                input.value = newValue
                                
                            })
                        }

                        for(var i = 0; i < plus.length; i++){
                            var button = plus[i];
                            button.addEventListener('click', (event)=>{

                                var buttonClicked = event.target;
                                var parent = buttonClicked.parentElement.parentElement;
                                var input = parent.parentElement.children[1].children[0];
                                var inputValue = input.value
                                var newValue = 1;
                                if(parseInt(inputValue) >= 1){
                                    newValue = parseInt(inputValue) + 1
                                }
                                input.value = newValue
                                
                            })
                        }

                        var botonesAgregarCarrito = document.getElementsByClassName("agregar-carrito")
                        
                        for(var i = 0; i < botonesAgregarCarrito.length; i++){
                            var button = botonesAgregarCarrito[i];
                            button.addEventListener('click', (event) => {
                                var buttonClicked = event.target;
                                var referencia = buttonClicked.getAttribute("value")
                                var parent = buttonClicked.parentElement.parentElement
                                var input = parent.children[1].children[0].children[1].children[1].children[1].children[0]
                                var cantidad = input.value

                                addCart(referencia, cantidad)
                                
                            })
                        }
                    }
                }
            })
        }

        listarProductos()

        function buscador(){
            document.addEventListener("keyup", element =>{

                if(element.target.matches("#buscador")){
                    $.ajax({
                        url: "https://bdagroexpress-production.up.railway.app/Verduras",
                        type: "GET",
                        dataType: "JSON",
                        success: (productos) =>{
                            let verduras = document.getElementById("cartas-verduras")
                            verduras.innerHTML = ""
            
                            if(productos.length > 0){
                                for (let producto = 0; producto < productos.length; producto++) {
                                    console.log(productos[producto])
                                    if(String(productos[producto].det_Nombre_product).toLowerCase().includes(element.target.value.toLowerCase())){
                                        verduras.innerHTML += '<div class="carta-producto-categoria card" aria-valuetext="'+ productos[producto].det_Nombre_product +'"><div class="card-img overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-100" alt=""></div><div class="card-body"><ul class="list-unstyled"><li><h5 class= "nombre-producto">'+ productos[producto].det_Nombre_product +'</h5></li><li><span>' + productos[producto].det_precio + '</span></li></ul><div class="contenedor-boton-agregar-carrito-comprador"><button class="boton-agregar-carrito-comprador" data-bs-toggle="modal" data-bs-target="#agregarCarrito' + producto +'" id="agregar-carrito">Agregar al carrito</button></div></div></div><div class="modal fade" id="agregarCarrito'+ producto +'" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="exampleModalLabel">Agregar al carrito</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body"><div><div class="titulo-modal"><span>'+ productos[producto].det_Nombre_product +'</span></div><div class="d-flex flex-column align-items-center"><div class="imagen-modal d-flex justify-content-center"><img src="../img/CEBOLLA.JPG" class="d-block w-100" alt=""></div><div class="d-flex overflow-hidden rounded-5 my-3"><div class="col"><button class="menos-producto w-100" id="restar-producto"><i class="bi bi-dash"></i></button></div><div class="cantidad-producto col bg-body-tertiary"><input type="text" class="w-100 py-1 border-0" value="1" id="cantidad-producto"></div><div class="col"><button class="mas-producto w-100" id="sumar-producto"><i class="bi bi-plus"></i></button></div></div></div></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="agregar-carrito btn btn-success" value="' + productos[producto].det_Referencia +'">Agregar al carrito</button></div></div></div></div>'
                                    }
            
                                    //Funciones para cantidad de productos en items carrito botones cantidad
                                    var plus = document.getElementsByClassName("mas-producto")
                                    var minus = document.getElementsByClassName("menos-producto")

                                    for(var i = 0; i < minus.length; i++){
                                        var button = minus[i];
                                        button.addEventListener('click', (event)=>{

                                            var buttonClicked = event.target;
                                            var parent = buttonClicked.parentElement.parentElement;
                                            var input = parent.parentElement.children[1].children[0];
                                            var inputValue = input.value
                                            var newValue = 1;
                                            if(parseInt(inputValue) > 1){
                                                newValue = parseInt(inputValue) - 1
                                            }
                                            input.value = newValue
                                            
                                        })
                                    }

                                    for(var i = 0; i < plus.length; i++){
                                        var button = plus[i];
                                        button.addEventListener('click', (event)=>{

                                            var buttonClicked = event.target;
                                            var parent = buttonClicked.parentElement.parentElement;
                                            var input = parent.parentElement.children[1].children[0];
                                            var inputValue = input.value
                                            var newValue = 1;
                                            if(parseInt(inputValue) >= 1){
                                                newValue = parseInt(inputValue) + 1
                                            }
                                            input.value = newValue
                                            
                                        })
                                    }

                                    var botonesAgregarCarrito = document.getElementsByClassName("agregar-carrito")
                        
                                    for(var i = 0; i < botonesAgregarCarrito.length; i++){
                                        var button = botonesAgregarCarrito[i];
                                        button.addEventListener('click', (event) => {
                                            var buttonClicked = event.target;
                                            var referencia = buttonClicked.getAttribute("value")
                                            var parent = buttonClicked.parentElement.parentElement
                                            var input = parent.children[1].children[0].children[1].children[1].children[1].children[0]
                                            var cantidad = input.value

                                            addCart(referencia, cantidad)
                                            
                                        })
                                    }
                                }
                            }
                        }
                    })
                }
            })
        }
        buscador()
        
    }else if (currentUrl.includes("Comprador_Categorias_Legumbres")){
        function listarProductos(){

            let legumbres = document.getElementById("cartas-legumbres")

            legumbres.innerHTML = ""

            $.ajax({
                url: "https://bdagroexpress-production.up.railway.app/Legumbres",
                type: "GET",
                dataType: "JSON",
                success: (productos) =>{

                    console.log(productos)

                    if(productos.length > 0){
                        console.log("hola")
                        for (let producto = 0; producto < productos.length; producto++) {
                            legumbres.innerHTML += '<div class="carta-producto-categoria card" aria-valuetext="'+ productos[producto].det_Nombre_product +'"><div class="card-img overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-100" alt=""></div><div class="card-body"><ul class="list-unstyled"><li><h5 class= "nombre-producto">'+ productos[producto].det_Nombre_product +'</h5></li><li><span>' + productos[producto].det_precio + '</span></li></ul><div class="contenedor-boton-agregar-carrito-comprador"><button class="boton-agregar-carrito-comprador" data-bs-toggle="modal" data-bs-target="#agregarCarrito' + producto +'" id="agregar-carrito">Agregar al carrito</button></div></div></div><div class="modal fade" id="agregarCarrito'+ producto +'" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="exampleModalLabel">Agregar al carrito</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body"><div><div class="titulo-modal"><span>'+ productos[producto].det_Nombre_product +'</span></div><div class="d-flex flex-column align-items-center"><div class="imagen-modal d-flex justify-content-center"><img src="../img/CEBOLLA.JPG" class="d-block w-100" alt=""></div><div class="d-flex overflow-hidden rounded-5 my-3"><div class="col"><button class="menos-producto w-100" id="restar-producto"><i class="bi bi-dash"></i></button></div><div class="cantidad-producto col bg-body-tertiary"><input type="text" class="w-100 py-1 border-0" value="1" id="cantidad-producto"></div><div class="col"><button class="mas-producto w-100" id="sumar-producto"><i class="bi bi-plus"></i></button></div></div></div></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="agregar-carrito btn btn-success" value="' + productos[producto].det_Referencia +'">Agregar al carrito</button></div></div></div></div>'
            
                            //Funciones para cantidad de productos en items carrito botones cantidad
                            var plus = document.getElementsByClassName("mas-producto")
                            
                            var minus = document.getElementsByClassName("menos-producto")

                            for(var i = 0; i < minus.length; i++){
                                var button = minus[i];
                                button.addEventListener('click', (event)=>{

                                    var buttonClicked = event.target;
                                    var parent = buttonClicked.parentElement.parentElement;
                                    var input = parent.parentElement.children[1].children[0];
                                    var inputValue = input.value
                                    var newValue = 1;
                                    if(parseInt(inputValue) > 1){
                                        newValue = parseInt(inputValue) - 1
                                    }
                                    input.value = newValue
                                    
                                })
                            }

                            for(var i = 0; i < plus.length; i++){
                                var button = plus[i];
                                button.addEventListener('click', (event)=>{

                                    var buttonClicked = event.target;
                                    var parent = buttonClicked.parentElement.parentElement;
                                    var input = parent.parentElement.children[1].children[0];
                                    var inputValue = input.value
                                    var newValue = 1;
                                    if(parseInt(inputValue) >= 1){
                                        newValue = parseInt(inputValue) + 1
                                    }
                                    input.value = newValue
                                    
                                })
                            }

                            var botonesAgregarCarrito = document.getElementsByClassName("agregar-carrito")

                            console.log(botonesAgregarCarrito)
                
                            for(var i = 0; i < botonesAgregarCarrito.length; i++){
                                var button = botonesAgregarCarrito[i];
                                button.addEventListener('click', (event) => {
                                    var buttonClicked = event.target;
                                    var referencia = buttonClicked.getAttribute("value")
                                    var parent = buttonClicked.parentElement.parentElement
                                    var input = parent.children[1].children[0].children[1].children[1].children[1].children[0]
                                    var cantidad = input.value

                                    addCart(referencia, cantidad)
                                    
                                })
                            }
                        }
                    }
                }
            })
        }

        function buscador(){
            document.addEventListener("keyup", element =>{

                if(element.target.matches("#buscador")){
                    $.ajax({
                        url: "https://bdagroexpress-production.up.railway.app/Legumbres",
                        type: "GET",
                        dataType: "JSON",
                        success: (productos) =>{
                            let legumbres = document.getElementById("cartas-legumbres")
                            legumbres.innerHTML = ""
            
                            if(productos.length > 0){
                                for (let producto = 0; producto < productos.length; producto++) {
                                    console.log(productos[producto])
                                    if(String(productos[producto].det_Nombre_poduct).toLowerCase().includes(element.target.value.toLowerCase())){
                                        legumbres.innerHTML += '<div class="carta-producto-categoria card" aria-valuetext="'+ productos[producto].det_Nombre_product +'"><div class="card-img overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-100" alt=""></div><div class="card-body"><ul class="list-unstyled"><li><h5 class= "nombre-producto">'+ productos[producto].det_Nombre_product +'</h5></li><li><span>' + productos[producto].det_precio + '</span></li></ul><div class="contenedor-boton-agregar-carrito-comprador"><button class="boton-agregar-carrito-comprador" data-bs-toggle="modal" data-bs-target="#agregarCarrito' + producto +'" id="agregar-carrito">Agregar al carrito</button></div></div></div><div class="modal fade" id="agregarCarrito'+ producto +'" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="exampleModalLabel">Agregar al carrito</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body"><div><div class="titulo-modal"><span>'+ productos[producto].det_Nombre_product +'</span></div><div class="d-flex flex-column align-items-center"><div class="imagen-modal d-flex justify-content-center"><img src="../img/CEBOLLA.JPG" class="d-block w-100" alt=""></div><div class="d-flex overflow-hidden rounded-5 my-3"><div class="col"><button class="menos-producto w-100" id="restar-producto"><i class="bi bi-dash"></i></button></div><div class="cantidad-producto col bg-body-tertiary"><input type="text" class="w-100 py-1 border-0" value="1" id="cantidad-producto"></div><div class="col"><button class="mas-producto w-100" id="sumar-producto"><i class="bi bi-plus"></i></button></div></div></div></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="agregar-carrito btn btn-success" value="' + productos[producto].det_Referencia +'">Agregar al carrito</button></div></div></div></div>'
                                    }
            
                                    //Funciones para cantidad de productos en items carrito botones cantidad
                                    var plus = document.getElementsByClassName("mas-producto")
                                    var minus = document.getElementsByClassName("menos-producto")

                                    for(var i = 0; i < minus.length; i++){
                                        var button = minus[i];
                                        button.addEventListener('click', (event)=>{

                                            var buttonClicked = event.target;
                                            var parent = buttonClicked.parentElement.parentElement;
                                            var input = parent.parentElement.children[1].children[0];
                                            var inputValue = input.value
                                            var newValue = 1;
                                            if(parseInt(inputValue) > 1){
                                                newValue = parseInt(inputValue) - 1
                                            }
                                            input.value = newValue
                                            
                                        })
                                    }

                                    for(var i = 0; i < plus.length; i++){
                                        var button = plus[i];
                                        button.addEventListener('click', (event)=>{

                                            var buttonClicked = event.target;
                                            var parent = buttonClicked.parentElement.parentElement;
                                            var input = parent.parentElement.children[1].children[0];
                                            var inputValue = input.value
                                            var newValue = 1;
                                            if(parseInt(inputValue) >= 1){
                                                newValue = parseInt(inputValue) + 1
                                            }
                                            input.value = newValue
                                            
                                        })
                                    }

                                    var botonesAgregarCarrito = document.getElementsByClassName("agregar-carrito")
                        
                                    for(var i = 0; i < botonesAgregarCarrito.length; i++){
                                        var button = botonesAgregarCarrito[i];
                                        button.addEventListener('click', (event) => {
                                            var buttonClicked = event.target;
                                            var referencia = buttonClicked.getAttribute("value")
                                            var parent = buttonClicked.parentElement.parentElement
                                            var input = parent.children[1].children[0].children[1].children[1].children[1].children[0]
                                            var cantidad = input.value

                                            addCart(referencia, cantidad)
                                            
                                        })
                                    }
                                }
                            }
                        }
                    })
                }
            })
        }

        listarProductos()
        buscador()
    }else if (currentUrl.includes("Comprador_Mis-Pedidos")){

        function fechaPersonalizada(fecha){
            var date = new Date(fecha)

            var dia = date.getDate()
            var mes = date.toLocaleDateString("es-ES", {month : "long"})
            var año = date.getFullYear()

            var dateFormated = dia + ' de ' + mes + ' de ' + año

            return dateFormated
        }

        function listarPedidos(){
            let insertar = document.querySelector("#mis-pedidos")
            let documento = window.sessionStorage.getItem("id_usuario")
            insertar.innerHTML = ""

            $.ajax({
                url : "https://bdagroexpress-production.up.railway.app/Pedidos/" + documento,
                type : "GET",
                dataType : "JSON",
                success : (e) =>{
                    console.log(e)
                    for (let pedido = 0; pedido < e.length; pedido++) {
                        insertar.innerHTML += '<div class="contendor-caja-mi-pedido"><div class="caja-mi-pedido"><div>' + fechaPersonalizada(e[pedido].ordc_fecha_compra) +'</div><div>' + e[pedido].ordc_total_compra +'</div><div class="estado-mi-pedido">' +  e[pedido].orde_estado+'</div><div><i class="icono-down-mi-pedido bi bi-chevron-down  collapsed" id="boton-detalle-mi-pedido' + e[pedido].ordc_id +'" aria-controls="detalle-mi-pedido" data-bs-toggle="collapse" data-bs-target="#detalle-mi-pedido' + e[pedido].ordc_id + '" aria-expanded="false" aria-valuetext="' + e[pedido].ordc_id +'"></i></div></div><div class="detalle-mi-pedido accordion-collapse collapse" id="detalle-mi-pedido' + e[pedido].ordc_id + '"><div class="detalle-datos-pedido"><div class="detalle-header"><div class="caja-detalle-total-compra overflow-hidden"><div class="detalle-total-compra"><div class="detalle-total-tittle">Total pedido</div><div class="detalle-total-compra-valor">' + e[pedido].ordc_total_compra +'</div></div></div><div class="caja-detalle-cantidad overflow-hidden"><div class="detalle-cantidad-tittle">Cantidad de productos</div><div class="detalle-cantidad-valor">' + e[pedido].ordc_cantidad_productos + '</div></div></div></div><div class="d-flex justify-content-center"><hr class="linea-division"></div><div class="contenedor-detalle-productos"><div class="detalle-productos overflow-hidden"><div class="detalle-productos-header"><div>Referencia</div><div>Nombre</div><div>Campesino</div><div>Cantidad</div><div>Precio Und.</div><div>Total</div></div><div id="detalle-productos-lista' + e[pedido].ordc_id + '"></div></div></div></div></div></div>'

                        listarProductosdetalle(e[pedido].ordc_id)
                    }
                }
            })
        }

        function listarProductosdetalle(id_pedido){
            let productos = document.getElementById("detalle-productos-lista" + id_pedido)

            $.ajax({
                url : "https://bdagroexpress-production.up.railway.app/ProductosPedido/" + id_pedido,
                type : "GET",
                dataType : "JSON",
                success : (products) =>{
                    console.log
                    for (let product = 0; product < products.length; product++) {
                        productos.appendChild += '<div class="detalle-productos-producto"><div>' + products[product].det_referencia + '</div><div>' + products[product].det_nombre_product +'</div><div>' + products[product].usu_nombre + " " + products[product].usu_apellidos + '</div><div>' + products[product].detc_cantidad_comprada + '</div><div>'+ products[product].det_precio +'</div><div>' + products[product].det_precio * products[product].detc_cantidad_comprada + '</div></div>'
                    }
                }
            })
        }

        listarPedidos()
    }else if(currentUrl.includes("Comprador_Carrito")){
        function listarProductos(){

            let cajaProductos = document.getElementById("productos-carrito")

            cajaProductos.innerHTML = ""

            $.ajax({
                url : "https://bdagroexpress-production.up.railway.app/GetCarrito",
                type : "GET",
                dataType : "JSON",
                success : (e)=>{

                    let subtotal = 0

                    e.forEach(element => {
                        console.log(element.id)
                        cajaProductos.innerHTML += '<div class="producto-carrito d-flex justify-content-evenly my-2 rounded-2 bg-body" id="' + element.id + '"><div class="d-flex w-100"><div class="imagen-producto-carrito d-flex align-items-center"><img src="../Img/Durazno.JPG" class="d-block w-100" alt=""></div><hr class="vr mx-3"><div class="my-3"><div><div class="d-flex flex-column"><span>Ref : ' + element.producto.det_Referencia + '</span><span class="nombre-producto-carrito">' + element.producto.det_Nombre_product + '</span></div></div></div></div><div class="segunda-mitad-producto-carrito d-flex w-100 px-3 position-relative"><div class="py-3"><div class="contador-cantidad"><div class="d-flex text-center rounded-4 overflow-hidden"><div class="col"><button class="menos-producto w-100" id="restar-producto"><i class="bi bi-dash"></i></button></div><div class="cantidad-producto col bg-body-tertiary d-flex justify-content-center align-items-center"><input type="tel" class="w-100 py-1 border-0" minlength="1" maxlength="5" placeholder = "1" value="' + element.cantidad + '" id="cantidad-producto"></div><div class="col"><button class="mas-producto w-100" id="sumar-producto"><i class="bi bi-plus"></i></button></div></div><div class="d-flex justify-content-center align-items-center mt-2"><button class="eliminar-producto-carrito border-0 bg-body" id="' + element.id + '">Eliminar</button></div></div></div><div class="d-flex justify-content-center align-items-center w-50"><span class="precio-unidad-producto mx-1 text-center">' + element.producto.det_precio + '</span><span class="unidad-medida-producto d-flex align-items-end">Und</span></div></div></div>'

                        subtotal += (element.producto.det_precio * element.cantidad)

                    });

                    //Funciones para cantidad de productos en items carrito botones cantidad
                    var plus = document.getElementsByClassName("mas-producto")
                    var minus = document.getElementsByClassName("menos-producto")
                    var borrar = document.getElementsByClassName("eliminar-producto-carrito")

                    for(var i = 0; i < minus.length; i++){
                        var button = minus[i];
                        button.addEventListener('click', (event)=>{

                            var buttonClicked = event.target;
                            var parent = buttonClicked.parentElement.parentElement;
                            var input = parent.parentElement.children[1].children[0];
                            var inputValue = input.value
                            var newValue = 1;
                            if(parseInt(inputValue) > 1){
                                newValue = parseInt(inputValue) - 1
                            }
                            input.value = newValue

                            var caja = button.parentElement.parentElement.parentElement.parentElement.parentElement
                            var value = caja.getAttribute("id")
                            
                            updateProducto(newValue, parseInt(value))
                            
                        })
                    }

                    for(var i = 0; i < plus.length; i++){
                        var button = plus[i];
                        button.addEventListener('click', (event)=>{

                            var buttonClicked = event.target;
                            var parent = buttonClicked.parentElement.parentElement;
                            var input = parent.parentElement.children[1].children[0];
                            var inputValue = input.value
                            var newValue = 1;
                            if(parseInt(inputValue) >= 1){
                                newValue = parseInt(inputValue) + 1
                            }
                            input.value = newValue

                            var caja = button.parentElement.parentElement.parentElement.parentElement.parentElement
                            var value = caja.getAttribute("id")
                            
                            updateProducto(newValue, parseInt(value))
                
                        })
                    }

                    for(var i = 0; i < borrar.length; i++){
                        var button = borrar[i];
                        button.addEventListener('click', (event)=>{

                            var boton = event.target
                            var buttonValue = boton.getAttribute("id")

                            eliminarProducto(buttonValue)
                
                        })
                    }

                    subtotalEnvio(subtotal)
                    
                }
            })
        }
        listarProductos()

        function subtotalEnvio(subtotal){
        
            let cajaSubtotal = document.getElementsByClassName("subtotal")
            let cajaEnvio = document.getElementsByClassName("envio")

            for(var i = 0; i < cajaSubtotal.length; i++){
                var caja = cajaSubtotal[i]

                caja.innerText = subtotal
            }

            for(var i = 0; i < cajaEnvio.length; i++){
                var caja = cajaEnvio[i]
                let valorEnvio = (subtotal * 16) / 100

                caja.innerText = valorEnvio
            }
        }

        function eliminarProducto(referencia){
            $.ajax({
                url : "https://bdagroexpress-production.up.railway.app/BorrarProducto/" + referencia,
                type : "DELETE",
                dataType : "JSON"
            })

            location.reload()
        }

        function updateProducto(cantidad, referencia){
            let producto = {
                id : referencia,
                cantidad : cantidad
            }

            let datosEnvio = JSON.stringify(producto)

            $.ajax({
                url : "https://bdagroexpress-production.up.railway.app/Update",
                type : "PUT",
                data : datosEnvio,
                dataType : "JSON",
                contentType : "application/JSON"
            })

            location.reload()
        }

        $("#confirmar-pedido").on("click", () =>{

            let cart = []

            $.ajax({
                url : "https://bdagroexpress-production.up.railway.app/GetCarrito",
                type : "GET",
                dataType : "JSON",
                success : (e) =>{
                    if(e.length > 0){
                        e.forEach(producto => {
                            let product = {
                                detC_CantidadComprada : producto.cantidad,
                                detC_Producto : producto.producto
                            }

                            cart.push(product)
                        });
                    }

                    let primus = window.sessionStorage.getItem("id_usuario")
                    console.log(cart)
                    let cartEnvio = JSON.stringify(cart)
                    console.log(cartEnvio)

                    $.ajax({
                        url : "https://bdagroexpress-production.up.railway.app/OrdenCompra/" + primus,
                        type : "POST",
                        data : cartEnvio,
                        contentType : "application/JSON",
                        success : (e) =>{
                            alert(e)
                        }
                    })
                }
            })

            $.ajax({
                url : "https://bdagroexpress-production.up.railway.app/ClearCart",
                type : "DELETE",
                dataType : "JSON"
            })

            location.reload()
        })
    }else if(currentUrl.includes("Comprador_Inicio")){
        function UltimosPedidos(){

            let productos = document.getElementById("tablaPedidos")
            productos.innerHTML = "";

            $.ajax({
                url: "https://bdagroexpress-production.up.railway.app/OrdenCompra",
                type: 'GET',
                dataType: "JSON",
                success: function (respuesta) {
                    if (respuesta.length === 0) {
                        productos.innerHTML = '<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay pedidos</span></div>';
                    } else {
                        let startIndex = respuesta.length - 2; // Start from the second-last index
                        let id = 1;
            
                        // Create the table HTML
                        let table = '<tr>' +
                            '<th>N° Compra</th>' +
                            '<td>Toma de pedido</td>' +
                            '<th>Puedes</th>' +
                            '<th>Estado</th>' +
                            '</tr>';
            
                        for (let producto = startIndex; producto < respuesta.length; producto++, id++) {
                            let noCompra = respuesta[producto].OrdC_Id;
                            let tomaPedido = respuesta[producto].Fac_FechaVenta;
                            let estado = respuesta[producto].estado;//el metodo del estado no esta
            
                            // Add rows to the table
                            table += '<tr>' +
                                '<td>' + noCompra + '</td>' +
                                '<td>' + tomaPedido + '</td>' +
                                '<td>' +
                                '<div class="d-flex justify-content-center">' +
                                '<button class="boton-tabla-pedidos py-1 btn btn-success">Consultar</button>' +//no se que poner al oprimir el boton
                                '</div>' +
                                '</td>' +
                                '<td>' + estado + '</td>' +
                                '</tr>';
                        }
            
                        // Set the table HTML to the 'productos' container
                        productos.innerHTML = table;
                    }
                }
            });
        }

        UltimosPedidos()

        function cargarTarjetas() {
            const tarjetas1 = document.getElementById('tarjetasContainer');
            tarjetas1.innerHTML = ""; // Vaciar el contenedor de tarjetas
        
            $.ajax({
                url: 'http://bdagroexpress-production.up.railway.app/Listarproductos',
                type: 'GET',
                dataType: "JSON",
                success: function (respuesta) {
                    if (respuesta.length === 0) {
                        tarjetas1.innerHTML = '<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay productos de esta categoría</span></div>';
                    } else {
                        for (let producto = 0; producto < respuesta.length; producto++) {
                            let detReferencia = respuesta[producto].det_Referencia;
                            tarjetas1.innerHTML += '<div class="carta-producto-comprador card">' +
                                '<div class="card-img overflow-hidden">' +
                                '<img src="../Img/Durazno.JPG" class="d-block w-100" alt="">' +
                                '</div>' +
                                '<div class="card-body">' +
                                '<ul class="list-unstyled">' +
                                '<li><h5>' + respuesta[producto].det_Nombre_product + '</h5></li>' +
                                '<li><span>$' + respuesta[producto].det_precio + '</span></li>' +
                                '</ul>' +
                                '<div class="contenedor-boton-agregar-carrito-comprador">' +
                                '<button class="boton-agregar-carrito-comprador" data-bs-toggle="modal" data-bs-target="#agregarCarrito">Poner en el carrito</button>' +
                                '</div>' +
                                '</div>' +
                                '</div>';
                        }
                    }
                }
            });
        }

        cargarTarjetas()
    }

})
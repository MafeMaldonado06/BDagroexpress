$(document).ready(function(){

    var currentUrl = window.location.href;

    if(currentUrl.includes("Comprador_Categorias_Verduras")){

        function listarProductos(){

            let caja = document.getElementById("cartas-verduras")

            caja.innerHTML = ""

            $.ajax({
                url: "http://localhost:8080/Verduras",
                type: "GET",
                dataType: "JSON",
                success: (productos) =>{

                    console.log(productos)

                    if(productos.length > 0){
                        console.log("hola")
                        for (let producto = 0; producto < productos.length; producto++) {
                            caja.innerHTML += '<div class="carta-producto-categoria card" aria-valuetext="'+ productos[producto].det_Nombre_poduct +'"><div class="card-img overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-100" alt=""></div><div class="card-body"><ul class="list-unstyled"><li><h5 class= "nombre-producto">'+ productos[producto].det_Nombre_poduct +'</h5></li><li><span>' + productos[producto].det_precio + '</span></li></ul><div class="contenedor-boton-agregar-carrito-comprador"><button class="boton-agregar-carrito-comprador" data-bs-toggle="modal" data-bs-target="#agregarCarrito' + producto +'">Poner en el carrito</button></div></div></div><div class="modal fade" id="agregarCarrito'+ producto +'" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="exampleModalLabel">Agregar al carrito</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body"><div><div class="titulo-modal"><span>'+ productos[producto].det_Nombre_poduct +'</span></div><div class="d-flex flex-column align-items-center"><div class="imagen-modal d-flex justify-content-center"><img src="../img/CEBOLLA.JPG" class="d-block w-100" alt=""></div><div class="d-flex overflow-hidden rounded-5 my-3"><div class="col"><button class="menos-producto w-100" id="restar-producto"><i class="bi bi-dash"></i></button></div><div class="cantidad-producto col bg-body-tertiary"><input type="tel" class="w-100 py-1 border-0" minlength="1" maxlength="5" placeholder = "1" value="1" id="cantidad-producto"></div><div class="col"><button class="mas-producto w-100" id="sumar-producto"><i class="bi bi-plus"></i></button></div></div></div></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="btn btn-success">Poner en el carrito</button></div></div></div></div>'

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

                            console.log(document.querySelector('.carta-producto-categoria').getAttribute("aria-valuetext"))
                        }
                    }
                }
            })
        }

        function buscador(){
            document.addEventListener("keyup", element =>{

                if(element.target.matches("#buscador")){
                    $.ajax({
                        url: "http://localhost:8080/Verduras",
                        type: "GET",
                        dataType: "JSON",
                        success: (productos) =>{
                            let caja = document.getElementById("cartas-verduras")
                            caja.innerHTML = ""
            
                            if(productos.length > 0){
                                for (let producto = 0; producto < productos.length; producto++) {
                                    console.log(productos[producto])
                                    if(String(productos[producto].det_Nombre_poduct).toLowerCase().includes(element.target.value.toLowerCase())){
                                        caja.innerHTML += '<div class="carta-producto-categoria card"><div class="card-img overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-100" alt=""></div><div class="card-body"><ul class="list-unstyled"><li><h5 class= "nombre-producto">'+ productos[producto].det_Nombre_poduct +'</h5></li><li><span>' + productos[producto].det_precio + '</span></li></ul><div class="contenedor-boton-agregar-carrito-comprador"><button class="boton-agregar-carrito-comprador" data-bs-toggle="modal" data-bs-target="#agregarCarrito' + producto +'">Poner en el carrito</button></div></div></div><div class="modal fade" id="agregarCarrito'+ producto +'" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="exampleModalLabel">Agregar al carrito</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body"><div><div class="titulo-modal"><span>'+ productos[producto].det_Nombre_poduct +'</span></div><div class="d-flex flex-column align-items-center"><div class="imagen-modal d-flex justify-content-center"><img src="../img/CEBOLLA.JPG" class="d-block w-100" alt=""></div><div class="d-flex overflow-hidden rounded-5 my-3"><div class="col"><button class="menos-producto w-100" id="restar-producto"><i class="bi bi-dash"></i></button></div><div class="cantidad-producto col bg-body-tertiary"><input type="tel" class="w-100 py-1 border-0" minlength="1" maxlength="5" placeholder = "1" value="1" id="cantidad-producto"></div><div class="col"><button class="mas-producto w-100" id="sumar-producto"><i class="bi bi-plus"></i></button></div></div></div></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="btn btn-success">Poner en el carrito</button></div></div></div></div>'
                                    }
            
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
                                }
                            }
                        }
                    })
                }
            })
        }

        //Activacion de funciones
        
        listarProductos()
        buscador()
    }else if (currentUrl.includes("Comprador_Categorias_Legumbres")){
        function listarProductos(){

            let caja = document.getElementById("cartas-legumbres")

            caja.innerHTML = ""

            $.ajax({
                url: "http://localhost:8080/Legumbres",
                type: "GET",
                dataType: "JSON",
                success: (productos) =>{

                    console.log(productos)

                    if(productos.length > 0){
                        console.log("hola")
                        for (let producto = 0; producto < productos.length; producto++) {
                            caja.innerHTML += '<div class="carta-producto-categoria card" aria-valuetext="'+ productos[producto].det_Nombre_poduct +'"><div class="card-img overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-100" alt=""></div><div class="card-body"><ul class="list-unstyled"><li><h5 class= "nombre-producto">'+ productos[producto].det_Nombre_poduct +'</h5></li><li><span>' + productos[producto].det_precio + '</span></li></ul><div class="contenedor-boton-agregar-carrito-comprador"><button class="boton-agregar-carrito-comprador" data-bs-toggle="modal" data-bs-target="#agregarCarrito' + producto +'">Poner en el carrito</button></div></div></div><div class="modal fade" id="agregarCarrito'+ producto +'" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="exampleModalLabel">Agregar al carrito</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body"><div><div class="titulo-modal"><span>'+ productos[producto].det_Nombre_poduct +'</span></div><div class="d-flex flex-column align-items-center"><div class="imagen-modal d-flex justify-content-center"><img src="../img/CEBOLLA.JPG" class="d-block w-100" alt=""></div><div class="d-flex overflow-hidden rounded-5 my-3"><div class="col"><button class="menos-producto w-100" id="restar-producto"><i class="bi bi-dash"></i></button></div><div class="cantidad-producto col bg-body-tertiary"><input type="tel" class="w-100 py-1 border-0" minlength="1" maxlength="5" placeholder = "1" value="1" id="cantidad-producto"></div><div class="col"><button class="mas-producto w-100" id="sumar-producto"><i class="bi bi-plus"></i></button></div></div></div></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="btn btn-success">Poner en el carrito</button></div></div></div></div>'

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

                            console.log(document.querySelector('.carta-producto-categoria').getAttribute("aria-valuetext"))
                        }
                    }
                }
            })
        }

        function buscador(){
            document.addEventListener("keyup", element =>{

                if(element.target.matches("#buscador")){
                    $.ajax({
                        url: "http://localhost:8080/Legumbres",
                        type: "GET",
                        dataType: "JSON",
                        success: (productos) =>{
                            let caja = document.getElementById("cartas-legumbres")
                            caja.innerHTML = ""
            
                            if(productos.length > 0){
                                for (let producto = 0; producto < productos.length; producto++) {
                                    console.log(productos[producto])
                                    if(String(productos[producto].det_Nombre_poduct).toLowerCase().includes(element.target.value.toLowerCase())){
                                        caja.innerHTML += '<div class="carta-producto-categoria card"><div class="card-img overflow-hidden"><img src="../Img/Durazno.JPG" class="d-block w-100" alt=""></div><div class="card-body"><ul class="list-unstyled"><li><h5 class= "nombre-producto">'+ productos[producto].det_Nombre_poduct +'</h5></li><li><span>' + productos[producto].det_precio + '</span></li></ul><div class="contenedor-boton-agregar-carrito-comprador"><button class="boton-agregar-carrito-comprador" data-bs-toggle="modal" data-bs-target="#agregarCarrito' + producto +'">Poner en el carrito</button></div></div></div><div class="modal fade" id="agregarCarrito'+ producto +'" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true"><div class="modal-dialog modal-dialog-centered"><div class="modal-content"><div class="modal-header"><h1 class="modal-title fs-5" id="exampleModalLabel">Agregar al carrito</h1><button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button></div><div class="modal-body"><div><div class="titulo-modal"><span>'+ productos[producto].det_Nombre_poduct +'</span></div><div class="d-flex flex-column align-items-center"><div class="imagen-modal d-flex justify-content-center"><img src="../img/CEBOLLA.JPG" class="d-block w-100" alt=""></div><div class="d-flex overflow-hidden rounded-5 my-3"><div class="col"><button class="menos-producto w-100" id="restar-producto"><i class="bi bi-dash"></i></button></div><div class="cantidad-producto col bg-body-tertiary"><input type="tel" class="w-100 py-1 border-0" minlength="1" maxlength="5" placeholder = "1" value="1" id="cantidad-producto"></div><div class="col"><button class="mas-producto w-100" id="sumar-producto"><i class="bi bi-plus"></i></button></div></div></div></div></div><div class="modal-footer"><button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button><button type="button" class="btn btn-success">Poner en el carrito</button></div></div></div></div>'
                                    }
            
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
                                }
                            }
                        }
                    })
                }
            })
        }

        //Activacion de funciones
        
        listarProductos()
        buscador()
    }
})
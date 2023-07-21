$(document).ready(function() {
    const Ordenes = $('#Ordenes');
    let orde_idSeleccionado;
    let valorSeleccionado;

    let documentoUsu=window.sessionStorage.getItem("id_usuario")

    function obtenerOrdenes() {
        $.ajax({
            url: 'https://bdagroexpress-production.up.railway.app/Odenentrega/'+documentoUsu,
            type: 'GET',
            dataType: 'JSON',
            success: function(respuesta) {
                if (respuesta.length === 0) {
                    Ordenes.append('<div class="w-75 text-center"><h1>Lo sentimos</h1><span>No hay usuarios de esta categoría</span></div>');
                } else {
                    // Variable para almacenar el contenido dinámico generado
                    let contenidoOrdenes = '';

                    for (let ordenentrega = 0; ordenentrega < respuesta.length; ordenentrega++) {
                        let orde_id = respuesta[ordenentrega].orde_id;
                        contenidoOrdenes += ` <div class="orden-entrega"> <div class="icon-truck-entrega"> <i class="bi bi-truck"></i> </div> <div class="datos-entrega"> <ul class="list-unstyled"> <li class="referencia-entrega">${orde_id}</li> <li>${respuesta[ordenentrega].usu_nombre}</li> <li>${respuesta[ordenentrega].usu_direccion}</li> <li>${respuesta[ordenentrega].orden_fecha_entrega_aproximada}</li> </ul> </div> <div class="mb-4"> <select name="" id="estadoSelect_${ordenentrega}" class="form-select"> <option value="estado">${respuesta[ordenentrega].orde_estado}</option> <option value="Pendiente">Pendiente</option> <option value="En camino">En camino</option> <option value="Entregado">Entregado</option> <option value="Devuelto">Devuelto</option> </select> </div> <div> <button class="button-modificar-estado actualizar" type="button"> <span>Modificar estado</span> </button> </div> </div>`;
                    }

                    // Agregar el contenido dinámico generado al contenedor Ordenes
                    Ordenes.html(contenidoOrdenes);

                    // Capturar el evento change para el elemento <select>
                    $('select[id^="estadoSelect_"]').change(function() {
                        valorSeleccionado = $(this).val();
                        orde_idSeleccionado = $(this).closest('.orden-entrega').find('.referencia-entrega').text();
                        console.log('orde_id seleccionado:', orde_idSeleccionado);
                        console.log('valorSeleccionado:', valorSeleccionado);
                    });
                }
            },
            error: function(xhr, status, error) {
                // Manejar errores de la solicitud AJAX
                console.log('Error en la solicitud AJAX:', error);
            }
        });
    }

    obtenerOrdenes();

    $(document).on('click', '.actualizar', function() {
        // Código para manejar el click del botón actualizar
        $.ajax({
            url: 'https://bdagroexpress-production.up.railway.app/ActualizarEstado/' + orde_idSeleccionado + '/' + valorSeleccionado,
            type: 'POST',
            dataType: 'JSON',
            success: function(response) {
                // Alerta de Bootstrap para indicar que se actualizó el estado
                const alertaExito = `
                    <div class="alert alert-success alert-dismissible fade show" role="alert">
                        El estado ha sido actualizado correctamente.
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                `;
                $('#alert-container').html(alertaExito);
                
                // Recargar la página después de 1 segundo (1000 milisegundos)
                setTimeout(function() {
                    location.reload();
                }, 1000);
            },
            error: function(xhr, status, error) {
                // Alerta de Bootstrap para indicar que ocurrió un error
                const alertaError = `
                    <div class="alert alert-danger alert-dismissible fade show" role="alert">
                        Ha ocurrido un error al actualizar el estado. Inténtalo de nuevo más tarde después de la recarga.
                        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                    </div>
                `;
                $('#alert-container').html(alertaError);
            }
        });
    });
});

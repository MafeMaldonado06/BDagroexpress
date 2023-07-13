package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Entidades.Rol;
import com.example.BDAgroexpressPrueba.Entidades.SessionRequest;
import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import com.example.BDAgroexpressPrueba.Servicios.Servicio_DetalleCompra;
import com.example.BDAgroexpressPrueba.Servicios.Servicio_Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_Usuario {

    Servicio_Usuario servicio;

    Servicio_DetalleCompra servicio_D;

    public Controlador_Usuario(Servicio_Usuario servicio, Servicio_DetalleCompra servicio_D) {
        this.servicio = servicio;
        this.servicio_D = servicio_D;
    }

    @GetMapping("/ListarUsuarios")
    public ArrayList<Usuario> listarUsuarios(){
        return servicio.ListarUsuarios();
    }

    @GetMapping("/Ingresar")
    public String IngresoUsuario(@RequestBody SessionRequest datos) {
        return servicio.ValidacionIngresoUsuario(datos);
    }

    @PostMapping("/AgregarUsuario/{rol}")
    public String AgregarUsuario(@PathVariable("rol") int rol ,@RequestBody Usuario user){

        String message = "No se pudo realizar el registro";

        if(servicio.AgregarUsuario(rol, user)){
            servicio.AgregarUsuario(rol,user);
            message = "Se agregó de manera exitosa";
        }
        return message;
    }
    @PutMapping("/ActualizarUsuario/{rol}")
    public String actualizarUsuario(@RequestBody Usuario usuario,@PathVariable("rol") int rol){
        if(servicio.ActualizarUsuario(usuario, rol)){
            return "Se actualizó correctamente el producto";
        }else {
            return "No se logró actualizar el producto";
        }
    }

    @GetMapping("/ListarCampesinos")
    public List<Usuario> getCampesinos(){
        return servicio.getCampesinos();
    }

   /* @PostMapping("/ActualizarEstado/{doc}/{estado}")
    public boolean actualizarEstado(@PathVariable("doc")String doc,@PathVariable("estado")String estado){
        return servicio_D.actualizarEstadoOrdenEntrega(doc,estado);
    }*/
}

package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import com.example.BDAgroexpressPrueba.Interfaz.Rol_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.Usuario_Repositorio;
import com.example.BDAgroexpressPrueba.Servicios.Servicio_Usuario;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_Usuario {

    Servicio_Usuario servicio;
    Usuario user = new Usuario();

    public Controlador_Usuario(Servicio_Usuario servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarUsuarios")
    public ArrayList<Usuario> listarUsuarios(){
        return servicio.ListarUsuarios();
    }

    @PostMapping(path = "/AgregarUsuario/{rol}")
    public String AgregarUsuario(@PathVariable int rol,@RequestBody Usuario usuario){
        String message = "No se pudo realizar el registro";

        if(servicio.AgregarUsuario(rol, usuario)){
            servicio.AgregarUsuario(rol,usuario);
            message = "Se agregó de manera exitosa";
        }
        return message;
    }
}

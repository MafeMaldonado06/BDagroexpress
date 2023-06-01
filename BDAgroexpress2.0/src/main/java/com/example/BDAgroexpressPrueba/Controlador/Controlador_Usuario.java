package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Entidades.Rol;
import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import com.example.BDAgroexpressPrueba.Servicios.Servicio_Usuario;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_Usuario {

    Servicio_Usuario servicio;

    public Controlador_Usuario(Servicio_Usuario servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarUsuarios")
    public ArrayList<Usuario> listarUsuarios(){
        return servicio.ListarUsuarios();
    }

    @GetMapping("/Ingresar/{documento}/{contraseña}")
    public Rol IngresoUsuario(@PathVariable("documento") String documento, @PathVariable("contraseña") String contraseña,HttpSession sesion){
        return servicio.ValidacionIngresoUsuario(documento, contraseña,sesion);
    }

    @PostMapping("/AgregarUsuario/{rol}")
    public String AgregarUsuario(@PathVariable("rol") int rol,@RequestBody Usuario user){

        String message = "No se pudo realizar el registro";

        if(servicio.AgregarUsuario(rol, user)){
            servicio.AgregarUsuario(rol,user);
            message = "Se agregó de manera exitosa";
        }
        return message;
    }
}

package com.example.BDAgroexpress.Controlador;

import com.example.BDAgroexpress.Entidades.Usuario;
import com.example.BDAgroexpress.Interfaz.Rol_Repositorio;
import com.example.BDAgroexpress.Interfaz.Usuario_Repositorio;
import com.example.BDAgroexpress.Servicios.Servicio_Usuario;
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

    @PostMapping("/AgregarUsuario")
    public void AgregarUsuario(@RequestBody Usuario usuario){
        System.out.println("Objeto del controlador:" + usuario);

        String message = "No se pudo realizar el registro";

    }
}

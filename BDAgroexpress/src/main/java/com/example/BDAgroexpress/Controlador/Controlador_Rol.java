package com.example.BDAgroexpress.Controlador;

import com.example.BDAgroexpress.Entidades.Rol;
import com.example.BDAgroexpress.Servicios.Servicio_Rol;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_Rol {
    Servicio_Rol servicio;

    public Controlador_Rol(Servicio_Rol servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarRoles")
    public ArrayList<Rol> ListarRoles(){
        return servicio.ListarRoles();
    }
}

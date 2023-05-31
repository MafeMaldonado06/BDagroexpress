package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Entidades.Rol;
import com.example.BDAgroexpressPrueba.Servicios.Servicio_Rol;
import org.springframework.web.bind.annotation.*;

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

package com.example.BDAgroexpress30.Controlador;

import com.example.BDAgroexpress30.Entidad.Rol;
import com.example.BDAgroexpress30.Servicio.Service_Rol;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controller_Rol {

    //Service_Rol service_rol;

    @PostMapping("/AgregarRol")
    public String agregarRol(@RequestBody Rol rol){
        System.out.println(rol);
        //return service_rol.agregarRol(rol);
        return "Hola";
    }

}

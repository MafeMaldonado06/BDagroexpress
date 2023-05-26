package com.example.BDAgroexpress30.Servicio;

import com.example.BDAgroexpress30.Entidad.Rol;
import com.example.BDAgroexpress30.Interfaz.Repository_Rol;
import org.springframework.stereotype.Service;

@Service
public class Service_Rol {

    Repository_Rol repository_rol;

    public String agregarRol(Rol rol){
        repository_rol.save(rol);
        return "Registro ingresado";
    }

}

package com.example.BDAgroexpress.Servicios;

import com.example.BDAgroexpress.Entidades.Rol;
import com.example.BDAgroexpress.Interfaz.Rol_Repositorio;
import com.example.BDAgroexpress.Interfaz.Usuario_Repositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Servicio_Rol {

    Usuario_Repositorio RepositorioUsuario;
    Rol_Repositorio ReporsitorioRol;

    public Servicio_Rol(Usuario_Repositorio repositorioUsuario, Rol_Repositorio reporsitorioRol) {
        RepositorioUsuario = repositorioUsuario;
        ReporsitorioRol = reporsitorioRol;
    }

    public ArrayList<Rol> ListarRoles(){
        return (ArrayList<Rol>) ReporsitorioRol.findAll();
    }
}

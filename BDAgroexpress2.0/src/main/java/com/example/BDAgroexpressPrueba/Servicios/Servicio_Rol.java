package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.Rol;
import com.example.BDAgroexpressPrueba.Interfaz.Rol_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.Usuario_Repositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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


    public List<Map<String, Object>> Transportador(){
        return ReporsitorioRol.Transportador();
    }



}

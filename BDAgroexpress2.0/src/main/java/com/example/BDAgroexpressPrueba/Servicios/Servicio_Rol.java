package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.Departamento;
import com.example.BDAgroexpressPrueba.Entidades.Municipio;
import com.example.BDAgroexpressPrueba.Entidades.Rol;
import com.example.BDAgroexpressPrueba.Interfaz.Departamento_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.Municipio_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.Rol_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.Usuario_Repositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Servicio_Rol {


    Departamento_Repositorio departamento_repositorio;
    Municipio_Repositorio municipio_repositorio;

    Usuario_Repositorio RepositorioUsuario;
    Rol_Repositorio ReporsitorioRol;

    public Servicio_Rol(Departamento_Repositorio departamento_repositorio, Municipio_Repositorio municipio_repositorio, Usuario_Repositorio repositorioUsuario, Rol_Repositorio reporsitorioRol) {
        this.departamento_repositorio = departamento_repositorio;
        this.municipio_repositorio = municipio_repositorio;
        RepositorioUsuario = repositorioUsuario;
        ReporsitorioRol = reporsitorioRol;
    }

    public ArrayList<Rol> ListarRoles(){
        return (ArrayList<Rol>) ReporsitorioRol.findAll();
    }

    public List<Map<String, Object>> getDepartameto(){
        return departamento_repositorio.findDepartamento();
    }

    public List<Map<String, Object>> getMunicipios(){
        return municipio_repositorio.findMunicipio();
    }

}

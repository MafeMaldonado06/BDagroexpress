package com.example.BDAgroexpress.Servicios;

import com.example.BDAgroexpress.Entidades.Usuario;
import com.example.BDAgroexpress.Interfaz.Rol_Repositorio;
import com.example.BDAgroexpress.Interfaz.Usuario_Repositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class Servicio_Usuario {

    Usuario_Repositorio RepositorioUsuario;
    Rol_Repositorio RepositorioRol;

    public Servicio_Usuario(Usuario_Repositorio repositorioUsuario, Rol_Repositorio repositorioRol) {
        RepositorioUsuario = repositorioUsuario;
        RepositorioRol = repositorioRol;
    }

    public ArrayList<Usuario> ListarUsuarios(){
        return (ArrayList<Usuario>) RepositorioUsuario.findAll();
    }
}

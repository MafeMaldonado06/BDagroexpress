package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.Rol;
import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import com.example.BDAgroexpressPrueba.Interfaz.Rol_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.Usuario_Repositorio;
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

    public Boolean AgregarUsuario(int rol,Usuario usuario){
        Boolean status = false;

        Rol roles = RepositorioRol.findById(rol).get();

        if (RepositorioRol.findById(rol).isPresent()){
            status = true;
            usuario.setUsu_Rol(roles);
            RepositorioUsuario.save(usuario);
        }

        return status;

    }
}

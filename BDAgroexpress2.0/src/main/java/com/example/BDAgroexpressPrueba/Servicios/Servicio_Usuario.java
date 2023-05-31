package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.Rol;
import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import com.example.BDAgroexpressPrueba.Interfaz.Rol_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.Usuario_Repositorio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

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

    public Rol ValidacionIngresoUsuario(String documento, String contraseña){
        Rol rol = null;

        System.out.println("Password: " + contraseña);
        if(RepositorioUsuario.findById(documento).isPresent()){
            Usuario user =  RepositorioUsuario.findById(documento).get();
            System.out.println(user.getUsu_Contrasena());
            System.out.println(user);
            if(user.getUsu_Contrasena().equals(contraseña)){
                rol = user.getUsu_Rol();
                System.out.println(rol);
            }else{
                System.out.println("El documento o la contraseña son incorrectos");
            }
        }

        return rol;
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

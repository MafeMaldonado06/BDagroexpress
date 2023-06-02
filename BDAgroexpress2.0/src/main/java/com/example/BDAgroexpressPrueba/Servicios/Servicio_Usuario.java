package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.Rol;
import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import com.example.BDAgroexpressPrueba.Interfaz.Rol_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.Usuario_Repositorio;
import jakarta.persistence.Id;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class Servicio_Usuario {
    @Autowired
    Usuario_Repositorio RepositorioUsuario;
    Rol_Repositorio RepositorioRol;
    private HttpSession session;

    public Servicio_Usuario(Usuario_Repositorio repositorioUsuario, Rol_Repositorio repositorioRol, HttpSession session) {
        RepositorioUsuario = repositorioUsuario;
        RepositorioRol = repositorioRol;
        this.session = session;
    }

    public HttpSession getSession() {
        return session;
    }

    //Metodos

    public ArrayList<Usuario> ListarUsuarios(){
        return (ArrayList<Usuario>) RepositorioUsuario.findAll();
    }

    public Rol ValidacionIngresoUsuario(String documento, String contraseña){
        Rol rol = null;

        if(RepositorioUsuario.findById(documento).isPresent()){
            Usuario user =  RepositorioUsuario.findById(documento).get();
            if(user.getUsu_Contrasena().equals(contraseña)){
                rol = user.getUsu_Rol();
                session.setAttribute("Usuario", user);
            }
        }
        return rol;
    }

    public Boolean AgregarUsuario(int rol,Usuario usuario){
        Boolean status = false;

        Rol roles = RepositorioRol.findById(rol).get();
        String documento = usuario.getUsu_Documento();

        if (RepositorioRol.findById(rol).isPresent() && !RepositorioUsuario.findById(documento).isPresent()){
            status = true;
            usuario.setUsu_Rol(roles);
            RepositorioUsuario.save(usuario);
        }
        return status;
    }

    public List<Usuario> getCampesinos(){
        return RepositorioUsuario.findCampesinos();
    }

}

package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.Departamento;
import com.example.BDAgroexpressPrueba.Entidades.Municipio;
import com.example.BDAgroexpressPrueba.Entidades.Rol;
import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import com.example.BDAgroexpressPrueba.Interfaz.Departamento_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.Municipio_Repositorio;
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
    Municipio_Repositorio municipioRepositorio;
    Departamento_Repositorio departamentoRepositorio;
    private HttpSession session;

    public Servicio_Usuario(Usuario_Repositorio repositorioUsuario, Rol_Repositorio repositorioRol, Municipio_Repositorio municipioRepositorio, Departamento_Repositorio departamentoRepositorio, HttpSession session) {
        RepositorioUsuario = repositorioUsuario;
        RepositorioRol = repositorioRol;
        this.municipioRepositorio = municipioRepositorio;
        this.departamentoRepositorio = departamentoRepositorio;
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

    public Boolean AgregarUsuario(int rol,Usuario usuario, int departamento, int ciudad){
        Boolean status = false;

        Rol roles = RepositorioRol.findById(rol).get();
        Departamento departament = departamentoRepositorio.findById(departamento).get();
        Municipio municipio = municipioRepositorio.findById(ciudad).get();
        String documento = usuario.getUsu_Documento();


        if (RepositorioRol.findById(rol).isPresent() && !RepositorioUsuario.findById(documento).isPresent() && municipioRepositorio.findById(ciudad).isPresent() && departamentoRepositorio.findById(departamento).isPresent()){
            status = true;
            usuario.setUsu_Departamento(departament);
            usuario.setUsu_Ciudad(municipio);
            usuario.setUsu_Rol(roles);
            RepositorioUsuario.save(usuario);

            session.setAttribute("Usuario", usuario);
        }
        return status;
    }

    public List<Usuario> getCampesinos(){
        return RepositorioUsuario.findCampesinos();
    }

}

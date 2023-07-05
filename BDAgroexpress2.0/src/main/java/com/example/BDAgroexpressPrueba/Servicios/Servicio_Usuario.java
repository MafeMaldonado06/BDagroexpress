package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.*;
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

    public void setSession(HttpSession session) {
        this.session = session;
    }

    //Metodos

    public ArrayList<Usuario> ListarUsuarios(){
        return (ArrayList<Usuario>) RepositorioUsuario.findAll();
    }

    public List<Usuario> getCampesinos(){
        return RepositorioUsuario.findCampesinos();
    }

    public Rol ValidacionIngresoUsuario(SessionRequest datos){
        Rol rol = null;

        if(RepositorioUsuario.findById(datos.getDocumento()).isPresent()){
            Usuario user =  RepositorioUsuario.findById(datos.getDocumento()).get();
            if(user.getUsu_Contrasena().equals(datos.getContraseña())){
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

    public Boolean ActualizarUsuario(Usuario usuario, int rol, int municipio, int departamento){

        Boolean status = false;

        Usuario datosSesion = (Usuario) session.getAttribute("Usuario");

        Usuario user = RepositorioUsuario.findById(datosSesion.getUsu_Documento()).get();
        Rol role = RepositorioRol.findById(rol).get();
        Departamento departament = departamentoRepositorio.findById(departamento).get();
        Municipio ciudad = municipioRepositorio.findById(municipio).get();


        if(user != null){
            user.setUsu_Nombre(usuario.getUsu_Nombre());
            user.setUsu_Apellidos(usuario.getUsu_Apellidos());
            user.setUsu_Correo(usuario.getUsu_Correo());
            user.setUsu_Celular(usuario.getUsu_Celular());
            user.setUsu_Telefono(usuario.getUsu_Telefono());
            user.setUsu_Departamento(departament);
            user.setUsu_Ciudad(ciudad);
            user.setUsu_Direccion(usuario.getUsu_Direccion());
            user.setUsu_Contrasena(usuario.getUsu_Contrasena());
            status = true;

            RepositorioUsuario.save(user);

            session.setAttribute("Usuario", user);
        }

        return status;

    }

}

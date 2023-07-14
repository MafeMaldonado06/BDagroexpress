package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.*;
import com.example.BDAgroexpressPrueba.Interfaz.Usuario_Repositorio;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Servicio_Usuario {
    @Autowired
    Usuario_Repositorio RepositorioUsuario;
    private HttpSession session;

    public Servicio_Usuario(Usuario_Repositorio repositorioUsuario, HttpSession session) {
        RepositorioUsuario = repositorioUsuario;
        this.session = session;
    }

    //Metodos
    @Transactional
    public ArrayList<Usuario> ListarUsuarios(){
        return (ArrayList<Usuario>) RepositorioUsuario.findAll();
    }

    public List<Usuario> getCompradores(){
        return RepositorioUsuario.findCompradores();
    }

    public List<Usuario> getCampesinos(){
        return RepositorioUsuario.findCampesinos();
    }

    public List<Usuario> Transportador(){
        return RepositorioUsuario.Transportador();
    }

    public List<Usuario> getAdministradores(){
        return RepositorioUsuario.findAdministrador();
    }

    public String ValidacionIngresoUsuario(SessionRequest datos){
        String acceso = "\n" +
                "\"Access\": false\n" +
                "}";

        if(RepositorioUsuario.findById(datos.getDocumento()).isPresent()){
            Usuario user =  RepositorioUsuario.findById(datos.getDocumento()).get();
            if(user.getUsu_Contrasena().equals(datos.getContraseña())){
                String rol = user.getUsu_Rol();
                acceso = "{\n" +
                        "\"Access\": true\n" +
                        "\"usu_Rol\": " + rol  + "\n" +
                        "}";
                session.setAttribute("Usuario", user);
            }
        }
        return acceso;
    }

    public Boolean AgregarUsuario(Usuario usuario){
        Boolean status = false;

        String documento = usuario.getUsu_Documento();

        System.out.println(documento);

        if (!RepositorioUsuario.findById(documento).isPresent()){
            status = true;
            RepositorioUsuario.save(usuario);
        }
        return status;
    }

    public Boolean ActualizarUsuario(Usuario usuario, int rol){

        Boolean status = false;

        Usuario datosSesion = (Usuario) session.getAttribute("Usuario");

        Usuario user = RepositorioUsuario.findById(datosSesion.getUsu_Documento()).get();

        if(user != null){
            user.setUsu_Nombre(usuario.getUsu_Nombre());
            user.setUsu_Apellidos(usuario.getUsu_Apellidos());
            user.setUsu_Correo(usuario.getUsu_Correo());
            user.setUsu_Celular(usuario.getUsu_Celular());
            user.setUsu_Telefono(usuario.getUsu_Telefono());
            user.setUsu_Direccion(usuario.getUsu_Direccion());
            user.setUsu_Contrasena(usuario.getUsu_Contrasena());
            status = true;

            RepositorioUsuario.save(user);

            session.setAttribute("Usuario", user);
        }

        return status;

    }

}

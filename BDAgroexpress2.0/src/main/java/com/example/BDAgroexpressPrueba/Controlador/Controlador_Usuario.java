package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Entidades.Rol;
import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import com.example.BDAgroexpressPrueba.Servicios.Servicio_Usuario;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_Usuario {

    Servicio_Usuario servicio;

    public Controlador_Usuario(Servicio_Usuario servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/ListarUsuarios")
    public ArrayList<Usuario> listarUsuarios(){
        return servicio.ListarUsuarios();
    }

    @GetMapping("/Ingresar/{documento}/{contraseña}")
    public Rol IngresoUsuario(@PathVariable("documento") String documento, @PathVariable("contraseña") String contraseña){
        return servicio.ValidacionIngresoUsuario(documento, contraseña);
    }

    @PostMapping("/AgregarUsuario/{rol}/{departamento}/{ciudad}")
    public String AgregarUsuario(@PathVariable("rol") int rol,@PathVariable("departamento") int departamento, @PathVariable("ciudad") int ciudad,@RequestBody Usuario user){

        String message = "No se pudo realizar el registro";

        if(servicio.AgregarUsuario(rol, user, departamento, ciudad)){
            servicio.AgregarUsuario(rol,user, departamento, ciudad);
            message = "Se agregó de manera exitosa";
        }
        return message;
    }

    @GetMapping("/ListarCampesinos")
    public List<Usuario> getCampesinos(){
        return servicio.getCampesinos();
    }
}

package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Entidades.Android;
import com.example.BDAgroexpressPrueba.Entidades.SessionRequest;
import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import com.example.BDAgroexpressPrueba.Servicios.Servicio_DetalleCompra;
import com.example.BDAgroexpressPrueba.Servicios.Servicio_Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_Usuario {

    Servicio_Usuario servicio;

    Servicio_DetalleCompra servicio_D;

    public Controlador_Usuario(Servicio_Usuario servicio, Servicio_DetalleCompra servicio_D) {
        this.servicio = servicio;
        this.servicio_D = servicio_D;
    }


    @GetMapping("/ListarUsuarios")
    public ArrayList<Usuario> listarUsuarios(){
        return servicio.ListarUsuarios();
    }

    @GetMapping("/listarCompradores")
    public List<Usuario> getCompradores(){
        return servicio.getCompradores();
    }

    @GetMapping("/listarCampesinos")
    public List<Usuario> findCampesinos(){
        return servicio.getCampesinos();
    }

    @GetMapping("/listarTranpsotador")
    public List<Usuario> Transportador(){
        return servicio.Transportador();
    }

    @GetMapping("/listarAdministradores")
    public List<Usuario> findAdministradores(){
        return servicio.getAdministradores();
    }

    @GetMapping("/DatosSesion/{documento}")
    public Usuario datosSesion(@PathVariable("documento") String documento){
        return servicio.datosSesion(documento);
    }

    @PostMapping("/Ingresar")
    public Map<String, String> IngresoUsuario(@RequestBody SessionRequest datos) {
        return servicio.ValidacionIngresoUsuario(datos);
    }

    @GetMapping("/ListarAndroid")
    public List<Android> ListarAndroid(){
        return servicio.Documentoandroid();
    }

    @DeleteMapping("/EliminarAndroid")
    public ResponseEntity<String> eliminarAndroid() {
        servicio.eliminarTodosLosAndroid();
        return ResponseEntity.ok("Eliminación exitosa");
    }


    @PostMapping("/AgregarUsuario")
    public String AgregarUsuario(@RequestBody Usuario user){

        String message = "No se pudo realizar el registro";

        if(servicio.AgregarUsuario(user)){
            servicio.AgregarUsuario(user);
            message = "Se agregó de manera exitosa";
        }
        return message;
    }
    @PutMapping("/ActualizarUsuario/{rol}")
    public String actualizarUsuario(@RequestBody Usuario usuario,@PathVariable("rol") int rol){
        if(servicio.ActualizarUsuario(usuario, rol)){
            return "Se actualizó correctamente el producto";
        }else {
            return "No se logró actualizar el producto";
        }
    }

    @GetMapping("/ListarCampesinos")
    public List<Usuario> getCampesinos(){
        return servicio.getCampesinos();
    }

   /* @PostMapping("/ActualizarEstado/{doc}/{estado}")
    public boolean actualizarEstado(@PathVariable("doc")String doc,@PathVariable("estado")String estado){
        return servicio_D.actualizarEstadoOrdenEntrega(doc,estado);
    }*/

    @DeleteMapping("/eliminarUsuario/{documento}")
    public String eliminarUsuario(@PathVariable String documento) {
        servicio.eliminarUsuario(documento);

        return "listo";
    }

}

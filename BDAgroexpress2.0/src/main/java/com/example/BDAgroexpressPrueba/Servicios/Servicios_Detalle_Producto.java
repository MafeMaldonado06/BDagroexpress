package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import com.example.BDAgroexpressPrueba.Interfaz.DetalleProducto_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.Usuario_Repositorio;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Servicios_Detalle_Producto {
    DetalleProducto_Repositorio repositorio;
    Usuario_Repositorio RepositorioUsuario;
    Servicio_Usuario servicioUsuario;

    public Servicios_Detalle_Producto(DetalleProducto_Repositorio repositorio, Usuario_Repositorio repositorioUsuario, Servicio_Usuario servicioUsuario) {
        this.repositorio = repositorio;
        RepositorioUsuario = repositorioUsuario;
        this.servicioUsuario = servicioUsuario;
    }

    public ArrayList<DetalleProducto> listarDetalleProducto(){
        return  (ArrayList<DetalleProducto>) repositorio.findAll();
    }

    //Campesino

    public String agregarproducto(String doc, DetalleProducto producto) {

        if (RepositorioUsuario.findById(doc).isPresent()) {
            Usuario campe= RepositorioUsuario.findById(doc).get();

            int rol = campe.getUsu_Rol().getRol_Id();

            if (rol == 2 || rol == 4){
                producto.setDet_IdUsuario(campe);
                repositorio.save(producto);
                return "El producto se agrego exitosamente";
            }else {
                return "usted no puede agregar prodcutos";
            }
        } else {
            return "su usario no existe";
        }
    }

    public void getProductosPorCampesino(){
        Usuario usuario = (Usuario) servicioUsuario.getSession().getAttribute("Usuario");

        System.out.println(repositorio.ProductosPorCampesino(usuario.getUsu_Documento()));
    }

}

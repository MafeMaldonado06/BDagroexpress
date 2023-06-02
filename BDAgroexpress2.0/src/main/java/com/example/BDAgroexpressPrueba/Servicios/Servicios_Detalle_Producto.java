package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import com.example.BDAgroexpressPrueba.Interfaz.DetalleProducto_Repositorio;
import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Interfaz.DetalleProducto_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.Usuario_Repositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Servicios_Detalle_Producto {
    DetalleProducto_Repositorio repositorio;
    Usuario_Repositorio RepositorioUsuario;

    public Servicios_Detalle_Producto(DetalleProducto_Repositorio repositorio,  Usuario_Repositorio repositorioUsuario) {
        this.repositorio = repositorio;
        RepositorioUsuario = repositorioUsuario;
    }

    public ArrayList<DetalleProducto> listarDetalleProducto(){
        return  (ArrayList<DetalleProducto>) repositorio.findAll();
    }

    //Campesino

    public String agregarproducto(String doc, DetalleProducto campesino) {

        if (RepositorioUsuario.findById(doc).isPresent()) {
            Usuario campe= RepositorioUsuario.findById(doc).get();

            int rol = campe.getUsu_Rol().getRol_Id();

            if (rol == 2 || rol == 4){
                campesino.setDet_IdUsuario(campe);
                repositorio.save(campesino);
                return "El producto se agrego exitosamente";

            }else {

                return "usted no puede agregar prodcutos";
            }

        } else {

            return "su usario no existe";
        }

    }

}

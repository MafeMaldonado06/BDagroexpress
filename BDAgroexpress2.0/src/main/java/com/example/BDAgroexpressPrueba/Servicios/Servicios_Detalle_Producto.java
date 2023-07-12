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
    public List<DetalleProducto> getProductosPorCampesino(String documento){
        List<DetalleProducto> productos = null;

        Usuario usuario = RepositorioUsuario.findById(documento).get();

        if(usuario.getUsu_Rol().getRol_Id() == 4 || usuario.getUsu_Rol().getRol_Id() == 2){
            productos = repositorio.ProductosPorCampesino(usuario.getUsu_Documento());
        }

        return productos;
    }

    public String agregarproducto(DetalleProducto producto, String documento) {

        Usuario usuario = RepositorioUsuario.findById(documento).get();

        if (usuario.getUsu_Rol().getRol_Id() == 2 || usuario.getUsu_Rol().getRol_Id() == 4) {
                producto.setDet_IdUsuario(usuario);
                repositorio.save(producto);
                return "El producto se agrego exitosamente";
        }else {
            return "usted no puede agregar productos";
        }
    }

    public Boolean actualizarProducto(int id,DetalleProducto producto, String documento){

        Boolean status = false;

        Usuario usuario = RepositorioUsuario.findById(documento).get();
        DetalleProducto product = repositorio.findById(id).get();

        if(usuario != null && usuario.getUsu_Rol().getRol_Id() == 2 || usuario.getUsu_Rol().getRol_Id() == 4){

            product.setDet_Referencia(product.getDet_Referencia());
            product.setDet_IdUsuario(usuario);
            product.setDet_Img(producto.getDet_Img());
            product.setDet_Nombre_product(producto.getDet_Nombre_poduct());
            product.setDet_Categoria(producto.getDet_Categoria());
            product.setDet_precio(producto.getDet_precio());
            product.setDet_cantidad(producto.getDet_cantidad());

            repositorio.save(product);

            status = true;
        }
        return status;
    }

    public Boolean EliminarProducto(int id, String documento){

        Boolean status = false;

        Usuario usuario = RepositorioUsuario.findById(documento).get();
        DetalleProducto producto = repositorio.findById(id).get();

        if(getProductosPorCampesino(documento).contains(producto)){
            repositorio.deleteById(id);
            status = true;
        }

        return status;
    }

    public List<DetalleProducto> listarProductosCategoriaFrutas(){
        return repositorio.ProductosFrutas();
    }

    public List<DetalleProducto> listarProductosCategoriaVerduras(){
        return repositorio.ProductosVerduras();
    }

    public List<DetalleProducto> listarProductosCategoriaLegumbres(){
        return repositorio.ProductosLegumbres();
    }

}

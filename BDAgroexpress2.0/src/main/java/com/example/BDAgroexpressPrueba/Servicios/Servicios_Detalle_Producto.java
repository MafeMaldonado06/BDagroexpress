package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.DetalleProducto;
import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import com.example.BDAgroexpressPrueba.Interfaz.DetalleProducto_Repositorio;
import com.example.BDAgroexpressPrueba.Interfaz.Usuario_Repositorio;
import org.eclipse.sisu.reflect.Soft;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class Servicios_Detalle_Producto {
    DetalleProducto_Repositorio detalleProductoRepositorio;
    Usuario_Repositorio RepositorioUsuario;
    Servicio_Usuario servicioUsuario;

    public Servicios_Detalle_Producto(DetalleProducto_Repositorio detalleProductoRepositorio, Usuario_Repositorio repositorioUsuario, Servicio_Usuario servicioUsuario) {
        this.detalleProductoRepositorio = detalleProductoRepositorio;
        RepositorioUsuario = repositorioUsuario;
        this.servicioUsuario = servicioUsuario;
    }

    public List<DetalleProducto> listarDetalleProducto(){
        return (List<DetalleProducto>) detalleProductoRepositorio.findAll();
    }

    //Campesino
    public List<DetalleProducto> getProductosPorCampesino(String documento){
        List<DetalleProducto> productos = null;

        Usuario usuario = RepositorioUsuario.findById(documento).get();

        if(usuario.getUsu_Rol().equals("Administrador") || usuario.getUsu_Rol().equals("Campesino")){
            productos = detalleProductoRepositorio.ProductosPorCampesino(usuario.getUsu_Documento());
        }

        return productos;
    }

    public String agregarproducto(DetalleProducto producto, String documento) {

        Usuario usuario = RepositorioUsuario.findById(documento).get();

        if (usuario.getUsu_Rol().equals("Administrador") || usuario.getUsu_Rol().equals("Campesino")) {
                producto.setDet_IdUsuario(usuario);
                detalleProductoRepositorio.save(producto);
                return "El producto se agrego exitosamente";
        }else {
            return "usted no puede agregar productos";
        }
    }

    public Boolean actualizarProducto(int id,DetalleProducto producto, String documento){

        Boolean status = false;

        Usuario usuario = RepositorioUsuario.findById(documento).get();
        DetalleProducto product = detalleProductoRepositorio.getProducto(id);

        if(usuario != null && usuario.getUsu_Rol().equals("Administrador") || usuario.getUsu_Rol().equals("Campesino")){

            product.setDet_Referencia(product.getDet_Referencia());
            product.setDet_IdUsuario(usuario);
            product.setDet_Img(producto.getDet_Img());
            product.setDet_Nombre_product(producto.getDet_Nombre_product());
            product.setDet_Categoria(producto.getDet_Categoria());
            product.setDet_precio(producto.getDet_precio());
            product.setDet_cantidad(producto.getDet_cantidad());

            detalleProductoRepositorio.save(product);

            status = true;
        }
        return status;
    }

    public Boolean EliminarProducto(int id, String documento){

        Boolean status = false;

        System.out.println(id);
        System.out.println(documento);

        Usuario usuario = RepositorioUsuario.findById(documento).get();
        System.out.println(usuario);
        DetalleProducto producto = detalleProductoRepositorio.getProducto(id);

        System.out.println(producto);

        List<DetalleProducto> productosPorCampesino = getProductosPorCampesino(documento);
        System.out.println(productosPorCampesino);

        if(getProductosPorCampesino(documento).contains(producto)){
            detalleProductoRepositorio.deleteById(id);
            status = true;
        }


        return status;

    }

    public List<DetalleProducto> listarProductosCategoriaFrutas(){
        return detalleProductoRepositorio.ProductosFrutas();
    }

    public List<DetalleProducto> listarProductosCategoriaVerduras(){
        return detalleProductoRepositorio.ProductosVerduras();
    }

    public List<DetalleProducto> listarProductosCategoriaLegumbres(){
        return detalleProductoRepositorio.ProductosLegumbres();
    }

    public DetalleProducto getProducto(int referencia){
        return detalleProductoRepositorio.getProducto(referencia);
    }

    public int contarProductos(int doc) {
        return detalleProductoRepositorio.countProductsByUserId(doc);
    }
}

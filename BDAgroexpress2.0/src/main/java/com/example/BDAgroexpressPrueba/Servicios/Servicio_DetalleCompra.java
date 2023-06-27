package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.*;
import com.example.BDAgroexpressPrueba.Interfaz.*;
import jakarta.persistence.Id;
import jakarta.servlet.http.HttpSession;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;

@Service
public class Servicio_DetalleCompra {

    Ord_Entrega_Repositorio ordEntregaRepositorio;

    Factura_Repositorio facturaRepositorio;
    Usuario_Repositorio RepositorioUsuario;
    DetalleProducto_Repositorio detalleProductoRepositorio;

    DetalleCompra_Repositorio detalleCompraRepositorio;

    Servicio_Usuario servicioUsuario;

    private HttpSession session;

    public Servicio_DetalleCompra(Ord_Entrega_Repositorio ordEntregaRepositorio, Factura_Repositorio facturaRepositorio, Usuario_Repositorio repositorioUsuario, DetalleProducto_Repositorio detalleProductoRepositorio, DetalleCompra_Repositorio detalleCompraRepositorio, Servicio_Usuario servicioUsuario) {
        this.ordEntregaRepositorio = ordEntregaRepositorio;
        this.facturaRepositorio = facturaRepositorio;
        RepositorioUsuario = repositorioUsuario;
        this.detalleProductoRepositorio = detalleProductoRepositorio;
        this.detalleCompraRepositorio = detalleCompraRepositorio;
        this.servicioUsuario = servicioUsuario;
    }

    public HttpSession getSession() {
        return session;
    }
    Factura factura = new Factura();



    public ArrayList<DetalleCompra> getOrdenCompra(){
        return (ArrayList<DetalleCompra>) detalleCompraRepositorio.findAll();
    }


    public String Agregarcarrito(String documento, int id) {
        DetalleCompra detalleCompra = new DetalleCompra();

        Optional<DetalleProducto> detalleProductoOptional = detalleProductoRepositorio.findById(id);
        Optional<Usuario> usuarioOptional = RepositorioUsuario.findById(documento);

        if (detalleProductoOptional.isPresent() && usuarioOptional.isPresent()) {
            DetalleProducto detalleProducto = detalleProductoOptional.get();
            Usuario usuario = usuarioOptional.get();


            detalleCompra.setOrdC_Producto(detalleProducto);
            detalleCompra.setUsuario(usuario);
            detalleCompra.setPrecio_producto(detalleProducto.getDet_precio());
            // Guardar la orden de compra en la base de datos
            detalleCompra=detalleCompraRepositorio.save(detalleCompra);

            return "si se epudo";
        }

        return "no se puso";
    }

    public void factura(int idusu){

        Optional<Factura> facturaOptional = facturaRepositorio.findById(idusu);


        List<DetalleCompra> detalleCompras = detalleCompraRepositorio.findAll();

        List<Factura> facturas = new ArrayList<>();
        for (DetalleCompra compra:detalleCompras ){
            Factura fact = new Factura();
            fact.setFac_Total((double) compra.getPrecio_producto());
            //id carrito
            fact.getFac_OrdC_Id(compra.getOrdC_Id());

            facturas.add(fact);
        }
        facturaRepositorio.saveAll(facturas);

    }



    public void eliminarPorProductoId(int productoId) {
        DetalleCompra detalleCompra = detalleCompraRepositorio.findByProductoId(productoId);
        if (detalleCompra != null) {
            detalleCompraRepositorio.delete(detalleCompra);
        }
    }

    public List<Map<String, Object>>findrntrgado(int doc){
        return ordEntregaRepositorio.finentrgado(doc);
    }

    public List<Map<String, Object>>finentregando(int doc){
        return ordEntregaRepositorio.finentregando(doc);
    }


}



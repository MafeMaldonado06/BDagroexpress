package com.example.BDAgroexpressPrueba.Servicios;

import com.example.BDAgroexpressPrueba.Entidades.*;
import com.example.BDAgroexpressPrueba.Interfaz.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Id;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class Servicio_DetalleCompra {

    Ord_Entrega_Repositorio ordEntregaRepositorio;

    Factura_Repositorio facturaRepositorio;
    Usuario_Repositorio RepositorioUsuario;
    DetalleProducto_Repositorio detalleProductoRepositorio;

    DetalleCompra_Repositorio detalleCompraRepositorio;

    Servicio_Usuario servicioUsuario;

    @PersistenceContext
    private EntityManager entityManager;

    public Servicio_DetalleCompra(Ord_Entrega_Repositorio ordEntregaRepositorio, Factura_Repositorio facturaRepositorio, Usuario_Repositorio repositorioUsuario, DetalleProducto_Repositorio detalleProductoRepositorio, DetalleCompra_Repositorio detalleCompraRepositorio, Servicio_Usuario servicioUsuario) {
        this.ordEntregaRepositorio = ordEntregaRepositorio;
        this.facturaRepositorio = facturaRepositorio;
        RepositorioUsuario = repositorioUsuario;
        this.detalleProductoRepositorio = detalleProductoRepositorio;
        this.detalleCompraRepositorio = detalleCompraRepositorio;
        this.servicioUsuario = servicioUsuario;
    }

    Factura factura = new Factura();



    public ArrayList<DetalleCompra> getOrdenCompra(){
        return (ArrayList<DetalleCompra>) detalleCompraRepositorio.findAll();
    }


    public String Agregarcarrito(String documento, int id) {
        DetalleCompra detalleCompra = new DetalleCompra();

        Optional<DetalleProducto> detalleProductoOptional = detalleProductoRepositorio.findById(id);
        Optional<Usuario> doc = RepositorioUsuario.findById(documento);

        if (detalleProductoOptional.isPresent() && doc.isPresent()) {
            DetalleProducto detalleProducto = detalleProductoOptional.get();
            Usuario usuario = doc.get();


            detalleCompra.setOrdC_Producto(detalleProducto);
            detalleCompra.setUsuario(usuario);
            detalleCompra.setPrecio_producto(detalleProducto.getDet_precio());

            // Guardar la orden de compra en la base de datos
            detalleCompra=detalleCompraRepositorio.save(detalleCompra);




            return "se agrego al carrito";
        }

        return "no se agrego al carrito";
    }

    public void factura(int idusu){

        Optional<Factura> facturaOptional = facturaRepositorio.findById(idusu);
        List<DetalleCompra> detalleCompras = detalleCompraRepositorio.findAll();

        List<Factura> facturas = new ArrayList<>();
        for (DetalleCompra compra:detalleCompras ){
            Factura fact = new Factura();
            //id carrito

            facturas.add(fact);
        }
        facturaRepositorio.saveAll(facturas);

    }


    //@Transactional
    public boolean generarFactura(String documento) {
        Optional<Usuario> usuarioOptional = RepositorioUsuario.findById(documento);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();

            // Obtener la lista de DetalleCompra del usuario
            Set<DetalleCompra> detalleCompras = usuario.getDetalleCompras();

            double total = 0;

            // Calcular el total del precio de los productos en el carrito
            for (DetalleCompra detalleCompra : detalleCompras) {
                total += detalleCompra.getPrecio_producto();
            }

            // Crear una nueva instancia de Factura
            Factura factura = new Factura();
            factura.setFac_FechaVenta(new Date());
            factura.setFac_Total(total);
            factura.setUsuario(usuario);

            // Guardar la factura en la base de datos
            factura = facturaRepositorio.save(factura);



            /*entityManager.createQuery("DELETE FROM DetalleCompra d WHERE d.usuario = :usuario")
                    .setParameter("usuario", usuario)
                    .executeUpdate();*/

            return true;
        }

        return false;
    }




    public void elimarproductodelcarrito(int productoId) {
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

    public List<Map<String, Object>>prodcutocompra(int docusu){
        return detalleCompraRepositorio.prodcutocompra(docusu);
    }


    /*public boolean actualizarEstadoOrdenEntrega(String doc, String Estado) {
        Optional<Usuario> usuarioOptional = RepositorioUsuario.findById(doc);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            Set<Ord_Entrega> ordenesEntrega = usuario.getOrdenentrega();

            for (Ord_Entrega ordenEntrega : ordenesEntrega) {
                ordenEntrega.setOrdE_Estado(Estado);
                ordEntregaRepositorio.save(ordenEntrega);
            }

            return true;
        }

        return false;
    }*/
}






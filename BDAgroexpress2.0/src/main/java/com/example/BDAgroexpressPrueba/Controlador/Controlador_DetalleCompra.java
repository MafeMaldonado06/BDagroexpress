package com.example.BDAgroexpressPrueba.Controlador;

import com.example.BDAgroexpressPrueba.Entidades.DetalleCompra;
import com.example.BDAgroexpressPrueba.Entidades.Usuario;
import com.example.BDAgroexpressPrueba.Interfaz.DetalleCompra_Repositorio;
import com.example.BDAgroexpressPrueba.Servicios.Servicio_DetalleCompra;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class Controlador_DetalleCompra {



    Servicio_DetalleCompra servicioOrdenCompra;

    DetalleCompra_Repositorio detalleCompraRepositorio;


    public Controlador_DetalleCompra(Servicio_DetalleCompra servicioOrdenCompra, DetalleCompra_Repositorio detalleCompraRepositorio) {
        this.servicioOrdenCompra = servicioOrdenCompra;
        this.detalleCompraRepositorio = detalleCompraRepositorio;
    }

    @GetMapping("/ListarOrdenesCompra")
    public ArrayList<DetalleCompra> getOrdenesCompra(){
        return servicioOrdenCompra.getOrdenCompra();
    }


    @PostMapping("/Agregarproducto/{doc}/{id}")
    public String guardarProducto(@PathVariable("doc") String documento, @PathVariable("id")int id) {
        return servicioOrdenCompra.Agregarcarrito(documento, id);
    }

    @DeleteMapping("/eliminarproducto/{productoId}")
    public String eliminarproducto(@PathVariable("productoId") int productoId) {
        servicioOrdenCompra.elimarproductodelcarrito(productoId);
        return "Detalle de compra eliminado correctamente.";
    }

    @PostMapping("/generarafactura/{idusu}")
    public int generarfactura(@PathVariable("idusu") int idusu){
        servicioOrdenCompra.factura(idusu);
        return idusu;
    }

    @GetMapping("/Entregado/{doc}")
    public List<Map<String, Object>>finentrgado(@PathVariable("doc") int doc){
        return servicioOrdenCompra.findrntrgado(doc);
    }

    @GetMapping("/Entregando/{doc}")
    public List<Map<String, Object>>finentregando(@PathVariable("doc")int doc){
        return servicioOrdenCompra.finentregando(doc);
    }

    @PostMapping("/Factura/{doc}")
    public void prueba(@PathVariable("doc") String documento) {
        servicioOrdenCompra.generarFactura(documento);
    }

    @GetMapping("/productos/{docusu}")
    public List<Map<String, Object>>prodcutocompra(@PathVariable("docusu")int docusu){
        return servicioOrdenCompra.prodcutocompra(docusu);
    }






}

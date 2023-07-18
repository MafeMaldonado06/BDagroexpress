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

    //Repositorios

    //Servicios
    Servicio_DetalleCompra servicioDetalleCompra;

    public Controlador_DetalleCompra(Servicio_DetalleCompra servicioDetalleCompra) {
        this.servicioDetalleCompra = servicioDetalleCompra;
    }

    @PostMapping("/GuardarProducto/{documento}")
    public void GuardarProducto(@RequestBody List<DetalleCompra> producto, @PathVariable("documento") String documento){
        servicioDetalleCompra.GuardarProducto(producto, documento);
    }





























    /*Servicio_DetalleCompra servicioOrdenCompra;

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




    @PostMapping("/Factura/{doc}")
    public void prueba(@PathVariable("doc") String documento) {
        servicioOrdenCompra.generarOrdenEntrega(documento);
        servicioOrdenCompra.generarFactura(documento);
    }



    @GetMapping("/productos/{docusu}")
    public List<Map<String, Object>>prodcutocompra(@PathVariable("docusu")int docusu){
        return servicioOrdenCompra.prodcutocompra(docusu);
    }*/








}

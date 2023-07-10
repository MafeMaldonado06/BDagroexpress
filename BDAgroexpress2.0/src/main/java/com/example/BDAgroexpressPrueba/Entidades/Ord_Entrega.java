package com.example.BDAgroexpressPrueba.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "ordenentrega")
public class Ord_Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String OrdE_Id;


   @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "Usu_Documento",nullable = false)
    @JsonIgnore
    private Usuario OrdE_IdTrasportador;

    @Column(nullable = false)
    private int OrdE_Cantidad;
    @Column(unique = true, length = 20)
    private String OrdE_Fecha;

    @Column(nullable = false)
    private int OrdE_TotalPagar;

    @Column(unique = true, length = 20)
    private String OrdE_FechaDespachoAproximada;

    @Column(unique = true, length = 20)
    private String Orden_FechaEntregaAproximada;
    @Column(length = 15)
    private String OrdE_Estado;

   /* @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "documento_usu",referencedColumnName = "Usu_Documento")
    private Usuario usuario;*/


    public Ord_Entrega(String ordE_Id, Usuario ordE_IdTrasportador, int ordE_Cantidad, String ordE_Fecha, int ordE_TotalPagar, String ordE_FechaDespachoAproximada, String orden_FechaEntregaAproximada, String ordE_Estado, Usuario usuario) {
        OrdE_Id = ordE_Id;
        //OrdE_IdTrasportador = ordE_IdTrasportador;
        OrdE_Cantidad = ordE_Cantidad;
        OrdE_Fecha = ordE_Fecha;
        OrdE_TotalPagar = ordE_TotalPagar;
        OrdE_FechaDespachoAproximada = ordE_FechaDespachoAproximada;
        Orden_FechaEntregaAproximada = orden_FechaEntregaAproximada;
        OrdE_Estado = ordE_Estado;
        //this.usuario = usuario;
    }

    public Ord_Entrega() {
    }

    /*public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }*/

    public String getOrdE_id() {
        return OrdE_Id;
    }

    public void setOrdE_id(String ordE_id) {
        OrdE_Id = ordE_id;
    }


    public Usuario getOrdE_IdTrasportador() {
        return OrdE_IdTrasportador;
    }

    public void setOrdE_IdTrasportador(Usuario ordE_IdTrasportador) {
        OrdE_IdTrasportador = ordE_IdTrasportador;
    }

    public int getOrdE_Cantidad() {
        return OrdE_Cantidad;
    }

    public void setOrdE_Cantidad(int ordE_Cantidad) {
        OrdE_Cantidad = ordE_Cantidad;
    }

    public String getOrdE_Fecha() {
        return OrdE_Fecha;
    }

    public void setOrdE_Fecha(String ordE_Fecha) {
        OrdE_Fecha = ordE_Fecha;
    }

    public int getOrdE_TotalPagar() {
        return OrdE_TotalPagar;
    }

    public void setOrdE_TotalPagar(int ordE_TotalPagar) {
        OrdE_TotalPagar = ordE_TotalPagar;
    }

    public String getOrdE_FechaDespachoAproximada() {
        return OrdE_FechaDespachoAproximada;
    }

    public void setOrdE_FechaDespachoAproximada(String ordE_FechaDespachoAproximada) {
        OrdE_FechaDespachoAproximada = ordE_FechaDespachoAproximada;
    }

    public String getOrden_FechaEntregaAproximada() {
        return Orden_FechaEntregaAproximada;
    }

    public void setOrden_FechaEntregaAproximada(String orden_FechaEntregaAproximada) {
        Orden_FechaEntregaAproximada = orden_FechaEntregaAproximada;
    }

    public String getOrdE_Estado() {
        return OrdE_Estado;
    }

    public void setOrdE_Estado(String ordE_Estado) {
        OrdE_Estado = ordE_Estado;
    }

    @Override
    public String toString() {
        return "Ord_Entrega{" +
                "OrdE_Id='" + OrdE_Id + '\'' +
                ", OrdE_IdTrasportador=" + OrdE_IdTrasportador +
                ", OrdE_Cantidad=" + OrdE_Cantidad +
                ", OrdE_Fecha='" + OrdE_Fecha + '\'' +
                ", OrdE_TotalPagar=" + OrdE_TotalPagar +
                ", OrdE_FechaDespachoAproximada='" + OrdE_FechaDespachoAproximada + '\'' +
                ", Orden_FechaEntregaAproximada='" + Orden_FechaEntregaAproximada + '\'' +
                ", OrdE_Estado='" + OrdE_Estado + '\'' +
                //", usuario=" + usuario +
                '}';
    }
}

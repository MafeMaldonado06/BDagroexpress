package com.example.BDAgroexpressPrueba.Entidades;

public class Prueba {

    private Integer Id;
    private String nombre;
    private String documento;

    public Prueba(int Id, String nombre, String documento) {
        this.Id = Id;
        this.nombre = nombre;
        this.documento = documento;
    }

    public Prueba() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "Prueba{" +
                "Id=" + Id +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                '}';
    }
}

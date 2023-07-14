package com.example.BDAgroexpress30.Entidad;

import jakarta.persistence.*;

@Entity
@Table(name = "Categorias")
public class Categorias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Cat_Id;
    @Column(nullable = false)
    private String Cat_Nombre;

    public Categorias(String cat_Nombre) {
        Cat_Nombre = cat_Nombre;
    }

    //Getter
    public int getCat_Id() {
        return Cat_Id;
    }

    public String getCat_Nombre() {
        return Cat_Nombre;
    }

    //Setter
    public void setCat_Id(int cat_Id) {
        Cat_Id = cat_Id;
    }

    public void setCat_Nombre(String cat_Nombre) {
        Cat_Nombre = cat_Nombre;
    }

    @Override
    public String toString() {
        return "Categorias{" +
                "Cat_Id=" + Cat_Id +
                ", Cat_Nombre='" + Cat_Nombre + '\'' +
                '}';
    }
}

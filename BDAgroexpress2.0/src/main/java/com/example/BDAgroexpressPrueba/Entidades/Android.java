package com.example.BDAgroexpressPrueba.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "android")
public class Android {
    @Id
    @Column(nullable = true)
    private String documento;

    public Android(String documento) {
        this.documento = documento;
    }

    public Android() {
    }


    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "Android{" +
                "documento='" + documento + '\'' +
                '}';
    }

}

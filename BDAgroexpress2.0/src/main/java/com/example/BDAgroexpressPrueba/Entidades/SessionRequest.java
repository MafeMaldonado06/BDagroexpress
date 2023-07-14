package com.example.BDAgroexpressPrueba.Entidades;

public class SessionRequest {

    private String documento;
    private String contraseña;

    public SessionRequest(String documento, String contraseña) {
        this.documento = documento;
        this.contraseña = contraseña;
    }

    public SessionRequest() {
    }

    public String getDocumento() {
        return documento;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "SessionRequest{" +
                "documento='" + documento + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }
}

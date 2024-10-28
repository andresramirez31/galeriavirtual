package com.gamodel.galeriavirtual.dto;

public class RegisterRequest {

    private String nombre;
    private String rol;
    private String estado;

    public RegisterRequest() {
    }

    public RegisterRequest(String nombre, String rol, String estado) {
        this.nombre = nombre;
        this.rol = rol;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}

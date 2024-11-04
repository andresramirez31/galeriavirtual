package com.gamodel.galeriavirtual.dto;

public class RegisterRequest {

    private String nombre;
    private String rol;
    private String estado;
    private String correo;
    private String password;

    public RegisterRequest() {
    }

    public RegisterRequest(String nombre, String rol, String estado) {
        this.nombre = nombre;
        this.rol = rol;
        this.estado = estado;
    }

    public RegisterRequest(String nombre, String rol, String estado, String correo, String password) {
        this.nombre = nombre;
        this.rol = rol;
        this.estado = estado;
        this.correo = correo;
        this.password = password;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

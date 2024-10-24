package com.gamodel.galeriavirtual.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "Salon")
public class Salon {

    @Id
    private String id;
    private String nombre;
    private String fondo;
    private String fechaVigencia;
    private String sponsor;
    private List<String> comentarios;  // Cambiado a un arreglo de Strings

    // Constructor por defecto
    public Salon() {}

    // Constructor con parámetros
    public Salon(String nombre, String fondo, String fechaVigencia, String sponsor, List<String> comentarios) {
        this.nombre = nombre;
        this.fondo = fondo;
        this.fechaVigencia = fechaVigencia;
        this.sponsor = sponsor;
        this.comentarios = comentarios;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFondo() {
        return fondo;
    }

    public void setFondo(String fondo) {
        this.fondo = fondo;
    }

    public String getFechaVigencia() {
        return fechaVigencia;
    }

    public void setFechaVigencia(String fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public List<String> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<String> comentarios) {
        this.comentarios = comentarios;
    }

    @Override
    public String toString() {
        return "Salon{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", fondo='" + fondo + '\'' +
                ", fechaVigencia='" + fechaVigencia + '\'' +
                ", sponsor='" + sponsor + '\'' +
                ", comentarios=" + comentarios +
                '}';
    }
}

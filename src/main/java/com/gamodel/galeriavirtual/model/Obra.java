package com.gamodel.galeriavirtual.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "Obra") // Define la colección en MongoDB
public class Obra {

    @Id
    private String id;
    private String nombre;
    private String medioAudiovisual;
    private String descripcion;
    private String exponente;
    private List<String> palabrasClave;
    private String otros;
    private List<String> nota; // Ahora es un array de Strings

    // Constructor por defecto
    public Obra() {
    }

    public Obra(String nombre, String medioAudiovisual, String descripcion, String exponente,
            List<String> palabrasClave, String otros) {
        this.nombre = nombre;
        this.medioAudiovisual = medioAudiovisual;
        this.descripcion = descripcion;
        this.exponente = exponente;
        this.palabrasClave = palabrasClave;
        this.otros = otros;
    }

    // Constructor con parámetros
    public Obra(String nombre, String medioAudiovisual, String descripcion,
            String exponente, List<String> palabrasClave, String otros,
            List<String> nota) {
        this.nombre = nombre;
        this.medioAudiovisual = medioAudiovisual;
        this.descripcion = descripcion;
        this.exponente = exponente;
        this.palabrasClave = palabrasClave;
        this.otros = otros;
        this.nota = nota;
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

    public String getMedioAudiovisual() {
        return medioAudiovisual;
    }

    public void setMedioAudiovisual(String medioAudiovisual) {
        this.medioAudiovisual = medioAudiovisual;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getExponente() {
        return exponente;
    }

    public void setExponente(String exponente) {
        this.exponente = exponente;
    }

    public List<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(List<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public String getOtros() {
        return otros;
    }

    public void setOtros(String otros) {
        this.otros = otros;
    }

    public List<String> getNota() {
        return nota;
    }

    public void setNota(List<String> nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return "Obra{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", medioAudiovisual='" + medioAudiovisual + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", exponente='" + exponente + '\'' +
                ", palabrasClave=" + palabrasClave +
                ", otros='" + otros + '\'' +
                ", nota=" + nota +
                '}';
    }
}
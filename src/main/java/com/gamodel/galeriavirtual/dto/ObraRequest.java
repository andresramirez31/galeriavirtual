package com.gamodel.galeriavirtual.dto;

import java.util.List;

public class ObraRequest {

    private String nombre;
    private String medioAudiovisual;
    private String descripcion;
    private String exponente;
    private List<String> palabrasClave;
    private String otros;

    public ObraRequest(String nombre, String medioAudiovisual, String descripcion, String exponente,
            List<String> palabrasClave, String otros) {
        this.nombre = nombre;
        this.medioAudiovisual = medioAudiovisual;
        this.descripcion = descripcion;
        this.exponente = exponente;
        this.palabrasClave = palabrasClave;
        this.otros = otros;
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

}

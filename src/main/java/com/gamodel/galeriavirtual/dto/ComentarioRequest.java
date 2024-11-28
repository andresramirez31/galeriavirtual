package com.gamodel.galeriavirtual.dto;

public class ComentarioRequest {

    private String idOriginalObra;
    private String nota;
    private String comentario;

    public ComentarioRequest() {
    }

    public ComentarioRequest(String idOriginalObra, String nota, String comentario) {
        this.idOriginalObra = idOriginalObra;
        this.nota = nota;
        this.comentario = comentario;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getIdOriginalObra() {
        return idOriginalObra;
    }

    public void setIdOriginalObra(String idOriginalObra) {
        this.idOriginalObra = idOriginalObra;
    }

}

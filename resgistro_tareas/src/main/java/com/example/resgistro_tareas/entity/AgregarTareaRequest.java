package com.example.resgistro_tareas.entity;
public class AgregarTareaRequest {

    private long identificador;

    private String descripcion;

    private boolean vigente;

    public long getIdentificador() { return identificador; }

    public void setIdentificador(long identificador) { this.identificador = identificador; }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) { this.vigente = vigente; }
}

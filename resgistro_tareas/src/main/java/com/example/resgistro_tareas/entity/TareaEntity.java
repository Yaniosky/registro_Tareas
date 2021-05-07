package com.example.resgistro_tareas.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TareaEntity {

    @Id
    @Column
    @JsonProperty(value="identificador", required = true)
    private long identificador;

    @Column
    @JsonProperty(value="descripcion", required = true)
    private String descripcion;

    @Column
    @JsonProperty(value="fechaCreacion", required = true)
    @NotNull()
    private Date fechaCreacion;

    @Column
    @JsonProperty(value="vigente", required = true)
    @NotNull()
    private boolean vigente;

    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean isVigente() {
        return vigente;
    }

    public void setVigente(boolean vigente) {
        this.vigente = vigente;
    }
}

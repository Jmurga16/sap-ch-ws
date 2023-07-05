package com.wydnex.sapchws.utils.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Historial {
    @JsonIgnore
    private String historialId;

    private String observacionId;
    private String descripcion;
    @JsonIgnore
    private String fechaHora;
    private String fecha;
    private String hora;
    @JsonIgnore
    private String estado;

    private String usuarioId;

    public String getHistorialId() {
        return historialId;
    }

    public void setHistorialId(String historialId) {
        this.historialId = historialId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getObservacionId() {
        return observacionId;
    }

    public void setObservacionId(String observacionId) {
        this.observacionId = observacionId;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }
}

package com.wydnex.sapchws.configuracion.model;

public class Usuario {


    private Integer usuarioId;
    private String usuarioNombre;
    private Integer usuarioEstado;
    private String usuarioFechaNacimiento;

    public Usuario() {
    }

    public Usuario( String usuarioNombre, Integer usuarioEstado, String usuarioFechaNacimiento) {

        this.usuarioNombre = usuarioNombre;
        this.usuarioEstado = usuarioEstado;
        this.usuarioFechaNacimiento = usuarioFechaNacimiento;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNombre() {
        return usuarioNombre;
    }

    public void setUsuarioNombre(String usuarioNombre) {
        this.usuarioNombre = usuarioNombre;
    }

    public Integer getUsuarioEstado() {
        return usuarioEstado;
    }

    public void setUsuarioEstado(Integer usuarioEstado) {
        this.usuarioEstado = usuarioEstado;
    }

    public String getUsuarioFechaNacimiento() {
        return usuarioFechaNacimiento;
    }

    public void setUsuarioFechaNacimiento(String usuarioFechaNacimiento) {
        this.usuarioFechaNacimiento = usuarioFechaNacimiento;
    }
}

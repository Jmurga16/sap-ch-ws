package com.wydnex.sapchws.control.model.dto;

import java.util.List;
import java.util.Map;

public class ParametrosReporte {

    public ParametrosReporte(String[] titulosReporte, String nombreHoja, Map<String, String[]> cabecera, Map<String, List<Object[]>> filas) {
        this.titulosReporte = titulosReporte;
        this.nombreHoja = nombreHoja;
        this.cabecera = cabecera;
        this.filas = filas;
    }

    private String[] titulosReporte;
    private String nombreHoja;
    private Map<String, String[]> cabecera;
    private Map<String, List<Object[]>> filas;

    public String[] getTitulosReporte() {
        return titulosReporte;
    }

    public void setTitulosReporte(String[] titulosReporte) {
        this.titulosReporte = titulosReporte;
    }

    public String getNombreHoja() {
        return nombreHoja;
    }

    public void setNombreHoja(String nombreHoja) {
        this.nombreHoja = nombreHoja;
    }

    public Map<String, String[]> getCabecera() {
        return cabecera;
    }

    public void setCabecera(Map<String, String[]> cabecera) {
        this.cabecera = cabecera;
    }

    public Map<String, List<Object[]>> getFilas() {
        return filas;
    }

    public void setFilas(Map<String, List<Object[]>> filas) {
        this.filas = filas;
    }
}

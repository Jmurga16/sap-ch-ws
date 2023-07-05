package com.wydnex.sapchws.utils.model;

import java.util.List;

public class RequestCombo {
    private String comboCodigo;
    private List<Filtro> filtros;

    public String getComboCodigo() {
        return comboCodigo;
    }

    public void setComboCodigo(String comboCodigo) {
        this.comboCodigo = comboCodigo;
    }

    public List<Filtro> getFiltros() {
        return filtros;
    }

    public void setFiltros(List<Filtro> filtros) {
        this.filtros = filtros;
    }
}

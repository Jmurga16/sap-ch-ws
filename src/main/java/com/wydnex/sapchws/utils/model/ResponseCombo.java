package com.wydnex.sapchws.utils.model;

import java.util.List;

public class ResponseCombo {
    private String idDefecto;
    private List<ComboItem> items;

    public List<ComboItem> getItems() {
        return items;
    }

    public void setItems(List<ComboItem> items) {
        this.items = items;
    }

    public String getIdDefecto() {
        return idDefecto;
    }

    public void setIdDefecto(String idDefecto) {
        this.idDefecto = idDefecto;
    }
}

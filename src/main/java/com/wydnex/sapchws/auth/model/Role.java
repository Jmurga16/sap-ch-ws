package com.wydnex.sapchws.auth.model;


import java.io.Serializable;



public class Role implements Serializable {

    private Long id;
    private String autorithy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAutorithy() {
        return autorithy;
    }

    public void setAutorithy(String autorithy) {
        this.autorithy = autorithy;
    }
}

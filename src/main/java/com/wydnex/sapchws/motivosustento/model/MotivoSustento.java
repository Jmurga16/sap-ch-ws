package com.wydnex.sapchws.motivosustento.model;

public class MotivoSustento {
    private Integer IMOTSUSAMP;
    private String CDESCRIPCI;
    private Integer IVIGENTE;
    public MotivoSustento(Integer IMOTSUSAMP, String CDESCRIPCI, Integer IVIGENTE) {
        this.IMOTSUSAMP = IMOTSUSAMP;
        this.CDESCRIPCI = CDESCRIPCI;
        this.IVIGENTE = IVIGENTE;
    }


    public Integer getIMOTSUSAMP() {
        return IMOTSUSAMP;
    }

    public void setIMOTSUSAMP(Integer IMOTSUSAMP) {
        this.IMOTSUSAMP = IMOTSUSAMP;
    }

    public String getCDESCRIPCI() {
        return CDESCRIPCI;
    }

    public void setCDESCRIPCI(String CDESCRIPCI) {
        this.CDESCRIPCI = CDESCRIPCI;
    }

    public Integer getIVIGENTE() {
        return IVIGENTE;
    }

    public void setIVIGENTE(Integer IVIGENTE) {
        this.IVIGENTE = IVIGENTE;
    }
}

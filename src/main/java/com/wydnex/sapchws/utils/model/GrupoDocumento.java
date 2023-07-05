package com.wydnex.sapchws.utils.model;

import java.util.List;

public class GrupoDocumento {
    private String grupoDocumentoId;
    private List<Documento> documentos;

    public String getGrupoDocumentoId() {
        return grupoDocumentoId;
    }

    public void setGrupoDocumentoId(String grupoDocumentoId) {
        this.grupoDocumentoId = grupoDocumentoId;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }
}

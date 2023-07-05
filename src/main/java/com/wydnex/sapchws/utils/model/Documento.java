package com.wydnex.sapchws.utils.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public class Documento {

    private String documentoId;
    private String nombreOriginal;
    private String fechaRegistro;
    private String extension;
    private String tamano;
    private String nombreGenerado;
    @JsonIgnore
    private String estado;
    private String contentType;
    @JsonIgnore
    private MultipartFile multipartFile;
    @JsonIgnore
    Resource documento;

    public Resource getDocumento() {
        return documento;
    }

    public void setDocumento(Resource documento) {
        this.documento = documento;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }

    public String getDocumentoId() {
        return documentoId;
    }

    public void setDocumentoId(String documentoId) {
        this.documentoId = documentoId;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreOriginal() {
        return nombreOriginal;
    }

    public void setNombreOriginal(String nombreOriginal) {
        this.nombreOriginal = nombreOriginal;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }



    public String getNombreGenerado() {
        return nombreGenerado;
    }

    public void setNombreGenerado(String nombreGenerado) {
        this.nombreGenerado = nombreGenerado;
    }



    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}

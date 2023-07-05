package com.wydnex.sapchws.utils.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String s) {
        super("Error de Negocio - ".concat(s));
    }

    public BusinessException() {
        super("Error de Negocio - ");
    }
}

package com.wydnex.sapchws.utils.controller;


import com.wydnex.sapchws.utils.exceptions.BusinessException;
import com.wydnex.sapchws.utils.model.ResponseApi;
import com.wydnex.sapchws.utils.model.ResponseApiPayload;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandlerController {

    @ExceptionHandler(BusinessException.class)
    public ResponseApi<?> businessError(BusinessException be) {

        ResponseApi<?> responseApi = new ResponseApi<>();
        responseApi.setPayload((new ResponseApiPayload<>(false, be.getMessage(), null)));
        return responseApi;
    }

    @ExceptionHandler(Exception.class)
    public ResponseApi<?> exceptionError(Exception e) {
        return (new ResponseApi<>()).responseError("Error en el proceso.", e.getMessage());
    }
}

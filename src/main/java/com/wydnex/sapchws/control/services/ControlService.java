package com.wydnex.sapchws.control.services;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ControlService {

    //region Service Llamada
    List<Map<String, String>> listarLlamadas();

    Map<String, String> listarLlamadaPorId(Integer llamadaId);

    Map<String, Integer> registrarLlamada(Map<String, String> llamada);

    Map<String, Integer> actualizarLlamada(Map<String, String> llamada);

    //endregion


    //region Service Llamada Telefonica
    List<Map<String, String>> listarLlamadasTelefonicas(String fechaDesde, String fechaHasta, Integer page, Integer limit);

    Map<String, Object> importExcelLlamadas(MultipartFile file) throws IOException;

    List<Map<String, Object>> exportExcelLlamadas(String fechaDesde, String fechaHasta);
    //endregion


    //region Service Autorización de llamada telefónica a clientes
    List<Map<String, String>> listarAutorizacionLlamadas(Integer autorizado);

    Map<String, String> obtenerDetallePorTelefono(String numeroTelefonico);

    Map<String, String> obtenerAutorizacionPorId(Integer numeroTelefonico);

    Map<String, Integer> registrarAutorizacionLlamada(Map<String, String> authLlamada);

    Map<String, Integer> actualizarAutorizacionLlamada(Map<String, String> authLlamada);

    //endregion

}

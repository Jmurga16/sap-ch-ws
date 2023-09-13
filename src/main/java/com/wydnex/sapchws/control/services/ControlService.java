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


    //region Service Autorización general de llamada telefónica
    List<Map<String, String>> listarAutorizacionGeneralLlamadas(Integer autorizado);

    Map<String, String> obtenerDetalleNumeroTelefonico(String numeroTelefonico);

    Map<String, String> obtenerAutorizacionGeneralPorId(Integer numeroTelefonico);

    Map<String, Integer> registrarAutorizacionGeneralLlamada(Map<String, String> authGeneralLlamada);

    Map<String, Integer> actualizarAutorizacionGeneralLlamada(Map<String, String> authGeneralLlamada);

    //endregion


    //region Service Registro de llamadas telefonicas
    List<Map<String, String>> listarLlamadaTipo();

    List<Map<String, String>> listarLlamadasPorUsuario(String usuario, Integer page, Integer limit);

    Map<String, String> obtenerDetalleLlamadaTelefonica(Integer llamadaId);

    Map<String, String> obtenerDatosTelefono(String numeroTelefonico);

    Map<String, Integer> registrarLlamadaTelefonica(Map<String, String> llamada);

    Map<String, Integer> actualizarLlamadaTelefonica(Map<String, String> llamada);

    List<Map<String, Object>> exportExcelTelefonosPersonal(Integer vigente);

    //endregion


    //region Service Personal exonerado
    List<Map<String, String>> listarPersonalExonerado(Integer vigente);

    Map<String, String> obtenerPersonalPorCodigoUsuario(String codigoUsuario);

    Map<String, String> obtenerDetallePersonalExonerado(Integer personalExoneradoId);

    Map<String, Integer> registrarPersonalExonerado(Map<String, String> personalExonerado);

    Map<String, Integer> actualizarPersonalExonerado(Map<String, String> personalExonerado);

    Map<String, Integer> anularPersonalExonerado(Map<String, String> personalExonerado);

    List<Map<String, Object>> exportExcelPersonalExonerado(Integer vigente);

    //endregion


    //region Service Costo de llamadas telefónicas
    List<Map<String, String>> listarLlamadasPendientes(String fechaDesde, String fechaHasta);
    List<Map<String, String>> listarCostoPorLlamada();
    Map<String, String> obtenerCantidadLlamadas(String fechaDesde, String fechaHasta);
    List<Map<String, String>> procesarLlamadas(Map<String, String> request);

    //endregion


}

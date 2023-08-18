package com.wydnex.sapchws.control.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ControlMapper {

    //region Mapper Llamada
    List<Map<String, String>> listarLlamadas();

    Map<String, String> listarLlamadaPorId(@Param("llamadaId") Integer llamadaId);

    Map<String, Integer> registrarLlamada(@Param("llamada") Map<String, String> llamada);

    Map<String, Integer> actualizarLlamada(@Param("llamada") Map<String, String> llamada);

    //endregion


    //region Mapper Llamadas Telefonicas

    List<Map<String, String>> listarLlamadasTelefonicas(@Param("fechaDesde") String fechaDesde, @Param("fechaHasta") String fechaHasta,
                                                        @Param("page") Integer page, @Param("limit") Integer limit);

    Map<String, Integer> importExcelLlamadas(@Param("llamada") Map<String, String> llamada);

    List<Map<String, Object>> exportExcelLlamadas(@Param("fechaDesde") String fechaDesde, @Param("fechaHasta") String fechaHasta);
    //endregion


    //region Mapper Autorización de llamada telefónica a clientes
    List<Map<String, String>> listarAutorizacionLlamadas(@Param("autorizado") Integer autorizado);

    Map<String, String> obtenerDetallePorTelefono(@Param("numeroTelefonico") String numeroTelefonico);

    Map<String, String> obtenerAutorizacionPorId(@Param("autorizacionId") Integer autorizacionId);

    Map<String, Integer> registrarAutorizacionLlamada(@Param("authLlamada") Map<String, String> authLlamada);

    Map<String, Integer> actualizarAutorizacionLlamada(@Param("authLlamada") Map<String, String> authLlamada);

    //endregion

}

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


    //region Mapper Autorización general de llamada telefónica
    List<Map<String, String>> listarAutorizacionGeneralLlamadas(@Param("autorizado") Integer autorizado);

    Map<String, String> obtenerDetalleNumeroTelefonico(@Param("numeroTelefonico") String numeroTelefonico);

    Map<String, String> obtenerAutorizacionGeneralPorId(@Param("autorizacionId") Integer autorizacionId);

    Map<String, Integer> registrarAutorizacionGeneralLlamada(@Param("authLlamada") Map<String, String> authGeneralLlamada);

    Map<String, Integer> actualizarAutorizacionGeneralLlamada(@Param("authLlamada") Map<String, String> authGeneralLlamada);

    //endregion


    //region Mapper Registro de llamadas telefonicas
    List<Map<String, String>> listarLlamadaTipo();

    List<Map<String, String>> listarLlamadasPorUsuario(@Param("usuario") String usuario, @Param("page") Integer page, @Param("limit") Integer limit);

    Map<String, String> obtenerDetalleLlamadaTelefonica(@Param("llamadaId") Integer llamadaId);

    Map<String, String> obtenerDatosTelefono(@Param("numeroTelefonico") String numeroTelefonico);

    Map<String, Integer> registrarLlamadaTelefonica(@Param("llamada") Map<String, String> llamada);

    Map<String, Integer> actualizarLlamadaTelefonica(@Param("llamada") Map<String, String> llamada);

    List<Map<String, Object>> exportExcelTelefonosPersonal(@Param("vigente") Integer vigente);
    //endregion


    //region Mapper Personal exonerado
    List<Map<String, String>> listarPersonalExonerado(@Param("vigente") Integer vigente);

    Map<String, String> obtenerPersonalPorCodigoUsuario(@Param("codigoUsuario") String codigoUsuario);

    Map<String, String> obtenerDetallePersonalExonerado(@Param("personalExoneradoId") Integer personalExoneradoId);

    Map<String, Integer> registrarPersonalExonerado(@Param("personalExonerado") Map<String, String> personalExonerado);

    Map<String, Integer> actualizarPersonalExonerado(@Param("personalExonerado") Map<String, String> personalExonerado);

    Map<String, Integer> anularPersonalExonerado(@Param("personalExonerado") Map<String, String> personalExonerado);
    List<Map<String, Object>> exportExcelPersonalExonerado(@Param("vigente") Integer vigente);

    //endregion


}

package com.wydnex.sapchws.control.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ControlMapper {

    //region Mapper Llamada
    List<Map<String, String>> listarLlamadas();

    Map<String, String>  listarLlamadaPorId(@Param("llamadaId") Integer llamadaId);

    Map<String, Integer> registrarLlamada(@Param("llamada") Map<String, String> llamada);

    Map<String, Integer> actualizarLlamada(@Param("llamada") Map<String, String> llamada);

    //endregion



}

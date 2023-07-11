package com.wydnex.sapchws.configuracion.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ConfiguracionMapper {
    List<Map<String, String>> listarMotivoSustento();

    Map<String, Integer> registrarMotivoSustento(@Param("motivoSustento") Map<String, String> motivoSustento);

    Map<String, Integer> actualizarMotivoSustento(@Param("motivoSustento") Map<String, String> motivoSustento);

    Map<String, Integer> eliminarMotivoSustento(@Param("motivoSustento") Map<String, String> motivoSustento);

    List<Map<String, String>> listarMotivoAutorizacion();

    Map<String, Integer> registrarMotivoAutorizacion(@Param("motivoAutorizacion") Map<String, String> motivoAutorizacion);

    Map<String, Integer> actualizarMotivoAutorizacion(@Param("motivoAutorizacion") Map<String, String> motivoAutorizacion);

    Map<String, Integer> eliminarMotivoAutorizacion(@Param("motivoAutorizacion") Map<String, String> motivoAutorizacion);
}

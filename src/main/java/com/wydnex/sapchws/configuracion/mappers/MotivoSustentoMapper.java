package com.wydnex.sapchws.configuracion.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MotivoSustentoMapper {
    List<Map<String,String>> listarMotivoSustento();
    Map<String, Integer> registrarMotivoSustento(@Param("motivoSustento") Map<String,String> motivoSustento);
    Map<String, Integer>  actualizarMotivoSustento(@Param("motivoSustento") Map<String,String> motivoSustento);
    Map<String, Integer>  eliminarMotivoSustento(@Param("motivoSustento") Map<String,String> motivoSustento);
}

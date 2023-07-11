package com.wydnex.sapchws.configuracion.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface MotivoAutorizacionMapper {
    List<Map<String,String>> listarMotivoAutorizacion();
    Integer registrarMotivoAutorizacion(@Param("motivoAutorizacion") Map<String,Object> motivoAutorizacion);
    Integer actualizarMotivoAutorizacion(@Param("motivoAutorizacion") Map<String,Object> motivoAutorizacion);
    Integer eliminarMotivoAutorizacion(@Param("motivoAutorizacion") Map<String,Object> motivoAutorizacion);
}

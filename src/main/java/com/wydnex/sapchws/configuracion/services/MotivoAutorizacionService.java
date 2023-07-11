package com.wydnex.sapchws.configuracion.services;

import java.util.List;
import java.util.Map;

public interface MotivoAutorizacionService {
    List<Map<String,String>> listarMotivoAutorizacion();
    Integer registrarMotivoAutorizacion(Map<String,Object> motivoAutorizacion);
    Integer actualizarMotivoAutorizacion(Map<String,Object> motivoAutorizacion);
    Integer eliminarMotivoAutorizacion(Map<String,Object> motivoAutorizacion);
}

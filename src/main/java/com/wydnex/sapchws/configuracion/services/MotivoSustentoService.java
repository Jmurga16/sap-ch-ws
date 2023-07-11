package com.wydnex.sapchws.configuracion.services;

import java.util.List;
import java.util.Map;

public interface MotivoSustentoService {
    List<Map<String,String>> listarMotivoSustento();
    Map<String, Integer> registrarMotivoSustento(Map<String,String> motivoSustento);
    Map<String, Integer>  actualizarMotivoSustento(Map<String,String> motivoSustento);
    Map<String, Integer>  eliminarMotivoSustento(Map<String,String> motivoSustento);
}

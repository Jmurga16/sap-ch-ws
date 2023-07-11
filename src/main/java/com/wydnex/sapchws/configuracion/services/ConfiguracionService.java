package com.wydnex.sapchws.configuracion.services;

import java.util.List;
import java.util.Map;

public interface ConfiguracionService {
    List<Map<String, String>> listarMotivoSustento();

    Map<String, Integer> registrarMotivoSustento(Map<String, String> motivoSustento);

    Map<String, Integer> actualizarMotivoSustento(Map<String, String> motivoSustento);

    Map<String, Integer> eliminarMotivoSustento(Map<String, String> motivoSustento);

    List<Map<String, String>> listarMotivoAutorizacion();

    Map<String, Integer> registrarMotivoAutorizacion(Map<String, String> motivoAutorizacion);

    Map<String, Integer> actualizarMotivoAutorizacion(Map<String, String> motivoAutorizacion);

    Map<String, Integer> eliminarMotivoAutorizacion(Map<String, String> motivoAutorizacion);
}

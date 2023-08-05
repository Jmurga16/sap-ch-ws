package com.wydnex.sapchws.control.services;

import java.util.List;
import java.util.Map;

public interface ControlService {

    //region Service Llamada
    List<Map<String, String>> listarLlamadas();

    Map<String, String> listarLlamadaPorId(Integer llamadaId);

    Map<String, Integer> registrarLlamada(Map<String, String> llamada);

    Map<String, Integer> actualizarLlamada(Map<String, String> llamada);

    //endregion


}

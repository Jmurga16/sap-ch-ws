package com.wydnex.sapchws.utils.services;

import com.wydnex.sapchws.utils.model.Historial;

import java.util.List;

public interface ObservacionService {
    List<Historial> obtenerObservaciones(Integer observacionId, Integer flagNotificacion);
}

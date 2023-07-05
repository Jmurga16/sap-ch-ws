package com.wydnex.sapchws.utils.services.impl;

import com.wydnex.sapchws.utils.mappers.UtilMapper;
import com.wydnex.sapchws.utils.model.Historial;
import com.wydnex.sapchws.utils.services.ObservacionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObservacionServiceImpl implements ObservacionService {

    private UtilMapper utilMapper;

    public ObservacionServiceImpl(UtilMapper utilMapper) {
        this.utilMapper = utilMapper;
    }

    @Override
    public List<Historial> obtenerObservaciones(Integer observacionId, Integer flagNotificacion) {
        return utilMapper.obtenerObservaciones(observacionId, flagNotificacion);
    }
}

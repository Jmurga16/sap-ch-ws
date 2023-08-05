package com.wydnex.sapchws.control.services.impl;

import com.wydnex.sapchws.control.mappers.ControlMapper;
import com.wydnex.sapchws.control.services.ControlService;
import com.wydnex.sapchws.utils.exceptions.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ControlImpl implements ControlService {
    private ControlMapper controlMapper;

    public ControlImpl(ControlMapper controlMapper) {
        this.controlMapper = controlMapper;
    }

    //region Implementacion Llamada
    @Override
    public List<Map<String, String>> listarLlamadas() {
        return controlMapper.listarLlamadas();
    }

    @Override
    public Map<String, String> listarLlamadaPorId(Integer llamadaId) {
        return controlMapper.listarLlamadaPorId(llamadaId);
    }

    @Override
    public Map<String, Integer> registrarLlamada(Map<String, String> llamada) {
        Map<String, Integer> result = controlMapper.registrarLlamada(llamada);

        if (result.get("llamadaId") == 0) {
            throw new BusinessException("Código y/o descripción de llamada ya registrado anteriormente");
        }
        else if (result.get("llamadaId") == -1) {
            throw new BusinessException("La fecha 'Desde' no puede ser mayor a la fecha 'Hasta'");
        }
        return result;
    }

    @Override
    public Map<String, Integer> actualizarLlamada(Map<String, String> llamada) {
        Map<String, Integer> result = controlMapper.actualizarLlamada(llamada);

        if (result.get("llamadaId") == 0) {
            throw new BusinessException("Código y/o descripción de llamada ya registrado anteriormente");
        }
        else if (result.get("llamadaId") == -1) {
            throw new BusinessException("La fecha 'Desde' no puede ser mayor a la fecha 'Hasta'");
        }

        return result;
    }


    //endregion


}

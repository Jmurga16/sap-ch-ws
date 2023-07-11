package com.wydnex.sapchws.configuracion.services.impl;

import com.wydnex.sapchws.configuracion.mappers.ConfiguracionMapper;
import com.wydnex.sapchws.configuracion.services.ConfiguracionService;
import com.wydnex.sapchws.utils.exceptions.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ConfiguacionImpl implements ConfiguracionService {
    private ConfiguracionMapper configuracionMapper;

    public ConfiguacionImpl(ConfiguracionMapper configuracionMapper) {
        this.configuracionMapper = configuracionMapper;
    }

    @Override
    public List<Map<String, String>> listarMotivoSustento() {
        return configuracionMapper.listarMotivoSustento();
    }

    @Override
    public Map<String, Integer> registrarMotivoSustento(Map<String, String> motivoSustento) {
        Map<String, Integer> result = configuracionMapper.registrarMotivoSustento(motivoSustento);

        if (result.get("motivoSustentoId") == 0) {
            throw new BusinessException("Motivo de Sustento ya registrado anteriormente");
        }
        return result;
    }

    @Override
    public Map<String, Integer> actualizarMotivoSustento(Map<String, String> motivoSustento) {
        Map<String, Integer> result = configuracionMapper.actualizarMotivoSustento(motivoSustento);
        if (result.get("motivoSustentoId") == 0) {
            throw new BusinessException("Motivo de Sustento ya registrado anteriormente");
        }
        return result;
    }

    @Override
    public Map<String, Integer> eliminarMotivoSustento(Map<String, String> motivoSustento) {
        return configuracionMapper.eliminarMotivoSustento(motivoSustento);
    }

    @Override
    public List<Map<String, String>> listarMotivoAutorizacion() {
        return configuracionMapper.listarMotivoAutorizacion();
    }

    @Override
    public Map<String, Integer> registrarMotivoAutorizacion(Map<String, String> motivoAutorizacion) {
        Map<String, Integer> result = configuracionMapper.registrarMotivoAutorizacion(motivoAutorizacion);
        return result;
    }

    @Override
    public Map<String, Integer> actualizarMotivoAutorizacion(Map<String, String> motivoAutorizacion) {
        Map<String, Integer> result = configuracionMapper.actualizarMotivoAutorizacion(motivoAutorizacion);
        return result;
    }

    @Override
    public Map<String, Integer> eliminarMotivoAutorizacion(Map<String, String> motivoAutorizacion) {
        return configuracionMapper.eliminarMotivoAutorizacion(motivoAutorizacion);
    }
}

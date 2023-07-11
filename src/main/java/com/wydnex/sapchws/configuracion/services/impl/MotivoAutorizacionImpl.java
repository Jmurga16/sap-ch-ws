package com.wydnex.sapchws.configuracion.services.impl;

import com.wydnex.sapchws.configuracion.mappers.MotivoAutorizacionMapper;
import com.wydnex.sapchws.configuracion.services.MotivoAutorizacionService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MotivoAutorizacionImpl implements MotivoAutorizacionService {
    private MotivoAutorizacionMapper motivoAutorizacionMapper;

    public MotivoAutorizacionImpl(MotivoAutorizacionMapper motivoAutorizacionMapper) {
        this.motivoAutorizacionMapper = motivoAutorizacionMapper;
    }

    @Override
    public List<Map<String, String>> listarMotivoAutorizacion() {
        return motivoAutorizacionMapper.listarMotivoAutorizacion();
    }

    @Override
    public Integer registrarMotivoAutorizacion(Map<String, Object> motivoAutorizacion) {
        Integer result = motivoAutorizacionMapper.registrarMotivoAutorizacion(motivoAutorizacion);
        return result;
    }
    @Override
    public Integer actualizarMotivoAutorizacion(Map<String, Object> motivoAutorizacion) {
        Integer result = motivoAutorizacionMapper.actualizarMotivoAutorizacion(motivoAutorizacion);
        return result;
    }
    @Override
    public Integer eliminarMotivoAutorizacion(Map<String, Object> motivoAutorizacion) {
        return motivoAutorizacionMapper.eliminarMotivoAutorizacion(motivoAutorizacion);
    }
}

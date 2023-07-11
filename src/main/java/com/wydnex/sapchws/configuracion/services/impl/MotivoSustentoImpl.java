package com.wydnex.sapchws.configuracion.services.impl;


import com.wydnex.sapchws.configuracion.mappers.MotivoSustentoMapper;
import com.wydnex.sapchws.configuracion.services.MotivoSustentoService;
import com.wydnex.sapchws.utils.exceptions.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MotivoSustentoImpl implements MotivoSustentoService {
    private MotivoSustentoMapper motivoSustentoMapper;

    public MotivoSustentoImpl(MotivoSustentoMapper motivoSustentoMapper) {
        this.motivoSustentoMapper = motivoSustentoMapper;
    }

    @Override
    public List<Map<String, String>> listarMotivoSustento() {
        return motivoSustentoMapper.listarMotivoSustento();
    }

    @Override
    public Map<String, Integer> registrarMotivoSustento(Map<String, String> motivoSustento) {
        Map<String, Integer> result = motivoSustentoMapper.registrarMotivoSustento(motivoSustento);

        if (result.get("motivoSustentoId")== 0) {
            throw new BusinessException("Motivo de Sustento ya registrado anteriormente");
        }
        return result;
    }
    @Override
    public Map<String, Integer>  actualizarMotivoSustento(Map<String, String> motivoSustento) {
        Map<String, Integer> result= motivoSustentoMapper.actualizarMotivoSustento(motivoSustento);
        if (result.get("motivoSustentoId")== 0) {
            throw new BusinessException("Motivo de Sustento ya registrado anteriormente");
        }
        return result;
    }
    @Override
    public Map<String, Integer>  eliminarMotivoSustento(Map<String, String> motivoSustento) {
        return motivoSustentoMapper.eliminarMotivoSustento(motivoSustento);
    }


}

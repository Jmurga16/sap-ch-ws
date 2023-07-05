package com.wydnex.sapchws.motivosustento.services.impl;

import com.wydnex.sapchws.motivosustento.mappers.MotivoSustentoMapper;
import com.wydnex.sapchws.motivosustento.model.MotivoSustento;
import com.wydnex.sapchws.motivosustento.services.MotivoSustentoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotivoSustentoImpl implements MotivoSustentoService {
    private MotivoSustentoMapper motivoSustentoMapper;

    public MotivoSustentoImpl(MotivoSustentoMapper motivoSustentoMapper) {
        this.motivoSustentoMapper = motivoSustentoMapper;
    }
    @Override
    public List<MotivoSustento> listarMotivoSustento() {
        return motivoSustentoMapper.listarMotivoSustento();
    }
    @Override
    public Integer registrarMotivoSustento(MotivoSustento motivoSustento) {
        return motivoSustentoMapper.registrarMotivoSustento(motivoSustento);
    }

    @Override
    public Integer actualizarMotivoSustento(MotivoSustento motivoSustento) {
        return motivoSustentoMapper.actualizarMotivoSustento(motivoSustento);
    }

}

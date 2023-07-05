package com.wydnex.sapchws.motivosustento.services;

import com.wydnex.sapchws.motivosustento.model.MotivoSustento;

import java.util.List;

public interface MotivoSustentoService {
    List<MotivoSustento> listarMotivoSustento();
    Integer registrarMotivoSustento(MotivoSustento motivoSustento);

    Integer actualizarMotivoSustento(MotivoSustento motivoSustento);

}

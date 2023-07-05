package com.wydnex.sapchws.motivosustento.mappers;

import com.wydnex.sapchws.motivosustento.model.MotivoSustento;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MotivoSustentoMapper {
    List<MotivoSustento> listarMotivoSustento();
    Integer registrarMotivoSustento(@Param("motivoSustento") MotivoSustento motivoSustento);

    Integer actualizarMotivoSustento(@Param("motivoSustento") MotivoSustento motivoSustento);

}

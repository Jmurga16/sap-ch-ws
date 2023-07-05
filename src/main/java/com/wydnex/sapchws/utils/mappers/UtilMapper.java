package com.wydnex.sapchws.utils.mappers;


import com.wydnex.sapchws.utils.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UtilMapper {
    ResponseCombo listarCombo(@Param("comboRequest") String comboRequest);

    GrupoDocumento registrarDocumentos(@Param("documentos") List<Documento> documentos);

    Documento obtenerDocumento(@Param("idDocumento") Integer idDocumento);

    List<Historial> obtenerObservaciones(
            @Param("observacionId") Integer observacionId,
            @Param("flagNotifiacion") Integer flagNotifiacion);


    void registrarObservaciones(@Param("historiales") List<Historial> historiales );
}

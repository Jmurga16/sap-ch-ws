package com.wydnex.sapchws.configuracion.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ConfiguracionMapper {

    //region Mapper Motivo_Sustento
    List<Map<String, String>> listarMotivoSustento();

    Map<String, Integer> registrarMotivoSustento(@Param("motivoSustento") Map<String, String> motivoSustento);

    Map<String, Integer> actualizarMotivoSustento(@Param("motivoSustento") Map<String, String> motivoSustento);

    Map<String, Integer> eliminarMotivoSustento(@Param("motivoSustento") Map<String, String> motivoSustento);
    //endregion

    //region Mapper Motivo_Autorizacion
    List<Map<String, String>> listarMotivoAutorizacion();

    Map<String, Integer> registrarMotivoAutorizacion(@Param("motivoAutorizacion") Map<String, String> motivoAutorizacion);

    Map<String, Integer> actualizarMotivoAutorizacion(@Param("motivoAutorizacion") Map<String, String> motivoAutorizacion);

    Map<String, Integer> eliminarMotivoAutorizacion(@Param("motivoAutorizacion") Map<String, String> motivoAutorizacion);
    //endregion

    //region Mapper Motivo_ModificacionPres
    List<Map<String, String>> listarMotivoModificacionPres();

    Map<String, Integer> registrarMotivoModificacionPres(@Param("motivoModificacionPres") Map<String, String> motivoModificacionPres);

    Map<String, Integer> actualizarMotivoModificacionPres(@Param("motivoModificacionPres") Map<String, String> motivoModificacionPres);

    Map<String, Integer> eliminarMotivoModificacionPres(@Param("motivoModificacionPres") Map<String, String> motivoModificacionPres);
    //endregion

    //region Mapper TipoGasto
    List<Map<String, String>> listarTipoGasto();

    Map<String, Integer> registrarTipoGasto(@Param("tipoGasto") Map<String, String> tipoGasto);

    Map<String, Integer> actualizarTipoGasto(@Param("tipoGasto") Map<String, String> tipoGasto);

    Map<String, Integer> eliminarTipoGasto(@Param("tipoGasto") Map<String, String> tipoGasto);
    //endregion

    //region Mapper Plantilla
    List<Map<String, String>> listarProceso();
    List<Map<String, String>> listarPlantilla(@Param("procesoId") Integer procesoId);
    Map<String, String> listarDetallePlantilla(@Param("plantillaId") Integer plantillaId);
    List<Map<String, String>> obtenerVersionPlantilla(@Param("procesoId") Integer procesoId);

    Map<String, Integer> registrarPlantilla(@Param("plantilla") Map<String, String> plantilla);

    Map<String, Integer> actualizarPlantilla(@Param("plantilla") Map<String, String> plantilla);

    //endregion


}

package com.wydnex.sapchws.configuracion.services;

import java.util.List;
import java.util.Map;

public interface ConfiguracionService {

    //region Service Motivo_Sustento
    List<Map<String, String>> listarMotivoSustento();

    Map<String, Integer> registrarMotivoSustento(Map<String, String> motivoSustento);

    Map<String, Integer> actualizarMotivoSustento(Map<String, String> motivoSustento);

    Map<String, Integer> eliminarMotivoSustento(Map<String, String> motivoSustento);
    //endregion

    //region Service Motivo_Autorizacion
    List<Map<String, String>> listarMotivoAutorizacion();

    Map<String, Integer> registrarMotivoAutorizacion(Map<String, String> motivoAutorizacion);

    Map<String, Integer> actualizarMotivoAutorizacion(Map<String, String> motivoAutorizacion);

    Map<String, Integer> eliminarMotivoAutorizacion(Map<String, String> motivoAutorizacion);
    //endregion

    //region Service Motivo_ModificacionPres
    List<Map<String, String>> listarMotivoModificacionPres();

    Map<String, Integer> registrarMotivoModificacionPres(Map<String, String> motivoModificacionPres);

    Map<String, Integer> actualizarMotivoModificacionPres(Map<String, String> motivoModificacionPres);

    Map<String, Integer> eliminarMotivoModificacionPres(Map<String, String> motivoModificacionPres);
    //endregion

    //region Service TipoGasto
    List<Map<String, String>> listarTipoGasto();

    Map<String, Integer> registrarTipoGasto(Map<String, String> tipoGasto);

    Map<String, Integer> actualizarTipoGasto(Map<String, String> tipoGasto);

    Map<String, Integer> eliminarTipoGasto(Map<String, String> tipoGasto);
    //endregion

    //region Service Plantilla
    List<Map<String, String>> listarProceso();
    List<Map<String, String>> listarPlantilla(Integer procesoId);
    List<Map<String, String>> listarDetallePlantilla(Integer plantillaId);
    List<Map<String, String>> obtenerVersionPlantilla(Integer procesoId);

    Map<String, Integer> registrarPlantilla(Map<String, String> plantilla);

    Map<String, Integer> actualizarPlantilla(Map<String, String> plantilla);

    //endregion

}

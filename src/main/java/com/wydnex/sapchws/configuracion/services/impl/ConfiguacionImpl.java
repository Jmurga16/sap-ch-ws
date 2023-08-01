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

    //region Implementacion Motivo_Sustento
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
    //endregion

    //region Implementacion Motivo_Autorizacion
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
    //endregion

    //region Implementacion Motivo_ModificacionPres
    @Override
    public List<Map<String, String>> listarMotivoModificacionPres() {
        return configuracionMapper.listarMotivoModificacionPres();
    }

    @Override
    public Map<String, Integer> registrarMotivoModificacionPres(Map<String, String> motivoModificacionPres) {
        Map<String, Integer> result = configuracionMapper.registrarMotivoModificacionPres(motivoModificacionPres);
        return result;
    }

    @Override
    public Map<String, Integer> actualizarMotivoModificacionPres(Map<String, String> motivoModificacionPres) {
        Map<String, Integer> result = configuracionMapper.actualizarMotivoModificacionPres(motivoModificacionPres);
        return result;
    }

    @Override
    public Map<String, Integer> eliminarMotivoModificacionPres(Map<String, String> motivoModificacionPres) {
        return configuracionMapper.eliminarMotivoModificacionPres(motivoModificacionPres);
    }
    //endregion

    //region Implementacion TipoGasto
    @Override
    public List<Map<String, String>> listarTipoGasto() {
        return configuracionMapper.listarTipoGasto();
    }

    @Override
    public Map<String, Integer> registrarTipoGasto(Map<String, String> tipoGasto) {
        Map<String, Integer> result = configuracionMapper.registrarTipoGasto(tipoGasto);

        if (result.get("tipoGastoId") == 0) {
            throw new BusinessException("Tipo de Gasto ya registrado anteriormente");
        }

        return result;
    }

    @Override
    public Map<String, Integer> actualizarTipoGasto(Map<String, String> tipoGasto) {
        Map<String, Integer> result = configuracionMapper.actualizarTipoGasto(tipoGasto);

        if (result.get("tipoGastoId") == 0) {
            throw new BusinessException("Tipo de Gasto ya registrado anteriormente");
        }

        return result;
    }

    @Override
    public Map<String, Integer> eliminarTipoGasto(Map<String, String> tipoGasto) {
        return configuracionMapper.eliminarTipoGasto(tipoGasto);
    }
    //endregion

    //region Implementacion Plantilla
    @Override
    public List<Map<String, String>> listarProceso() {
        return configuracionMapper.listarProceso();
    }
    @Override
    public List<Map<String, String>> listarPlantilla(Integer procesoId) {
        return configuracionMapper.listarPlantilla(procesoId);
    }
    @Override
    public List<Map<String, String>> listarDetallePlantilla(Integer plantillaId) {
        return configuracionMapper.listarDetallePlantilla(plantillaId);
    }
    @Override
    public List<Map<String, String>> obtenerVersionPlantilla(Integer procesoId) {
        return configuracionMapper.obtenerVersionPlantilla(procesoId);
    }

    @Override
    public Map<String, Integer> registrarPlantilla(Map<String, String> plantilla) {
        Map<String, Integer> result = configuracionMapper.registrarPlantilla(plantilla);
        return result;
    }

    @Override
    public Map<String, Integer> actualizarPlantilla(Map<String, String> plantilla) {
        Map<String, Integer> result = configuracionMapper.actualizarPlantilla(plantilla);
        return result;
    }

    //endregion

}

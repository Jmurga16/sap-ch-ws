package com.wydnex.sapchws.control.reportes;

import com.wydnex.sapchws.control.services.ControlService;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ConfiguracionReporteImp implements ConfiguracionReporteService {

    private ControlService controlService;

    public ConfiguracionReporteImp(ControlService controlService) {
        this.controlService = controlService;
    }

    @Override
    public Resource generarExcelLlamadas(String fechaDesde, String fechaHasta) {
        List<Map<String, Object>> mapList = controlService.exportExcelLlamadas(fechaDesde, fechaHasta);
        return new LlamadasReporte(mapList).generarReporte();
    }

    @Override
    public Resource generarExcelTelefonosPersonal(Integer vigente) {
        List<Map<String, Object>> mapList = controlService.exportExcelTelefonosPersonal(vigente);
        return new TelefonosPersonalReporte(mapList).generarReporte();
    }

}

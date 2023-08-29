package com.wydnex.sapchws.control.reportes;

import org.springframework.core.io.Resource;

public interface ConfiguracionReporteService {

    Resource generarExcelLlamadas(String fechaDesde, String fechaHasta);
    Resource generarExcelTelefonosPersonal(Integer vigente);
    Resource generarExcelPersonalExonerado(Integer vigente);
}

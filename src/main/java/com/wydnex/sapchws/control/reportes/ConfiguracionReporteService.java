package com.wydnex.sapchws.control.reportes;

import org.springframework.core.io.Resource;

public interface ConfiguracionReporteService {

    Resource generarExcelLlamadas(String fechaDesde, String fechaHasta);

}
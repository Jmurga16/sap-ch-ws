package com.wydnex.sapchws.control.reportes;

import org.springframework.core.io.Resource;

import java.util.List;
import java.util.Map;

public interface ReporteGeneradorInterface {

    Map<String, String[]> obtenerCabecera();

    Map<String, List<Object[]>> obtenerLista();

    Resource generarReporte();

}

package com.wydnex.sapchws.control.reportes;

import com.wydnex.sapchws.control.model.dto.ParametrosReporte;
import org.springframework.core.io.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class DescuentoTelefonicoReporteResumen implements ReporteGeneradorInterface {


    private final List<Map<String, Object>> mapList;


    public DescuentoTelefonicoReporteResumen(List<Map<String, Object>> mapList) {
        this.mapList = mapList;
    }

    @Override
    public Map<String, String[]> obtenerCabecera() {
        Map<String, String[]> data = new HashMap<>();
        String[] cabecera = new String[]{
                "N°",
                "NOMBRE",
                "CÓDIGO",
                "MONTO DESCONTADO",
                "N° REG. INDENTIF."
        };
        data.put("cabecera", cabecera);
        return data;
    }

    @Override
    public Map<String, List<Object[]>> obtenerLista() {
        Map<String, List<Object[]>> data = new HashMap<>();
        List<Object[]> objectsList = mapList
                .stream()
                .map(map -> {
                    Object[] objects = new Object[map.size()];
                    objects[0] = map.get("fila");
                    objects[1] = map.get("nombrePersona");
                    objects[2] = map.get("codigoPersona");
                    objects[3] = map.get("montoDescontado");
                    objects[4] = map.get("registroIdentificacion");
                    return objects;
                }).collect(Collectors.toList());

        data.put("data", objectsList);
        return data;
    }

    @Override
    public Resource generarReporte() {
        String[] titulos = new String[]{"RESUMEN DE DESCUENTO POR LLAMADAS TELEFÓNICAS"};
        return new AnexoGenerador(
                new ParametrosReporte(titulos,
                        "Reporte Resumen",
                        obtenerCabecera(),
                        obtenerLista()))
                .generarReporte();


    }
}

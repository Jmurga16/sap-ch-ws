package com.wydnex.sapchws.control.reportes;

import com.wydnex.sapchws.control.model.dto.ParametrosReporte;
import org.springframework.core.io.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class DescuentoTelefonicoReporteDetalle implements ReporteGeneradorInterface {


    private final List<Map<String, Object>> mapList;


    public DescuentoTelefonicoReporteDetalle(List<Map<String, Object>> mapList) {
        this.mapList = mapList;
    }

    @Override
    public Map<String, String[]> obtenerCabecera() {
        Map<String, String[]> data = new HashMap<>();
        String[] cabecera = new String[]{
                "NÚMERO TELEFÓNICO",
                "COD. REG.",
                "FECHA",
                "HORA",
                "DURACIÓN",
                "PRECIO",
                "TIPO"
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
                    objects[0] = map.get("numeroTelefonico");
                    objects[1] = map.get("codigoRegistro");
                    objects[2] = map.get("fechaLlamada");
                    objects[3] = map.get("horaLlamada");
                    objects[4] = map.get("duracionLlamada");
                    objects[5] = map.get("precioLlamada");
                    objects[6] = map.get("tipoLlamada");

                    return objects;
                }).collect(Collectors.toList());

        data.put("data", objectsList);
        return data;
    }

    @Override
    public Resource generarReporte() {
        String[] titulos = new String[]{"DETALLE DE DESCUENTO POR LLAMADAS TELEFÓNICAS"};
        return new AnexoGenerador(
                new ParametrosReporte(titulos,
                        "Reporte Detalle",
                        obtenerCabecera(),
                        obtenerLista()))
                .generarReporte();


    }
}

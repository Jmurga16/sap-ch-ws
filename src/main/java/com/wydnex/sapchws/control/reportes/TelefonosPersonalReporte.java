package com.wydnex.sapchws.control.reportes;

import com.wydnex.sapchws.control.model.dto.ParametrosReporte;
import org.springframework.core.io.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class TelefonosPersonalReporte implements ReporteGeneradorInterface {


    private List<Map<String, Object>> mapList;


    public TelefonosPersonalReporte(List<Map<String, Object>> mapList) {
        this.mapList = mapList;
    }

    @Override
    public Map<String, String[]> obtenerCabecera() {
        Map<String, String[]> data = new HashMap<>();
        String[] cabecera = new String[]{
                "FECHA DE REGISTRO",
                "TELEFONO",
                "TIPO TELEFONO",
                "TELEFONO DESTINO",
                "TIPO LLAMADA",
                "UBICACIÓN",
                "FAMILIAR O INSTITUCIÓN",
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
                    objects[0] = map.get("fechaRegistro");
                    objects[1] = map.get("telefono");
                    objects[2] = map.get("tipoTelefono");
                    objects[3] = map.get("telefonoDestino");
                    objects[4] = map.get("tipoLlamada");
                    objects[5] = map.get("ubicacion");
                    objects[6] = map.get("familiarInstitucion");
                    return objects;
                }).collect(Collectors.toList());

        data.put("data", objectsList);
        return data;
    }

    @Override
    public Resource generarReporte() {
        String[] titulos = new String[]{"DECLARACIÓN JURADA DE TELEFONOS DEL PERSONAL"};
        return new AnexoGenerador(
                new ParametrosReporte(titulos,
                        "REPORTE",
                        obtenerCabecera(),
                        obtenerLista()))
                .generarReporte();


    }
}

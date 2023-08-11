package com.wydnex.sapchws.control.reportes;

import com.wydnex.sapchws.control.model.dto.ParametrosReporte;
import org.springframework.core.io.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class LlamadasReporte implements ReporteGeneradorInterface {


    private List<Map<String, Object>> mapList;


    public LlamadasReporte(List<Map<String, Object>> mapList) {
        this.mapList = mapList;
    }

    @Override
    public Map<String, String[]> obtenerCabecera() {
        Map<String, String[]> data = new HashMap<>();
        String[] cabecera = new String[]{
                "CÓDIGO PROCESO",
                "PERIODO",
                "CÓDIGO PERSONA",
                "NÚMERO TELEFONO",
                "CÓDIGO REGISTRADO",
                "TIPO LLAMADA",
                "FECHA DE LLAMADA",
                "HORA LLAMADA",
                "DURACIÓN LLAMADA(SEG)",
                "PRECIO DE LLAMADA",
                "USUARIO",
                "FECHA DE PROCESO",
                "CÓDIGO ESTADO",
                "ctipidella",
                "NOMBRE DE PERSONA"
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
                    objects[0] = map.get("codigoProceso");
                    objects[1] = map.get("periodo");
                    objects[2] = map.get("codigoPersona");
                    objects[3] = map.get("numeroTelefonico");
                    objects[4] = map.get("codigoRegistro");
                    objects[5] = map.get("tipoLlamada");
                    objects[6] = map.get("fechaLlamada");
                    objects[7] = map.get("horaLlamada");
                    objects[8] = map.get("duracionLlamada");
                    objects[9] = map.get("precioLlamada");
                    objects[10] = map.get("usuario");
                    objects[11] = map.get("fechaProceso");
                    objects[12] = map.get("codigoEstado");
                    objects[13] = map.get("ctipidella");
                    objects[14] = map.get("nombrePersona");
                    return objects;
                }).collect(Collectors.toList());

        data.put("data", objectsList);
        return data;
    }

    @Override
    public Resource generarReporte() {
        String[] titulos = new String[]{"Reporte de Llamadas"};
        return new AnexoGenerador(
                new ParametrosReporte(titulos,
                        "REPORTE DE LLAMADAS",
                        obtenerCabecera(),
                        obtenerLista()))
                .generarReporte();


    }
}

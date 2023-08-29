package com.wydnex.sapchws.control.reportes;

import com.wydnex.sapchws.control.model.dto.ParametrosReporte;
import org.springframework.core.io.Resource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class PersonalExoneradoReporte implements ReporteGeneradorInterface {


    private final List<Map<String, Object>> mapList;


    public PersonalExoneradoReporte(List<Map<String, Object>> mapList) {
        this.mapList = mapList;
    }

    @Override
    public Map<String, String[]> obtenerCabecera() {
        Map<String, String[]> data = new HashMap<>();
        String[] cabecera = new String[]{
                "NOMBRE",
                "CÓDIGO",
                "FECHA INICIO EXONERACIÓN",
                "FECHA FIN EXONERACIÓN",
                "CÓDIGO EXONERACIÓN",
                "FECHA REGISTRO",
                "USUARIO REGISTRO",
                "VIGENCIA",
                "REGISTRO EXONERACIÓN",
                "FECHA ÚLTIMA EXONERACIÓN",
                "USUARIO ÚLTIMA EXONERACIÓN",
                "MOTIVO",
                "ESTADO EXONERACIÓN"
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
                    objects[0] = map.get("nombreUsuarioExonerado");
                    objects[1] = map.get("codigoUsuarioExonerado");
                    objects[2] = map.get("fechaInicio");
                    objects[3] = map.get("fechaFin");
                    objects[4] = map.get("codigoExoneracion");
                    objects[5] = map.get("fechaRegistro");
                    objects[6] = map.get("usuarioRegistro");
                    objects[7] = map.get("vigente");
                    objects[8] = map.get("registroExoneracion");
                    objects[9] = map.get("fechaUltimaExoneracion");
                    objects[10] = map.get("usuarioUltimaExoneracion");
                    objects[11] = map.get("motivo");
                    objects[12] = map.get("estado");

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

package com.wydnex.sapchws.control.controller;

import com.wydnex.sapchws.control.reportes.ConfiguracionReporteService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import static com.wydnex.sapchws.control.config.PathsControl.*;
import static com.wydnex.sapchws.utils.config.PathsUtil.ROOT_API;
import static com.wydnex.sapchws.utils.config.PathsUtil.VERSION;


import static com.wydnex.sapchws.utils.config.PathsUtil.*;

@RequestMapping(ROOT_API + CONTROL + VERSION + REPORTES)
@RestController
public class ReporteController {


    private final ConfiguracionReporteService reporteService;


    public ReporteController(ConfiguracionReporteService reporteService) {
        this.reporteService = reporteService;

    }

    @GetMapping(EXPORTAR_EXCEL_LLAMADAS)
    public ResponseEntity<Resource> exportExcelLlamadas(@RequestParam("fechaDesde") String fechaDesde, @RequestParam("fechaHasta") String fechaHasta) {

        Resource anexoGenerador = reporteService.generarExcelLlamadas(fechaDesde, fechaHasta);

        return ResponseEntity.ok()
                .headers(httpHeaders -> {
                    httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "FER103_Anexo.xlsx");
                    httpHeaders.add("ms-filename", "");
                })
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(anexoGenerador);
    }

    @GetMapping(EXPORTAR_EXCEL_TELEFONOS_PERSONAL)
    public ResponseEntity<Resource> exportExcelTelefonosPersonal(@RequestParam("vigente") Integer vigente) {

        Resource anexoGenerador = reporteService.generarExcelTelefonosPersonal(vigente);

        return ResponseEntity.ok()
                .headers(httpHeaders -> {
                    httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "FER108_Anexo.xlsx");
                    httpHeaders.add("ms-filename", "");
                })
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(anexoGenerador);
    }

    @GetMapping(EXPORTAR_EXCEL_PERSONAL_EXONERADO)
    public ResponseEntity<Resource> exportExcelPersonalExonerado(@RequestParam("vigente") Integer vigente) {

        Resource anexoGenerador = reporteService.generarExcelPersonalExonerado(vigente);

        return ResponseEntity.ok()
                .headers(httpHeaders -> {
                    httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "FER105_Anexo.xlsx");
                    httpHeaders.add("ms-filename", "");
                })
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(anexoGenerador);
    }

    @GetMapping(EXPORTAR_REPORTE_DESCUENTO_DETALLE)
    public ResponseEntity<Resource> exportarReporteDescuentoDetalle(@RequestParam("month") Integer month, @RequestParam("year") Integer year) {

        Resource anexoGenerador = reporteService.generarExcelReporteDescuentoDetalle(month, year);

        return ResponseEntity.ok()
                .headers(httpHeaders -> {
                    httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "FER107_Detalle_Anexo.xlsx");
                    httpHeaders.add("ms-filename", "");
                })
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(anexoGenerador);
    }

    @GetMapping(EXPORTAR_REPORTE_DESCUENTO_RESUMEN)
    public ResponseEntity<Resource> exportarReporteDescuentoResumen(@RequestParam("month") Integer month, @RequestParam("year") Integer year) {

        Resource anexoGenerador = reporteService.generarExcelReporteDescuentoResumen(month, year);

        return ResponseEntity.ok()
                .headers(httpHeaders -> {
                    httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "FER107_Resumen_Anexo.xlsx");
                    httpHeaders.add("ms-filename", "");
                })
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(anexoGenerador);
    }

}

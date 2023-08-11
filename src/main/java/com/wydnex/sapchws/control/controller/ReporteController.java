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


    private ConfiguracionReporteService reporteService;


    public ReporteController(ConfiguracionReporteService reporteService) {
        this.reporteService = reporteService;

    }

    @GetMapping(EXPORTAR_EXCEL_LLAMADAS)
    public ResponseEntity<Resource> exportExcelLlamadas(@RequestParam("fechaDesde") String fechaDesde, @RequestParam("fechaHasta") String fechaHasta) {

        Resource anexoGenerador = reporteService.generarExcelLlamadas(fechaDesde,fechaHasta);

        return ResponseEntity.ok()
                .headers(httpHeaders -> {
                    httpHeaders.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + "FER103_Anexo.xlsx");
                    httpHeaders.add("ms-filename", "");
                })
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(anexoGenerador);
    }

}

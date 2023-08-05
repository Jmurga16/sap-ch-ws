package com.wydnex.sapchws.control.controller;

import com.wydnex.sapchws.control.services.ControlService;
import com.wydnex.sapchws.utils.model.ResponseApi;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.wydnex.sapchws.control.config.PathsControl.*;
import static com.wydnex.sapchws.utils.config.PathsUtil.ROOT_API;
import static com.wydnex.sapchws.utils.config.PathsUtil.VERSION;

@RestController
@RequestMapping(ROOT_API + CONTROL + VERSION)
public class ControlController {

    private final ControlService controlService;

    public ControlController(ControlService controlService) {
        this.controlService = controlService;
    }

    //region Controllers Llamada
    @GetMapping(LISTAR_LLAMADAS)
    public ResponseApi<List<Map<String, String>>> listarLlamadas() {
        return ResponseApi.build(controlService.listarLlamadas());
    }

    @GetMapping(LISTAR_LLAMADA_POR_ID)
    public ResponseApi<Map<String, String>> listarLlamadaPorId(@RequestParam("llamadaId") Integer llamadaId) {
        return ResponseApi.build(controlService.listarLlamadaPorId(llamadaId));
    }

    @PostMapping(REGISTRAR_LLAMADA)
    public ResponseApi<Map<String, Integer>> registrarLlamada(@RequestBody Map<String, String> llamada) {
        return ResponseApi.build(controlService.registrarLlamada(llamada));
    }

    @PostMapping(ACTUALIZAR_LLAMADA)
    public ResponseApi<Map<String, Integer>> actualizarLlamada(@RequestBody Map<String, String> llamada) {
        return ResponseApi.build(controlService.actualizarLlamada(llamada));
    }
    //endregion


}


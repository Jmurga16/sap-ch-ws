package com.wydnex.sapchws.utils.controller;

import com.wydnex.sapchws.utils.model.Historial;
import com.wydnex.sapchws.utils.model.ResponseApi;
import com.wydnex.sapchws.utils.services.ObservacionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.wydnex.sapchws.utils.config.PathsUtil.*;

@RestController
@RequestMapping(ROOT_API + OSERVACION + VERSION)
public class ObservacionController {

    private ObservacionService observacionService;

    public ObservacionController(ObservacionService observacionService) {
        this.observacionService = observacionService;
    }

    @GetMapping("/listarObservaciones")
    public ResponseApi<List<Historial>> obtenerObservaciones(
            @RequestParam("observacionId") Integer observacionId,
            @RequestParam("flagNotifiacion") Integer flagNotifiacion) {

        return ResponseApi.build(observacionService.obtenerObservaciones(observacionId, flagNotifiacion));
    }
}

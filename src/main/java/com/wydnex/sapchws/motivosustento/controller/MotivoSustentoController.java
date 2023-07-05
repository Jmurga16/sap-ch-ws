package com.wydnex.sapchws.motivosustento.controller;


import com.wydnex.sapchws.motivosustento.model.MotivoSustento;
import com.wydnex.sapchws.motivosustento.services.MotivoSustentoService;
import com.wydnex.sapchws.utils.model.ResponseApi;
import org.springframework.web.bind.annotation.*;


import java.util.List;

import static com.wydnex.sapchws.motivosustento.config.PathsMotivoSustento.*;
import static com.wydnex.sapchws.utils.config.PathsUtil.ROOT_API;
import static com.wydnex.sapchws.utils.config.PathsUtil.VERSION;

@RestController
@RequestMapping(ROOT_API + MOTIVO_SUSTENTO + VERSION)
public class MotivoSustentoController {
    private MotivoSustentoService motivoSustentoService;

    public MotivoSustentoController(MotivoSustentoService motivoSustentoService) {
        this.motivoSustentoService = motivoSustentoService;
    }

    @GetMapping(LISTAR_MOTIVOSUSTENTO)
    public ResponseApi<List<MotivoSustento>> listarMotivoSustento() {
        return ResponseApi.build(motivoSustentoService.listarMotivoSustento());
    }

    @PostMapping(REGISTRAR_MOTIVOSUSTENTO)
    public ResponseApi<Integer> registrarMotivoSustento(@RequestBody MotivoSustento motivoSustento) {
        return ResponseApi.build(motivoSustentoService.registrarMotivoSustento(motivoSustento));
    }

    @PostMapping(ACTUALIZAR_MOTIVOSUSTENTO)
    public ResponseApi<Integer> actualizarMotivoSustento(@RequestBody MotivoSustento motivoSustento) {
        return ResponseApi.build(motivoSustentoService.actualizarMotivoSustento(motivoSustento));
    }


}

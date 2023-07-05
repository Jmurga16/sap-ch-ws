package com.wydnex.sapchws.utils.controller;
import static com.wydnex.sapchws.utils.config.PathsUtil.*;

import com.wydnex.sapchws.utils.model.ResponseApi;
import com.wydnex.sapchws.utils.model.ResponseCombo;
import com.wydnex.sapchws.utils.services.ComboService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ROOT_API +UTILS + VERSION)
public class ComboController {
    private ComboService utilService;

    public ComboController(ComboService utilService) {
        this.utilService = utilService;
    }


    @PostMapping(LISTAR_COMBO)
    public ResponseApi<ResponseCombo> listarComboSecure(@RequestBody String comboRequest) {

        return ResponseApi.build(utilService.listarCombo(comboRequest));
    }

}

package com.wydnex.sapchws.configuracion.controller;


import com.wydnex.sapchws.configuracion.model.Usuario;
import com.wydnex.sapchws.configuracion.services.UsuarioService;
import com.wydnex.sapchws.utils.model.ResponseApi;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static com.wydnex.sapchws.configuracion.config.PathsConfiguracion.*;
import static com.wydnex.sapchws.utils.config.PathsUtil.ROOT_API;
import static com.wydnex.sapchws.utils.config.PathsUtil.VERSION;

@RestController
@RequestMapping(ROOT_API + CONFIGURACION + VERSION)
public class ConfiguracionController {

    private UsuarioService usuarioService;

    public ConfiguracionController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping(LISTAR_USUARIOS)
    public ResponseApi<List<Usuario>> listarUsuarios() {
        return ResponseApi.build(usuarioService.listarUsuarios());
    }

    @PostMapping(REGISTRAR_USUARIO)
    public ResponseApi<Integer> registrarUsuario(@RequestBody Usuario usuario) {
        return ResponseApi.build(usuarioService.registrarUsuario(usuario));
    }

    @PostMapping(ACTUALIZAR_USUARIO)
    public ResponseApi<Integer> actualizarUsuario(@RequestBody Usuario usuario) {
        return ResponseApi.build(usuarioService.actualizarUsuario(usuario));
    }

    @GetMapping(OBTENER_USUARIO)
    public ResponseApi<Usuario> obtenerUsuarioPorId(@RequestParam("usuarioId") Integer usuarioId) {
        return ResponseApi.build(usuarioService.obtenerUsuariosPorId(usuarioId));
    }
}


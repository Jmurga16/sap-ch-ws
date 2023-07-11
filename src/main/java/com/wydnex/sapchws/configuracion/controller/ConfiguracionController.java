package com.wydnex.sapchws.configuracion.controller;


import com.wydnex.sapchws.configuracion.model.Usuario;
import com.wydnex.sapchws.configuracion.services.ConfiguracionService;
import com.wydnex.sapchws.configuracion.services.MotivoAutorizacionService;
import com.wydnex.sapchws.configuracion.services.MotivoSustentoService;
import com.wydnex.sapchws.configuracion.services.UsuarioService;
import com.wydnex.sapchws.utils.model.ResponseApi;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.wydnex.sapchws.configuracion.config.PathsConfiguracion.*;
import static com.wydnex.sapchws.utils.config.PathsUtil.ROOT_API;
import static com.wydnex.sapchws.utils.config.PathsUtil.VERSION;

@RestController
@RequestMapping(ROOT_API + CONFIGURACION + VERSION)
public class ConfiguracionController {

    private UsuarioService usuarioService;
    private ConfiguracionService configuracionService;

    public ConfiguracionController(UsuarioService usuarioService, ConfiguracionService configuracionService) {
        this.usuarioService = usuarioService;
        this.configuracionService = configuracionService;
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

    @GetMapping(LISTAR_MOTIVOS_SUSTENTO)
    public ResponseApi<List<Map<String, String>>> listarMotivosSustento() {
        return ResponseApi.build(configuracionService.listarMotivoSustento());
    }

    @PostMapping(REGISTRAR_MOTIVO_SUSTENTO)
    public ResponseApi<Map<String, Integer>> registrarMotivoSustento(@RequestBody Map<String, String> motivoSustento) {
        return ResponseApi.build(configuracionService.registrarMotivoSustento(motivoSustento));
    }

    @PutMapping(ACTUALIZAR_MOTIVO_SUSTENTO)
    public ResponseApi<Map<String, Integer>> actualizarMotivoSustento(@RequestBody Map<String, String> motivoSustento) {
        return ResponseApi.build(configuracionService.actualizarMotivoSustento(motivoSustento));
    }

    @DeleteMapping(ELIMINAR_MOTIVO_SUSTENTO)
    public ResponseApi<Map<String, Integer>> eliminarMotivoSustento(@RequestBody Map<String, String> motivoSustento) {
        return ResponseApi.build(configuracionService.eliminarMotivoSustento(motivoSustento));
    }

    @GetMapping(LISTAR_MOTIVOS_AUTORIZACION)
    public ResponseApi<List<Map<String, String>>> listarMotivosAutorizacion() {
        return ResponseApi.build(configuracionService.listarMotivoAutorizacion());
    }

    @PostMapping(REGISTRAR_MOTIVO_AUTORIZACION)
    public ResponseApi<Map<String, Integer>> registrarMotivoAutorizacion(@RequestBody Map<String, String> motivoAutorizacion) {
        return ResponseApi.build(configuracionService.registrarMotivoAutorizacion(motivoAutorizacion));
    }

    @PutMapping(ACTUALIZAR_MOTIVO_AUTORIZACION)
    public ResponseApi<Map<String, Integer>> actualizarMotivoAutorizacion(@RequestBody Map<String, String> motivoAutorizacion) {
        return ResponseApi.build(configuracionService.actualizarMotivoAutorizacion(motivoAutorizacion));
    }

    @DeleteMapping(ELIMINAR_MOTIVO_AUTORIZACION)
    public ResponseApi<Map<String, Integer>> eliminarMotivoAutorizacion(@RequestBody Map<String, String> motivoAutorizacion) {
        return ResponseApi.build(configuracionService.eliminarMotivoAutorizacion(motivoAutorizacion));
    }


}


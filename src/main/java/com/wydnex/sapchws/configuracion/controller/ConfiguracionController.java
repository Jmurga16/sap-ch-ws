package com.wydnex.sapchws.configuracion.controller;


import com.wydnex.sapchws.configuracion.model.Usuario;
import com.wydnex.sapchws.configuracion.services.ConfiguracionService;
import com.wydnex.sapchws.configuracion.services.UsuarioService;
import com.wydnex.sapchws.utils.model.ResponseApi;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

import static com.wydnex.sapchws.configuracion.config.PathsConfiguracion.*;
import static com.wydnex.sapchws.utils.config.PathsUtil.ROOT_API;
import static com.wydnex.sapchws.utils.config.PathsUtil.VERSION;

@RestController
@RequestMapping(ROOT_API + CONFIGURACION + VERSION)
public class ConfiguracionController {

    private final UsuarioService usuarioService;
    private final ConfiguracionService configuracionService;

    public ConfiguracionController(UsuarioService usuarioService, ConfiguracionService configuracionService) {
        this.usuarioService = usuarioService;
        this.configuracionService = configuracionService;
    }

    //region Controllers Usuario
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
    //endregion

    //region Controllers Motivo_Sustento
    @GetMapping(LISTAR_MOTIVOS_SUSTENTO)
    public ResponseApi<List<Map<String, String>>> listarMotivosSustento() {
        return ResponseApi.build(configuracionService.listarMotivoSustento());
    }

    @PostMapping(REGISTRAR_MOTIVO_SUSTENTO)
    public ResponseApi<Map<String, Integer>> registrarMotivoSustento(@RequestBody Map<String, String> motivoSustento) {
        return ResponseApi.build(configuracionService.registrarMotivoSustento(motivoSustento));
    }

    @PostMapping(ACTUALIZAR_MOTIVO_SUSTENTO)
    public ResponseApi<Map<String, Integer>> actualizarMotivoSustento(@RequestBody Map<String, String> motivoSustento) {
        return ResponseApi.build(configuracionService.actualizarMotivoSustento(motivoSustento));
    }

    @PostMapping(ELIMINAR_MOTIVO_SUSTENTO)
    public ResponseApi<Map<String, Integer>> eliminarMotivoSustento(@RequestBody Map<String, String> motivoSustento) {
        return ResponseApi.build(configuracionService.eliminarMotivoSustento(motivoSustento));
    }
    //endregion

    //region Controllers Motivo_Autorizacion
    @GetMapping(LISTAR_MOTIVOS_AUTORIZACION)
    public ResponseApi<List<Map<String, String>>> listarMotivosAutorizacion() {
        return ResponseApi.build(configuracionService.listarMotivoAutorizacion());
    }

    @PostMapping(REGISTRAR_MOTIVO_AUTORIZACION)
    public ResponseApi<Map<String, Integer>> registrarMotivoAutorizacion(@RequestBody Map<String, String> motivoAutorizacion) {
        return ResponseApi.build(configuracionService.registrarMotivoAutorizacion(motivoAutorizacion));
    }

    @PostMapping(ACTUALIZAR_MOTIVO_AUTORIZACION)
    public ResponseApi<Map<String, Integer>> actualizarMotivoAutorizacion(@RequestBody Map<String, String> motivoAutorizacion) {
        return ResponseApi.build(configuracionService.actualizarMotivoAutorizacion(motivoAutorizacion));
    }

    @PostMapping(ELIMINAR_MOTIVO_AUTORIZACION)
    public ResponseApi<Map<String, Integer>> eliminarMotivoAutorizacion(@RequestBody Map<String, String> motivoAutorizacion) {
        return ResponseApi.build(configuracionService.eliminarMotivoAutorizacion(motivoAutorizacion));
    }
    //endregion

    //region Controllers Motivo_ModificacionPres
    @GetMapping(LISTAR_MOTIVOS_MODIFICACION_PRES)
    public ResponseApi<List<Map<String, String>>> listarMotivosModificacionPres() {
        return ResponseApi.build(configuracionService.listarMotivoModificacionPres());
    }

    @PostMapping(REGISTRAR_MOTIVO_MODIFICACION_PRES)
    public ResponseApi<Map<String, Integer>> registrarMotivoModificacionPres(@RequestBody Map<String, String> motivoModificacionPres) {
        return ResponseApi.build(configuracionService.registrarMotivoModificacionPres(motivoModificacionPres));
    }

    @PostMapping(ACTUALIZAR_MOTIVO_MODIFICACION_PRES)
    public ResponseApi<Map<String, Integer>> actualizarMotivoModificacionPres(@RequestBody Map<String, String> motivoModificacionPres) {
        return ResponseApi.build(configuracionService.actualizarMotivoModificacionPres(motivoModificacionPres));
    }

    @PostMapping(ELIMINAR_MOTIVO_MODIFICACION_PRES)
    public ResponseApi<Map<String, Integer>> eliminarMotivoModificacionPres(@RequestBody Map<String, String> motivoModificacionPres) {
        return ResponseApi.build(configuracionService.eliminarMotivoModificacionPres(motivoModificacionPres));
    }
    //endregion

    //region Controllers TipoGasto
    @GetMapping(LISTAR_TIPO_GASTO)
    public ResponseApi<List<Map<String, String>>> listarTipoGasto() {
        return ResponseApi.build(configuracionService.listarTipoGasto());
    }

    @PostMapping(REGISTRAR_TIPO_GASTO)
    public ResponseApi<Map<String, Integer>> registrarTipoGasto(@RequestBody Map<String, String> tipoGasto) {
        return ResponseApi.build(configuracionService.registrarTipoGasto(tipoGasto));
    }

    @PostMapping(ACTUALIZAR_TIPO_GASTO)
    public ResponseApi<Map<String, Integer>> actualizarTipoGasto(@RequestBody Map<String, String> tipoGasto) {
        return ResponseApi.build(configuracionService.actualizarTipoGasto(tipoGasto));
    }

    @PostMapping(ELIMINAR_TIPO_GASTO)
    public ResponseApi<Map<String, Integer>> eliminarTipoGasto(@RequestBody Map<String, String> tipoGasto) {
        return ResponseApi.build(configuracionService.eliminarTipoGasto(tipoGasto));
    }
    //endregion

    //region Controllers Plantilla
    @GetMapping(LISTAR_PROCESO)
    public ResponseApi<List<Map<String, String>>> listarProceso() {
        return ResponseApi.build(configuracionService.listarProceso());
    }

    @GetMapping(LISTAR_PLANTILLA)
    public ResponseApi<List<Map<String, String>>> listarPlantilla(@RequestParam("procesoId") Integer procesoId) {
        return ResponseApi.build(configuracionService.listarPlantilla(procesoId));
    }

    @GetMapping(LISTAR_DETALLE_PLANTILLA)
    public ResponseApi<Map<String, String>> listarDetallePlantilla(@RequestParam("plantillaId") Integer plantillaId) {
        return ResponseApi.build(configuracionService.listarDetallePlantilla(plantillaId));
    }

    @GetMapping(OBTENER_VERSION_PLANTILLA)
    public ResponseApi<List<Map<String, String>>> obtenerVersionPlantilla(@RequestParam("procesoId") Integer procesoId) {
        return ResponseApi.build(configuracionService.obtenerVersionPlantilla(procesoId));
    }

    @PostMapping(REGISTRAR_PLANTILLA)
    public ResponseApi<Map<String, Integer>> registrarPlantilla(@RequestBody Map<String, String> plantilla) {
        return ResponseApi.build(configuracionService.registrarPlantilla(plantilla));
    }

    @PostMapping(ACTUALIZAR_PLANTILLA)
    public ResponseApi<Map<String, Integer>> actualizarPlantilla(@RequestBody Map<String, String> plantilla) {
        return ResponseApi.build(configuracionService.actualizarPlantilla(plantilla));
    }

    //endregion

}


package com.wydnex.sapchws.control.controller;

import com.wydnex.sapchws.control.services.ControlService;
import com.wydnex.sapchws.utils.model.ResponseApi;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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


    //region Controllers Llamadas Telefonicas
    @GetMapping(LISTAR_LLAMADAS_TELEFONICAS)
    public ResponseApi<List<Map<String, String>>> listarLlamadasTelefonicas(@RequestParam("fechaDesde") String fechaDesde, @RequestParam("fechaHasta") String fechaHasta, @RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        return ResponseApi.build(controlService.listarLlamadasTelefonicas(fechaDesde, fechaHasta, page, limit));
    }

    @PostMapping(IMPORTAR_EXCEL_LLAMADAS)
    public ResponseApi<Map<String, Object>> importExcelLlamadas(@RequestBody MultipartFile file) throws IOException {

        return ResponseApi.build(controlService.importExcelLlamadas(file));
    }

    //endregion


    //region Controllers Autorización de llamada telefónica a clientes
    @GetMapping(LISTAR_AUTORIZACION_LLAMADAS)
    public ResponseApi<List<Map<String, String>>> listarAutorizacionLlamadas(@RequestParam("autorizado") Integer autorizado) {
        return ResponseApi.build(controlService.listarAutorizacionLlamadas(autorizado));
    }

    @GetMapping(OBTENER_DETALLE_POR_TELEFONO)
    public ResponseApi<Map<String, String>> obtenerDetallePorTelefono(@RequestParam("numeroTelefonico") String numeroTelefonico) {
        return ResponseApi.build(controlService.obtenerDetallePorTelefono(numeroTelefonico));
    }

    @GetMapping(OBTENER_AUTORIZACION_POR_ID)
    public ResponseApi<Map<String, String>> obtenerAutorizacionPorId(@RequestParam("autorizacionId") Integer autorizacionId) {
        return ResponseApi.build(controlService.obtenerAutorizacionPorId(autorizacionId));
    }

    @PostMapping(REGISTRAR_AUTORIZACION_LLAMADA)
    public ResponseApi<Map<String, Integer>> registrarAutorizacionLlamada(@RequestBody Map<String, String> authLlamada) {
        return ResponseApi.build(controlService.registrarAutorizacionLlamada(authLlamada));
    }

    @PostMapping(ACTUALIZAR_AUTORIZACION_LLAMADA)
    public ResponseApi<Map<String, Integer>> actualizarAutorizacionLlamada(@RequestBody Map<String, String> authLlamada) {
        return ResponseApi.build(controlService.actualizarAutorizacionLlamada(authLlamada));
    }
    //endregion


    //region Controllers Autorización general de llamada telefónica
    @GetMapping(LISTAR_AUT_GENERAL_LLAMADAS)
    public ResponseApi<List<Map<String, String>>> listarAutorizacionGeneralLlamadas(@RequestParam("autorizado") Integer autorizado) {
        return ResponseApi.build(controlService.listarAutorizacionGeneralLlamadas(autorizado));
    }

    @GetMapping(OBTENER_DETALLE_NUMERO_TELEFONICO)
    public ResponseApi<Map<String, String>> obtenerDetalleNumeroTelefonico(@RequestParam("numeroTelefonico") String numeroTelefonico) {
        return ResponseApi.build(controlService.obtenerDetalleNumeroTelefonico(numeroTelefonico));
    }

    @GetMapping(OBTENER_AUT_GENERAL_LLAMADA_POR_ID)
    public ResponseApi<Map<String, String>> obtenerAutorizacionGeneralPorId(@RequestParam("autorizacionId") Integer autorizacionId) {
        return ResponseApi.build(controlService.obtenerAutorizacionGeneralPorId(autorizacionId));
    }

    @PostMapping(REGISTRAR_AUT_GENERAL_LLAMADA)
    public ResponseApi<Map<String, Integer>> registrarAutorizacionGeneralLlamada(@RequestBody Map<String, String> authGeneralLlamada) {
        return ResponseApi.build(controlService.registrarAutorizacionGeneralLlamada(authGeneralLlamada));
    }

    @PostMapping(ACTUALIZAR_AUT_GENERAL_LLAMADA)
    public ResponseApi<Map<String, Integer>> actualizarAutorizacionGeneralLlamada(@RequestBody Map<String, String> authGeneralLlamada) {
        return ResponseApi.build(controlService.actualizarAutorizacionGeneralLlamada(authGeneralLlamada));
    }
    //endregion


    //region Controllers Registro de llamadas telefonicas
    @GetMapping(LISTAR_LLAMADA_TIPO)
    public ResponseApi<List<Map<String, String>>> listarLlamadaTipo() {
        return ResponseApi.build(controlService.listarLlamadaTipo());
    }

    @GetMapping(LISTAR_LLAMADAS_POR_USUARIO)
    public ResponseApi<List<Map<String, String>>> listarLlamadasPorUsuario(@RequestParam("usuario") String usuario, @RequestParam("page") Integer page, @RequestParam("limit") Integer limit) {
        return ResponseApi.build(controlService.listarLlamadasPorUsuario(usuario, page, limit));
    }

    @GetMapping(OBTENER_DETALLE_LLAMADA_TELEFONICA)
    public ResponseApi<Map<String, String>> obtenerDetalleLlamadaTelefonica(@RequestParam("llamadaId") Integer llamadaId) {
        return ResponseApi.build(controlService.obtenerDetalleLlamadaTelefonica(llamadaId));
    }

    @GetMapping(OBTENER_DATOS_TELEFONO)
    public ResponseApi<Map<String, String>> obtenerDatosTelefono(@RequestParam("numeroTelefonico") String numeroTelefonico) {
        return ResponseApi.build(controlService.obtenerDatosTelefono(numeroTelefonico));
    }

    @PostMapping(REGISTRAR_LLAMADA_TELEFONICA)
    public ResponseApi<Map<String, Integer>> registrarLlamadaTelefonica(@RequestBody Map<String, String> llamada) {
        return ResponseApi.build(controlService.registrarLlamadaTelefonica(llamada));
    }

    @PostMapping(ACTUALIZAR_LLAMADA_TELEFONICA)
    public ResponseApi<Map<String, Integer>> actualizarLlamadaTelefonica(@RequestBody Map<String, String> llamada) {
        return ResponseApi.build(controlService.actualizarLlamadaTelefonica(llamada));
    }
//endregion


    //region Controllers Personal exonerado
    @GetMapping(LISTAR_PERSONAL_EXONERADO)
    public ResponseApi<List<Map<String, String>>> listarPersonalExonerado(@RequestParam("vigente") Integer vigente) {
        return ResponseApi.build(controlService.listarPersonalExonerado(vigente));
    }

    @GetMapping(OBTENER_PERSONAL_POR_CODIGO_USUARIO)
    public ResponseApi<Map<String, String>> obtenerPersonalPorCodigoUsuario(@RequestParam("codigoUsuario") String codigoUsuario) {
        return ResponseApi.build(controlService.obtenerPersonalPorCodigoUsuario(codigoUsuario));
    }

    @GetMapping(OBTENER_DETALLE_PERSONAL_EXONERADO)
    public ResponseApi<Map<String, String>> obtenerDetallePersonalExonerado(@RequestParam("personalExoneradoId") Integer personalExoneradoId) {
        return ResponseApi.build(controlService.obtenerDetallePersonalExonerado(personalExoneradoId));
    }

    @PostMapping(REGISTRAR_PERSONAL_EXONERADO)
    public ResponseApi<Map<String, Integer>> registrarPersonalExonerado(@RequestBody Map<String, String> personalExonerado) {
        return ResponseApi.build(controlService.registrarPersonalExonerado(personalExonerado));
    }

    @PostMapping(ACTUALIZAR_PERSONAL_EXONERADO)
    public ResponseApi<Map<String, Integer>> actualizarPersonalExonerado(@RequestBody Map<String, String> personalExonerado) {
        return ResponseApi.build(controlService.actualizarPersonalExonerado(personalExonerado));
    }

    @PostMapping(ANULAR_PERSONAL_EXONERADO)
    public ResponseApi<Map<String, Integer>> anularPersonalExonerado(@RequestBody Map<String, String> personalExonerado) {
        return ResponseApi.build(controlService.anularPersonalExonerado(personalExonerado));
    }

//endregion
}


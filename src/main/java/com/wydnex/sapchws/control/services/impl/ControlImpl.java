package com.wydnex.sapchws.control.services.impl;

import com.wydnex.sapchws.control.mappers.ControlMapper;
import com.wydnex.sapchws.control.services.ControlService;
import com.wydnex.sapchws.utils.exceptions.BusinessException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ControlImpl implements ControlService {
    private final ControlMapper controlMapper;

    public ControlImpl(ControlMapper controlMapper) {
        this.controlMapper = controlMapper;
    }

    //region Implementacion Precio de llamadas telefónicas - FER102
    @Override
    public List<Map<String, String>> listarLlamadas() {
        return controlMapper.listarLlamadas();
    }

    @Override
    public Map<String, String> listarLlamadaPorId(Integer llamadaId) {
        return controlMapper.listarLlamadaPorId(llamadaId);
    }

    @Override
    public Map<String, Integer> registrarLlamada(Map<String, String> llamada) {
        Map<String, Integer> result = controlMapper.registrarLlamada(llamada);

        if (result.get("llamadaId") == 0) {
            throw new BusinessException("Código y/o descripción de llamada ya registrado anteriormente");
        } else if (result.get("llamadaId") == -1) {
            throw new BusinessException("La fecha 'Desde' no puede ser mayor a la fecha 'Hasta'");
        }
        return result;
    }

    @Override
    public Map<String, Integer> actualizarLlamada(Map<String, String> llamada) {
        Map<String, Integer> result = controlMapper.actualizarLlamada(llamada);

        if (result.get("llamadaId") == 0) {
            throw new BusinessException("Código y/o descripción de llamada ya registrado anteriormente");
        } else if (result.get("llamadaId") == -1) {
            throw new BusinessException("La fecha 'Desde' no puede ser mayor a la fecha 'Hasta'");
        }

        return result;
    }


    //endregion


    //region Implementacion Importar llamadas telefónicas - FER103
    @Override
    public List<Map<String, String>> listarLlamadasTelefonicas(String fechaDesde, String fechaHasta, Integer page, Integer limit) {
        return controlMapper.listarLlamadasTelefonicas(fechaDesde, fechaHasta, page, limit);
    }

    @Override
    public Map<String, Object> importExcelLlamadas(MultipartFile file) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
        XSSFSheet worksheet = workbook.getSheetAt(0);
        Map<String, Object> generalMap = new HashMap<>();
        List<Map<String, String>> maps = new ArrayList<>();

        var numberRows = worksheet.getPhysicalNumberOfRows();

        var codigoUsuario = "Prueba";

        //UserDetailsCustom user = (UserDetailsCustom) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //codigoUsuario= user.getCodigo();

        for (int i = 1; i < numberRows; i++) {
            Map<String, String> map = new HashMap<>();
            XSSFRow row = worksheet.getRow(i);

            if (row != null) {
                map.put("codigoProceso", row.getCell(0).getRawValue());
                map.put("periodo", row.getCell(1).toString());
                map.put("codigoPersona", row.getCell(2).getRawValue());
                map.put("numeroTelefonico", row.getCell(3).getRawValue());
                map.put("codigoRegistro", row.getCell(4).getRawValue());
                map.put("tipoLlamada", row.getCell(5).getRawValue());
                map.put("fechaLlamada", row.getCell(6).toString());
                map.put("horaLlamada", row.getCell(7).toString());
                map.put("duracionLlamada", Integer.parseInt(row.getCell(8).getRawValue()) + "");
                map.put("precioLlamada", row.getCell(9).toString());
                map.put("usuario", codigoUsuario);
                map.put("fechaProceso", row.getCell(11).toString());
                map.put("codigoEstado", row.getCell(12).getRawValue());
                map.put("ctipidella", row.getCell(13).toString());
                map.put("nombrePersona", row.getCell(14).toString());


                Map<String, Integer> result = controlMapper.importExcelLlamadas(map);

                maps.add(map);
            }

        }

        generalMap.put("data", maps);

        return generalMap;
    }

    @Override
    public List<Map<String, Object>> exportExcelLlamadas(String fechaDesde, String fechaHasta) {
        return controlMapper.exportExcelLlamadas(fechaDesde, fechaHasta);
    }
    //endregion


    //region Implementacion Autorización de llamada telefónica a clientes - FER109
    @Override
    public List<Map<String, String>> listarAutorizacionLlamadas(Integer autorizado) {
        return controlMapper.listarAutorizacionLlamadas(autorizado);
    }

    @Override
    public Map<String, String> obtenerDetallePorTelefono(String numeroTelefonico) {
        return controlMapper.obtenerDetallePorTelefono(numeroTelefonico);
    }

    @Override
    public Map<String, String> obtenerAutorizacionPorId(Integer autorizacionId) {
        return controlMapper.obtenerAutorizacionPorId(autorizacionId);
    }


    @Override
    public Map<String, Integer> registrarAutorizacionLlamada(Map<String, String> authLlamada) {
        Map<String, Integer> result = controlMapper.registrarAutorizacionLlamada(authLlamada);

        if (result.get("autorizacionId") == 0) {
            throw new BusinessException("Numero Telefónico ya registrado anteriormente");
        }
        return result;
    }

    @Override
    public Map<String, Integer> actualizarAutorizacionLlamada(Map<String, String> authLlamada) {
        Map<String, Integer> result = controlMapper.actualizarAutorizacionLlamada(authLlamada);

        return result;
    }


    //endregion


    //region Implementacion Autorización general de llamada telefónica - FER110
    @Override
    public List<Map<String, String>> listarAutorizacionGeneralLlamadas(Integer autorizado) {
        return controlMapper.listarAutorizacionGeneralLlamadas(autorizado);
    }

    @Override
    public Map<String, String> obtenerDetalleNumeroTelefonico(String numeroTelefonico) {
        return controlMapper.obtenerDetalleNumeroTelefonico(numeroTelefonico);
    }

    @Override
    public Map<String, String> obtenerAutorizacionGeneralPorId(Integer autorizacionId) {
        return controlMapper.obtenerAutorizacionGeneralPorId(autorizacionId);
    }


    @Override
    public Map<String, Integer> registrarAutorizacionGeneralLlamada(Map<String, String> authGeneralLlamada) {
        Map<String, Integer> result = controlMapper.registrarAutorizacionGeneralLlamada(authGeneralLlamada);

        if (result.get("autorizacionId") == 0) {
            throw new BusinessException("Numero Telefónico ya registrado anteriormente");
        }
        return result;
    }

    @Override
    public Map<String, Integer> actualizarAutorizacionGeneralLlamada(Map<String, String> authGeneralLlamada) {
        Map<String, Integer> result = controlMapper.actualizarAutorizacionGeneralLlamada(authGeneralLlamada);

        return result;
    }


    //endregion


    //region Implementacion Registro de llamadas telefonicas - FER108
    @Override
    public List<Map<String, String>> listarLlamadaTipo() {
        return controlMapper.listarLlamadaTipo();
    }

    @Override
    public List<Map<String, String>> listarLlamadasPorUsuario(String usuario, Integer page, Integer limit) {
        return controlMapper.listarLlamadasPorUsuario(usuario, page, limit);
    }

    @Override
    public Map<String, String> obtenerDetalleLlamadaTelefonica(Integer llamadaId) {
        return controlMapper.obtenerDetalleLlamadaTelefonica(llamadaId);
    }

    @Override
    public Map<String, String> obtenerDatosTelefono(String numeroTelefonico) {
        return controlMapper.obtenerDatosTelefono(numeroTelefonico);
    }

    @Override
    public Map<String, Integer> registrarLlamadaTelefonica(Map<String, String> llamada) {

        Map<String, Integer> result = controlMapper.registrarLlamadaTelefonica(llamada);

        if (result.get("llamadaId") == 0) {
            throw new BusinessException("Numero Telefónico ya registrado anteriormente");
        }
        return result;
    }

    @Override
    public Map<String, Integer> actualizarLlamadaTelefonica(Map<String, String> llamada) {
        Map<String, Integer> result = controlMapper.actualizarLlamadaTelefonica(llamada);
        return result;
    }

    @Override
    public List<Map<String, Object>> exportExcelTelefonosPersonal(Integer vigente) {
        return controlMapper.exportExcelTelefonosPersonal(vigente);
    }
    //endregion


    //region Implementacion Personal exonerado - FER105
    @Override
    public List<Map<String, String>> listarPersonalExonerado(Integer vigente) {
        return controlMapper.listarPersonalExonerado(vigente);
    }

    @Override
    public Map<String, String> obtenerPersonalPorCodigoUsuario(String codigoUsuario) {
        return controlMapper.obtenerPersonalPorCodigoUsuario(codigoUsuario);
    }

    @Override
    public Map<String, String> obtenerDetallePersonalExonerado(Integer personalExoneradoId) {
        return controlMapper.obtenerDetallePersonalExonerado(personalExoneradoId);
    }

    @Override
    public Map<String, Integer> registrarPersonalExonerado(Map<String, String> personalExonerado) {
        Map<String, Integer> result = controlMapper.registrarPersonalExonerado(personalExonerado);
        return result;
    }

    @Override
    public Map<String, Integer> actualizarPersonalExonerado(Map<String, String> personalExonerado) {
        Map<String, Integer> result = controlMapper.actualizarPersonalExonerado(personalExonerado);
        return result;
    }

    @Override
    public Map<String, Integer> anularPersonalExonerado(Map<String, String> personalExonerado) {
        Map<String, Integer> result = controlMapper.anularPersonalExonerado(personalExonerado);
        return result;
    }

    @Override
    public List<Map<String, Object>> exportExcelPersonalExonerado(Integer vigente) {
        return controlMapper.exportExcelPersonalExonerado(vigente);
    }
    //endregion


    //region Implementacion Costo de llamadas telefónicas - FER104
    @Override
    public List<Map<String, String>> listarLlamadasPendientes(String fechaDesde, String fechaHasta) {
        return controlMapper.listarLlamadasPendientes(fechaDesde, fechaHasta);
    }

    @Override
    public List<Map<String, String>> listarCostoPorLlamada() {
        return controlMapper.listarCostoPorLlamada();
    }

    @Override
    public Map<String, String> obtenerCantidadLlamadas(String fechaDesde, String fechaHasta) {
        return controlMapper.obtenerCantidadLlamadas(fechaDesde, fechaHasta);
    }

    @Override
    public List<Map<String, String>> procesarLlamadas(Map<String, String> request) {

        request.put("usuarioRegistro", "user");

        //UserDetailsCustom user = (UserDetailsCustom) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //codigoUsuario= user.getCodigo();

        return controlMapper.procesarLlamadas(request);
    }

    //endregion


    //region Implementacion Genera descuento telefónico - FER106
    @Override
    public List<Map<String, String>> listarMeses() {
        return controlMapper.listarMeses();
    }

    @Override
    public List<Map<String, String>> listarAnios() {
        return controlMapper.listarAnios();
    }

    @Override
    public Map<String, String> obtenerEstadoPorMesAnio(Integer month, Integer year) {
        return controlMapper.obtenerEstadoPorMesAnio(month, year);
    }

    @Override
    public List<Map<String, String>> procesarDescuentos(Map<String, String> request) {

        request.put("usuarioRegistro", "user");

        //UserDetailsCustom user = (UserDetailsCustom) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //codigoUsuario= user.getCodigo();

        return controlMapper.procesarDescuentos(request);
    }

    @Override
    public List<Map<String, String>> listarUsuariosExoneradosPorFecha(String fechaDesde, String fechaHasta) {
        return controlMapper.listarUsuariosExoneradosPorFecha(fechaDesde, fechaHasta);
    }


    //endregion


    //region Implementacion Reportes de descuento telefónico - FER107
    @Override
    public List<Map<String, Object>> listarReporteDescuentoDetalle(Integer month, Integer year) {
        return controlMapper.listarReporteDescuentoDetalle(month, year);
    }

    @Override
    public List<Map<String, Object>> listarReporteDescuentoResumen(Integer month, Integer year) {
        return controlMapper.listarReporteDescuentoResumen(month, year);
    }

    //endregion
}

package com.wydnex.sapchws.control.config;

public class PathsControl {
    public static final String CONTROL = "/control";

    //region Endpoints Llamada
    public static final String LISTAR_LLAMADAS = "/listarLlamadas";
    public static final String LISTAR_LLAMADA_POR_ID = "/listarLlamadaPorId";
    public static final String REGISTRAR_LLAMADA = "/registrarLlamada";
    public static final String ACTUALIZAR_LLAMADA = "/actualizarLlamada";
    //endregion

    //region Endpoints Llamadas Telefonicas
    public static final String LISTAR_LLAMADAS_TELEFONICAS = "/listarLlamadasTelefonicas";
    public static final String IMPORTAR_EXCEL_LLAMADAS = "/importExcelLlamadas";
    public static final String EXPORTAR_EXCEL_LLAMADAS = "/exportExcelLlamadas";
    //endregion

    //region Endpoints Autorización de llamada telefónica a clientes
    public static final String LISTAR_AUTORIZACION_LLAMADAS = "/listarAutorizacionLlamadas";
    public static final String OBTENER_DETALLE_POR_TELEFONO = "/obtenerDetallePorTelefono";
    public static final String OBTENER_AUTORIZACION_POR_ID = "/obtenerAutorizacionPorId";
    public static final String REGISTRAR_AUTORIZACION_LLAMADA = "/registrarAutorizacionLlamada";
    public static final String ACTUALIZAR_AUTORIZACION_LLAMADA = "/actualizarAutorizacionLlamada";
    //endregion
}

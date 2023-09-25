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


    //region Endpoints Autorización general de llamada telefónica
    public static final String LISTAR_AUT_GENERAL_LLAMADAS = "/listarAutorizacionGeneralLlamadas";
    public static final String OBTENER_DETALLE_NUMERO_TELEFONICO = "/obtenerDetalleNumeroTelefonico";
    public static final String OBTENER_AUT_GENERAL_LLAMADA_POR_ID = "/obtenerAutorizacionGeneralPorId";
    public static final String REGISTRAR_AUT_GENERAL_LLAMADA = "/registrarAutorizacionGeneralLlamada";
    public static final String ACTUALIZAR_AUT_GENERAL_LLAMADA = "/actualizarAutorizacionGeneralLlamada";
    //endregion


    //region Endpoints Registro de llamadas telefonicas
    public static final String LISTAR_LLAMADA_TIPO = "/listarLlamadaTipo";
    public static final String LISTAR_LLAMADAS_POR_USUARIO = "/listarLlamadasPorUsuario";
    public static final String OBTENER_DETALLE_LLAMADA_TELEFONICA = "/obtenerDetalleLlamadaTelefonica";
    public static final String OBTENER_DATOS_TELEFONO = "/obtenerDatosTelefono";
    public static final String REGISTRAR_LLAMADA_TELEFONICA = "/registrarLlamadaTelefonica";
    public static final String ACTUALIZAR_LLAMADA_TELEFONICA = "/actualizarLlamadaTelefonica";
    public static final String EXPORTAR_EXCEL_TELEFONOS_PERSONAL = "/exportExcelTelefonosPersonal";
    //endregion


    //region Endpoints Registro de Personal Exonerado
    public static final String LISTAR_PERSONAL_EXONERADO = "/listarPersonalExonerado";
    public static final String OBTENER_PERSONAL_POR_CODIGO_USUARIO = "/obtenerPersonalPorCodigoUsuario";
    public static final String OBTENER_DETALLE_PERSONAL_EXONERADO = "/obtenerDetallePersonalExonerado";
    public static final String REGISTRAR_PERSONAL_EXONERADO = "/registrarPersonalExonerado";
    public static final String ACTUALIZAR_PERSONAL_EXONERADO = "/actualizarPersonalExonerado";
    public static final String ANULAR_PERSONAL_EXONERADO = "/anularPersonalExonerado";
    public static final String EXPORTAR_EXCEL_PERSONAL_EXONERADO = "/exportExcelPersonalExonerado";
    //endregion


    //region Endpoints Costo de llamadas telefónicas
    public static final String LISTAR_LLAMADAS_PENDIENTES = "/listarLlamadasPendientes";
    public static final String LISTAR_COSTO_POR_LLAMADA = "/listarCostoPorLlamada";
    public static final String OBTENER_CANTIDAD_LLAMADAS = "/obtenerCantidadLlamadas";
    public static final String PROCESAR_LLAMADAS = "/procesarLlamadas";
    //endregion


    //region Endpoints Genera descuento telefónico
    public static final String LISTAR_MESES = "/listarMeses";
    public static final String LISTAR_ANIOS = "/listarAnios";
    public static final String OBTENER_ESTADO_POR_MES_ANIO = "/obtenerEstadoPorMesAnio";
    public static final String PROCESAR_DESCUENTOS = "/procesarDescuentos";
    public static final String LISTAR_USUARIOS_EXONERADOS_POR_FECHA = "/listarUsuariosExoneradosPorFecha";
    //endregion


    //region Endpoints Reportes de descuento telefónico
    public static final String EXPORTAR_REPORTE_DESCUENTO_DETALLE = "/exportarReporteDescuentoDetalle";
    public static final String EXPORTAR_REPORTE_DESCUENTO_RESUMEN = "/exportarReporteDescuentoResumen";
    public static final String LISTAR_REPORTE_DESCUENTO_DETALLE = "/listarReporteDescuentoDetalle";
    public static final String LISTAR_REPORTE_DESCUENTO_RESUMEN = "/listarReporteDescuentoResumen";
    //endregion


    //region Endpoints Cargos de movilidad
    public static final String LISTAR_CARGOS = "/listarCargos";
    public static final String OBTENER_DETALLE_CARGO = "/obtenerDetalleCargo";
    public static final String REGISTRAR_CARGO_MOVILIDAD = "/registrarCargoMovilidad";
    public static final String ACTUALIZAR_CARGO_MOVILIDAD = "/actualizarCargoMovilidad";
    public static final String LISTAR_CARGOS_MOVILIDAD = "/listarCargosMovilidad";
    //endregion

}

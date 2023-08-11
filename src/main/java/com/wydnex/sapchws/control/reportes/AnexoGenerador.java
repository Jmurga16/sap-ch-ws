package com.wydnex.sapchws.control.reportes;

import com.wydnex.sapchws.control.model.dto.ParametrosReporte;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class AnexoGenerador implements ReporteInterface {

    private ParametrosReporte parametrosReporte;

    public AnexoGenerador(ParametrosReporte parametrosReporte) {
        this.parametrosReporte = parametrosReporte;
    }

    @Override
    public Resource generarReporte() {
        Workbook wb = new XSSFWorkbook();
        Sheet sheet = wb.createSheet(parametrosReporte.getNombreHoja());


        // formato de valores
        DataFormat df = wb.createDataFormat();
        short decimal2 = df.getFormat("#,###,###.00");

        // estilos
        CellStyle styletitle = wb.createCellStyle();
        Font fontTitulo = wb.createFont();
        styletitle.setAlignment(HorizontalAlignment.CENTER);
        styletitle.setVerticalAlignment(VerticalAlignment.CENTER);
        fontTitulo.setBold(true);
        fontTitulo.setFontHeight((short) 300);
        styletitle.setFont(fontTitulo);


        CellStyle styleGris = wb.createCellStyle();
        styleGris.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        styleGris.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        styleGris.setAlignment(HorizontalAlignment.CENTER);
        styleGris.setVerticalAlignment(VerticalAlignment.CENTER);
        Font fontTti02 = wb.createFont();
        fontTti02.setBold(true);
        styleGris.setFont(fontTti02);
        styleGris.setWrapText(true);

        CellStyle styleData = wb.createCellStyle();
        styleData.setAlignment(HorizontalAlignment.CENTER);
        styleData.setVerticalAlignment(VerticalAlignment.CENTER);
        styleData.setWrapText(true);

        CellStyle styleDataLeft = wb.createCellStyle();
        styleDataLeft.setAlignment(HorizontalAlignment.LEFT);
        styleDataLeft.setVerticalAlignment(VerticalAlignment.CENTER);
        styleDataLeft.setWrapText(true);

        CellStyle styleDataMonto = wb.createCellStyle();
        styleDataMonto.setAlignment(HorizontalAlignment.CENTER);
        styleDataMonto.setVerticalAlignment(VerticalAlignment.CENTER);
        styleDataMonto.setDataFormat(decimal2);

        int cantidadCol = parametrosReporte.getCabecera().get("cabecera").length;
        sheet.addMergedRegion(new CellRangeAddress(0, 1, 0, cantidadCol-1));

        Row rowTitulo = sheet.createRow(0);
        Cell cellTit01 = rowTitulo.createCell(0);
        cellTit01.setCellValue(parametrosReporte.getTitulosReporte()[0]);
        cellTit01.setCellStyle(styletitle);


        Row rowCabecera = sheet.createRow(2);

        for (int i = 0; i < parametrosReporte.getCabecera().get("cabecera").length; i++) {
            Cell cellTit02 = rowCabecera.createCell(i);
            cellTit02.setCellStyle(styleGris);
            cellTit02.setCellValue(parametrosReporte.getCabecera().get("cabecera")[i]);
            sheet.setColumnWidth(i, 7000);
        }

        // data

        List<Object[]> list = parametrosReporte.getFilas().get("data");
        if (list.size() > 0) {
            int fil_num = 4;
            for (Object[] fil : list) {
                Row row = sheet.createRow(fil_num);
                int cellNum = 0;
                for (Object o : fil) {
                    Cell cell = row.createCell(cellNum);
                    if (o instanceof String) {
                        cell.setCellValue((String) o);
                        cell.setCellStyle(styleDataLeft);
                    } else if (o instanceof Integer) {
                        cell.setCellValue((Integer) o);
                        cell.setCellStyle(styleData);
                    } else if (o instanceof Double) {
                        cell.setCellValue((Double) o);
                        cell.setCellStyle(styleDataMonto);
                    } else if (o instanceof BigDecimal) {
                        cell.setCellValue(((BigDecimal) o).doubleValue());
                        cell.setCellStyle(styleDataMonto);
                    }

                    cellNum++;
                }
                fil_num++;
            }
        }

        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {

            wb.write(byteArrayOutputStream);
            return new ByteArrayResource(byteArrayOutputStream.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error while generating excel.");
        }
    }


}

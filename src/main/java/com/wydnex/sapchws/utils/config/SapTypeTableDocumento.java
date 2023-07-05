package com.wydnex.sapchws.utils.config;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.microsoft.sqlserver.jdbc.SQLServerPreparedStatement;
import com.wydnex.sapchws.utils.model.Documento;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class SapTypeTableDocumento extends BaseTypeHandler<List<Documento>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Documento> parameter, JdbcType jdbcType) throws SQLException {
        SQLServerDataTable dataTable = new SQLServerDataTable();


        try {
            dataTable.addColumnMetadata("cNombreOriginal", Types.VARCHAR);
            dataTable.addColumnMetadata("cExtension", Types.VARCHAR);
            dataTable.addColumnMetadata("iTamano", Types.BIGINT);
            dataTable.addColumnMetadata("cNombreGenerado", Types.VARCHAR);
            dataTable.addColumnMetadata("iEstado", Types.INTEGER);
            dataTable.addColumnMetadata("cContentType", Types.VARCHAR);


        } catch (SQLServerException e) {
            e.printStackTrace();
        }


        parameter.forEach(doc -> {
            try {

                dataTable.addRow(doc.getNombreOriginal(), doc.getExtension(), Long.parseLong(doc.getTamano()), doc.getNombreGenerado(), Integer.parseInt(doc.getEstado()), doc.getContentType());

            } catch (SQLServerException e) {
                e.printStackTrace();
            }
        });

        ps.unwrap(SQLServerPreparedStatement.class)
                .setStructured(i, "SAP_type_table_documento", dataTable);
    }

    @Override
    public List<Documento> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public List<Documento> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public List<Documento> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }


}

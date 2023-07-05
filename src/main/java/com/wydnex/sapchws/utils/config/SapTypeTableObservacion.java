package com.wydnex.sapchws.utils.config;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.microsoft.sqlserver.jdbc.SQLServerPreparedStatement;
import com.wydnex.sapchws.utils.model.Historial;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.List;

public class SapTypeTableObservacion extends BaseTypeHandler<List<Historial>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Historial> parameter, JdbcType jdbcType) throws SQLException {
        SQLServerDataTable dataTable = new SQLServerDataTable();


        try {
            dataTable.addColumnMetadata("iObservacionId", Types.INTEGER);
            dataTable.addColumnMetadata("cDescripcion", Types.VARCHAR);
            dataTable.addColumnMetadata("cUsuarioCodigo", Types.INTEGER);



        } catch (SQLServerException e) {
            e.printStackTrace();
        }


        parameter.forEach(obs -> {
            try {

                dataTable.addRow(obs.getObservacionId(),obs.getDescripcion(),obs.getUsuarioId());

            } catch (SQLServerException e) {
                e.printStackTrace();
            }
        });

        ps.unwrap(SQLServerPreparedStatement.class)
                .setStructured(i, "SAP_type_table_Observacion", dataTable);
    }

    @Override
    public List<Historial> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public List<Historial> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public List<Historial> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }


}

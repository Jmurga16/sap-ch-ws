package com.wydnex.sapchws.utils.config;

import com.microsoft.sqlserver.jdbc.SQLServerDataTable;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import com.microsoft.sqlserver.jdbc.SQLServerPreparedStatement;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class SapTypeTableGeneric extends BaseTypeHandler<List<Map<String, String>>> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, List<Map<String, String>> parameter, JdbcType jdbcType) throws SQLException {
        SQLServerDataTable dataTable = new SQLServerDataTable();


        IntStream rangeStream = IntStream.rangeClosed(1, 20);
        rangeStream.forEach((num) -> {
            try {
                dataTable.addColumnMetadata("col" + num, Types.VARCHAR);
            } catch (SQLServerException e) {
                e.printStackTrace();
            }
        });

        parameter.forEach(map -> {
            try {
                Object[] rows = map.values().toArray();
               // System.out.println("objects = " + Arrays.toString(objects));
                dataTable.addRow(rows);
            } catch (SQLServerException e) {
                e.printStackTrace();
            }
        });

        ps.unwrap(SQLServerPreparedStatement.class)
                .setStructured(i, "SAP_type_table_generic", dataTable);
    }

    @Override
    public List<Map<String, String>> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return null;
    }

    @Override
    public List<Map<String, String>> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return null;
    }

    @Override
    public List<Map<String, String>> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }


}

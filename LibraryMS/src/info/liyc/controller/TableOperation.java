package info.liyc.controller;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

/**
 * Created by liyc on 17-4-30.
 */
public class TableOperation {
    public static Vector<String> getColumnName(ResultSetMetaData rsmd) {
        Vector<String> columns = new Vector<String>();
        try {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                columns.add(rsmd.getColumnName(i));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return columns;
    }

    public static Vector<Vector<String>> getTableData(ResultSet rs, ResultSetMetaData rsmd) {
        Vector<Vector<String>> data = new Vector<Vector<String>>();
        try {
            while (rs.next()) {
                Vector<String> rowData = new Vector<String>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rowData.add(rs.getString(i));
                }
                data.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}

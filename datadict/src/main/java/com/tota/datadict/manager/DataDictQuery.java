package com.tota.datadict.manager;

import com.tota.datadict.entity.Column;
import com.tota.datadict.entity.Database;
import com.tota.datadict.entity.Table;
import com.tota.datadict.util.RandomUtil;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataDictQuery {

    private DruidDataSourceManager dataSourceManager;

    public  DataDictQuery(DruidDataSourceManager dataSourceManager){
        this.dataSourceManager=dataSourceManager;
    }

    public Database getDatabase() throws Exception {
        DatabaseMetaData dbmd= dataSourceManager.getMetaData();
        Database database=new Database();
        String databaseId= RandomUtil.generateString(32);
        database.setDatabaseId(databaseId);
        String url=dataSourceManager.getUrl();
        String databaseName=url.substring(url.lastIndexOf("/")+1);
        database.setDatabaseName(databaseName);
        database.setDatabaseUrl(dbmd.getURL());
        database.setDatabaseAdminUserName(dbmd.getUserName());
        database.setDatabaseAdminPassWord("");
        database.setTables(getTables(dbmd,databaseId));
        return database;
    }

    private List<Table> getTables(DatabaseMetaData dbmd, String databaseId) throws Exception {
        List<Table> tables=new ArrayList<>();
        ResultSet rs = dbmd.getTables(null, null, null, new String[] { "TABLE" });
        while (rs.next()) {
            Table table=new Table();
            String tableId=RandomUtil.generateString(32);
            table.setTableId(tableId);
            table.setTableName(rs.getString("TABLE_NAME"));
            table.setTableComment(rs.getString("REMARKS"));
            table.setDatabaseId(databaseId);
            table.setColumns(getColumns(rs,tableId));
            tables.add(table);
//           System.out.println("表名：" + rs.getString("TABLE_NAME"));
//           System.out.println("表类型：" + rs.getString("TABLE_TYPE"));
//           System.out.println("表所属数据库：" + rs.getString("TABLE_CAT"));
//           System.out.println("表备注：" + rs.getString("REMARKS"));
        }
        return tables;
    }

    private List<Column> getColumns(ResultSet rs, String  tableId) throws Exception {
        List<Column> columns = new ArrayList<>();
        ResultSet rsColimns = dataSourceManager.getMetaData().getColumns(null, "%", rs.getString("TABLE_NAME"), "%");
        while (rsColimns.next()) {
            Column column=new Column();
            String columnId= RandomUtil.generateString(32);
            column.setColumnId(columnId);
            column.setColumnName(rsColimns.getString("COLUMN_NAME"));
            column.setColumnComment(rsColimns.getString("REMARKS"));
            column.setColumnDataType(rsColimns.getString("TYPE_NAME"));
            column.setColumnLength(rsColimns.getInt("COLUMN_SIZE"));
            column.setColumnDefaultValue(rsColimns.getString("COLUMN_DEF"));
            column.setTableId(tableId);
            columns.add(column);
        }
        return columns;
    }
}

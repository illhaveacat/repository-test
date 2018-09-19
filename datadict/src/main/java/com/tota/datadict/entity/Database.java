package com.tota.datadict.entity;

import java.beans.Transient;
import java.util.List;

public class Database {

    private String  databaseId;

    private String databaseName;

    private String databaseUrl;

    private String databaseAdminUserName;

    private String databaseAdminPassWord;

    private List<Table> tables;

    @Transient
    public List<Table> getTables() {
        return tables;
    }

    public void setTables(List<Table> tables) {
        this.tables = tables;
    }

    public String getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(String databaseId) {
        this.databaseId = databaseId;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

    public String getDatabaseAdminUserName() {
        return databaseAdminUserName;
    }

    public void setDatabaseAdminUserName(String databaseAdminUserName) {
        this.databaseAdminUserName = databaseAdminUserName;
    }

    public String getDatabaseAdminPassWord() {
        return databaseAdminPassWord;
    }

    public void setDatabaseAdminPassWord(String databaseAdminPassWord) {
        this.databaseAdminPassWord = databaseAdminPassWord;
    }
}

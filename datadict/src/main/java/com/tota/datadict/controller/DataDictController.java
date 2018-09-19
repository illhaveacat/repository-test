package com.tota.datadict.controller;


import com.tota.datadict.common.AjaxResult;
import com.tota.datadict.entity.Column;
import com.tota.datadict.entity.Database;
import com.tota.datadict.entity.Table;
import com.tota.datadict.manager.DataDictQuery;
import com.tota.datadict.manager.DruidDataSourceManager;
import com.tota.datadict.mapper.ColumnMapper;
import com.tota.datadict.mapper.DatabaseMapper;
import com.tota.datadict.mapper.TableMapper;
import com.tota.datadict.service.DataDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/datadict")
public class DataDictController extends BaseController {

    @Autowired
    DatabaseMapper databaseMapper;

    @Autowired
    TableMapper tableMapper;

    @Autowired
    ColumnMapper columnMapper;

    @Autowired
    DataDictService dataDictService;

    @RequestMapping("/showDatabases")
    public String showDatabases(ModelMap modelMap) {
        List<Database> databases = databaseMapper.getAll();
        modelMap.put("databases", databases);
        return "database";
    }

    @RequestMapping("/showTables")
    public String showTables(ModelMap modelMap){
        String databaseId=getHttpServletRequest().getParameter("databaseId");
        String databaseName=getHttpServletRequest().getParameter("databaseName");
        List<Table> tables=tableMapper.getTablesByDatabaseId(databaseId);
        modelMap.put("tables",tables);
        modelMap.put("databaseName",databaseName);
        return "table";
    }

    @RequestMapping("/showColumns")
    public String showColumns(ModelMap modelMap){
        String tableId=getHttpServletRequest().getParameter("tableId");
        String tableName=getHttpServletRequest().getParameter("tableName");
        List<Column> columns=columnMapper.getColumnsByTableId(tableId);
        modelMap.put("columns",columns);
        modelMap.put("tableName",tableName);
        return "column";
    }

    @RequestMapping(value = "/addDatabases")
    @ResponseBody
    public AjaxResult addDatabases() {
        try {
            String url = getHttpServletRequest().getParameter("databaseUrl");
            String username = getHttpServletRequest().getParameter("databaseUserName");
            String password = getHttpServletRequest().getParameter("databasePassWord");
            DruidDataSourceManager dataSourceManager = new DruidDataSourceManager(url, username, password);
            DataDictQuery dictQuery = new DataDictQuery(dataSourceManager);
            Database database = dictQuery.getDatabase();
            dataDictService.addNewDict(database);
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult(false,"添加失败",null);
        }
        return new AjaxResult(true,"添加成功",null);
    }

    @RequestMapping("/updateTable")
    @ResponseBody
    public AjaxResult updateTable(){
        String tableId = getHttpServletRequest().getParameter("tableId");
        String tableComment = getHttpServletRequest().getParameter("tableComment");
        tableMapper.update(tableId,tableComment);
        return new AjaxResult(true,"修改成功",null);
    }

    @RequestMapping("/updateColumn")
    @ResponseBody
    public AjaxResult updateColumn(){
        String columnId = getHttpServletRequest().getParameter("columnId");
        String columnComment = getHttpServletRequest().getParameter("columnComment");
        columnMapper.update(columnId,columnComment);
        return new AjaxResult(true,"修改成功",null);
    }
}

package com.tota.datadict.service.impl;

import com.tota.datadict.entity.Column;
import com.tota.datadict.entity.Database;
import com.tota.datadict.entity.Table;
import com.tota.datadict.exception.BussinessException;
import com.tota.datadict.mapper.ColumnMapper;
import com.tota.datadict.mapper.DatabaseMapper;
import com.tota.datadict.mapper.TableMapper;
import com.tota.datadict.service.DataDictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataDictServiceImpl implements DataDictService {

    @Autowired
    DatabaseMapper databaseMapper;

    @Autowired
    TableMapper tableMapper;

    @Autowired
    ColumnMapper columnMapper;

    @Transactional
    @Override
    public void addNewDict(Database database) {
        databaseMapper.insert(database);
        List<Table> tableList=database.getTables();
        List<Column> columns=new ArrayList<>();
        tableMapper.insertList(tableList);
        for(Table table:tableList){
            columns.addAll(table.getColumns());
        }
        columnMapper.insertList(columns);
    }
}

package com.tota.datadict.mapper;

import com.tota.datadict.entity.Column;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ColumnMapper {

    @Select("select * from data_dict_column")
    @Results({
            @Result(property = "columnId",  column = "column_id"),
            @Result(property = "columnName",  column = "column_name"),
            @Result(property = "columnDataType",  column = "column_datatype"),
            @Result(property = "columnLength",  column = "column_length"),
            @Result(property = "columnDefaultValue",  column = "column_default_value"),
            @Result(property = "columnComment",  column = "column_comment"),
            @Result(property = "tableId",  column = "table_id")
    })
    List<Column> getAll();


    @Select("select * from data_dict_column where table_id=#{tableId}")
    @Results({
            @Result(property = "columnId",  column = "column_id"),
            @Result(property = "columnName",  column = "column_name"),
            @Result(property = "columnDataType",  column = "column_datatype"),
            @Result(property = "columnLength",  column = "column_length"),
            @Result(property = "columnDefaultValue",  column = "column_default_value"),
            @Result(property = "columnComment",  column = "column_comment"),
            @Result(property = "tableId",  column = "table_id")
    })
    List<Column> getColumnsByTableId(String tableId);


    @Insert("insert into data_dict_column(column_id,column_name,column_datatype,column_length,column_default_value,column_comment,table_id)" +
            " values(#{columnId},#{columnName},#{columnDataType},#{columnLength},#{columnDefaultValue},#{columnComment},#{tableId}) ")
    void insert(Column column);


    @Insert("<script>INSERT INTO data_dict_column(column_id,column_name,column_datatype,column_length,column_default_value,column_comment,table_id)" +
            " VALUES <foreach collection=\"list\" item=\"item1\" index=\"index\"  separator=\",\">" +
            "(#{item1.columnId},#{item1.columnName},#{item1.columnDataType},#{item1.columnLength},#{item1.columnDefaultValue},#{item1.columnComment},#{item1.tableId})" +
            "</foreach>" +
            "</script>")
    void insertList(@Param("list")List<Column> columns);

    @Update("update data_dict_column set column_comment=#{columnComment} where column_id=#{columnId}")
    void update(@Param("columnId")String columnId,@Param("columnComment")String columnComment);
}

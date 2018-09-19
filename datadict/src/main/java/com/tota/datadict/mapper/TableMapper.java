package com.tota.datadict.mapper;

import com.tota.datadict.entity.Table;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TableMapper {

    @Select("select * from data_dict_table")
    @Results({
            @Result(property = "tableId",  column = "table_id"),
            @Result(property = "tableName",  column = "table_name"),
            @Result(property = "tableComment",  column = "table_comment"),
            @Result(property = "databaseId",  column = "database_id")
    })
    List<Table> getAll();

    @Select("select * from data_dict_table where database_id=#{databaseId}")
    @Results({
            @Result(property = "tableId",  column = "table_id"),
            @Result(property = "tableName",  column = "table_name"),
            @Result(property = "tableComment",  column = "table_comment"),
            @Result(property = "databaseId",  column = "database_id")
    })
    List<Table> getTablesByDatabaseId(String databaseId);

    @Insert("insert into data_dict_table(table_id,table_name,table_comment,database_id) " +
            "values(#{tableId},#{tableName},#{tableComment},#{databaseId})")
    void insert(Table table);


    @Insert("<script>INSERT INTO data_dict_table(table_id,table_name,table_comment,database_id) VALUES" +
        "<foreach collection=\"list\" item=\"item1\" index=\"index\"  separator=\",\">" +
        "(#{item1.tableId},#{item1.tableName},#{item1.tableComment},#{item1.databaseId})" +
        "</foreach>" +
        "</script>")
    void insertList(@Param("list")List<Table> tables);



    @Update("update data_dict_table set table_comment=#{tableComment} where table_id=#{tableId}")
    void update(@Param("tableId")String tableId,@Param("tableComment")String tableComment);
}

package com.tota.datadict.mapper;

import com.tota.datadict.entity.Database;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DatabaseMapper {

    @Select("select * from data_dict_database")
    @Results({
            @Result(property = "databaseId",  column = "database_id"),
            @Result(property = "databaseName",  column = "database_name"),
            @Result(property = "databaseUrl",  column = "database_url"),
            @Result(property = "databaseAdminUserName",  column = "database_admin_username"),
            @Result(property = "database_admin_password",  column = "databaseAdminPassWord")
    })
    List<Database> getAll();

    @Insert("insert into data_dict_database(database_id,database_name,database_url,database_admin_username,database_admin_password) " +
            "values(#{databaseId},#{databaseName},#{databaseUrl},#{databaseAdminUserName},#{databaseAdminPassWord})")
    void insert(Database database);

}

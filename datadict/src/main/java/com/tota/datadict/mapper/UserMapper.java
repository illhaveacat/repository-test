package com.tota.datadict.mapper;


import com.tota.datadict.entity.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("select *  from t_user where username=#{username}")
    User getOne(String username);


}
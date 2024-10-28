package com.niuniu.user.mapper;

import com.niuniu.user.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    @Select("select id,name from t_user where id = #{id}")
    User getById(@Param("id") Integer id);

}

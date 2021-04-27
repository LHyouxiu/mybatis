package com.kuang.dao;


import com.kuang.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from user")
    List<User> getUsers();
    
    @Insert("insert into user (id,name,pwd) values (#{id},#{name},#{password})")
    int addUser(User user);

    @Delete("delete from user where id=#{uid}")
    int deUser(@Param("uid") int id);

    @Update("update user set name=#{name},pwd=#{password} where id=#{id}")
    int updateUsers(User user);
}

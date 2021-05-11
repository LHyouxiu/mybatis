package com.kuang.dao;

import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface UserMapper {
    //根据用户查id
    User queryUserById(@Param("ids") int id);

    int updateUser(Map map);
}

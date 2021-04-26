package com.kuang.dao;


import com.kuang.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * for user")
    List<User> getUserAll();
}

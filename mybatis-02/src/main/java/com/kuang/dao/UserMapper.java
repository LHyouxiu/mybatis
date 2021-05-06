package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;

public interface UserMapper {
    //查询uo所有用户
    List<User> getUserList();
    //插入用户
    int addUser(User user);
    //根据id查询用户
    User getUserById(int id);
    //修改
    int updateUser(User user);
    //删除
    int deleteUserById(int id);
}

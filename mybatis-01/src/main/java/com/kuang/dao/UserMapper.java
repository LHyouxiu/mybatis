package com.kuang.dao;

import com.kuang.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询uo所有用户
    public List<User> getUserList();
    //map查询
    List<User> getUserList2(String value);
    //插入用户
    int addUser(User user);
    //map插入
    int addUser2(Map<String,Object> map);
    //根据id查询用户
    User getUserById(int id);
    //
    User getUserById2(Map<String,Object> map);
    //修改
    int updateUser(User user);
    //删除
    int deleteUserById(int id);
}

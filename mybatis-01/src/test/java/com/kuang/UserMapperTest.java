package com.kuang;

import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    //查询所有
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
        for (User user:userList){
            System.out.println(user);
        }
        sqlSession.close();
    }
    //模糊查询
    @Test
    public void mohu(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList2 = mapper.getUserList2("李%");
        for (User user : userList2) {
            System.out.println(user);
        }

        sqlSession.close();
    }

//    插入
    @Test
    public void test2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(5,"狂神测试","777");
        mapper.addUser(user);
        //提交事务
        sqlSession.commit();

        //关闭sqlSession
        sqlSession.close();
    }

//    Map插入
    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<String,Object>();
        map.put("id",5);
        map.put("username","hashUser");
        map.put("password","hashPassword");
        mapper.addUser2(map);
        sqlSession.commit();

        sqlSession.close();
    }

//根据id查询
   @Test
    public void test3(){
       SqlSession sqlSession = MybatisUtils.getSqlSession();

       UserMapper mapper = sqlSession.getMapper(UserMapper.class);
       int i = 1;
       User userById = mapper.getUserById(i);
       System.out.println(userById);

       sqlSession.close();
   }
//Map查询
    @Test
    public void getUserByIdMap(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId",1);
        User userById2 = mapper.getUserById2(map);
        System.out.println(userById2);
        sqlSession.commit();

        sqlSession.close();
    }

   //根据id修改
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.updateUser(new User(1, "狂神update", "update_0000"));
        if (i>0){
            sqlSession.commit();
            System.out.println(i);
        }

        sqlSession.close();
    }

    //根据id删除
    @Test
    public void testDeleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUserById(4);
        if (i>0){
            sqlSession.commit();
            System.out.println(i);
        }

        sqlSession.close();
    }
}

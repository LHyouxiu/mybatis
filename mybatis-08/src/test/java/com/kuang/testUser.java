package com.kuang;

import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;

public class testUser {
    @Test
    public void testQueryUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        sqlSession.clearCache();//手动清除缓存

        User user1 = mapper.queryUserById(1);
        System.out.println(user1);
//        两次结果相等 查询语句直走一此，第二次走缓存
        System.out.println(user == user1);//true

        sqlSession.close();
    }

    @Test
    public void testQueryUserById2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

        User user1 = mapper2.queryUserById(2);
        System.out.println(user1);
//        两次结果相等 查询语句直走一此，第二次走缓存
        System.out.println(user == user1);//

        sqlSession.close();
    }

    @Test
    public void testUpdateQuery(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.queryUserById(1);
        System.out.println(user);

//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put("id","1");
//        hashMap.put("name","小明2222");
        HashMap hashMap = new HashMap();
        hashMap.put("id","1");
        hashMap.put("name","小明2222");
        mapper.updateUser(hashMap);

        User user1 = mapper.queryUserById(2);
        System.out.println(user1);

        System.out.println(user == user1);

        sqlSession.close();
    }

    @Test
    public void testCacheEnabled(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession1 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        sqlSession.close();

        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        //继续查询1 走缓存
        User user1 = mapper1.queryUserById(1);
//        User user1 = mapper1.queryUserById(2);
        System.out.println(user1);

        System.out.println(user == user1);
        sqlSession1.close();
    }
}

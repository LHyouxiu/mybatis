package com.kuang;

import com.kuang.dao.UserMapper;
import com.kuang.pojo.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
    static Logger logger = Logger.getLogger(UserMapperTest.class);

    @Test
    public void getLimitRowBound(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(1, 2);

        Cursor<Object> objects = sqlSession.selectCursor("com.kuang.dao.UserMapper.getLimitRowBounds", null, rowBounds);
        for (Object object : objects) {
            System.out.println(object);
        }
        sqlSession.close();
    }

    @Test
    public void getLimit(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("startIndex",1);
        stringIntegerHashMap.put("pageSize",2);

        List<User> userByLimit = mapper.getUserByLimit(stringIntegerHashMap);
        for (User user : userByLimit) {
            System.out.println(user);
        }

        sqlSession.close();
    }


    //查询所有
    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
            System.out.println(userById);

        sqlSession.close();
    }

    @Test
    public void log4jTest(){

        logger.info("info:进入log4j");
        logger.debug("debug:进入log4j");
        logger.error("error:进入log4j");
    }

}

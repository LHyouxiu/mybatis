package com.kuang;

import com.kuang.dao.BlogMapper;
import com.kuang.pojo.Blog;
import com.kuang.utils.IDUtil;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class addIntoBlog {
    @Test
    public void addBlogTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtil.getId());
        blog.setTitle("Mybatis添加");
        blog.setAuthor("添加");
        blog.setCreateTime(new Date());
        blog.setViews(99999);

        mapper.addBlog(blog);

        blog.setId(IDUtil.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDUtil.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);


        sqlSession.close();
    }

    @Test
    public void testQueryBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, String> stringHashMap = new HashMap<>();
        stringHashMap.put("title","Mybatis添加");
        stringHashMap.put("author","添加");
        List<Blog> blogs = mapper.queryBlogIf(stringHashMap);
        System.out.println(blogs);

        sqlSession.close();
    }

    @Test
    public void testAddBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("title","修改的title");
        hashMap.put("author","修改的作者");
        hashMap.put("id","1696ecb173694203b615c8ff9d487b4f");
        mapper.updateBlog(hashMap);

        sqlSession.close();
    }

    @Test
    public void testQueryBlogChoose(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("title","修改的title");
        hashMap.put("author",null);
        hashMap.put("views",null);
//        hashMap.put("author","修改的作者");
//        hashMap.put("views","99999");

        List<Blog> blogs = mapper.queryBlogChoose(hashMap);
        System.out.println(blogs);

        sqlSession.close();
    }

    @Test
    public void testQueryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap hashMap = new HashMap();
        ArrayList<String> integers = new ArrayList<String>();
        integers.add("1696ecb173694203b615c8ff9d487b4f");
        integers.add("1696ecb173694203b615c8ff9d487b4b");
        integers.add("1696ecb173694203b615c8ff9d487b4c");

//        修改 id 为1，2，3测试
//        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
        hashMap.put("ids",integers);

        List<Blog> blogs = mapper.queryBlogForeach(hashMap);
        System.out.println(blogs);

        sqlSession.close();
    }
}

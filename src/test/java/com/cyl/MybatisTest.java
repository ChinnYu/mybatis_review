package com.cyl;

import com.cyl.entity.Log;
import com.cyl.entity.Order;
import com.cyl.entity.Phone;
import com.cyl.entity.User;
import com.cyl.mapper.LogMapper;
import com.cyl.mapper.OrderMapper;
import com.cyl.mapper.PhoneMapper;
import com.cyl.mapper.UserMapper;
import com.cyl.util.SqlSessionFactoryUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author : Liu
 * @Date : 2019/11/8 下午 05:40
 * @Description :
 */

public class MybatisTest {

    @Test
    public void selectByUserNameTest(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("1.");
        User user1 = userMapper.getById(1);
        user1.setUsername("帥");
        System.out.println("2.");
        User user2 = userMapper.getById(1);
        System.out.println(user1 == user2);
        System.out.println(user2.getUsername());
        sqlSession.close();
    }


    @Test
    public void selectByUserNameTest2(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("1.");
        User user1 = userMapper.getById(1);
        user1.setUsername("rr");
        user1.setPassword("r55r");
        userMapper.insert(user1);
        System.out.println("2.");
        User user2 = userMapper.getById(1);
        System.out.println(user1 == user2);
        System.out.println(user2.getUsername());
        sqlSession.close();
    }

    @Test
    public void cacheTest2(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        System.out.println("1.");
        User user1 = userMapper.getById(1);
        user1.setUsername("rrd");
//        user1.setPassword("r55r");
//        userMapper.insert(user1);
        System.out.println("2.");
        User user2 = userMapper.getById(1);
        System.out.println(user1 == user2);
        System.out.println(user2.getUsername());
        sqlSession.close();

        sqlSession = SqlSessionFactoryUtils.getSqlSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
        User user3 = userMapper.getById(1);
        System.out.println(user3.getUsername());
    }
}

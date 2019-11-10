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
        User user = new User();
        user.setUsername("jas");
        userMapper.selectByUserName(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByUserNameTest2(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(1);
        user.setUsername("jas");
        List<User> list = userMapper.selectByUserName2(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByUserNameTest3(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
//        user.setId(1);
//        user.setUsername("jas");
        List<User> list = userMapper.selectByUserName3(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void selectByUserNameTest4(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
//        user.setId(1);
        user.setUsername("jas");
        List<User> list = userMapper.selectByUserName4(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserTest(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
//        user.setId(1);
//        user.setUsername("jasf");
        user.setId(1);
        user.setNote("22323232");
        long res = userMapper.updateUser(user);
        System.out.println(res);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delByArrayTest(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int[] arr = {5,6};
        long res = userMapper.delByArray(arr);
        System.out.println(res);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void delByListTest(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<Integer> list = new ArrayList<Integer>();
        list.add(3);
        long res = userMapper.delByList(list);
        System.out.println(res);
        sqlSession.commit();
        sqlSession.close();
    }
}

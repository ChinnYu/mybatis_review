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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : Liu
 * @Date : 2019/11/8 下午 05:40
 * @Description :
 */

public class MybatisTest {

    @Test
    public void factoryTest(){
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println(sqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void factoryTest2(){
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            System.out.println(sqlSession);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectClassicTest(){
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            Log log = sqlSession.selectOne("com.cyl.mapper.LogMapper.selectLog",1);
            System.out.println(log.getContent()+log.getCreateTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectTest(){
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
            Log log = logMapper.selectLog(1);
            System.out.println(log.getContent()+log.getCreateTime());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertTest(){
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
            Log log =  new Log();
            log.setContent("666");
            log.setCreateTime(new Date());
            long count = logMapper.insertLog(log);
            //引響行數
            System.out.println(count);
            //提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void delByIdTest(){
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
            long count = logMapper.delById(5);
            //引響行數
            System.out.println(count);
            //提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void updateTest(){
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
            Log log = new Log();
            log.setId(6);
            log.setContent("8888");
            log.setCreateTime(new Date());
            long count = logMapper.updateLog(log);
            //引響行數
            System.out.println(count);
            //提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listTest(){
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
            List<Log> list = logMapper.list();
            for (Log log :list){
                System.out.println(log.getContent());
            }
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void listTest2(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        LogMapper logMapper = sqlSession.getMapper(LogMapper.class);
        List<Log> list = logMapper.list();
        for (Log log :list){
            System.out.println(log.getContent());
        }
        sqlSession.commit();
    }

    @Test
    public void selectUserTest(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectUser(1);
        System.out.println(user);
    }

    @Test
    public void listByMapTest(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("username","j");
        map.put("note","2");
        List<User> list = userMapper.listByMap(map);
        for (User user1: list){
            System.out.println(user1.getUsername());
        }
    }

    @Test
    public void listByAnnotationTest(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = userMapper.listByAnnotation("j","k");
        for (User user1: list){
            System.out.println(user1.getUsername());
        }
    }

    @Test
    public void listByObjectTest(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("j");
        user.setPassword("k");
        List<User> list = userMapper.listByObject(user);
        for (User user1: list){
            System.out.println(user1.getUsername());
        }
    }

    @Test
    public void insertTest2(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("jaaa");
        user.setPassword("kaaa");
        user.setNote("kaaaaaaaa");
        user.setCreateTime(new Date());
        long count = userMapper.insert(user);
        System.out.println("影響行數"+ count);
        System.out.println("主鍵"+ user.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void listByTableNameTest(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Order> list = orderMapper.listByTableName("t_order_2018");
        System.out.println(list.size());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void phoneTest(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        PhoneMapper phoneMapper = sqlSession.getMapper(PhoneMapper.class);
        Phone phone = phoneMapper.getPhoneAndUser(1);
        System.out.println(phone.getBrand());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void phoneTest2(){
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        PhoneMapper phoneMapper = sqlSession.getMapper(PhoneMapper.class);
        Phone phone = phoneMapper.getPhoneAndUser2(1);
        System.out.println(phone.getBrand());
        sqlSession.commit();
        sqlSession.close();
    }

}

package com.cyl.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : Liu
 * @Date : 2019/11/8 下午 08:41
 * @Description :
 */

public class SqlSessionFactoryUtils {

    private SqlSessionFactoryUtils(){

    }

    private static SqlSessionFactory sqlSessionFactory;

    public static SqlSessionFactory getSqlSessionFactory(){
        synchronized (SqlSessionFactory.class){
            if (sqlSessionFactory != null){
                return sqlSessionFactory;
            }
            String resource = "mybatis-config.xml";
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            return sqlSessionFactory;
        }

    }

    public static SqlSession getSqlSession(){
        if (sqlSessionFactory == null){
            getSqlSessionFactory();
        }
        return sqlSessionFactory.openSession();
    }
}

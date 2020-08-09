package com.dahuang.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;

/**
 * 获取SQLSession对象和关闭
 * @author dahuang
 * @create 2020-08-08 15:42
 */
public class SqlSessionUtil {
    private static SqlSessionFactory factory;

    static {
        String config = "mybatis-config.xml";
        InputStream in = null;
        try {
            in = Resources.getResourceAsStream(config);
            factory = new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //用来存放是生成的sqlsession
    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();

    /**
     * 获取SqlSession对象
     * @return
     */
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession == null){
            sqlSession = factory.openSession();
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }

    /**
     * 关闭sqlSession对象
     * @param sqlSession
     */
    public static void closeSqlSession(SqlSession sqlSession){
        if (sqlSession != null){
            sqlSession.close();
            //一定要执行此操作，将对象移出
            threadLocal.remove();
        }
    }


}

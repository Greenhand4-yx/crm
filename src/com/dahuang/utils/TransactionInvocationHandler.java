package com.dahuang.utils;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dahuang
 * @create 2020-08-08 16:06
 */
public class TransactionInvocationHandler implements InvocationHandler {
    //声明目标对象
    private Object target;
    //给目标对象赋值
    public TransactionInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        SqlSession sqlSession = null;
        Object obj = null;
        try{
            sqlSession = SqlSessionUtil.getSqlSession();
            //处理业务逻辑方法
            obj = method.invoke(target, args);
            //处理完业务逻辑后，提交事务
            sqlSession.commit();
        }catch (Exception e){
            //出异常回滚事务
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            if (sqlSession != null){
                SqlSessionUtil.closeSqlSession(sqlSession);
            }
        }

        return obj;
    }

    /**
     *取得代理对象
     * @return
     */
    public Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }
}

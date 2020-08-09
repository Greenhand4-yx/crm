package com.dahuang.utils;

/**
 * @author dahuang
 * @create 2020-08-08 16:15
 */
public class ServiceFactory {
    public static Object getService(Object service){
        return new TransactionInvocationHandler(service).getProxy();
    }
}

package com.sunk.basic;


import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;

public class Part1 {
    private ThreadLocal<SimpleDateFormat> T = new ThreadLocal<>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("");
        }
    };


    @Test
    public void t1() {
        final UserStatus locked = UserStatus.LOCKED;
        System.out.println(locked.ordinal());;
        System.out.println(locked.name());
        System.out.println(UserStatus.valueOf("DISABLE"));


        System.out.println(locked.roleName);

    }

    /*
     * 更强的类型约束
     */
    enum UserStatus {
        NORMAL("admin", "1000"),
        LOCKED("user", "1001"),
        DISABLE("other", "1002");

        /*
         * 自定义属性
         */
        private final String roleName;
        private final String statueCode;

        /*
         * 自定义构造函数
         */
        UserStatus(String roleName, String statueCode) {
            this.roleName = roleName;
            this.statueCode = statueCode;
        }
    }


    // 动态代理类
    class DynamicProxy implements InvocationHandler {

        private Object object;

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("start invoke");
            final Object invoke = method.invoke(object, args);
            System.out.println("finish invoke");
            return invoke;
        }

        public Object getObject(Object targetObject) {
            this.object = targetObject;
            return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
        }
    }


}

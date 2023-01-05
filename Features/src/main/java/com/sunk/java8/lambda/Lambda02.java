package com.sunk.java8.lambda;

/**
 * 方法引用
 *
 * @author sunk
 * @since 2023/1/5
 **/
public class Lambda02 {

    public static void main(String[] args) {
        /*
         * 方法引用：有时候多个 lambda 表达式实现的函数一样，可以封装成通用的方法
         * - 对象::方法
         * - 类::静态方法
         */
        IF4 if4 = new Lambda02()::testImpl;
        IF4 if41 = Lambda02::testImpl2;
    }

    public boolean testImpl(int a, int b) {
        return a >= b;
    }

    public static boolean testImpl2(int a, int b) {
        return a >= b;
    }

    interface IF4 {
        boolean test(int a, int b);
    }

}

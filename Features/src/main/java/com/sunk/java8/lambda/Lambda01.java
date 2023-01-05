package com.sunk.java8.lambda;

/**
 * Lambda 表达式的基础使用
 *
 * @author sunk
 * @since 2023/1/5
 **/
public class Lambda01 {

    public static void main(String[] args) {
        // 1 无参无返回值
        IF1 if1 = () -> {
            System.out.println("IF1");
        };
        if1.test();


        // 2 无参有返回值
        IF2 if2 = () -> {
            return false;
        };
        System.out.println("IF2: " + if2.test());


        // 3 有参有返回值
        IF3 if3 = (int a) -> {
            return a >= 100;
        };
        System.out.println("IF3: " + if3.test(100));


        // 4 有多个参数有返回值
        IF4 if4 = (int a, int b) -> {
            return a >= b;
        };
        System.out.println("IF4: " + if4.test(100, 20));

        /*
         * 语法的省略
         * - 参数类型可以省略
         * - 只有一个参数，括号可以省略
         * - 方法体只有一条语句，大括号可以省略
         * - 方法体中只有一个 return 语句，那么省略大括号的同时也要省略 return 关键字
         */
        IF3 if31 = a -> a >= 100;
        IF4 if41 = (a, b) -> a > b;
    }


    interface IF1 {
        void test();
    }


    interface IF2 {
        boolean test();
    }

    interface IF3 {
        boolean test(int a);
    }

    interface IF4 {
        boolean test(int a, int b);
    }
}

package com.sunk.java8.lambda;

/**
 * \@FunctionalInterface 注解
 *
 * @author sunk
 * @since 2023/1/5
 **/
public class Lambda05 {


    public static void main(String[] args) {

        /*
         * @FunctionalInterface 注解
         *
         * - 这个注解是函数式接口注解，所谓的函数式接口，首先是一个接口，其次这个接口里面只能有一个抽象方法
         * - 这种类型的接口也称为 SAM 接口，即 Simple Abstract Method Interfaces
         *
         * - 此类接口特点
         *      - 接口有且仅有一个抽象方法
         *      - 允许定义静态方法
         *      - 允许定义默认方法
         *      - 允许 Object 中的 public 方法
         *      - 该注解不是必须的，如果接口复合 SAM 的定义那么不加此注解也可以，但是如果加上了这个注解就必须是函数式接口，否则编译器会报错
         */
    }

    @FunctionalInterface
    interface IF1 {

        // 抽象方法
        void add();

        // Object 中的 public 方法
        public boolean equals(Object var1);

        // 默认方法
        public default void defaultMethod() {
            System.out.println("DEFAULT");
        }

        // 静态方法
        public static void add2() {
            System.out.println("STATIC ADD2");
        }
    }

}

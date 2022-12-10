package com.sunk.chapter05;


public class Compare {

    public static void main(String[] args) {

        // 等于：“==” 和 equals
        /*
         * - 基本数据类型，“==” 仅比较数值大小
         */
        int i = 10;
        int j = 10;
        System.out.println(i == j);     // true
        double d = 10.0d;
        System.out.println(i == d);     // true

        /*
         * - 字符串
         */
        // 对于引用数据类型，“==” 比较内存地址
        // jvm 优化将字符串封装为常量，存入字符串常量池，s1，s2指向相同的内存地址
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);   // true
        // new String 会创建一个新的字符串对象
        final String s3 = new String("abc");
        System.out.println(s1 == s3);   // false
        // 比较字符串的内容，使用 equals 方法进行比较，String 类重写了 equals 方法
        System.out.println(s1.equals(s3));  // true

        /*
         * - 自定义类
         */
        final User user1 = new User();
        final User user2 = new User();
        // new 了两个对象，在内存中的地址不同
        System.out.println(user1 == user2);     // false
        // 未重写 equals 的默认情况下 equals 方法使用 “==” 进行比较
        System.out.println(user1.equals(user2));    // false

        final User2 user21 = new User2();
        final User2 user22 = new User2();
        System.out.println(user21.equals(user22));  // true

        /*
         * - 包装类
         *
         * int => Integer JVM 为了操作方便，简化了很多操作
         * Integer 中有一个缓存类，对于在缓存范围[-128~127]之内的不会 new 出来，“==” 比较时会相等
         * 所以引用类型的比较都是用 equals
         */
        Integer i1 = 100;
        Integer i2 = 100;
        System.out.println(i1 == i2);       // true

        Integer i3 = 1000;
        Integer i4 = 1000;
        System.out.println(i3 == i4);       // false

    }
}

class User {

}

class User2 {
    @Override
    public boolean equals(Object obj) {
        // 自定义认为相等的规则
        if (obj instanceof User2) {
            return true;
        }

        return false;
    }

    @Override
    public int hashCode() {
        // 一般重写 equals 方法，都会重写 hashcode 方法 ？？？
        return 1;
    }
}

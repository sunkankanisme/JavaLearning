package com.sunk.chapter04;


public class ObjectTest10 {

    public static void main(String[] args) {
        final User10 user10 = new User10();
        user10.test();
    }

}

class Person10 {
    public String name = "zhangsan";
}

class User10 extends Person10 {
    public String name = "lisi";

    public void test() {
        String name = "wangwu";
        System.out.println(name);
    }

    public void test2() {
        System.out.println(name);
    }
}




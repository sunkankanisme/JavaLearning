package com.sunk.chapter04;

public class ObjectTest2 {

    public static void main(String[] args) {

    }

}

class Parent {
    String name = "zhangsan";

    void test() {
        System.out.println("PARENT_TEST");
    }
}

class Child extends Parent {
    String name = "xiaozhang";


    @Override
    void test() {
        System.out.println("CHILD TEST");
    }
}

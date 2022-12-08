package com.sunk.chapter04;


public class ObjectTest8 {

    public static void main(String[] args) {
        final Me me = new Me();

        // 内部类继承抽象类
        me.sayHello(new Person() {
            @Override
            public String getName() {
                return "zhang san";
            }
        });

        // 内部类实现接口
        new Fly() {
            @Override
            public void fly() {
                System.out.println("i am fly ...");
            }
        }.fly();
    }
}

abstract class Person {
    public abstract String getName();
}

class Me {
    public void sayHello(Person person) {
        System.out.println("Hello " + person.getName());
    }
}

interface Fly {
    void fly();
}




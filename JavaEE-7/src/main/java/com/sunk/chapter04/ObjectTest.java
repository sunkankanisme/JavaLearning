package com.sunk.chapter04;


import java.util.Arrays;

public class ObjectTest {

    public static void main(String[] args) {
        final Dog dog = new Dog();
        dog.speak("旺~");
    }

}

class Animal {
    String color = "black";

    void speak(String sth) {
        System.out.println("speak: " + sth);
    }
}

class Dog extends Animal {

}

class Cat extends Animal {
    String color = "red";

    @Override
    void speak(String sth) {
        System.out.println("I am Cat");
    }

    public String returnColors() {
        // 使用 super 获取父类的属性和方法
        final String parentColor = super.color;
        // 使用 this 获取当前类的属性和方法，默认可以省略
        final String sonColor = this.color;

        return parentColor + " -> " + sonColor;
    }
}


class Parent {
    String name;

    public Parent() {

    }

    public Parent(String name) {
        this.name = name;
    }
}

class Son extends Parent {

    public Son() {

    }

    public Son(String name) {
        super(name);
    }
}






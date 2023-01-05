package com.sunk.java8.lambda;

import com.sunk.java8.lambda.beans.Dog;

import java.util.ArrayList;
import java.util.function.Consumer;

/**
 * 应用实例
 *
 * @author sunk
 * @since 2023/1/5
 **/
public class Lambda04 {

    public static void main(String[] args) {
        final ArrayList<Dog> list = new ArrayList<>();
        list.add(new Dog("2", 2));
        list.add(new Dog("1", 1));
        list.add(new Dog("5", 200));
        list.add(new Dog("4", 4));
        list.add(new Dog("3", 3));
        System.out.println(list);

        // 使用 lambda 进行集合排序
        list.sort((d1, d2) -> d1.getAge() - d2.getAge());
        System.out.println(list);

        // 使用 lambda 遍历集合
        list.forEach(new Consumer<Dog>() {
            @Override
            public void accept(Dog dog) {
                System.out.println(dog);
            }
        });

        list.forEach((dog) -> System.out.println(dog));

        list.forEach(System.out::println);

        // 方法引用需要与接口中的方法一致
        // list.forEach(Lambda04::printDog);
    }

    public static void printDog(Dog dog, String other) {
        System.out.println(dog + " | " + other);
    }

}

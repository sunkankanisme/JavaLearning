package com.sunk.java8.lambda;

import com.sunk.java8.lambda.beans.Dog;

/**
 * 构造方法引用
 *
 * @author sunk
 * @since 2023/1/5
 **/
public class Lambda03 {

    public static void main(String[] args) {
        /*
         * 构造方法引用
         */

        // 经典 lambda
        DogService dogService = () -> new Dog();
        System.out.println(dogService.getDog());

        // 使用构造方法引用
        DogService dogService2 = Dog::new;
        System.out.println(dogService2.getDog());

        // 有参使用构造方法引用
        DogService2 dogService21 = Dog::new;
        dogService21.getDog("旺财", 200);

    }

    interface DogService {
        Dog getDog();
    }

    interface DogService2 {
        Dog getDog(String name, int age);
    }

}

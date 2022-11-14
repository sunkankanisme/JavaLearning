package com.sunk.interview;

import java.io.Serializable;
import java.util.Collections;

public class Singleton {

    public static void main(String[] args) {
        Runtime.getRuntime().gc();

        System.gc();


    }

    static class SingletonE implements Serializable {
        private static final SingletonE instance = new SingletonE();

        private SingletonE() {
            // 预防使用反射破坏单例的手段
            if (instance != null) {
                throw new RuntimeException("单例对象不能重复创建");
            }
        }

        public static SingletonE getInstance() {
            return instance;
        }

        // 预防使用序列化破坏单例的手段
        public Object readResolve() {
            return instance;
        }
    }

    /*
     * 使用枚举类创建单例
     */
    enum Sex {
        MAIL, FEMALE
    }

    enum SingletonEnum {
        INSTANCE;

        private SingletonEnum() {
            System.out.println("private SingletonEnum");
        }

        public static SingletonEnum getInstance() {
            return INSTANCE;
        }
    }


    /*
     * 懒汉式单例
     */
    static class SingletonL {
        /*
         * 保证线程之间的可见性和有序性
         */
        private static volatile SingletonL INSTANCE = null;

        private SingletonL() {
        }

        // 双重检查锁
        public static SingletonL getINSTANCE() {
            if (INSTANCE == null) {
                synchronized (SingletonL.class) {
                    if (INSTANCE != null) {
                        INSTANCE = new SingletonL();
                    }
                }
            }

            return INSTANCE;
        }
    }
}

/*
 * 懒汉式单例
 */
class SingletonInnerClass implements Serializable {
    private SingletonInnerClass() {

    }

    /*
     * 创建静态内部类
     */
    private static class Holder {
        static SingletonInnerClass INSTANCE = new SingletonInnerClass();
    }

    public static SingletonInnerClass getInstance() {
        return Holder.INSTANCE;
    }
}

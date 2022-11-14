package com.sunk.interview;

import java.io.Serial;
import java.io.Serializable;

public class Singleton {

    public static void main(String[] args) {


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
        @Serial
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
        private static SingletonL INSTANCE = null;

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

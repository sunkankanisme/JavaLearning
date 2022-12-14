package com.sunk.chapter09;

public class ThreadTest01 {

    public static void main(String[] args) throws InterruptedException {
        final MyThread1 thread1 = new MyThread1();
        final MyThread2 thread2 = new MyThread2();

        thread1.start();
        thread2.start();

        // 将线程连接成串
        thread1.join();
        thread2.join();

        System.out.println("Main 线程执行完毕");
    }

    /*
     * 构建自定义线程类
     * - 继承 Thread 类，重写 run 方法
     */
    static class MyThread1 extends Thread {

        @Override
        public void run() {
            System.out.println("My Thread 1: " + Thread.currentThread().getName());
        }

    }

    static class MyThread2 extends Thread {

        @Override
        public void run() {
            System.out.println("My Thread 2: " + Thread.currentThread().getName());
        }

    }

}

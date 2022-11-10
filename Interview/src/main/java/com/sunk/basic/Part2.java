package com.sunk.basic;


import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Part2 {

    @Test
    public void test1() throws ExecutionException, InterruptedException {

        // 1 继承 thread 重写 run 方法
        final Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("1");
            }
        };

        t1.start();


        final Thread t2 = new Thread(new MyRun());
        t2.start();


        final FutureTask<String> task = new FutureTask<>(new MyCall());
        final Thread t3 = new Thread(task);
        t3.start();
        final String res = task.get();
        System.out.println(res);
    }


    class MyRun implements Runnable {

        @Override
        public void run() {
            System.out.println("2");
        }
    }

    class MyCall implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println("3");
            return "CALLABLE";
        }
    }

    @Test
    public void test2() throws InterruptedException {
        /*
         * 线程的状态
         *
         * - NEW：初始化态，任务创建完成，未调用start
         * - RUNNABLE：运行态
         *   - ready：准备态
         *   - running：执行态
         * - BLOCKED：阻塞态
         * - WAITING：等待状态
         * - TIMED_WAITING：等待固定时间
         * - TERMINATED：结束态
         */
        final Thread t = new Thread(() -> {
            System.out.println("--- start");
            try {
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("--- end");
        });

        System.out.println(t.getState());
        t.start();
        System.out.println(t.getState());
        Thread.sleep(1000);
        System.out.println(t.getState());
        Thread.sleep(3000);
        System.out.println(t.getState());
    }

    /*
     * sleep 和 wait
     *
     * sleep 不释放锁，sleep 时线程类的方法，可以在任何场景下使用，除去出现异常只能等待sleep完成
     *
     * wait  释放锁，Object 对象的，必须在同步块使用，可以使用 notify 随时唤醒
     *
     */

    /*
     *
     *
     *
     *
     */

}

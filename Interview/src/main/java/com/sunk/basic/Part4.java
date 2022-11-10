package com.sunk.basic;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author sunk
 * @description
 * @create 2022/11/10
 **/
public class Part4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        final MyTask myTask1 = new MyTask(100);
        final FutureTask<Boolean> futureTask1 = new FutureTask<>(myTask1);
        final MyTask myTask2 = new MyTask(200);
        final FutureTask<Boolean> futureTask2 = new FutureTask<>(myTask2);
        final MyTask myTask3 = new MyTask(300);
        final FutureTask<Boolean> futureTask3 = new FutureTask<>(myTask3);


        new Thread(futureTask1).start();
        new Thread(futureTask2).start();
        new Thread(futureTask3).start();

        if (futureTask1.get() && futureTask2.get() && futureTask3.get()) {
            System.out.println("All Task Finished");
        }


        System.out.println("Continue Main");
    }


    static class MyTask implements Callable<Boolean> {

        private final int runTimes;


        public MyTask(int runTimes) {
            this.runTimes = runTimes;
        }

        @Override
        public Boolean call() throws Exception {

            for (int i = 0; i < runTimes; i++) {
                System.out.println("RUN: " + i + ", " + Thread.currentThread().getName());
                Thread.sleep(100);
            }

            return true;
        }
    }


}


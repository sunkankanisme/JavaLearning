package com.sunk.interview;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {

        final AtomicInteger atomicInteger = new AtomicInteger(1);
        final ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(2);
        new ThreadPoolExecutor(2, 3, 0, TimeUnit.MINUTES, queue,
                r -> new Thread(r, "myThread_" + atomicInteger.incrementAndGet()),
                new ThreadPoolExecutor.CallerRunsPolicy());

        final ReentrantLock lock = new ReentrantLock();

        final Condition c1 = lock.newCondition();
        final Condition c2 = lock.newCondition();

        c1.await();
        c1.signal();









    }

    private static void testWait() throws InterruptedException {

        synchronized (ThreadTest.class) {
            ThreadTest.class.wait();

        }

    }

    private static void testBlocked() {
        final Thread t2 = new Thread(() -> {
            System.out.println("t2 before sync");

            synchronized (ThreadTest.class) {
                System.out.println("t2 in sync");
            }
        }, "t2");

        t2.start();
        System.out.println("t2 state " + t2.getState());

        synchronized (ThreadTest.class) {
            System.out.println("t2 state " + t2.getState());
        }

        System.out.println("t2 state " + t2.getState());
    }


    private static void testNewRunnableTerminated() {
        final Thread t1 = new Thread(() -> {
            System.out.println("running ...");
        }, "t1");

        System.out.println("state " + t1.getState());
        t1.start();

        System.out.println("state " + t1.getState());

        System.out.println("state " + t1.getState());
    }

}

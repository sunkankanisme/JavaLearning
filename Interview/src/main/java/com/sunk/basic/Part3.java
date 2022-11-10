package com.sunk.basic;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * 生产者消费者模型
 */
public class Part3 {

    public static void main(String[] args) {
        final Buffer buffer = new Buffer();

        final Producer producer = new Producer(buffer);
        final Consumer consumer = new Consumer(buffer);

        consumer.start();
        producer.start();

        // cas
        AtomicInteger num = new AtomicInteger(1);
        num.compareAndSet(1, 2);
        num.incrementAndGet();


    }


    static class Producer extends Thread {
        private Buffer buffer;

        public Producer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    buffer.add(i);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    static class Consumer extends Thread {
        private Buffer buffer;

        public Consumer(Buffer buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                final int value;
                try {
                    value = buffer.pull();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(value);
            }
        }
    }


    static class Buffer {
        private Queue<Integer> queue = new LinkedList<>();
        private int size = 5;

        public synchronized void add(int value) throws InterruptedException {
            if (queue.size() > size) {
                // 队列满了，阻塞生产者
                wait();
            }

            queue.add(value);
            notify();

        }

        public synchronized int pull() throws InterruptedException {
            if (queue.size() == 0) {
                wait();
            }

            int value = queue.poll();
            notify();
            return value;
        }

    }

}

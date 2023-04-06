package com.sunk.chapter09;


public class ThreadTest02 {

    public static void main(String[] args) throws InterruptedException {
        synchronized (Object.class) {

        }

        final User user = new User();
        user.wait();

    }

    static class User {
        public synchronized void test() {

        }
    }

}

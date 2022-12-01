package com.sunk.interview;

import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

public class Test {

    public static void main(String[] args) throws IOException, InterruptedException {
        // weakReference
        final WeakReference<Dog> weakReference = new WeakReference<>(new Dog("weakReference"));
        // softReference
        final SoftReference<Dog> softReference = new SoftReference<>(new Dog("softReference"));
        // phantomReference
        final ReferenceQueue<Dog> dogReferenceQueue = new ReferenceQueue<>();
        final PhantomReference<Dog> phantomReference = new PhantomReference<>(new Dog("phantomReference"), dogReferenceQueue);

        final Dog hard = new Dog("HARD");

        System.gc();
        System.in.read();

        System.gc();
        System.in.read();
    }


    static class Dog {

        private final String name;

        public Dog(String name) {
            this.name = name;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println(name + ": 我被回收了，5555~");
        }
    }
}

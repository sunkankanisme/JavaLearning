package com.sunk.chapter07;


import java.util.concurrent.ArrayBlockingQueue;

public class CollectionTest07 {

    public static void main(String[] args) throws InterruptedException {
        // 固定长度队列
        final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

        // 1 add 方法添加数据，超过总长度直接报错
        queue.add("zhangsan");
        queue.add("lisi");
        queue.add("wangwu");
        System.out.println(queue);

        // 2 put 方法添加数据，超过总长度，则线程会阻塞住
        // queue.put("zhaoliu");
        // System.out.println(queue);

        // 3 offer 添加数据返回是否添加成功的 bool
        final boolean offer = queue.offer("100");
        System.out.println(offer);
        System.out.println(queue);      // [zhangsan, lisi, wangwu]

        // 4 poll 拉取最先的数据，拉取不到返回 null
        final String poll1 = queue.poll();
        final String poll2 = queue.poll();
        final String poll3 = queue.poll();
        final String poll4 = queue.poll();
        System.out.println(poll1 + " | " + poll2 + " | " + poll3 + " | " + poll4);

        System.out.println(queue);      // [lisi, wangwu]

        // 5 阻塞拉取数据，当没有数据时队列会阻塞
        final String take1 = queue.take();
        final String take2 = queue.take();
        final String take3 = queue.take();

        // 6 其他 api
        queue.size();
        queue.clear();


    }

}

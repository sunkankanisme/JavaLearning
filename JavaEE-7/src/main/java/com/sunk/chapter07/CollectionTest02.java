package com.sunk.chapter07;


import java.util.LinkedList;

public class CollectionTest02 {

    public static void main(String[] args) {

        final LinkedList<String> list = new LinkedList<>();
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");

        // 1 push 数据添加到头
        list.push("push");

        // 2 pop 弹出第一个元素
        list.pop();

    }

}

package com.sunk.chapter05;


public class StringTest {

    public static void main(String[] args) {

        final StringBuilder builder = new StringBuilder();
        // 拼接字符串
        builder.append(1);
        builder.append("a");
        builder.append(true);

        // 翻转字符串
        builder.reverse();

        // 指定位置插入
        builder.insert(1, "--");

        final String s = builder.toString();
        System.out.println(s);      // e--urta1

    }
}

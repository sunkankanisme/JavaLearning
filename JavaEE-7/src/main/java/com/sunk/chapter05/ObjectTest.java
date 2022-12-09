package com.sunk.chapter05;


public class ObjectTest {

    public static void main(String[] args) {
        // 声明一个数组
        String[] names;

        // 定义一个数组
        names = new String[3];

        // 通过索引值向数组中添加数据
        names[0] = "zhangsan";
        names[0] = "zhaoliu";
        names[1] = "lisi";
        names[2] = "wangwu";

        // 数组下标越界
        // 添加和访问数据时，索引不能超过指定的范围 (0 ~ length -1)
        // names[3] = "xxx";

        // 访问数据中的元素
        System.out.println(names[0]);       // zhaoliu
        System.out.println(names[1]);       // lisi
        System.out.println(names[2]);       // wangwu

        System.out.println("===============");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        String[][] strss = new String[3][3];
        strss[1][1] = "1,1";
        strss[1][2] = "1,2";



    }

}

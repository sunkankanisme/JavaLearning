package com.sunk.chapter07;


import java.util.ArrayList;

public class CollectionTest01 {

    public static void main(String[] args) {

        final ArrayList<String> list = new ArrayList<>(16);
        list.add("zhangsan");
        list.add("lisi");
        list.add("wangwu");
        list.add("zhangsan");
        System.out.println(list);       // [zhangsan, lisi, wangwu, zhangsan]

        // 1 add 可以插入到位置，后续数据会向后移动
        list.add(1, "zhaoliu");
        System.out.println(list);       // [zhangsan, zhaoliu, lisi, wangwu, zhangsan]

        // 2 addAll 将集合中的数据加入数组
        final ArrayList<String> strings = new ArrayList<>();
        strings.add("other1");
        strings.add("other2");
        list.addAll(strings);
        System.out.println(list);       // [zhangsan, zhaoliu, lisi, wangwu, zhangsan, other1, other2]

        // 3 判断集合是否为空
        System.out.println(list.isEmpty());     // false

        // 4 清空集合，删除所有数据
        // list.clear();

        // 5 对应 addAll，此方法删除 list 中存在于 strings 的数据
        list.removeAll(strings);

        // 6 判断 list 是否包含指定数据
        System.out.println(list.contains("lisi"));      // true
        System.out.println(list.contains("abc"));       // false

        // 7 判断数据在集合中位置，不存在返回 -1，存在多个相同元素时返回第一个元素位置
        System.out.println(list.indexOf("zhangsan"));           // 0
        System.out.println(list.indexOf("abc"));                // -1
        System.out.println(list.lastIndexOf("zhangsan"));    // 4

        // 8 将集合转换为数组
        final Object[] array = list.toArray();

        // 9 数组复制
        final ArrayList clone = (ArrayList<String>) list.clone();

    }

}

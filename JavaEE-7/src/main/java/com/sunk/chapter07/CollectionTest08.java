package com.sunk.chapter07;


import java.util.HashMap;

public class CollectionTest08 {

    public static void main(String[] args) {
        final HashMap<String, String> map = new HashMap<>();

        // 1 添加数据 - 根据 key 确定 hash 值
        map.put("zhangsan", "1");
        map.put("lisi", "2");
        System.out.println(map);        // {lisi=2, zhangsan=1}

        // 2 更新数据 - 存入相同的 key 而 value 不同时会覆盖 value 的值，返回旧值
        final String old = map.put("zhangsan", "100");
        System.out.println(map);        // {lisi=2, zhangsan=100}

        // 3 查询数据 - 按照 key 进行查询
        final String value = map.get("zhangsan");
        System.out.println(value);

    }

}

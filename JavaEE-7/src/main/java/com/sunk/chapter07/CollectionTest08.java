package com.sunk.chapter07;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

        // 4 插入数据，不存在就放，存在就忽略
        map.putIfAbsent("zhangsan", "200");

        // 5 修改数据，不存在数据就忽略
        map.replace("zhangsan", "800");

        // 6 清空数据
        map.clear();

        // 7 取出所有的 key
        final Set<String> keySet = map.keySet();
        final boolean b = map.containsKey("");

        // 8 获取所有的 value
        final Collection<String> values = map.values();
        final boolean b1 = map.containsValue("");

        // 9 获取所有的 key 和 value
        final Set<Map.Entry<String, String>> entries = map.entrySet();

        // 10 遍历 map
        for (String s : keySet) {
            System.out.println(s + " | " + map.get(s));
        }

        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " | " + entry.getValue());
        }

        // 11 移除对象 - 按照 key
        map.remove("zhangsan");

        // 12 移除对象 - 按照 key + value
        map.remove("zhangsan", "1000");

    }

}

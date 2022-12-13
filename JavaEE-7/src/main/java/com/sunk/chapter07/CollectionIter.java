package com.sunk.chapter07;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CollectionIter {

    public static void main(String[] args) {
        final HashMap<String, Integer> map = new HashMap<>();

        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        final Set<String> keys = map.keySet();

        // 遍历过程中修改会出现异常
        for (String s : keys) {
            // java.util.ConcurrentModificationException
            // if ("b".equals(s)) {
            //     map.remove(s);
            // }

            System.out.println(s + " | " + map.get(s));
        }

        System.out.println("=================");
        // 使用迭代器进行遍历
        final Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            final String nextKey = iterator.next();

            // 使用 remove 删除当前的 key
            if ("b".equals(nextKey)) {
                iterator.remove();
            }

            System.out.println(nextKey + " | " + map.get(nextKey));
        }
    }

}

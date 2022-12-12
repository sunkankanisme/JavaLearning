package com.sunk.chapter07;


import java.util.ArrayList;
import java.util.Comparator;

public class CollectionTest05 {

    public static void main(String[] args) {
        final ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(8);
        list.add(2);
        list.add(4);
        System.out.println(list);       // [1, 3, 8, 2, 4]

        // 1
        list.sort(new NumComparator());
        System.out.println(list);       // [1, 2, 3, 4, 8]
    }

    static class NumComparator implements Comparator<Integer> {

        /*
         * 定义比较规则
         * - 第一个数比第二个大，返回正数，升序排序
         * - 第一个数比第二个小，返回负数，降序排序
         * - 两数相等，返回零
         */
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }

    }
}

package com.sunk.chapter07;


import java.util.Arrays;
import java.util.List;

public class CollectionTools {

    public static void main(String[] args) {

        // 打印集合（数组）
        final int[] ints = {3, 1, 2};
        final int[] ints2 = {1, 2, 3, 4, 5};
        final String arrStr = Arrays.toString(ints);

        // 元素转集合
        final List<Integer> integers = Arrays.asList(1, 2, 3);

        // 集合排序
        Arrays.sort(ints);

        // 二分查找
        final int index = Arrays.binarySearch(ints, 2);

        // 数组的比较 - 相同的位置每个元素都相等
        final boolean b1 = Arrays.equals(ints2, ints);
        final boolean b2 = Arrays.equals(ints2, 0, 3, ints, 0, 3);

    }

}

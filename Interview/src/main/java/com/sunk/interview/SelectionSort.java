package com.sunk.interview;

import java.util.Arrays;

import static com.sunk.interview.BubbleSort.swap;

/*
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] a = {5, 3, 7, 2, 1, 9, 8, 4};
        selection(a);
    }

    private static void selection(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            // i 代表每一轮选择最小的元素需要存入的下标

            // s 代表当前轮最小元素的索引
            int s = i;

            // 每一轮循环的开始从 s+1 开始
            for (int j = s + 1; j < a.length - 1; j++) {
                if (a[s] > a[j]) {
                    s = j;
                }
            }

            // 将最小值存入索引位置
            if (s != i) {
                swap(a, s, i);
            }

            System.out.println(i + " " + Arrays.toString(a));
        }
    }


}

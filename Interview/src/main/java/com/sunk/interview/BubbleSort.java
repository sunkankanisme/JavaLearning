package com.sunk.interview;

import java.util.Arrays;

/*
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {5, 9, 7, 4, 1, 3, 2, 8};
        // bubble(a);
        bubbleV2(a);
    }

    /*
     * 冒泡算法的实现
     */
    public static void bubble(int[] a) {
        for (int j = 0; j < a.length - 1; j++) {
            // 优化 2: 定义一个变量用于标识当前轮是否发生了交换
            // 如果一轮没有发生交换,说明数组已经有序
            boolean swapped = false;

            // 优化 1: 内层循环用于 2 个数字比较, 由于每一轮之后都可以减少一次比较
            // 所以可以利用 j减少内层循环的次数
            for (int i = 0; i < a.length - j - 1; i++) {
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    swapped = true;
                }
            }

            System.out.println(j + ": " + Arrays.toString(a));
            if (!swapped) break;
        }
    }

    public static void bubbleV2(int[] a) {
        int n = a.length - 1;

        while (true) {
            // 表示最后一次发生交换时的索引位置
            int last = 0;

            for (int i = 0; i < n; i++) {
                System.out.println("比较次数: " + i);
                if (a[i] > a[i + 1]) {
                    swap(a, i, i + 1);
                    last = i;
                }
            }

            System.out.println(Arrays.toString(a));

            n = last;
            if (n == 0) break;
        }
    }


    public static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }


}

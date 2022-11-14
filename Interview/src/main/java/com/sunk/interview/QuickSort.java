package com.sunk.interview;

import java.util.Arrays;

import static com.sunk.interview.BubbleSort.swap;

/*
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] a = {5, 3, 7, 2, 9, 8, 1, 4};
        quick(a, 0, a.length - 1);

        System.out.println(Arrays.toString(a));
    }

    public static void quick(int[] a, int low, int high) {
        // 只有一个元素或没有元素的时候完成递归
        if (low >= high) return;

        // p 为基准点的正确索引值
        int p = partition2(a, low, high);

        // 左边递归, 修改范围
        quick(a, low, p - 1);

        // 右边递归, 修改范围
        quick(a, p + 1, high);
    }

    /*
     * 分区方法
     *
     * 返回值: 代表基准点元素所在的正确索引, 用它可以确定下一轮分区的边界
     */
    private static int partition(int[] a, int low, int high) {
        // 定义基准点元素
        int pv = a[high];

        // i 是边界为止
        int i = low;

        // j 从边界开始, 到基准点元素的前一个元素为止
        for (int j = low; j < high; j++) {
            // 查找小于基准点的元素, 找到之后与 i 交换, i++
            if (a[j] < pv) {
                // 优化 2 当 i != j 时再交换
                if (i != j) {
                    swap(a, i, j);
                }

                i++;
            }
        }
        // 将基准点与 i 进行交换, 优化 1 当 i != high 时再交换
        if (i != high) {
            swap(a, i, high);
        }

        System.out.println("MIDDLE: " + i + " " + Arrays.toString(a));

        return i;
    }

    /*
     * 双边循环快排
     */
    private static int partition2(int[] a, int low, int high) {
        // 定义基准点元素
        int pv = a[low];

        int i = low;
        int j = high;

        while (i < j) {
            System.out.println(i + ", " + j + ", " + Arrays.toString(a));
            /*
             * j 从右向左找比基准点小的
             * [i < j]: j 查找之后,作为边界已经发生了改变,所以需要动态的判断
             *
             * 必须先运行 j 找小的的逻辑, 因为最后一步 swap(a, low, i) 会出现问题
             */
            while (i < j && a[j] > pv) {
                j--;
            }

            /*
             * i 从左向右找比基准点大的
             * [i < j]:
             * [<=]: i 的第一个元素就是 pv 要使 i 指针向后移动进行查找条件要更改为 a[i] <= pv
             */
            while (i < j && a[i] <= pv) {
                i++;
            }

            swap(a, i, j);
        }

        // 基准点元素与 i/j 元素进行交换
        swap(a, low, i);

        System.out.println("MIDDLE: " + i + " " + Arrays.toString(a));
        return i;
    }


}

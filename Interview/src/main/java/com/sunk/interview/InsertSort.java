package com.sunk.interview;

import java.util.Arrays;

/*
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] a = {9, 3, 7, 2, 5, 8, 1, 4};
        insert(a);
    }

    public static void insert(int[] a) {
        // i 代表待插入元素的索引
        for (int i = 1; i < a.length; i++) {
            // 将待插入的值存入临时变量, 因为后续操作会将当前索引的值覆盖掉
            int t = a[i];

            // j 代表前面部分有序的数组的索引
            // 将比 t 大的有序数组元素向后移动
            int j = i - 1;
            while (j >= 0) {
                if (t < a[j]) {
                    a[j + 1] = a[j];
                } else {
                    // 在有序数组中, 当元素比 t 小之后, 之前的元素就不需要比较了
                    break;
                }

                j--;
            }

            a[j + 1] = t;
            System.out.println(i + " " + Arrays.toString(a));
        }

    }

}

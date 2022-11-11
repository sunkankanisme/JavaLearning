package com.sunk.interview;

public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 5, 8, 11, 19, 22, 31, 35, 40, 45, 48, 49, 80};
        int target = 48;

        int res = binarySearch(array, target);
        System.out.println(res);
    }

    /*
     * 经典二分查找
     */
    private static int binarySearch(int[] array, int target) {
        int l = 0, r = array.length - 1, m;

        while (l <= r) {
            m = (l + r) / 2;

            /*
             * 解决整数溢出问题
             *
             * --- 方案一
             *     (l + r) / 2
             * => l/2 + r/2
             * => l - l/2 + r/2
             * => l - (l/2 - r/2)
             * => l + (r/2 - l/2)
             * => l + (r - l) / 2
             *
             * --- 方案二，使用无符号的右移运算
             * (l + r) >>> 1
             *
             */

            if (array[m] == target) {
                return m;
            } else if (array[m] > target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }
}

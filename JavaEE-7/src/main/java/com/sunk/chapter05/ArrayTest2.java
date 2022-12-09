package com.sunk.chapter05;


import java.util.Arrays;

public class ArrayTest2 {

    public static void main(String[] args) {

    }

    public void sort1() {
        int[] nums = {1, 4, 3, 5, 2};
        System.out.println(Arrays.toString(nums));

        // 希望得到 1,2,3,4,5
        // 1 简化需求：将数组中最大的元素放置到最后
        for (int i = 0; i < nums.length - 1; i++) {
            int num1 = nums[i];
            int num2 = nums[i + 1];
            // 左边大于右边，交换位置
            if (num1 > num2) {
                nums[i] = num2;
                nums[i + 1] = num1;
            }
        }
        System.out.println(Arrays.toString(nums));

        // 2 将剩余的数据进行排序
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                int num1 = nums[j];
                int num2 = nums[j + 1];
                // 左边大于右边，交换位置
                if (num1 > num2) {
                    nums[j] = num2;
                    nums[j + 1] = num1;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public void sort2() {
        int[] nums = {1, 4, 3, 5, 2};
        System.out.println(Arrays.toString(nums));

        int maxIndex = 0;
        for (int j = 0; j < nums.length; j++) {
            for (int i = 1; i < nums.length - j; i++) {
                if (nums[i] > nums[maxIndex]) {
                    maxIndex = i;
                }
            }

            // 将最大值放到最后一个位置
            final int num1 = nums[nums.length - j - 1];
            final int num2 = nums[maxIndex];
            nums[nums.length - j - 1] = num2;
            nums[maxIndex] = num1;
        }
        System.out.println(Arrays.toString(nums));
    }
}

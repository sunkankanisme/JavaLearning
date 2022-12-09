package com.sunk.chapter05;


public class ArrayTest3 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int target = 6;
        int start = 0;
        int end = nums.length - 1;
        int middle = 0;

        while (start <= end) {
            middle = start + (end - start) / 2;
            if (nums[middle] > target) {
                end = middle - 1;
            } else if (nums[middle] < target) {
                start = middle + 1;
            } else {
                break;
            }
        }

        System.out.println("数据的下标是 " + middle);

    }

    public int find(int[] nums, int target) {



        return 1;
    }
}

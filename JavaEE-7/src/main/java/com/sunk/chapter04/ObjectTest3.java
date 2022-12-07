package com.sunk.chapter04;


import java.math.BigDecimal;

public class ObjectTest3 {

    public static void main(String[] args) {
        System.out.println(compute(10));
        System.out.println(test(5));


        final BigDecimal bigDecimal = new BigDecimal("10.00");

    }

    public static int compute(int num) {
        if (num == 1) return 1;

        num = num % 2 == 0 ? num - 1 : num;
        return num + compute(num - 2);
    }


    public static int add(int res, int value) {
        if (value >= 10) return res;

        res += value;
        value += 2;
        return add(res, value);
    }

    // 阶乘 5! = 5 * 4 * 3 * 2 * 1
    public static int test(int num) {
        if (num == 0) return 1;
        return num * test(num - 1);
    }

}

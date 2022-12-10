package com.sunk.chapter06;

public class Exception2 {

    public static void main(String[] args) {
        /*
         * 除数为 0 的算数异常 - java.lang.ArithmeticException
         * - 运行期异常：JVM 不会显示的要求处理
         */
        // final int i = 1 / 0;

        /*
         * 空指针异常 - java.lang.NullPointerException
         * - 调用了一个为空对象的成员属性或方法时，静态属性和方法不影响
         */
        // String s = null;
        // final byte[] bytes = s.getBytes();


        /*
         * 数组下标越界 - java.lang.Array(String)IndexOutOfBoundsException
         */
        // final int[] ints = new int[3];
        // ints[10] = 100;
        // String s = "abc";
        // final char c = s.charAt(10);

        /*
         * 格式化异常 - java.lang.NumberFormatException
         */
        // String s2 = "123";
        // String s3 = "a123";
        // // java: 不兼容的类型: java.lang.String无法转换为java.lang.Integer
        // // Integer i = (Integer) s2;
        // final int i1 = Integer.parseInt(s3);

        /*
         * 类型转换异常 - java.lang.ClassCastException
         * - o instanceof Emp: 使用 instanceof 判断
         */
        Object o = new User();
        Emp e = (Emp) o;
    }

    static class User{}
    static class Emp{}
}

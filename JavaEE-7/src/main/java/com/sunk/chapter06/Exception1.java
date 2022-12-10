package com.sunk.chapter06;

public class Exception1 {

    public static void main(String[] args) {
        /*
         * 语法错误
         */
        // 1 类型转换出现了错误
        String s = "123";
        // Integer i = (Integer) s;
        final int i = Integer.parseInt(s);

        /*
         * ERROR 错误，出现错误 JVM 会自动停止，尽量避免
         */
        // 2 栈溢出：递归没有跳出逻辑
        test();

        /*
         * Exception 异常
         * Java 中的异常分为 2 类
         * - 可以通过代码逻辑恢复正常运行的异常，称之为运行时异常，父类 RuntimeException
         * - 不可以通过代码逻辑恢复正常运行的异常，称之为编译器异常，编译器会提醒可能出现此类异常 Exception
         */
        // 3 空指针异常，对象未初始化就使用
        String s2 = null;
        s2.getBytes();
    }

    public static void test() {
        test();
    }

}

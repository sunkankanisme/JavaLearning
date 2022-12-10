package com.sunk.chapter06;

public class Exception3 {

    public static void main(String[] args) {
        final User user = new User();
        // 会出现异常，是别的类抛出来的，由于抛出来的是运行时异常，所以可以不处理
        user.test(1, 0);

        // 此处必须进行异常的处理
        try {
            user.test2(1, 0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static class User {
        // 方法中可能会出现异常，需要提前声明 使用 throws 关键字
        public void test(int i, int j) throws ArithmeticException {
            System.out.println(i / j);
        }

        // 手动抛出异常对象，使用 throw 关键字
        public void test2(int i, int j) throws Exception {
            try {
                System.out.println(i / j);
            } catch (Exception e) {
                throw new Exception(e);
            }
        }
    }
}

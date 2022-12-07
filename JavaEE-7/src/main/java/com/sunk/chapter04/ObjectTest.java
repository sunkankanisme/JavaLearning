package com.sunk.chapter04;


import java.util.Arrays;

public class ObjectTest {
    public static void main(String[] args) {
        byte[] bs = new byte[12];

        final byte[] bytes = "abc".getBytes();

        System.out.println(Arrays.toString(bytes));

        final char[] chars = "abc".toCharArray();
        System.out.println(Arrays.toString(chars));



    }
}

class User {
    void login(String username, String password) {
        System.out.println("账号登录");
    }

    void login(String phoneNum) {
        System.out.println("手机验证码登录" + phoneNum);
    }

    void login() {
        System.out.println("微信支付宝登录");
    }
}




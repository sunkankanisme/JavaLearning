package com.sunk.chapter02;

public class Variable {

    public static void main(String[] args) {

        String name = "zhangsan";
        int age = 30;
        byte b = 10;
        short s = 10;


        long l = 100;
        age = (int) l;


        System.out.println(b == age);
        System.out.println(b != age);
        System.out.println(b >= age);
        System.out.println(b <= age);


        String str = "aa";
        String str2 = "aa";

        System.out.println(str2 == str);

        System.out.println(str2 != str);



    }
}

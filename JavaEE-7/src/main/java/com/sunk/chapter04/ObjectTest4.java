package com.sunk.chapter04;


public class ObjectTest4 {

    public static void main(String[] args) {
        // 创建外部类
        final ObjectTest4 objectTest4 = new ObjectTest4();

        // 创建内部类
        final ObjectTest4.InnerClass innerClass = objectTest4.new InnerClass();

        // 创建静态内部类
        final InnerStaticClass innerStaticClass = new InnerStaticClass();

    }

    /*
     * 内部类就当成外部类的属性使用即可
     */
    private class InnerClass {

    }

    /*
     * 内部静态类
     */
    private static class InnerStaticClass {

    }

}




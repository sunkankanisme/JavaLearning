package com.sunk.chapter07;


public class CollectionTest04 {

    public static void main(String[] args) {
        // 传入的类型和或得到的类型一致
        final MyClass<String> myClass = new MyClass<>();
        final String data = myClass.data;

    }

    public static void test() {

    }

    /*
     * 将类型的约束传入，有事把泛型称之为类型参数
     */
    static class MyClass<C> {
        public C data;
    }

}

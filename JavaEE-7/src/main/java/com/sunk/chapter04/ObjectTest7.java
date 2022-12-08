package com.sunk.chapter04;


public class ObjectTest7 {

    public static void main(String[] args) {
        System.out.println(City.BEIJING);
        System.out.println(City.BEIJING.name);
        System.out.println(City.BEIJING.code);
    }
}


enum City {
    /*
     * 使用构造方法在枚举类中定义对象
     */
    BEIJING("北京", 1000), SHANGHAI("上海", 1001);

    /*
     * 定义构造方法
     */
    City(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public final String name;
    public final int code;

}


class MyCity {
    public String name;
    public int code;

    private MyCity(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public static final MyCity BEIJING = new MyCity("北京", 1000);
    public static final MyCity SHANGHAI = new MyCity("上海", 1001);
}



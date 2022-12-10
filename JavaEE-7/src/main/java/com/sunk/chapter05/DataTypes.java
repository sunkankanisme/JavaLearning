package com.sunk.chapter05;

public class DataTypes {

    public static void main(String[] args) {

        Byte b = null;
        Short s = null;
        Integer i = null;
        Long l = null;
        Float f = null;
        Double d = null;
        Character c = null;
        Boolean bool = null;

        int i1 = 100;
        // 装箱：将基本数据类型转换为包装类型
        final Integer integer = new Integer(i1);
        final Integer integer1 = Integer.valueOf(i1);
        // 自动装箱
        final Integer integer2 = i1;

        // 拆箱：从包装类型的对象获取到基本数据类型
        final int i2 = integer1.intValue();
        // 自动拆箱
        final int i3 = integer1.intValue();
    }
}

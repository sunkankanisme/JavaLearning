package com.sunk.chapter10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectTest01 {

    public static void main(String[] args) throws Exception {

        User user = new Child();
        user.testUser();

        // 获取类对象
        final Class<? extends User> aClass = user.getClass();
        final Class<?> aClass1 = Class.forName("com.sunk.chapter10.ReflectTest01.User");
        final Class<User> aClass2 = User.class;

        // 获取类名
        final String name = aClass.getName();
        final String simpleName = aClass.getSimpleName();
        System.out.println(name);           // com.sunk.chapter10.ReflectTest01$Child
        System.out.println(simpleName);     // Child

        // 获取包名
        final String packageName = aClass.getPackageName();
        System.out.println(packageName);    // com.sunk.chapter10

        // 获取父类
        final Class<?> superclass = aClass.getSuperclass();
        System.out.println(superclass);     // class com.sunk.chapter10.ReflectTest01$User

        // 获取类的所有接口
        final Class<?>[] interfaces = aClass.getInterfaces();

        /*
         * 获取类的属性
         * - getField：获取指定的公共的属性
         * - getDeclaredField：获取所有的公共属性
         * - getFields：获取所有公共属性
         * - getDeclaredFields：获取所有声明的属性
         */
        final Field classField = aClass.getField("name");
        final Field declaredField = aClass.getDeclaredField("name");
        final Field[] fields = aClass.getFields();
        final Field[] declaredFields = aClass.getDeclaredFields();


        /*
         * 获取类的方法
         */
        final Method method = aClass.getMethod("test");
        final Method declaredMethod = aClass.getDeclaredMethod("test");
        final Method[] methods = aClass.getMethods();
        final Method[] declaredMethods = aClass.getDeclaredMethods();


        // 获取构造方法
        final Constructor<? extends User> constructor = aClass.getConstructor();
        final Constructor<? extends User> declaredConstructor = aClass.getDeclaredConstructor();
        final Constructor<?>[] constructors = aClass.getConstructors();
        final Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();

        // 获取权限修饰符
        final int modifiers = aClass.getModifiers();
        final boolean isPublic = Modifier.isPublic(modifiers);

        final User newInstance = constructor.newInstance();
        classField.set(newInstance, "zhangsan");
        method.invoke(newInstance);


    }

    static class User {
        public void testUser() {
            System.out.println("test USER");
        }
    }

    static class Child extends User {

        public void testChild() {
            System.out.println("test CHILD");
        }

    }

}

package com.sunk.chapter07;


import java.util.ArrayList;

public class CollectionTest03 {

    public static void main(String[] args) {
        final User user = new User();
        final Person person = new Person();

        /*
         * 不指定泛型
         */
        final ArrayList list = new ArrayList<>();
        list.add(user);
        list.add(person);

        // 问题点
        final User obj = (User) list.get(0);
        obj.testUser();
        list.remove(0);
        final User obj2 = (User) list.get(0);
        obj2.testUser();        // 出现异常 - java.lang.ClassCastException

        /*
         * 指定泛型
         */
        final ArrayList<User> list1 = new ArrayList<>();
        list1.add(user);
        final User user1 = list1.get(0);

    }


    static class User {
        public void testUser() {
            System.out.println("user ...");
        }
    }

    static class Person {
        private void testPerson() {
            System.out.println("Person ...");
        }
    }

}

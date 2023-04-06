package com.sunk.chapter07;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;

public class CollectionTest06 {

    public static void main(String[] args) {
        /*
         * - 在不重写 hashcode 方法的情况下，会认为以下三个是不同的对象，都会存储到 HashSet 中
         * - 重写 hashcode 和 equals 方法之后，通过 hashcode 进行数组位置的定位，
         *      再通过 equals 方法进行是否是同一对象的判断
         */
        final User user1 = new User(1, "zhangsan");
        final User user3 = new User(1, "zhangsan");
        final User user2 = new User(2, "lisi");

        final HashSet<User> users = new HashSet<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        System.out.println(users);

    }

    static class User {
        public int id;
        public String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return id == user.id && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return id;
        }
    }

}

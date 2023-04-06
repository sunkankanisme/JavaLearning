package com.sunk.chapter08;


import java.io.*;

public class TestIO06 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        final File userFile = new File("D:\\workspace\\Java\\Sunk\\JavaLearning\\JavaEE-7\\src\\main\\resources\\io\\users.txt");
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(userFile));

        // 创建对象
        final User user1 = new User(1, "zhangsan");
        final User user2 = new User(2, "lisi");

        // 输出对象到文件 - java.io.NotSerializableException
        objectOutputStream.writeObject(user1);
        objectOutputStream.writeObject(user2);
        objectOutputStream.flush();
        objectOutputStream.close();

        System.out.println("====================");
        final ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(userFile));

        // 从文件取出对象
        User u = (User) objectInputStream.readObject();
        System.out.println(u);
        objectInputStream.close();
    }

    /*
     * 实现 Serializable 接口才能够进行类对象的输出
     */
    static class User implements Serializable {
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
    }

}

package com.sunk.chapter08;


import java.io.File;
import java.io.IOException;

public class TestIO02 {

    public static void main(String[] args) throws IOException {

        /*
         * ====== File =====
         */

        // 1 创建文件对象
        String s = "D:\\workspace\\Java\\Sunk\\JavaLearning\\JavaEE-7\\src\\main\\resources\\io\\new.txt";
        final File file = new File(s);

        // 2 判断文件对象关联的是否是文件 / 文件夹
        final boolean b1 = file.isFile();
        final boolean b2 = file.isDirectory();

        // 3 判断当前文件是否存在
        final boolean b3 = file.exists();

        // 4 创建文件 / 文件夹
        file.createNewFile();
        file.mkdirs();

        // 5 文件的属性
        file.length();
        file.lastModified();
        file.getName();
        file.getPath();

        // 6 文件夹的属性
        if (file.isDirectory()) {
            file.lastModified();
            file.getName();

            // 获取文件夹内的文件集合
            final File[] files = file.listFiles();
        }


    }

}

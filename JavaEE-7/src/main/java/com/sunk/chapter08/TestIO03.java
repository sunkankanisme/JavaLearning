package com.sunk.chapter08;


import java.io.*;

public class TestIO03 {

    public static void main(String[] args) {

        // 源文件
        final File srcFile = new File("D:\\workspace\\Java\\Sunk\\JavaLearning\\JavaEE-7\\src\\main\\resources\\io\\new.txt");
        // 目标文件
        final File descFile = new File("D:\\workspace\\Java\\Sunk\\JavaLearning\\JavaEE-7\\src\\main\\resources\\io\\new.txt.copy");

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            // 使用文件输入输出流
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(descFile);

            int data = -1;
            // 将数据输入到管道
            while ((data = inputStream.read()) != -1) {
                // 将管道中的数据输出
                outputStream.write(data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭输入输出流
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

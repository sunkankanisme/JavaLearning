package com.sunk.chapter08;

import java.io.*;

/*
 * 缓冲流
 */
public class TestIO04 {

    public static void main(String[] args) {

        // 源文件
        final File srcFile = new File("D:\\workspace\\Java\\Sunk\\JavaLearning\\JavaEE-7\\src\\main\\resources\\io\\new.txt");
        // 目标文件
        final File descFile = new File("D:\\workspace\\Java\\Sunk\\JavaLearning\\JavaEE-7\\src\\main\\resources\\io\\new.txt.copy");

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        // 增减缓冲流对象
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        // 增加缓冲区
        byte[] cache = new byte[1024];

        try {
            // 使用文件输入输出流
            inputStream = new FileInputStream(srcFile);
            outputStream = new FileOutputStream(descFile);

            // 对接缓冲流
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);

            // 使用缓冲区进行数据传输
            int read = -1;
            while ((read = bufferedInputStream.read(cache)) != -1) {
                // 将管道中的数据输出
                bufferedOutputStream.write(cache, 0, read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭输入输出流
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (bufferedOutputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

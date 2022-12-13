package com.sunk.chapter08;


import java.io.*;

public class TestIO05 {

    public static void main(String[] args) {

        // 源文件
        final File srcFile = new File("D:\\workspace\\Java\\Sunk\\JavaLearning\\JavaEE-7\\src\\main\\resources\\io\\new.txt");
        // 目标文件
        final File descFile = new File("D:\\workspace\\Java\\Sunk\\JavaLearning\\JavaEE-7\\src\\main\\resources\\io\\new.txt.copy");

        BufferedReader br = null;
        PrintWriter pr = null;

        try {
            // 使用文件输入输出流
            br = new BufferedReader(new FileReader(srcFile));
            pr = new PrintWriter(descFile);

            String line = null;
            // 将数据输入到管道
            while ((line = br.readLine()) != null) {
                pr.write(line);
                pr.write("\n");
            }

            pr.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭输入输出流
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            if (pr != null) {
                pr.close();
            }
        }
    }

}

package com.sunk.bingfa;

import java.io.*;
import java.net.Socket;

/**
 * @author sunk
 * @description
 * @create 2022/11/10
 **/
public class ClientSocketDemo {

    public static void main(String[] args) {
        try {
            final Socket socket = new Socket("localhost", 8080);


            final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我是客户端 01\n\n");
            bufferedWriter.flush();


            // 获取输入流
            final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final String line = reader.readLine();
            System.out.println("SERVER MSG: " + line);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}

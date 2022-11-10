package com.sunk.bingfa;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocketThreadDemo extends Thread {
    ServerSocket serverSocket = null;

    public ServerSocketThreadDemo(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {

        try {
            // 默认情况下 accept 是阻塞的，直到有客户端连接过来
            final Socket socket = serverSocket.accept();
            System.out.println("启动服务，并获得一个客户端连接");

            // 获取输入流
            final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            final String line = reader.readLine();
            System.out.println("CLIENT MSG: " + line);
            Thread.sleep(20 * 1000);


            // 服务端返回消息
            final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            bufferedWriter.write("我是服务端，我收到了你的消息\n");
            bufferedWriter.flush();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}

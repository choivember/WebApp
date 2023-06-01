package com.section02.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class Application {

    public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(8001);

        int count = 1;

        try{
            out.println("HTTP Server started at 8001 port");
            while(true) {
                Socket socket = listener.accept();
                out.println("NEw Client Connect! connected IP :" + % s, Port : %d\n ", socket.getInetAddress(),
                socket.getPort());

                String contentType = "Content-Type: text/html; charset=utf-8";
                String contentLength = "Content-Length:" + responseText.length() + "\r\n";
                String whiteLine = "\r\n";

                out.write(responseGeneralHeader.getBytes());
                out.write(contentType.getBytes());
                out.write(contentLength.getBytes());
                out.flush();

                }
            } finally {
            socket

        }
    }
}

package com.acme.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ReadOnlyServer {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private BufferedReader in;

    public void start(int port) throws IOException {
        System.out.println("ServerSocket::start (INIT)");
        serverSocket = new ServerSocket(port);

        clientSocket = serverSocket.accept();
        System.out.println("ServerSocket::start clientSocket accepted");

        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String greeting = in.readLine();
        System.out.println(greeting);

        System.out.println("ServerSocket::start (END)");
    }

    public void stop() throws IOException {
        System.out.println("ServerSocket::stop (INIT)");
        in.close();
        clientSocket.close();
        serverSocket.close();
        System.out.println("ServerSocket::stop (END)");
    }
}

package com.acme.client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class WriteOnlyClient {

    private Socket clientSocket;
    private PrintWriter out;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
    }

    public void sendMessage(String msg) {
        out.println(msg);
    }

    public void stopConnection() throws IOException {
        out.close();
        clientSocket.close();
    }

}

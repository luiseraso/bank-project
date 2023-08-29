package com.acme.client;

import java.io.IOException;

public class Application {

    public static final String HOST = "localhost";
    public static final int PORT = 9500;

    public static void main(String[] args) throws IOException {
        WriteOnlyClient client = new WriteOnlyClient();
        client.startConnection(HOST, PORT);
        client.sendMessage("Hola");
        client.sendMessage("Hay alguien ahí?");
        client.sendMessage("Adios");
        client.stopConnection();
    }
}
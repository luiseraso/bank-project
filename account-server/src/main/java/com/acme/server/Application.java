package com.acme.server;

import java.io.IOException;

public class Application {

    public static final int PORT = 9500;

    public static void main(String[] args) throws IOException {
        ReadOnlyServer server = new ReadOnlyServer();
        server.start(PORT);
        server.stop();
    }
}
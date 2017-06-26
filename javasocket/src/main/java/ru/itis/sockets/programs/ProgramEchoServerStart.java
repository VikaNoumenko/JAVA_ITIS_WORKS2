package ru.itis.sockets.programs;

import ru.itis.sockets.servers.EchoServer;

public class ProgramEchoServerStart {
    public static void main(String[] args) {
        EchoServer server = new EchoServer();
        server.start(6666);
    }
}

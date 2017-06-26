package ru.itis.sockets.programs;

import ru.itis.sockets.servers.ChatMultiServer;

public class ProgramChatMultiServer {
    public static void main(String[] args) {
        ChatMultiServer server = new ChatMultiServer();
        server.start(6666);
    }
}

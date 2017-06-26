package ru.itis.sockets.programs;

import ru.itis.sockets.clients.GreetClient;

public class ProgramClientStart {
    public static void main(String[] args) {
        // создали объект клиента
        GreetClient client = new GreetClient();
        // подключились к серверу
        client.startConnection("127.0.0.1", 6666);
        // отправляете сообщение и получаете ответ
        client.sendMessage("bye");
    }
}

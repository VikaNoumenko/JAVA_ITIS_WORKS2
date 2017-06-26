package ru.itis.sockets.programs;

import ru.itis.sockets.clients.GreetClient;

import java.util.Scanner;

public class ProgramClientForEchoStart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GreetClient client = new GreetClient();

        client.startConnection("127.0.0.1", 6666);
        // пока true
        while (true) {
            // считываем сообщение с консоли
            String message = scanner.nextLine();
            // отправляем на сервер
            client.sendMessage(message);
        }
    }
}

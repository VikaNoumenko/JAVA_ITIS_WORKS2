package ru.itis.sockets.servers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    public void start(int port) {
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            // пока полученная строка от клиена не нулевая
            while ((inputLine = in.readLine()) != null) {
                // если строка от клиента - точка
                if (".".equals(inputLine)) {
                    // отправляем сообщение good bye
                    out.println("good bye");
                    // останавливаем приложение
                    break;
                }
                // отправляем эхо-сообщение клиенту
                out.println("From server " + inputLine);
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

}

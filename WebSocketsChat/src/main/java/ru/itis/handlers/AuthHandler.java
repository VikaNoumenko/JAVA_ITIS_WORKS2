package ru.itis.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import ru.itis.service.ChatService;
import ru.itis.service.SessionsService;

import java.io.IOException;

/**
 * 26.01.17
 * EchoHandler
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
// перехватчик сообщений из определенной сессии сокетов
public class AuthHandler extends TextWebSocketHandler {

    @Autowired
    private SessionsService sessionsService;

    @Autowired
    private ChatService chatService;

    /**
     * Перехват текстового сообщения
     * @param session
     * @param textMessage
     * @throws IOException
     */
    public void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws IOException {
        System.out.println(textMessage.getPayload());
        // вытаскиваем сообщение и делим его по пробелам
        String message[] = textMessage.getPayload().split(" ");
        // вытаскиваем токен
        String token = message[0];
        // перехватили номер чата, в котором хочет участвовать пользователь
        int chatId = Integer.parseInt(message[1]);
        // если пользователь не соответствует данному чату
        if (!chatService.isUserInChat(token, chatId)) {
            // закрываем соединение
            session.close();
        } else {
            // в противном случае - подтверждаем сессию
            sessionsService.submitSession(chatId, session);
        }
    }
}

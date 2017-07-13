package ru.itis.service;

import org.springframework.web.socket.WebSocketSession;
import ru.itis.dto.MessageDto;

import java.util.List;


public interface ChatService {
    /**
     * Получить все сообщения в чате
     * @param chatId
     * @return список сообщений
     */
    List<MessageDto> getMessages(String token, int chatId);

    /**
     * Сохранить сообщение от автора с token-ом, и разослать всем в чате
     * @param token
     * @param chatId
     * @param message
     */
    void saveAndDeliverMessage(String token, int chatId, MessageDto message);

    /**
     * Проверяет, состоит ли пользователь в чате
     * @param token токен пользователя
     * @param chatId идентификатор чата
     * @return
     */
    boolean isUserInChat(String token, int chatId);
}

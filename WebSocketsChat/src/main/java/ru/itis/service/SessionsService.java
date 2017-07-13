package ru.itis.service;

import org.springframework.web.socket.WebSocketSession;

import java.util.List;

public interface SessionsService {
    /**
     * Привязываем сессию пользователя к чату
     * @param chatId
     * @param session
     */
    void submitSession(int chatId, WebSocketSession session);

    /**
     * Получить список сессий чата
     * @param chatId
     * @return
     */
    List<WebSocketSession> getSessionsOfChat(int chatId);
}

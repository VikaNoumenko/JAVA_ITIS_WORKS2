package ru.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import ru.itis.converter.Converter;
import ru.itis.dao.ChatsDao;
import ru.itis.dao.MessagesDao;
import ru.itis.dao.UsersDao;
import ru.itis.dto.MessageDto;
import ru.itis.model.Chat;
import ru.itis.model.Message;
import ru.itis.model.User;

import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static ru.itis.converter.Converter.convert;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    private UsersDao usersDao;

    @Autowired
    private MessagesDao messagesDao;

    @Autowired
    private ChatsDao chatsDao;

    @Autowired
    private SessionsService sessionsService;

    @Override
    public List<MessageDto> getMessages(String token, int chatId) {
        User user = usersDao.findByToken(token);
        Chat chat = chatsDao.findOne(chatId);
        List<Message> messages = messagesDao.findByAuthorAndChat(user, chat);
        List<MessageDto> result = messages.
                stream().map(message ->
                new MessageDto(message.getText())).collect(Collectors.toList());
        return result;
    }

    @Override
    public void saveAndDeliverMessage(String token, int chatId, MessageDto message) {
        // проверяем, что пользователь, отправивший данное сообщение в чат
        // действительно имеет на это право
        if (isUserInChat(token, chatId)) {
            // находим пользователя по токену
            User user = usersDao.findByToken(token);
            // находим чат по его id
            Chat chat = chatsDao.findOne(chatId);
            // созлаем модель сообшения для сохранения
            Message model = new Message();
            // проставляем автора
            model.setAuthor(user);
            // проставляем чат
            model.setChat(chat);
            // проставляем текст
            model.setText(message.getMessage());
            // сохраняем сообщение
            messagesDao.save(model);
            // формируем список сессий данного чата
            List<WebSocketSession> sessions = sessionsService.getSessionsOfChat(chatId);
            // для каждой сессии
            for (WebSocketSession session : sessions) {
                try {
                    // отправляем сообщение
                    if (session.isOpen()) {
                        session.sendMessage(new TextMessage(message.getMessage().getBytes()));
                    }
                } catch (IOException e) {
                    throw new IllegalStateException(e);
                }
            }
        }

    }

    @Override
    public boolean isUserInChat(String token, int chatId) {
        User user = usersDao.findByToken(token);
        return chatsDao.isUserInChat(user.getId(), chatId);
    }
}

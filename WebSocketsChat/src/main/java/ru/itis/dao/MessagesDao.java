package ru.itis.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.model.Chat;
import ru.itis.model.Message;
import ru.itis.model.User;

import java.util.List;

public interface MessagesDao extends JpaRepository<Message, Integer> {
    List<Message> findByAuthorAndChat(User user, Chat chat);
}

package ru.itis.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ru.itis.dto.MessageDto;

@Controller
public class StompUsersController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/chat")
    public void getMessage(MessageDto message) {
        System.out.println("Get message " + message.getMessage());
        template.convertAndSend("/topic/1", new MessageDto("server"));
    }
}

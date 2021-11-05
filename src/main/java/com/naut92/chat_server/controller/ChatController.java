package com.naut92.chat_server.controller;

import com.naut92.chat_server.model.Greeting;
import com.naut92.chat_server.model.Message;
import com.naut92.chat_server.service.interfaces.SendMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.List;

@Controller
public class ChatController {

    private final SendMessage sendMessage;
    private static final HashSet<String> nameMap = new HashSet<>();

    public ChatController(SendMessage sendMessage) {
        this.sendMessage = sendMessage;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(Message message) throws Exception {
        //Thread.sleep(300); // simulated delay
        return sendMessage.sendGreeting(nameMap, message);
    }

    @MessageMapping("/message")
    @SendTo("/topic/message")
    public Greeting message(List<Message> messages) throws Exception {
        //Thread.sleep(300); // simulated delay
        return sendMessage.sendMessage(nameMap, messages);
    }
}

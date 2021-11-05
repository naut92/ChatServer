package com.naut92.chat_server.service;

import com.naut92.chat_server.model.Greeting;
import com.naut92.chat_server.model.Message;
import com.naut92.chat_server.service.interfaces.SendMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;

import java.util.HashSet;
import java.util.List;

@Service
public class SendMessageImpl implements SendMessage {

    @Override
    public Greeting sendGreeting(HashSet<String> nameMap, Message message) {
        nameMap.add(message.getName());
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    @Override
    public Greeting sendMessage(HashSet<String> nameMap, List<Message> messages) {

        Greeting message = new Greeting();
        if (!nameMap.isEmpty()) {
            nameMap.stream().filter(n -> messages.get(0).getName().equals(n)).map(n -> new Greeting(messages.get(0).getName() + ": " + HtmlUtils.htmlEscape(messages.get(1).getMessage()) + "!").getContent()).forEachOrdered(message::setContent);
        }
        return message;
    }
}

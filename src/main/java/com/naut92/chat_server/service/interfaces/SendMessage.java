package com.naut92.chat_server.service.interfaces;

import com.naut92.chat_server.model.Greeting;
import com.naut92.chat_server.model.Message;

import java.util.HashSet;
import java.util.List;


public interface SendMessage {
    Greeting sendGreeting(HashSet<String> nameMap, Message message);
    Greeting sendMessage(HashSet<String> nameMap, List<Message> messages);
}

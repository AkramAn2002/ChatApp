package com.example.chatting.Service;

import com.example.chatting.Entities.Message;
import com.example.chatting.Entities.User;
import com.example.chatting.Repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<Message> listAll() {
        System.out.println("listing all...");
        return messageRepository.findAll();
    }



    public void saveMessage(String messageContent,Long idUser) {
        User user = new User();
        user.setIdUser(idUser);
        Message message = new Message();
        message.setUser(user);
        message.setMessageContent(messageContent);
        messageRepository.save(message);
    }
}


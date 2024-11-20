package com.example.chatting.Controleur;

import com.example.chatting.Entities.Message;
import com.example.chatting.Service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RestMessageController {
    MessageService messageService;
    @GetMapping("/get-all-messages")
    public List<Message> getAllMessages(){
        return  messageService.listAll();
    }
}

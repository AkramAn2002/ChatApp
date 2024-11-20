package com.example.chatting.Controleur;

import com.example.chatting.Entities.Message;
import com.example.chatting.Entities.User;
import com.example.chatting.Service.MessageService;
import com.example.chatting.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class RestUserController {
    UserService userService;
    @GetMapping("/get-OnlineUsers")
    public List<User> getAllMessages(){
        return  userService.listAll();
    }
}

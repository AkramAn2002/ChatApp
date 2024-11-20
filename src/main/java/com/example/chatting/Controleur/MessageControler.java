package com.example.chatting.Controleur;

import com.example.chatting.Entities.Message;
import com.example.chatting.Entities.User;
import com.example.chatting.Service.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MessageControler {
    private final MessageService messageService;

    public MessageControler(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("/index")
    public String listMessage(Model model)
    {
        List<Message> messageList= messageService.listAll();
        model.addAttribute("listMessage",messageList);
        return "index";
    }

    @GetMapping("/message/new")
    public String showNewForm(Model model)
    {
        System.out.println("message controller");
        model.addAttribute("message",new Message());
        model.addAttribute("messages", messageService.listAll());
        System.out.println(messageService.listAll());
        return "chat";
    }

    @PostMapping("/message/save")
    public String saveMessage(@RequestParam("messageContent") String  messageContent,@RequestParam("idUser") Long idUser) {
        messageService.saveMessage(messageContent,idUser);
        return "redirect:/chats?user_id="+idUser;
    }

}

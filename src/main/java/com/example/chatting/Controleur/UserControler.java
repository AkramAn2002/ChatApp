package com.example.chatting.Controleur;

import com.example.chatting.Entities.Message;
import com.example.chatting.Entities.User;
import com.example.chatting.Repository.UserRepository;
import com.example.chatting.Service.MessageService;
import com.example.chatting.Service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserControler {
    private final UserService userService;
    private final MessageService messageService;


    @GetMapping("/user/index")
    public String listUsers(Model model) {
        List<User> userList = userService.listAll();
        model.addAttribute("listuser", userList);
        return "index";
    }

    @PostMapping("/index/login")
    public String login(User user, Model model, HttpSession session) {

        User us = userService .getUser(user);
        System.out.println(session.getAttribute("user"));
        if (us != null) {

            session.setAttribute("user-"+us.getIdUser(), us);
            model.addAttribute("userid", session.getId());
            model.addAttribute("error", "");

            if (!us.getBanned())
            {
                userService.updateUserStatus(us.getIdUser(), "Online");
                model.addAttribute("banned", "");
                return "redirect:/chats?user_id="+us.getIdUser();
            }
            model.addAttribute("banned", "YOU ARE BANNED");
        }


        model.addAttribute("error", "Identifiants incorrects. Réessayez.");
        return "index";
    }
    @GetMapping("/chats")
    public String showProfile(Model model, HttpSession session, @RequestParam(name = "user_id") Long user_id ) {
        User user = userService.getUserById(user_id);
            model.addAttribute("user", user);
            model.addAttribute("messages",messageService.listAll());
            return "chat";

    }
    @GetMapping("/logout")
    public String logout(@RequestParam("idUser") Long idUser, HttpSession session) {
        userService.updateUserStatus(idUser, "Offline");
        return "redirect:/user/index";
    }



}



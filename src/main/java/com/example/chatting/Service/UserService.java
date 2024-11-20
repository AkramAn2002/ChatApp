package com.example.chatting.Service;

import com.example.chatting.Entities.Message;
import com.example.chatting.Entities.User;
import com.example.chatting.Repository.MessageRepository;
import com.example.chatting.Repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository)
    {
        this.userRepository=userRepository;
    }
    public User getUser(User user) {
        List<User> users = userRepository.findAll();
        for (User us : users) {
            if (Objects.equals(us.getUserName(), user.getUserName()) && Objects.equals(us.getPassword(), user.getPassword())) {
                return us;
            }
        }
        return null;
    }
    public List<User> listAll()
    {
        return userRepository.findAll();
    }
    public User getUserById(Long userId){
        if (userRepository.findById(userId).isPresent()){
            return userRepository.findById(userId).get() ;
        }
        return null ;

    }

    public void updateUserStatus(Long userId, String status) {
        User user = userRepository.findById(userId).orElse(null);

        if (user != null) {
            user.setStatus(status);
            userRepository.save(user);
        }
    }

}

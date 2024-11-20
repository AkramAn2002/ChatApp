package com.example.chatting.Repository;

import com.example.chatting.Entities.Message;
import com.example.chatting.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {


}

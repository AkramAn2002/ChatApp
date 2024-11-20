package com.example.chatting.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table
@Data
@AllArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMessage ;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    private String messageContent;
    @CreationTimestamp
    private LocalDate dateSent;

    @CreationTimestamp
    private LocalTime timeSent;


    public Message() {
        this.dateSent = LocalDate.now();
        this.timeSent = LocalTime.now();
    }



}

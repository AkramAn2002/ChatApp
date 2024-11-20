package com.example.chatting.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser ;
    private String Nom;
    private String Prenom;
    private String UserName;
    private String password;
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Offline'")
    private String status;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(255) DEFAULT 'Classic'")
    private UserType userType;
    public enum UserType {
        Classic,
        MODERATOR,
        ADMINISTRATOR
    }
    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean banned;




}

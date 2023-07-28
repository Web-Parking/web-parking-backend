package com.projects.api.webparking.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String email;
    private Timestamp createdAt;
    public User() {}

    public User(String email) {
        this.setEmail(email);
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }


    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

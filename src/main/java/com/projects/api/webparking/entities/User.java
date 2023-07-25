package com.projects.api.webparking.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String email;
    @OneToMany
    private Occupation[] occupations;
    public User() {}


}

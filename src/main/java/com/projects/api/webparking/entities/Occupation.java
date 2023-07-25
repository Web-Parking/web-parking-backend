package com.projects.api.webparking.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "occupations")
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String code;
    private Timestamp enteredAt;
    private Timestamp leftAt;
    private OccupationStatus status;
    private PaymentStatus paymentStatus;
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    public Occupation() {}

    public enum OccupationStatus {
        CREATED, RELEASED, FINISHED
    }

    public enum PaymentStatus {
        WAITING_PAYMENT, PAID
    }
}

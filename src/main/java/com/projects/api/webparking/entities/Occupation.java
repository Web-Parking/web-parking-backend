package com.projects.api.webparking.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.UUID;
import java.util.random.RandomGenerator;

@Entity
@Table(name = "occupations")
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String code;

    public Timestamp getEnteredAt() {
        return enteredAt;
    }

    public void setEnteredAt(Timestamp enteredAt) {
        this.enteredAt = enteredAt;
    }

    public Timestamp getLeftAt() {
        return leftAt;
    }

    public void setLeftAt(Timestamp leftAt) {
        this.leftAt = leftAt;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    private Timestamp enteredAt;
    private Timestamp leftAt;
    private OccupationStatus status;
    private PaymentStatus paymentStatus;
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Occupation() {}
    public Occupation(User user) {
        this.user = user;
        UUID uuid = UUID.randomUUID();
        this.code = (uuid.toString()).substring(0,5);
        this.status = OccupationStatus.CREATED;
        this.paymentStatus = PaymentStatus.WAITING_PAYMENT;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public OccupationStatus getStatus() {
        return status;
    }

    public void setStatus(OccupationStatus status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public enum OccupationStatus {
        CREATED, RELEASED, FINISHED
    }

    public enum PaymentStatus {
        WAITING_PAYMENT, PAID
    }
}

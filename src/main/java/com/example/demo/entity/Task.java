package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String desp;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public Task() {}

    public Task(String name, String desp, int id) {
        this.name = name;
        this.desp = desp;
        this.id = id;
    }

    // Automatically set before saving
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // getters / setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDesp() { return desp; }
    public void setDesp(String desp){ this.desp = desp; }

    public LocalDateTime getCreatedAt() { return createdAt; }
}

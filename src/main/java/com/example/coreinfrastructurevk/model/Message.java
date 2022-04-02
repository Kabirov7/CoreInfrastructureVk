package com.example.coreinfrastructurevk.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String text;

    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "sender")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "target")
    private User target;

    public Message(String text, LocalDateTime createdAt, User sender, User target) {
        this.text = text;
        this.createdAt = createdAt;
        this.sender = sender;
        this.target = target;
    }

    public Message() {

    }
}

package com.example.coreinfrastructurevk.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class MessageDto implements Serializable {
    Long id;
    String text;
    UserDto sender;
    UserDto target;
    LocalDateTime createdAt;

    public MessageDto() {}

    public MessageDto(Long id, UserDto sender, UserDto target, LocalDateTime createdAt) {
        this.id = id;
        this.sender = sender;
        this.target = target;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getSender() {
        return sender;
    }

    public void setSender(UserDto sender) {
        this.sender = sender;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserDto getTarget() {
        return target;
    }

    public void setTarget(UserDto target) {
        this.target = target;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}

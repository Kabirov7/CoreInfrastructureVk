package com.example.coreinfrastructurevk.dto;

import java.io.Serializable;
import java.util.Date;

public class MessageDto implements Serializable {
    Long id;
    UserDto sender;
    UserDto target;
    Date createdAt;

    public MessageDto() {}

    public MessageDto(Long id, UserDto sender, UserDto target, Date createdAt) {
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

    public UserDto getTarget() {
        return target;
    }

    public void setTarget(UserDto target) {
        this.target = target;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}

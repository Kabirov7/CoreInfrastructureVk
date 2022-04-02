package com.example.coreinfrastructurevk.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;


public class MessageCreateDto implements Serializable {

    String sender;
    String target;
    String text;

    public MessageCreateDto(String sender, String target, String text) {
        this.sender = sender;
        this.target = target;
        this.text = text;
    }

    public MessageCreateDto() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
